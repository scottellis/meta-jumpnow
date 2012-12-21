This layer depends on:

        URI: git://git.yoctoproject.org/poky.git
        branch: denzil
        revision: HEAD
        commit: ef745cb 

        URI: git://git.openembedded.org/meta-openembedded
        branch: denzil
        revision: HEAD
        commit: e77646b

        meta-jumpnow layer maintainer: Scott Ellis <scott@pansenti.com>

Some notes for setting up and using this repository can be found here 

[Building Gumstix images with Yocto](http://www.jumpnowtek.com/index.php?option=com_content&view=article&id=85)



Bugs:

1) To get rid of the console-kit-log error on startup or when rebooting 
run this

        root@duovero:~# rm /lib/systemd/system/basic.target.wants/console-kit*
        root@duovero:~# rm /lib/systemd/system/halt.target.wants/console-kit*
        root@duovero:~# rm /lib/systemd/system/kexec.target.wants/console-kit*
        root@duovero:~# rm /lib/systemd/system/poweroff.target.wants/console-kit*
        root@duovero:~# rm /lib/systemd/system/reboot.target.wants/console-kit*

