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

export IMAGE_BASENAME = "jumpnow-qte-image"

