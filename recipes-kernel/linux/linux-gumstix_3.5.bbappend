FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += " \
    file://no_spam_on_clk_set_parent_fail.patch \
    file://twl4030-usb-adc36-enable.patch \
 "

