# 

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

KERNEL_MODULES_TOUCHSCREEN = " \
    kernel-module-ads7846 \
 "

IMAGE_INSTALL += " \
    ${QT_TOOLS} \
    ${TS_TOOLS} \
    ${KERNEL_MODULES_TOUCHSCREEN} \
 "

