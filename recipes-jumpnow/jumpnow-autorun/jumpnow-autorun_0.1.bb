DESCRIPTION = "Autorun an application on startup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# for the example I'm launching tstap a qt app
DEPENDS = "systemd tstap"

SRC_URI = "file://profile-example \
           file://autologin@tty7.service \
          "

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/home/root
    install -m 0744 profile-example ${D}/home/root/.profile

    install -d ${D}${sysconfdir}/systemd/system/getty.target.wants/
    install -m 0644 autologin@tty7.service \
             ${D}${sysconfdir}/systemd/system/getty.target.wants/
}

FILES_${PN} = "${sysconfdir} /home/root"

