# A dev image with Qt embedded, touchscreen library for Overo

require jumpnow-console-image.bb

QT_TOOLS = " \
    qt4-embedded-dev\
    qt4-embedded \
 "

QT_TOOLS_overo += " \
    qt4-embedded-dev\
    qt4-embedded \
    qt4-embedded-plugin-mousedriver-tslib \
    tslib-calibrate \
    tslib-tests \
    tslib-conf \
 " 

DEMOS = ""

DEMOS_overo = " \
    sample-qt \
 "

SYNTRO = " \
    syntrocore \
    syntrocore-dev \
    syntrov4lcamera \
 "

PSPLASH = ""

PSPLASH_duovero = "psplash"

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${DEMOS} \
    ${PSPLASH} \
    ${SYNTRO} \
 "

# qt brings in pulseaudio which brings in avahi which we don't 
# normally use, so disable it

disable_avahi() {
    echo AVAHI_DAEMON_START=0 > ${IMAGE_ROOTFS}/etc/default/avahi-daemon
}

ROOTFS_POSTPROCESS_COMMAND += "disable_avahi ; "

export IMAGE_BASENAME = "jumpnow-qte-image"

