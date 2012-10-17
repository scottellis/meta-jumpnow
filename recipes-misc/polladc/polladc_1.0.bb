DESCRIPTION = "Console app to read the Gumstix on-board ADCs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/scottellis/polladc.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 polladc ${D}${bindir}
}

