DESCRIPTION = "Start run wireless setup when wlan interface detected"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "udev"

SRC_URI = "file://wlan.rules \
           file://wlan.sh \
          "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/udev/
    install -d ${D}/${sysconfdir}/udev/rules.d/
    install -m 0644 wlan.rules ${D}${sysconfdir}/udev/rules.d/
    install -d ${D}/${sysconfdir}/udev/scripts/
    install -m 0744 wlan.sh ${D}${sysconfdir}/udev/scripts/
}

FILES_${PN} = "${sysconfdir}"

