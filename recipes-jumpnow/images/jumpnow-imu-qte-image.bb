# Add opencv and qte to the imu console image 

require jumpnow-imu-console-image.bb


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

DEMOS = " \
    tstap \
    tstracker \
    jumpnow-autorun \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${TS_TOOLS} \
    ${DEMOS} \
    psplash \
 "

