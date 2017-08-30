package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.Class122;
import com.playray.client.JFrame_Sub4;
import com.playray.client.SPanel_Sub41;

import java.awt.Component;

class JFrame_Sub4_Sub2 extends JFrame_Sub4 {

    private Class122 aClass122_3638;
    private SPanel_Sub41 aSPanel_Sub41_3639;
    private static final String aString3640 = "TellFriend_Title";


    protected JFrame_Sub4_Sub2(AApplet var1, Class122 var2) {
        super(var1);
        this.aClass122_3638 = var2;
        this.aSPanel_Sub41_3639 = new SPanel_Sub41(var1, var2, this);
    }

    protected void method2344(Component var1) {
        this.method2342(var1, this.anAApplet2260.aTextManager3821.getShared("TellFriend_Title"), this.aSPanel_Sub41_3639);
    }

    protected void close() {
        super.close();
        this.aClass122_3638.method1995();
        this.aSPanel_Sub41_3639 = null;
        this.aClass122_3638 = null;
    }

}
