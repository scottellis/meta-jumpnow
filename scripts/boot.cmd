setenv bootargs "console=ttyO2,115200n8 mpurate=500 root=/dev/mmcblk0p2 rw rootfstype=ext3 rootwait"
setenv loadaddr 0x82000000
fatload mmc 0 ${loadaddr} uImage
bootm ${loadaddr}
