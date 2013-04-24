# Add opencv and qte to the console image 

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

#OPENCV_DEV = " \
#    opencv-dev \
#    opencv-samples-dev \
# "

DEMOS = " \
    sample-qt \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${TS_TOOLS} \
    ${DEMOS} \
    psplash \
 "

