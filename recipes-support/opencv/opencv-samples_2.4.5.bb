DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://opencv.willowgarage.com/wiki/"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://include/opencv2/opencv.hpp;endline=41;md5=6d690d8488a6fca7a2c192932466bb14"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "opencv"

SRC_URI = "http://sourceforge.net/projects/opencvlibrary/files/opencv-unix/${PV}/opencv-${PV}.tar.gz"
SRC_URI[md5sum] = "8eac87462c7bec8b89021b723207c623"
SRC_URI[sha256sum] = "d30beecf4b57977fbd1635af54c5ab3fc00113e9e59a9d58081732260fe06292"

S = "${WORKDIR}/opencv-${PV}"


do_install() {
	cd samples/c
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/opencv/samples

	cp * ${D}/${datadir}/opencv/samples || true

	for i in *.c; do
		echo "compiling $i"
		${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .c` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .c` ${D}/${bindir} || true
		rm ${D}/${datadir}/opencv/samples/`basename $i .c` || true
	done

	for i in *.cpp; do
		echo "compiling $i"
		${CXX} ${CFLAGS} ${LDFLAGS} -ggdb `pkg-config --cflags opencv` -o `basename $i .cpp` $i `pkg-config --libs opencv` || true
		install -m 0755 `basename $i .cpp` ${D}/${bindir} || true
		rm ${D}/${datadir}/opencv/samples/`basename $i .cpp` || true
	done
}

FILES_${PN}-dev += "${datadir}/opencv/samples/*.c* ${datadir}/opencv/samples/*.vcp* ${datadir}/opencv/samples/build*" 
FILES_${PN} += "${bindir} ${datadir}/opencv"
