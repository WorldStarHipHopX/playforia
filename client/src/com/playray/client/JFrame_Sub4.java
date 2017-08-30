package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.SPanel;
import com.playray.client.SPanel_Sub41;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

abstract class JFrame_Sub4 extends JFrame implements WindowListener {

    protected AApplet anAApplet2260;
    private int anInt2261;
    private int anInt2262;
    private static final String aString2263 = "icon.png";


    protected JFrame_Sub4(AApplet var1) {
        this.anAApplet2260 = var1;
        this.anInt2261 = this.anInt2262 = 0;
        this.setIconImage(var1.anImageManager3822.getShared("icon.png"));
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.close();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected void method2342(Component var1, String var2, SPanel var3) {
        this.setTitle(var2);
        this.setVisible(true);
        Insets var4 = this.getInsets();
        Dimension var5 = var3.getSize();
        this.anInt2261 = var4.left + var5.width + var4.right;
        this.anInt2262 = var4.top + var5.height + var4.bottom;
        this.setSize(this.anInt2261, this.anInt2262);
        this.setResizable(false);
        Point var6 = var1.getLocationOnScreen();
        Dimension var7 = var1.getSize();
        this.setLocation(var6.x + var7.width / 2 - this.anInt2261 / 2, var6.y + var7.height / 2 - this.anInt2262 / 2);
        this.setBackground(SPanel_Sub41.aColor4302);
        this.setLayout((LayoutManager) null);
        var3.setLocation(0, 0);
        this.add(var3);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
    }

    protected void close() {
        this.dispose();
    }

}
