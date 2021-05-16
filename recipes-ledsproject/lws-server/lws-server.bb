SUMMARY = "Web server to send commands to led driver"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "libwebsockets"
SRCREV = "master"
SRC_URI = "git:///home/isidro/embedded-linux/minimal-ws-server/"
S = "${WORKDIR}/git"

inherit cmake

web_files = "${sysconfdir}/${PN}"

do_install_append() {
    mkdir -p ${D}${web_files}
    install ${S}/mount-origin/* ${D}${web_files}/
}

#FILES_${PN}_append = "${web_files}/index.html" 
FILES_${PN}_append = "${web_files}/*" 

#FILES_${PN} = "${bindir}/lws-minimal-ws-server"
# TODO: Añadir ficheros mout origin
