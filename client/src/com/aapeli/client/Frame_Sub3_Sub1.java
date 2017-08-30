package com.aapeli.client;

import com.aapeli.applet.AApplet;

import java.awt.Component;

class Frame_Sub3_Sub1 extends Frame_Sub3 {

    private Class78 aClass78_2884;
    private IPanel_Sub40 anIPanel_Sub40_2885;


    protected Frame_Sub3_Sub1(AApplet var1, Class78 var2, int var3, int var4) {
        super(var1.textManager);
        this.aClass78_2884 = var2;
        this.anIPanel_Sub40_2885 = new IPanel_Sub40(var1, this, var3, var4);
    }

    protected void method239(Component var1) {
        String var2 = this.anIPanel_Sub40_2885.method820();
        if (super.aTextManager187.isAvailable("Localized_GameClientName")) {
            var2 = var2 + " - " + super.aTextManager187.getGame("Localized_GameClientName");
        }

        this.method238(var1, var2, this.anIPanel_Sub40_2885);
    }

    protected void close() {
        super.close();
        this.aClass78_2884.method1603();
        this.anIPanel_Sub40_2885 = null;
        this.aClass78_2884 = null;
    }

}
