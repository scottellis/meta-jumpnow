#!/bin/bash

if [ "x${1}" = "x" ]; then
	echo -e "\nUsage: ${0} <block device>\n"
	exit 0
fi

if [[ -z "${OETMP}" ]]; then
	echo "Working from local directory"
else
	echo -e "\nOETMP: $OETMP"

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
	echo -e "MACHINE: $MACHINE\n"
fi

DEV=/dev/${1}1

if [ -b $DEV ]; then
	echo "Formatting FAT partition on $DEV"
	sudo mkfs.vfat -F 32 ${DEV} -n BOOT

	echo "Mounting $DEV"
	sudo mount ${DEV} /media/card

	echo "Copying MLO"
	sudo cp MLO-${MACHINE} /media/card/MLO
	echo "Copying u-boot"
	sudo cp u-boot-${MACHINE}.img /media/card/u-boot.img

	if [ -f boot.scr ]; then
		echo "Copying boot.scr"
		sudo cp boot.scr /media/card/boot.scr

		if [ -f boot.cmd ]; then
			echo "Copying boot.cmd"
			sudo cp boot.cmd /media/card/boot.cmd
		fi
	fi

	echo "Copying uImage"
	sudo cp uImage-${MACHINE}.bin /media/card/uImage

	echo "Unmounting ${DEV}"
	sudo umount ${DEV}
else
	echo -e "\nBlock device $DEV does not exist!\n"
fi


if [[ -z "${OETMP}" ]]; then
	echo "Done"
else
	cd $OLDPWD
	echo "Done"
fi
