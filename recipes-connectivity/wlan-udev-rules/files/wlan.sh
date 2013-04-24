#!/bin/sh

if [ "$INTERFACE" = "wlan0" ]; then
  case $ACTION in
    add)
        /usr/sbin/wpa_supplicant -Dwext -iwlan0 -c/etc/wpa_supplicant.conf -B
        sleep 1
        /sbin/udhcpc -iwlan0
    ;;
    remove)
        /usr/bin/killall wpa_supplicant
    ;;
  esac
fi

