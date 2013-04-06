# A minimal booting image

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit image

IMAGE_FEATURES += "package-management"

BASE_INSTALL = " \
    base-files \
    base-passwd \
    busybox \
    coreutils \
    dbus \
    findutils \
    ifupdown \
    initscripts \
    keymaps \
    less \
    modutils-initscripts \
    netbase \
    systemd \
    systemd-analyze \
    tinylogin \
 "

IMAGE_INSTALL += " \	
    ${ROOTFS_PKGMANAGE} \
    ${BASE_INSTALL} \
 "


# this section removes remnants of legacy sysvinit support for packages
# installed above and some systemd scripts that aren't needed
IMAGE_FILE_BLACKLIST += " \
                        /etc/init.d/avahi-daemon \
                        /etc/init.d/bootlogd \
                        /etc/init.d/stop-bootlogd \
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

rootfs_fixup() {
    for i in ${IMAGE_FILE_BLACKLIST}; do
        rm -rf ${IMAGE_ROOTFS}$i
    done

    touch ${IMAGE_ROOTFS}/etc/default/rcS
}

ROOTFS_POSTPROCESS_COMMAND =+ "rootfs_fixup ; "

