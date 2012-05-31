require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "3.2"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
#SRCREV = "33128932803c3f8c35fe8dae257901deb60db2aa"
SRC_URI = "git://www.sakoman.com/git/linux-omap-2.6.git;branch=omap-3.2;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

