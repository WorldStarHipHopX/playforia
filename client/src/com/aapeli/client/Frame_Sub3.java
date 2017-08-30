package com.aapeli.client;

import com.aapeli.client.Panel_Sub24;
import com.aapeli.client.TextManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

abstract class Frame_Sub3 extends Frame implements WindowListener {

    protected TextManager aTextManager187;
    private int anInt188;
    private int anInt189;
    private Color aColor190;


    protected Frame_Sub3(TextManager var1) {
        this.aTextManager187 = var1;
        this.anInt188 = this.anInt189 = 0;
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anInt188 > 0 && this.anInt189 > 0) {
            var1.setColor(this.aColor190);
            var1.fillRect(0, 0, this.anInt188, this.anInt189);
        }

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

    protected void method238(Component var1, String var2, Panel var3) {
        this.setTitle(var2);
        this.aColor190 = var3.getBackground();
        this.setVisible(true);
        Insets var4 = this.getInsets();
        Dimension var5 = var3.getSize();
        this.anInt188 = var4.left + var5.width + var4.right;
        this.anInt189 = var4.top + var5.height + var4.bottom;
        this.setSize(this.anInt188, this.anInt189);
        this.setResizable(false);
        Point var6 = var1.getLocationOnScreen();
        Dimension var7 = var1.getSize();
        this.setLocation(var6.x + var7.width / 2 - this.anInt188 / 2, var6.y + var7.height / 2 - this.anInt189 / 2);
        this.setBackground(Panel_Sub24.aColor616);
        this.setLayout((LayoutManager) null);
        var3.setLocation(var4.left, var4.top);
        this.add(var3);
        this.addWindowListener(this);
        this.toFront();
        this.requestFocus();
    }

    protected void close() {
        this.dispose();
    }
}
