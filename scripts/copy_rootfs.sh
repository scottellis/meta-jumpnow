#!/bin/bash

if [ "x${1}" = "x" ]; then
	echo -e "\nUsage: ${0} <block device>\n"
	exit 0
fi

if [ "x${2}" = "x" ]; then
    IMAGE=qte
else
    IMAGE=${2}
fi

if [[ -z "${OETMP}" ]]; then
	echo "Working from local directory"
else
	echo "Using OETMP: $OETMP"

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
	echo "Using MACHINE: $MACHINE"
fi

if [ ! -f "jumpnow-${IMAGE}-image-${MACHINE}.tar.bz2" ]; then
    echo "Root filesystem not found: jumpnow-${IMAGE}-image-${MACHINE}.tar.bz2"

    if [[ ! -z "${OETMP}" ]]; then
        cd $OLDPWD
    fi

    exit 1
fi

echo -e "Using IMAGE: $IMAGE\n"

DEV=/dev/${1}2

if [ -b $DEV ]; then
	echo "Formatting $DEV as ext3"
	sudo mkfs.ext3 -L ROOT $DEV

	echo "Mounting $DEV"
	sudo mount $DEV /media/card

	echo "Untar'ing rootfs to /media/card"
	sudo tar -C /media/card -xjf jumpnow-${IMAGE}-image-${MACHINE}.tar.bz2

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
