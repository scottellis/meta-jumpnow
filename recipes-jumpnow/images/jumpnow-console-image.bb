# A console development image with some C/C++ dev tools

require jumpnow-boot-image.bb

CORE_OS = " \
    avahi \
    busybox-hwclock \
    ntp \
    ntp-tickadj \
    task-core-ssh-openssh openssh-keygen \
    tzdata \
 "

# Custom kernel modules built out of tree
KERNEL_MODULES_OOT = ""

KERNEL_MODULES_OOT_overo = " \
    omap3-pwm \
    omap3-mux \
    omap3-irqlat \
    hrt-test \
    udelay-test \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
    ${KERNEL_MODULES_OOT} \
 "

WIFI_SUPPORT = " \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-wl12xx \
    wpa-supplicant \
 "

WIFI_SUPPORT_duovero = " \
    linux-firmware-sd8687 \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-wl12xx \
    wpa-supplicant \
 "

WIFI_SUPPORT_overo = " \
    linux-firmware-sd8686 \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-wl12xx \
    wpa-supplicant \
 "

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
 "

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    ethtool \
    findutils \
    i2c-tools \
    iperf \
    less \
    nano \
    sysfsutils \
    tcpdump \
    unzip \
    wget \
    zip \
 "

ALSA_TOOLS = " \
    alsa-lib \
    alsa-lib-dev \
    alsa-tools \
    alsa-utils \
 "

MISC_EXTRA = ""

MISC_EXTRA_overo = " \
    polladc \
 "

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${ALSA_TOOLS} \
    ${MISC_EXTRA} \
    ${WIFI_SUPPORT} \
 "

export IMAGE_BASENAME = "jumpnow-console-image"


