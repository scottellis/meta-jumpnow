DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://opencv.willowgarage.com/wiki/"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://include/opencv2/opencv.hpp;endline=41;md5=6d690d8488a6fca7a2c192932466bb14"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "v4l-utils libtool jpeg bzip2 zlib libpng tiff glib-2.0"

SRC_URI = "http://sourceforge.net/projects/opencvlibrary/files/opencv-unix/${PV}/opencv-${PV}.tar.gz"
SRC_URI[md5sum] = "8eac87462c7bec8b89021b723207c623"
SRC_URI[sha256sum] = "d30beecf4b57977fbd1635af54c5ab3fc00113e9e59a9d58081732260fe06292"

S = "${WORKDIR}/opencv-${PV}"

EXTRA_OECMAKE = "-DBUILD_PYTHON_SUPPORT=OFF \
                 -DWITH_FFMPEG=OFF \
                 -DWITH_GSTREAMER=OFF \
                 -DWITH_V4L=ON \
                 -DWITH_GTK=OFF \
                 -DCMAKE_SKIP_RPATH=ON \
                "

inherit distutils-base pkgconfig cmake

export BUILD_SYS
export HOST_SYS

TARGET_CC_ARCH += "-I${S}/include "

PACKAGES += "${PN}-apps"

python populate_packages_prepend () {
	cv_libdir = d.expand('${libdir}')
	cv_libdir_dbg = d.expand('${libdir}/.debug')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenCV %s library', extra_depends='', allow_links=True)

	pn = d.getVar('PN', 1)
	metapkg =  pn + '-dev'
	d.setVar('ALLOW_EMPTY_' + metapkg, "1")
	blacklist = [ metapkg ]
	metapkg_rdepends = [ ] 
	packages = d.getVar('PACKAGES', 1).split()
	for pkg in packages[1:]:
		if not pkg in blacklist and not pkg in metapkg_rdepends and pkg.endswith('-dev'):
			metapkg_rdepends.append(pkg)
	d.setVar('RRECOMMENDS_' + metapkg, ' '.join(metapkg_rdepends))
}

PACKAGES_DYNAMIC += "^libopencv-.*"

FILES_${PN} = ""
FILES_${PN}-apps = "${bindir}/* ${datadir}/OpenCV"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"
FILES_${PN}-doc = "${datadir}/OpenCV/doc"

ALLOW_EMPTY_${PN} = "1"

do_install_append() {
	cp ${S}/include/opencv/*.h ${D}${includedir}/opencv/
	sed -i '/blobtrack/d' ${D}${includedir}/opencv/cvaux.h
}

