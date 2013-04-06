DESCRIPTION = "Touchscreen event tracking app for debugging Qt touchscreen"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit qt4e

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/Pansenti/tstracker.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	export INSTALL_ROOT=${D}
	make install
}

