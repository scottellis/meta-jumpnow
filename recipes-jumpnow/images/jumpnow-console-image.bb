# A minimal console image with some C/C++ dev tools
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

require recipes-core/images/core-image-minimal.bb

BASE_INSTALL = " \
    coreutils \
    less \
    findutils \
 "

KERNEL_MODULES_FTDI_SERIAL = " \
    kernel-module-usbserial \
    kernel-module-ftdi-sio \
 "

KERNEL_MODULES_UVCVIDEO = " \
    kernel-module-media \
    kernel-module-videodev \
    kernel-module-uvcvideo \
 "

# Custom kernel modules built out of tree
KERNEL_MODULES_OOT = " \
    pwm-module \
 "

KERNEL_EXTRA_INSTALL = " \
    ${KERNEL_MODULES_FTDI_SERIAL} \
    ${KERNEL_MODULES_UVCVIDEO} \
    ${KERNEL_MODULES_OOT} \
 "

DEV_SDK_INSTALL = " \
   binutils \
   binutils-symlinks \
   cpp \
   cpp-symlinks \
   diffutils \
   gcc \
   gcc-symlinks \
   g++ \
   g++-symlinks \
   gettext \
   make \
   libstdc++ \
   libstdc++-dev \
   libtool \
   pkgconfig \
   ldd \
   file \
 "

DEV_EXTRA_TOOLS_INSTALL = " \
    task-core-ssh-openssh \
    devmem2 \
    git \
    vim-tiny \
    iperf \
    libusb1-dev \
    systemd-analyze \
 "

OPENCV_DEV = " \
    opencv-dev \
    opencv-samples-dev \
 "

IMAGE_INSTALL += " \	
    ${BASE_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRA_TOOLS_INSTALL} \
    ${OPENCV_DEV} \
 "

