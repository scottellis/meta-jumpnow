# A console development image with some C/C++ dev tools

require recipes-core/images/core-image-minimal.bb

BASE_INSTALL = " \
    coreutils \
    less \
    findutils \
    systemd \
    task-core-ssh-openssh \
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
    iw \
    wpa-supplicant \
    rfkill \
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
    iperf \
    systemd-analyze \
    tcpdump \
    vim-tiny \
    media-ctl \
    yavta \
 "

PYTHON_EXTRA = " \
    python-pyserial \
 "

IMAGE_INSTALL += " \	
    ${BASE_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${DEV_SDK_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${WIFI_SUPPORT} \
    ${PYTHON_EXTRA} \
 "


# this section removes remnants of legacy sysvinit support
# for packages installed above
IMAGE_FILE_BLACKLIST += " \
                        /etc/init.d/avahi-daemon \
                        /etc/init.d/dbus-1 \
                        /etc/init.d/mountnfs.sh \
                        /etc/init.d/umountnfs.sh \
                       "

remove_blacklist_files() {
        for i in ${IMAGE_FILE_BLACKLIST}; do
                rm -rf ${IMAGE_ROOTFS}$i
        done

}

ROOTFS_POSTPROCESS_COMMAND =+ "remove_blacklist_files ; "

