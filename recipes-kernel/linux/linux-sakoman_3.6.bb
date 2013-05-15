require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "duovero"

PV = "3.6"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/linux.git;branch=omap-3.6;protocol=git \
	   file://defconfig \
          "
