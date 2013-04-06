DESCRIPTION = "Wireless udev rules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRC_URI = "file://wlan.rules \
           file://wlan.sh \
          "

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/wlan.rules ${D}${sysconfdir}/udev/rules.d/
    install -d ${D}${sysconfdir}/udev/scripts
    install -m 0744 ${WORKDIR}/wlan.sh ${D}${sysconfdir}/udev/scripts/
}

FILES_${PN} = "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"

