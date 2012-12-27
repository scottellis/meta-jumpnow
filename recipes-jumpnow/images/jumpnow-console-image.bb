# A console development image with some C/C++ dev tools

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit image

IMAGE_FEATURES += "package-management"

BASE_INSTALL = " \
    coreutils \
    dbus \
    findutils \
    ifupdown \
    less \
    openssh-ssh openssh-keygen openssh-scp openssh-sshd-systemd \
    systemd systemd-compat-units \
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
    minicom \
    nano \
    systemd-analyze \
    sysfsutils \
    tcpdump \
    vim-tiny \
    media-ctl \
    yavta \
 "

PYTHON_EXTRA = " \
    python-pyserial \
 "

MISC_EXTRA = " \
    polladc \
 "

IMAGE_INSTALL += " \	
    task-core-boot \
    ${ROOTFS_PKGMANAGE} \
    ${BASE_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${DEV_SDK_INSTALL} \
    ${EXTRA_TOOLS_INSTALL} \
    ${WIFI_SUPPORT} \
    ${PYTHON_EXTRA} \
    ${MISC_EXTRA} \
 "


# this section removes remnants of legacy sysvinit support for packages
# installed above and some systemd scripts that aren't needed
IMAGE_FILE_BLACKLIST += " \
                        /etc/init.d/avahi-daemon \
                        /etc/init.d/bootmisc.sh \
                        /etc/init.d/dbus-1 \
                        /etc/init.d/mountnfs.sh \
                        /etc/init.d/umountnfs.sh \
                        /etc/init.d/udev \
                        /etc/init.d/udev-cache \
                        /lib/systemd/system/basic.target.wants/console-kit-log* \
                        /lib/systemd/system/halt.target.wants/console-kit-log* \
                        /lib/systemd/system/kexec.target.wants/console-kit-log* \
                        /lib/systemd/system/poweroff.target.wants/console-kit-log* \
                        /lib/systemd/system/reboot.target.wants/console-kit-log* \
                       "

remove_blacklist_files() {
        for i in ${IMAGE_FILE_BLACKLIST}; do
                rm -rf ${IMAGE_ROOTFS}$i
        done

}

ROOTFS_POSTPROCESS_COMMAND =+ "remove_blacklist_files ; "

