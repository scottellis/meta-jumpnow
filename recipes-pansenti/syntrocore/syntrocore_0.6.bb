SUMMARY = "Core libraries and applications for Syntro"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e

DEPENDS += "pkgconfig"

PR = "5"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroCore-${PV}.tar.bz2"
SRC_URI[md5sum] = "f6ea3a3fe206507212cede578a711f66"
SRC_URI[sha256sum] = "c56ae0bd302043e469edcd57050cba335af71d6c9d158a363fd084ae93121b17"

S = "${WORKDIR}"

do_install() {
    export INSTALL_ROOT=${D}
    make install

    install -d ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/SyntroLib/syntro.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir} ${bindir}"

