SUMMARY = "Core libraries and applications for Syntro"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e

DEPENDS += "pkgconfig"

PR = "2"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroCore-${PV}.tar.bz2"
SRC_URI[md5sum] = "beee8e61b32018272c5e7ee75f46c489"
SRC_URI[sha256sum] = "40ac4930f553dc3fd6796e1c275940ee215e3a720a886db854339b6f8fe202ef"

S = "${WORKDIR}"

do_install() {
    export INSTALL_ROOT=${D}
    make install

    install -d ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/SyntroLib/syntro.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir} ${bindir}"

