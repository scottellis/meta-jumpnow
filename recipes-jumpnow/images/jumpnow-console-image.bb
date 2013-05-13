# A console development image with some C/C++ dev tools

require jumpnow-boot-image.bb

CORE_TOOLS = " \
    task-core-ssh-openssh openssh-keygen \
 "

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
    linux-firmware-rtl8192su \
    linux-firmware-wl12xx \
    wpa-supplicant \
 "

#    linux-firmware-rtl8192cu
#    linux-firmware-rtl8192ce

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
    ethtool \
    git \
    sysfsutils \
 "

PYTHON_EXTRA = " \
    python-fcntl \
    python-pyserial \
 "

MISC_EXTRA = " \
    polladc \
 "

IMAGE_INSTALL += " \
    ${CORE_TOOLS} \
    ${KERNEL_EXTRA_INSTALL} \
    ${DEV_SDK_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${WIFI_SUPPORT} \
 "

export IMAGE_BASENAME = "jumpnow-console-image"


