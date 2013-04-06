# A console development image with some C/C++ dev tools

require jumpnow-boot-image.bb

# Custom kernel modules built out of tree
KERNEL_MODULES_OOT = " \
    pwm-module \
    mux-module \
    irqlat-module \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
    ${KERNEL_MODULES_OOT} \
 "

WIFI_SUPPORT = " \
    linux-firmware-sd8686 \
    iw \
    wpa-supplicant \
    wlan-udev-rules \
 "

DEV_SDK_INSTALL = " \
   binutils \
   binutils-symlinks \
   cpp \
   cpp-symlinks \
   diffutils \
   file \
   gcc \
   gcc-symlinks \
   g++ \
   g++-symlinks \
   gettext \
   ldd \
   libstdc++ \
   libstdc++-dev \
   libtool \
   make \
   pkgconfig \
 "

EXTRA_TOOLS_INSTALL = " \
    devmem2 \
    git \
    i2c-tools \
    iperf \
    nano \
    openssh-ssh openssh-keygen openssh-scp openssh-sshd-systemd \
    systemd-analyze \
    sysfsutils \
    tcpdump \
    vim-tiny \
  "

PYTHON_EXTRA = " \
    python-pyserial \
    python-fcntl \
 "

MISC_EXTRA = " \
    polladc \
 "

IMAGE_INSTALL += " \	
    ${KERNEL_EXTRA_INSTALL} \
    ${DEV_SDK_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${WIFI_SUPPORT} \
    ${PYTHON_EXTRA} \
    ${MISC_EXTRA} \
 "

