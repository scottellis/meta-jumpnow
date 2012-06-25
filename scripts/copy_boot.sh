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


DEV=/dev/${1}1

if [ -b $DEV ]; then
	echo "Formatting FAT partition on $DEV"
	sudo mkfs.vfat -F 32 ${DEV} -n BOOT

	echo "Mounting $DEV"
	sudo mount ${DEV} /media/card

	echo "Copying MLO"
	sudo cp MLO /media/card/MLO
	echo "Copying u-boot"
	sudo cp u-boot.img /media/card/u-boot.img

	if [ -f boot.scr ]; then
		echo "Copying boot.scr"
		sudo cp boot.scr /media/card/boot.scr

		if [ -f boot.cmd ]; then
			echo "Copying boot.cmd"
			sudo cp boot.cmd /media/card/boot.cmd
		fi
	fi

	echo "Copying uImage"
	sudo cp uImage-overo.bin /media/card/uImage

	echo "Syncing writes"
	sync

	echo "Unmounting ${DEV}"
	sudo umount ${DEV}
else
	echo -e "\nBlock special file $DEV does not exist!\n"
fi


if [[ -z "${OETMP}" ]]; then
	echo "Done"
else
	cd $OLDPWD
	echo "Done"
fi
