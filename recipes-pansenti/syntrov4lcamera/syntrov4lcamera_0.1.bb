SUMMARY = "Syntro V4L camera application"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e pkgconfig

DEPENDS += "syntrocore"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroV4LCamera-${PV}.tgz"
SRC_URI[md5sum] = "3699c2bec63462e0355395ade76c1531"
SRC_URI[sha256sum] = "5696a001eabde6b663785b1efff29ca2f3c3b192536a5dd963c67ca6fe2bdd0a"

S = "${WORKDIR}"

do_install() {
	export INSTALL_ROOT=${D}
	make install
}

FILES_${PN} = "${bindir}"

