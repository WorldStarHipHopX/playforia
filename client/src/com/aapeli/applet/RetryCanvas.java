package com.aapeli.applet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class RetryCanvas extends Canvas implements MouseMotionListener, MouseListener {

    private static final Color aColor128 = new Color(64, 64, 224);
    private static final Color aColor129 = new Color(224, 224, 255);
    private static final Font aFont130 = new Font("Dialog", 0, 12);
    private Color aColor131;
    private Color aColor132;
    private Color aColor133;
    private Color aColor134;
    private String aString135;
    private boolean aBoolean136;
    private boolean aBoolean137;
    private ActionListener anActionListener138;
    private int anInt139;
    private int anInt140;
    private Image anImage141;
    private Graphics aGraphics142;
    private static final String aString143 = "Dialog";


    protected RetryCanvas(String var1, int var2, int var3, ActionListener var4) {
        this.setBackground(aColor128);
        this.setForeground(aColor129);
        this.anInt139 = var2;
        this.anInt140 = var3;
        this.setSize(var2, var3);
        this.setFont(aFont130);
        this.aString135 = var1;
        this.anActionListener138 = var4;
        this.aBoolean136 = this.aBoolean137 = false;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        this.aBoolean136 = this.aBoolean137 = false;
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        if (this.anImage141 == null) {
            this.anImage141 = this.createImage(this.anInt139, this.anInt140);
            this.aGraphics142 = this.anImage141.getGraphics();
        }

        boolean var2 = this.aBoolean136;
        Color var3 = var2 ? this.aColor131 : aColor128;
        this.method220(this.aGraphics142, var3, this.anInt139, this.anInt140);
        if (this.aColor134 != null) {
            this.aGraphics142.setColor(this.aColor134);
        }

        this.method221(this.aGraphics142, this.anInt139, this.anInt140);
        this.aGraphics142.setColor(aColor129);
        this.aGraphics142.setFont(aFont130);
        this.aGraphics142.drawString(this.aString135, this.anInt139 / 2 - this.getFontMetrics(aFont130).stringWidth(this.aString135) / 2, this.anInt140 / 2 + aFont130.getSize() * 3 / 8 + 1);
        var1.drawImage(this.anImage141, 0, 0, this);
    }

    public void setBackground(Color var1) {
        super.setBackground(var1);
        this.aColor131 = this.method218(var1, 32);
        this.aColor132 = this.method218(var1, 48);
        this.aColor133 = this.method218(var1, -48);
        this.repaint();
    }

    public void mouseEntered(MouseEvent var1) {
        this.aBoolean136 = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent var1) {
        this.aBoolean136 = this.aBoolean137 = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean137 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean137;
        this.aBoolean137 = false;
        this.repaint();
        if (var2) {
            ActionEvent var3 = new ActionEvent(this, 1001, this.aString135);
            this.anActionListener138.actionPerformed(var3);
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    private Color method218(Color var1, int var2) {
        int var3 = this.method219(var1.getRed(), var2);
        int var4 = this.method219(var1.getGreen(), var2);
        int var5 = this.method219(var1.getBlue(), var2);
        return new Color(var3, var4, var5);
    }

    private int method219(int var1, int var2) {
        var1 += var2;
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 > 255) {
            var1 = 255;
        }

        return var1;
    }

    private void method220(Graphics var1, Color var2, int var3, int var4) {
        int var5 = var2.getRed();
        int var6 = var2.getGreen();
        int var7 = var2.getBlue();
        int var8 = var5;
        int var9 = var6;
        int var10 = var7;

        int var11;
        for (var11 = var4 / 2; var11 >= 0; --var11) {
            var1.setColor(new Color(var8, var9, var10));
            var1.drawLine(0, var11, var3 - 1, var11);
            var8 = this.method219(var8, 3);
            var9 = this.method219(var9, 3);
            var10 = this.method219(var10, 3);
        }

        var8 = var5;
        var9 = var6;
        var10 = var7;

        for (var11 = var4 / 2 + 1; var11 < var4; ++var11) {
            var8 = this.method219(var8, -3);
            var9 = this.method219(var9, -3);
            var10 = this.method219(var10, -3);
            var1.setColor(new Color(var8, var9, var10));
            var1.drawLine(0, var11, var3 - 1, var11);
        }

    }

    private void method221(Graphics var1, int var2, int var3) {
        if (this.aColor134 == null) {
            var1.setColor(!this.aBoolean137 ? this.aColor133 : this.aColor132);
        }

        var1.drawRect(0, 0, var2 - 1, var3 - 1);
        if (this.aColor134 == null) {
            var1.setColor(!this.aBoolean137 ? this.aColor132 : this.aColor133);
        }

        var1.drawLine(0, 0, var2 - 1, 0);
        var1.drawLine(0, 0, 0, var3 - 1);
    }

}
