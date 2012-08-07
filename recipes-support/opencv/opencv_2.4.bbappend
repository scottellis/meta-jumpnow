FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://code.opencv.org/opencv.git;tag=2.4.2;protocol=git \
           file://0001-Fix-CMakeLists.txt-numpy-detection.patch \
          "

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"


