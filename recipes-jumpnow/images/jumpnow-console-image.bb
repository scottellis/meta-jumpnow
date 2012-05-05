# A minimal console image with some C/C++ dev tools

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
 "

IMAGE_INSTALL += " \
	kernel-modules \
	rpm \
	${DEV_SDK_INSTALL} \
	${DEV_EXTRA_TOOLS_INSTALL} \
 "

