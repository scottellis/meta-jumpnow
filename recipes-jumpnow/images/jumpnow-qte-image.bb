# A dev image with Qt embedded, touchscreen library for Overo (and OpenCV coming) 

require jumpnow-console-image.bb

QT_TOOLS = " \
    qt4-embedded-dev\
    qt4-embedded \
 "

QT_TOOLS_overo = " \
    qt4-embedded-plugin-mousedriver-tslib \
    tslib-calibrate \
    tslib-tests \
    tslib-conf \
 " 

#OPENCV_DEV = "
#    opencv-dev
#    opencv-samples-dev
# "

DEMOS = ""

# Qt app to toggle some board leds on the Gumstix Overo
DEMOS_overo += " \
    sample-qt \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${DEMOS} \
    psplash \
 "

export IMAGE_BASENAME = "jumpnow-qte-image"

