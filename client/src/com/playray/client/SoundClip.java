package com.playray.client;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JApplet;

class SoundClip {

    private JApplet aJApplet1828;
    private URL anURL1829;
    private String aString1830;
    private boolean aBoolean1831;
    private AudioClip anAudioClip1832;
    private boolean aBoolean1833;
    private static final String[] aStringArray1834 = new String[2];


    protected SoundClip(JApplet var1, URL var2, String var3, boolean var4) {
        this.aJApplet1828 = var1;
        this.anURL1829 = var2;
        this.aString1830 = var3;
        this.aBoolean1831 = var4;
        this.anAudioClip1832 = null;
        this.aBoolean1833 = false;
    }

    protected boolean method1975() {
        return this.aBoolean1833;
    }

    protected void defineClip() {
        if (!this.aBoolean1833) {
            if (this.aBoolean1831) {
                System.out.println("SoundClip.defineClip(): \'dir\'=\"" + this.anURL1829 + "\", \'file\'=\"" + this.aString1830 + "\"");
            }

            //todo this.anAudioClip1832 = this.aJApplet1828.getAudioClip(this.anURL1829, this.aString1830);
            URL url = anURL1829;
            try {
                url = new URL(anURL1829, aString1830);
            } catch (Exception ex) {
            }
            anAudioClip1832 = Applet.newAudioClip(url);
            this.aBoolean1833 = true;
        }
    }

    protected AudioClip method1977() {
        return this.anAudioClip1832;
    }

    static {
        aStringArray1834[0] = "\", \'file\'=\"";
        aStringArray1834[1] = "SoundClip.defineClip(): \'dir\'=\"";
    }
}
