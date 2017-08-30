package com.aapeli.client;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

class Class86 {

    private Applet anApplet1473;
    private URL anURL1474;
    private String aString1475;
    private boolean aBoolean1476;
    private AudioClip anAudioClip1477;
    private boolean aBoolean1478;
    private static final String[] aStringArray1479 = new String[2];


    protected Class86(Applet var1, URL var2, String var3, boolean var4) {
        this.anApplet1473 = var1;
        this.anURL1474 = var2;
        this.aString1475 = var3;
        this.aBoolean1476 = var4;
        this.anAudioClip1477 = null;
        this.aBoolean1478 = false;
    }

    protected boolean method1682() {
        return this.aBoolean1478;
    }

    protected void method1683() {
        if (!this.aBoolean1478) {
            if (this.aBoolean1476) {
                System.out.println("SoundClip.defineClip(): \'dir\'=\"" + this.anURL1474 + "\", \'file\'=\"" + this.aString1475 + "\"");
            }

            //todo this.anAudioClip1477 = this.anApplet1473.getAudioClip(this.anURL1474, this.aString1475);
            URL url = anURL1474;
            try {
                url = new URL(anURL1474, aString1475);
            } catch (Exception ex) {
            }
            anAudioClip1477 = Applet.newAudioClip(url);
            this.aBoolean1478 = true;
        }
    }

    protected AudioClip method1684() {
        return this.anAudioClip1477;
    }

    static {
        aStringArray1479[0] = "SoundClip.defineClip(): \'dir\'=\"";
        aStringArray1479[1] = "\", \'file\'=\"";
    }
}
