# A minimal console image with some C/C++ dev tools
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

require core-image-minimal.bb


DEV_SDK_INSTALL = " \
       binutils \
       binutils-symlinks \
       coreutils \
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
       findutils \
       less \
       ldd \
       file \
 "

DEV_EXTRA_TOOLS_INSTALL = " \
	task-core-ssh-openssh \
	devmem2 \
	git \
	vim-tiny \
 "

IMAGE_INSTALL += " \	
	${DEV_SDK_INSTALL} \
	${DEV_EXTRA_TOOLS_INSTALL} \
 "

