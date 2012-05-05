# 

require jumpnow-console-image.bb


QT_TOOLS = " \
	qt4-embedded \
	qt4-embedded-dev \
	libqtcore4 \
	libqtgui4 \
	libqtnetwork4 \
 "

OPENCV_TOOLS = " \
	opencv-dev \
	opencv-samples \
 "

IMAGE_INSTALL += " \
	${QT_TOOLS} \
	${OPENCV_TOOLS} \
 "

