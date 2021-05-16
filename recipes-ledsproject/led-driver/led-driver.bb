SUMMARY = "Leds driver with multiple interfaces"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRC_URI = "file://hello.c"
#SRCREV = "8f6c34c923bd89787a8c69d2426566e7d0a6ccde"
SRCREV = "master"
SRC_URI = "git:///home/isidro/embedded-linux/rpi-ws2812-server/"
S = "${WORKDIR}/git"

#do_compile() {
#${CC} ${LDFLAGS} hello.c -o hello
#}

#do_install() {
#install -d ${D}${bindir}
#install -m 0755 hello ${D}${bindir}
#}

# Si no pongo esto me dice que no le he pasado ldflags, pero yo si lo hago, no entiendo
INSANE_SKIP_${PN} += "ldflags"

FILES_${PN} = "${bindir}/ws2812svr"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}'  'BUILDDIR=${S}' "
do_install() {
    oe_runmake install DEST_DIR=${D}${bindir}  'LDFLAGS=${LDFLAGS}'
}

