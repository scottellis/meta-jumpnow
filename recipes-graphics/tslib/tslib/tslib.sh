#!/bin/sh

if [ -e /dev/input/touchscreen0 ]; then
    TSLIB_TSDEVICE=/dev/input/touchscreen0
    export TSLIB_TSDEVICE
fi

TSLIB_TSEVENTTYPE=INPUT
export TSLIB_TSEVENTTYPE

TSLIB_CONSOLEDEVICE=none
export TSLIB_CONSOLEDEVICE

TSLIB_FBDEVICE=/dev/fb0
export TSLIB_FBDEVICE

TSLIB_CALIBFILE=/etc/pointercal
export TSLIB_CALIBFILE

TSLIB_CONFFILE=/etc/ts.conf
export TSLIB_CONFFILE

TSLIB_PLUGINDIR=/usr/lib/ts
export TSLIB_PLUGINDIR

