#!/bin/bash

if [ "x${1}" = "x" ]; then
	echo -e "\nUsage: ${0} <block device>\n"
	exit 0
fi

if [[ -z "${OETMP}" ]]; then
	echo "Working from local directory"
else
	echo "Using OETMP $OETMP"

	if [ -d ${OETMP}/deploy/images ]; then
		cd ${OETMP}/deploy/images
	else
		echo "Directory not found: ${OETMP}/deploy/images"
		exit 1
	fi
fi 

if [[ -z "${MACHINE}" ]]; then
	echo "Environment variable MACHINE not found!"
	echo "Example: export MACHINE=overo or export MACHINE=duovero"
	exit 1
else
	echo "Using MACHINE $MACHINE"
fi

DEV=/dev/${1}2

if [ -b $DEV ]; then
	echo "Formatting $DEV as ext3"
	sudo mkfs.ext3 -L ROOT $DEV

	echo "Mounting $DEV"
	sudo mount $DEV /media/card

	echo "Untar'ing rootfs to /media/card"
#	sudo tar -C /media/card -xjf jumpnow-boot-image-${MACHINE}.tar.bz2
#	sudo tar -C /media/card -xjf jumpnow-console-image-${MACHINE}.tar.bz2
	sudo tar -C /media/card -xjf jumpnow-qte-image-${MACHINE}.tar.bz2

	echo "Umounting $DEV"
	sudo umount $DEV
else
	echo "Block special file $DEV does not exist"
fi

if [[ -z "${OETMP}" ]]; then
	echo "Done"
else
	cd $OLDPWD
	echo "Done"
fi
