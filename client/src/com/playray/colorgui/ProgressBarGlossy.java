package com.playray.colorgui;

import com.playray.colorgui.Glossy;
import com.playray.colorgui.Progress;
import com.playray.tools.Tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.geom.RoundRectangle2D.Float;
import java.awt.image.BufferedImage;

public class ProgressBarGlossy extends Progress implements Runnable {

    private int anInt4964;
    private boolean aBoolean4965;
    private int anInt4966;
    private int anInt4967;
    private BufferedImage aBufferedImage4968;


    public ProgressBarGlossy(int var1) {
        this(var1, 0.0D);
    }

    public ProgressBarGlossy(int var1, double var2) {
        this.setColor(var1);
        this.setProgress(var2);
        this.aBoolean4965 = false;
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        this.method2914(var1, var3, var4);
    }

    public void run() {
        do {
            Tools.sleep(10L);
            if (this.aBoolean4965) {
                int var1 = this.getSize().width;
                this.anInt4966 += var1 / 100;
                if (this.anInt4966 > var1 * 2) {
                    this.anInt4966 = -this.anInt4967;
                }

                if (this.anInt4966 < var1) {
                    this.repaint();
                }
            }
        } while (this.aBoolean4965);

    }

    public void setColor(int var1) {
        this.anInt4964 = var1;
        this.repaint();
    }

    public void setProgress(double var1) {
        super.setProgress(var1);
        if (this.isCompleted()) {
            this.stopGlowIndicator();
        }

    }

    public void startGlowIndicator() {
        if (!this.aBoolean4965) {
            this.anInt4967 = this.getSize().width / 3;
            this.aBufferedImage4968 = new BufferedImage(this.anInt4967, 1, 2);

            for (int var1 = 0; var1 < this.anInt4967; ++var1) {
                int var2 = (int) ((1.0D + Math.sin(6.283185307179586D * (double) var1 / (double) this.anInt4967 - 1.5707963267948966D)) * 48.0D);
                this.aBufferedImage4968.setRGB(var1, 0, (int) ((long) var2 * 256L * 256L * 256L + 16711680L + 65280L + 255L));
            }

            this.aBoolean4965 = true;
            this.anInt4966 = -this.anInt4967;
            Thread var3 = new Thread(this);
            var3.setDaemon(true);
            var3.start();
        }
    }

    public void stopGlowIndicator() {
        this.aBoolean4965 = false;
        if (this.aBufferedImage4968 != null) {
            this.aBufferedImage4968.flush();
            this.aBufferedImage4968 = null;
        }

        this.repaint();
    }

    private void method2914(Graphics2D var1, int var2, int var3) {
        int var4 = (int) (15.0D + (double) (var3 - 20) / 4.0D + 0.5D);
        Shape var5 = var1.getClip();
        this.method2915(var1, var2, var3, var4, Glossy.COLOR_NORMAL[10], Glossy.COLOR_GLOSSY[10], var2, (BufferedImage) null);
        this.method2915(var1, var2, var3, var4, Glossy.COLOR_NORMAL[this.anInt4964], Glossy.COLOR_GLOSSY[this.anInt4964], (int) ((double) var2 * this.getProgress() + 0.5D), this.aBufferedImage4968);
        var1.setClip(var5);
        Stroke var6 = var1.getStroke();
        var1.setStroke(new BasicStroke(2.0F));
        var1.setColor(Color.black);
        var1.drawRoundRect(0, 0, var2 - 1, var3 - 1, var4, var4);
        var1.setStroke(var6);
    }

    private void method2915(Graphics2D var1, int var2, int var3, int var4, Color var5, Color var6, int var7, BufferedImage var8) {
        var1.setClip(0, 0, var7, var3);
        byte var9 = 1;
        var1.setColor(var5);
        var1.fillRoundRect(var9, var9, var2 - var9 * 2, var3 - var9 * 2, var4, var4);
        var1.setColor(var6);
        var1.setClip(0, 0, var7, var3 / 4);
        var1.fillRoundRect(var9, var9, var2 - var9 * 2, var3 - var9 * 2, var4, var4);
        var1.setClip(1, var3 / 4, var7 - 1, var3 / 2 + 1 - var3 / 4);
        var1.fillRoundRect(var9, 1 - var3 / 2 + 2, var2 - var9 * 2, var3 - 3, var4 * 2, var4 / 2);
        var1.setClip(new Float((float) var9, (float) var9, (float) (var2 - var9 * 2), (float) (var3 - var9 * 2), (float) var4, (float) var4));
        int var10 = (var3 - var9 * 2) / 2;
        double var11 = 48.0D;
        double var13 = var11 / (double) var10;

        int var15;
        for (var15 = var9; var15 < var10; ++var15) {
            var1.setColor(new Color(255, 255, 255, (int) (var11 + 0.5D)));
            var1.drawLine(var9, var15, var2 - var9 * 2, var15);
            var1.drawLine(var9, var3 - var15, var2 - var9 * 2, var3 - var15);
            var11 -= var13;
        }

        if (var8 != null) {
            var15 = Math.min(var7 + var4, var2);
            Double var16 = new Double(0.0D, 0.0D, (double) var15, (double) var3, (double) var4, (double) var4);
            Area var17 = new Area(var16);
            Rectangle var18 = new Rectangle(var7, 0, var2 - var7, var3);
            var17.subtract(new Area(var18));
            var1.setClip(var17);
            var1.drawImage(var8, this.anInt4966, 0, this.anInt4966 + this.anInt4967, var3, 0, 0, this.anInt4967, 1, this);
        }

    }
}
