SUMMARY = "Core libraries and applications for Syntro"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e

DEPENDS += "pkgconfig"

PR = "1"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroCore-${PV}.tgz"
SRC_URI[md5sum] = "f2b2978e6cdeb33ea504bd81884c3dca"
SRC_URI[sha256sum] = "d722ae618528c737a7be6db7297746a34369ffcaeab9c9797a3743bcfd07e91e"

S = "${WORKDIR}"

do_install() {
    export INSTALL_ROOT=${D}
    make install

    install -d ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/SyntroLib/syntro.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir} ${bindir}"

