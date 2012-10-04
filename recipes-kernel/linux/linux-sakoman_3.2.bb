require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

#BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
BOOT_SPLASH = ""

PV = "3.2"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/linux-omap-2.6.git;branch=omap-3.2;protocol=git \
	   file://defconfig \
           file://libertas-async-fwload.patch \
           "

