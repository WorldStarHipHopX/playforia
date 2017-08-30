package com.aapeli.client;

import com.aapeli.applet.AApplet;

import java.awt.Component;

public final class NeedAccountFrame extends Frame_Sub3 {

    private AApplet anAApplet2893;
    private Panel_Sub23 aPanel_Sub23_2894;
    private static final String aString2895 = "NeedAccount_Title";


    public NeedAccountFrame(AApplet var1) {
        super(var1.textManager);
        this.anAApplet2893 = var1;
        this.aPanel_Sub23_2894 = new Panel_Sub23(var1, this);
    }

    public void open() {
        this.open(this.anAApplet2893);
    }

    public void open(Component var1) {
        this.method238(var1, this.anAApplet2893.textManager.getShared("NeedAccount_Title"), this.aPanel_Sub23_2894);
    }

    public void close() {
        super.close();
        this.aPanel_Sub23_2894 = null;
        this.anAApplet2893 = null;
    }

}
