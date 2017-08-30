package com.playray.colorgui;

import com.playray.colorgui.Progress;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

public class ProgressBar extends Progress {

    public static final int TYPE_SOLID = 0;
    public static final int TYPE_SLIDE = 1;
    public static final int TYPE_BOX = 2;
    public static final int TYPE_GLOSSY = 3;
    private static final Color aColor4956 = new Color(0, 0, 0);
    private static final Color aColor4957 = new Color(255, 255, 255);
    private static final Color aColor4958 = new Color(0, 0, 255);
    private Color aColor4959;
    private Color aColor4960;
    private Color aColor4961;
    private int anInt4962;
    private int anInt4963;


    public ProgressBar() {
        this(0, 1, 0.0D);
    }

    public ProgressBar(int var1) {
        this(var1, 1, 0.0D);
    }

    public ProgressBar(int var1, int var2) {
        this(var1, var2, 0.0D);
    }

    public ProgressBar(int var1, int var2, double var3) {
        this.setBarType(var1);
        this.setBorderSize(var2);
        this.setBorderColor(aColor4956);
        this.setBackgroundColor(aColor4957);
        this.setBarColor(aColor4958);
        this.setProgress(var3);
    }

    public void paintContent(Graphics2D var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (this.anInt4962 != 3) {
            this.method2907(var1, var3, var4);
        } else {
            this.method2912(var1, var3, var4);
        }

    }

    public void setBarType(int var1) {
        this.anInt4962 = var1;
        this.repaint();
    }

    public void setBorderSize(int var1) {
        this.anInt4963 = var1;
    }

    public void setBorderColor(Color var1) {
        this.aColor4959 = var1;
        this.repaint();
    }

    public void setBackgroundColor(Color var1) {
        this.aColor4960 = var1;
        this.setBackground(this.aColor4960);
        this.repaint();
    }

    public void setBarColor(Color var1) {
        this.aColor4961 = var1;
        this.repaint();
    }

    private void method2907(Graphics2D var1, int var2, int var3) {
        var1.setColor(this.aColor4960);
        var1.fillRect(0, 0, var2, var3);
        int var4 = this.anInt4963;
        this.method2908(var1, var4, var4, var2 - var4 * 2, var3 - var4 * 2);
        if (var4 > 0) {
            var1.setColor(this.aColor4959);

            for (int var5 = 0; var5 < var4; ++var5) {
                var1.drawRect(var5, var5, var2 - var5 - 1, var3 - var5 - 1);
            }
        }

    }

    private void method2908(Graphics2D var1, int var2, int var3, int var4, int var5) {
        int var6 = (int) ((double) var4 * this.getProgress() + 0.5D);
        if (var6 != 0) {
            if (this.anInt4962 == 0) {
                this.method2909(var1, var2, var3, var6, var5);
            } else if (this.anInt4962 == 1) {
                this.method2910(var1, var2, var3, var6, var5);
            } else if (this.anInt4962 == 2) {
                this.method2911(var1, var2, var3, var6, var5);
            }

        }
    }

    private void method2909(Graphics2D var1, int var2, int var3, int var4, int var5) {
        var1.setColor(this.aColor4961);
        var1.fillRect(var2, var3, var4, var5);
    }

    private void method2910(Graphics2D var1, int var2, int var3, int var4, int var5) {
        int var6 = this.aColor4961.getRed();
        int var7 = this.aColor4961.getGreen();
        int var8 = this.aColor4961.getBlue();
        int var9 = (this.aColor4960.getRed() + var6) / 2;
        int var10 = (this.aColor4960.getGreen() + var7) / 2;
        int var11 = (this.aColor4960.getBlue() + var8) / 2;
        int var12 = var6 - var9;
        int var13 = var7 - var10;
        int var14 = var8 - var11;
        double var15 = 1.0D * (double) var12 / (double) var4;
        double var17 = 1.0D * (double) var13 / (double) var4;
        double var19 = 1.0D * (double) var14 / (double) var4;

        for (int var21 = 0; var21 < var4; ++var21) {
            var1.setColor(new Color((int) ((double) var9 + var15 * (double) var21 + 0.5D), (int) ((double) var10 + var17 * (double) var21 + 0.5D), (int) ((double) var11 + var19 * (double) var21 + 0.5D)));
            var1.drawLine(var2 + var21, var3, var2 + var21, var3 + var5 - 1);
        }

    }

    private void method2911(Graphics2D var1, int var2, int var3, int var4, int var5) {
        int var6 = var5 * 2 / 3;
        int var7 = (var4 + var6 / 2) / var6;
        double var8 = this.getProgress();
        if (var8 > 0.0D && var7 == 0) {
            var7 = 1;
        }

        if (var8 == 1.0D && var7 * var6 < var4) {
            ++var7;
        }

        var1.setColor(this.aColor4961);

        for (int var10 = 0; var10 < var7; ++var10) {
            var1.fillRect(var2 + var10 * var6 + 1, var3 + 1, var6 - 2, var5 - 2);
        }

    }

    private void method2912(Graphics2D var1, int var2, int var3) {
        Color var4 = this.aColor4960;
        Color var5 = var4.brighter();
        Color var6 = this.aColor4961;
        Color var7 = var6.brighter();
        if (var5.equals(var4)) {
            var4 = var4.darker();
        }

        if (var7.equals(var6)) {
            var6 = var6.darker();
        }

        int var8 = (int) (15.0D + (double) (var3 - 20) / 4.0D + 0.5D);
        byte var9 = 1;
        Shape var10 = var1.getClip();
        this.method2913(var1, var2, var3, var8, var9, var4, var5, var2);
        this.method2913(var1, var2, var3, var8, var9, var6, var7, (int) ((double) var2 * this.getProgress() + 0.5D));
        var1.setClip(var10);
        Stroke var11 = var1.getStroke();
        var1.setStroke(new BasicStroke(2.0F));
        var1.setColor(this.aColor4959);
        var1.drawRoundRect(0, 0, var2 - 1, var3 - 1, var8, var8);
        var1.setStroke(var11);
    }

    private void method2913(Graphics2D var1, int var2, int var3, int var4, int var5, Color var6, Color var7, int var8) {
        var1.setClip(0, 0, var8, var3);
        var1.setColor(var6);
        var1.fillRoundRect(var5, var5, var2 - var5 * 2 - 1, var3 - var5 * 2 - 1, var4, var4);
        var1.setColor(var7);
        var1.setClip(0, 0, var8, var3 / 4);
        var1.fillRoundRect(var5, var5, var2 - var5 * 2 - 1, var3 - var5 * 2 - 1, var4, var4);
        var1.setClip(1, var3 / 4, var8 - 1, var3 / 2 + 1 - var3 / 4);
        var1.fillRoundRect(var5, 1 - var3 / 2 + 2, var2 - var5 * 2 - 1, var3 - 3, var2 / 3, var3 / 4);
    }

}
