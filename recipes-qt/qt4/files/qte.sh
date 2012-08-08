#!/bin/sh

if [ -e /dev/input/touchscreen0 ]
then
    QWS_MOUSE_PROTO=Tslib:/dev/input/touchscreen0
    export QWS_MOUSE_PROTO
fi

QWS_SIZE=480x272
export QWS_SIZE

QWS_DISPLAY="linuxfb:mmHeight=53:mmWidth=95"
export QWS_DISPLAY

# For development convenience, can remove later for production
if [ -e /usr/share/qtopia/environment-setup ]
then
    source /usr/share/qtopia/environment-setup
fi

