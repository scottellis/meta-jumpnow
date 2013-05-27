SUMMARY = "Core libraries and applications for Syntro"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e

DEPENDS += "pkgconfig"

PR = "3"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroCore-${PV}.tar.bz2"
SRC_URI[md5sum] = "a6d252defcac8e7606af3c46548cddc4"
SRC_URI[sha256sum] = "db664d16f3ff90bd0bc61072a34be129d101db93a298d0e41c380cc23012c1f5"

S = "${WORKDIR}"

do_install() {
    export INSTALL_ROOT=${D}
    make install

    install -d ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/SyntroLib/syntro.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir} ${bindir}"

