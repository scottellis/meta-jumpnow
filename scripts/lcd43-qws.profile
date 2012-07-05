source /usr/share/qtopia/environment-setup

export TSLIB_TSEVENTTYPE=INPUT
export TSLIB_CONSOLEDEVICE=none
export TSLIB_FBDEVICE=/dev/fb0
export TSLIB_TSDEVICE=/dev/input/touchscreen0
export TSLIB_CALIBFILE=/etc/pointercal
export TSLIB_CONFFILE=/etc/ts.conf
export TSLIB_PLUGINDIR=/usr/lib/ts
export QWS_MOUSE_PROTO=tslib:/dev/input/touchscreen0
export TSLIB_TSDEVICE=/dev/input/touchscreen0
#export QWS_KEYBOARD=linuxinput:/dev/input/event2
export QWS_SIZE=480x272
export QWS_DISPLAY="linuxfb:mmHeight=53:mmWidth=95"

