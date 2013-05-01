DESCRIPTION = "Setup pwm module to be loaded on boot"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "systemd pwm-module"

SRC_URI = "file://modules-load.d/pwm.conf \
           file://modprobe.d/pwm.conf \
          "

PR = "r0"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/modules-load.d/
    install -m 0644 modules-load.d/pwm.conf ${D}${sysconfdir}/modules-load.d/
    install -d ${D}/${sysconfdir}/modprobe.d/
    install -m 0644 modprobe.d/pwm.conf ${D}${sysconfdir}/modprobe.d/
}

FILES_${PN} = "${sysconfdir}"

