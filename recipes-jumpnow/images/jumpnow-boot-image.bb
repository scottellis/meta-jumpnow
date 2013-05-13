# A minimal sysvinit boot image

LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
 "

export IMAGE_BASENAME = "jumpnow-boot-image"

