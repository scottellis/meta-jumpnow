# 

require jumpnow-console-image.bb


QT_TOOLS = " \
	qt4-x11-free-dev\
	qt4-x11-free \
	libqtcore4 \
	libqtgui4 \
	libqtnetwork4 \
 "

IMAGE_INSTALL += " \
	${QT_TOOLS} \
 "

