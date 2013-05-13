# A dev image with Qt embedded, touchscreen library (and OpenCV coming) 

require jumpnow-console-image.bb


QT_TOOLS = " \
    qt4-embedded-dev\
    qt4-embedded \
    qt4-embedded-plugin-mousedriver-tslib \
 "

TS_TOOLS = " \
    tslib-calibrate \
    tslib-tests \
    tslib-conf \
 " 

#OPENCV_DEV = "
#    opencv-dev
#    opencv-samples-dev
# "

#DEMOS = "
#    sample-qt
# "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${TS_TOOLS} \
 "

export IMAGE_BASENAME = "jumpnow-qte-image"

