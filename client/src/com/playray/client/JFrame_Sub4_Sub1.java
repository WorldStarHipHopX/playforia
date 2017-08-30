package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.Class111;
import com.playray.client.JFrame_Sub4;
import com.playray.client.SPanel_Sub39;

import java.awt.Component;

class JFrame_Sub4_Sub1 extends JFrame_Sub4 {

    private static final String aString3634 = "Localized_GameClientName";
    private Class111 aClass111_3635;
    private SPanel_Sub39 aSPanel_Sub39_3636;
    private static final String aString3637 = " - ";


    protected JFrame_Sub4_Sub1(AApplet var1, Class111 var2, int var3, int var4) {
        super(var1);
        this.aClass111_3635 = var2;
        this.aSPanel_Sub39_3636 = new SPanel_Sub39(var1, this, var3, var4);
    }

    protected void method2343(Component var1) {
        String var2 = this.aSPanel_Sub39_3636.method2812();
        if (this.anAApplet2260.aTextManager3821.isAvailable("Localized_GameClientName")) {
            var2 = var2 + " - " + this.anAApplet2260.aTextManager3821.method2039("Localized_GameClientName");
        }

        this.method2342(var1, var2, this.aSPanel_Sub39_3636);
    }

    protected void close() {
        super.close();
        this.aClass111_3635.method1903();
        this.aSPanel_Sub39_3636 = null;
        this.aClass111_3635 = null;
    }

}
