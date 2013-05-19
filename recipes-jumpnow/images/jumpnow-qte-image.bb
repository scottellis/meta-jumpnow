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

SYNTRO = " \
    syntrocore \
    syntrocore-dev \
    syntrov4lcamera \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    psplash \
    ${SYNTRO} \
 "

export IMAGE_BASENAME = "jumpnow-qte-image"

