SUMMARY = "Syntro V4L camera application"
HOMEPAGE = "http://www.pansenti.com"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit qt4e pkgconfig

DEPENDS += "syntrocore"

PR = "2"

SRC_URI = "ftp://www.pansenti.com/syntro/SyntroV4LCamera-${PV}.tar.bz2"
SRC_URI[md5sum] = "4bfee15d0091b82eb0850977c18f03a9"
SRC_URI[sha256sum] = "1af63809f3a36fcbb72b5d15ce9af24c03d62c35114bab9b3c5368810a779211"

S = "${WORKDIR}"

do_install() {
	export INSTALL_ROOT=${D}
	make install
}

FILES_${PN} = "${bindir}"

