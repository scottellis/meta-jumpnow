SUMMARY = "Core libraries and applications for Syntro"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e

DEPENDS += "pkgconfig"

PR = "4"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroCore-${PV}.tar.bz2"
SRC_URI[md5sum] = "38497a991f44b7844dc6e715fd23b4a4"
SRC_URI[sha256sum] = "b882da1da79f2922d75992cbe13cf276b132f62cc2368b524c74e7fc269ffec3"

S = "${WORKDIR}"

do_install() {
    export INSTALL_ROOT=${D}
    make install

    install -d ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/SyntroLib/syntro.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir} ${bindir}"

