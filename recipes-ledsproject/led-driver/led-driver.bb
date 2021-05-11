SUMMARY = "Leds driver with multiple interfaces"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.c"

do_compile() {
${CC} hello.c -o hello
}

do_install() {
install -d ${D}${bindir}
install -m 0755 hello ${D}${bindir}
}
