package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.JFrame_Sub4;
import com.playray.client.SPanel_Sub40;

import java.awt.Component;

public final class NeedAccountFrame extends JFrame_Sub4 {

    private SPanel_Sub40 aSPanel_Sub40_3632;
    private static final String aString3633 = "NeedAccount_Title";


    public NeedAccountFrame(AApplet var1) {
        super(var1);
        this.aSPanel_Sub40_3632 = new SPanel_Sub40(var1, this);
    }

    public void open() {
        this.open(this.anAApplet2260);
    }

    public void open(Component var1) {
        this.method2342(var1, this.anAApplet2260.aTextManager3821.getShared("NeedAccount_Title"), this.aSPanel_Sub40_3632);
    }

    public void close() {
        super.close();
        this.aSPanel_Sub40_3632 = null;
    }

}
