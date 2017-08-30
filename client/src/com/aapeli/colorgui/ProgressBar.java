package com.aapeli.colorgui;

import com.aapeli.client.IPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;

public class ProgressBar extends IPanel {

    public static final int TYPE_SOLID = 0;
    public static final int TYPE_SLIDE = 1;
    public static final int TYPE_BOX = 2;
    public static final int TYPE_GLOSSY = 3;
    private static final Color aColor3366 = new Color(0, 0, 0);
    private static final Color aColor3367 = new Color(255, 255, 255);
    private static final Color aColor3368 = new Color(0, 0, 255);
    private Color aColor3369;
    private Color aColor3370;
    private Color aColor3371;
    private int anInt3372;
    private int anInt3373;
    private double aDouble3374;
    private Image anImage3375;
    private Graphics aGraphics3376;
    private int anInt3377;
    private int anInt3378;


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
        this.setBorderColor(aColor3366);
        this.setBackgroundColor(aColor3367);
        this.setBarColor(aColor3368);
        this.setProgress(var3);
        this.anInt3377 = this.anInt3378 = -1;
    }

    public void update(Graphics var1) {
        Dimension var2 = this.getSize();
        int var3 = var2.width;
        int var4 = var2.height;
        if (var3 != this.anInt3377 || var4 != this.anInt3378) {
            this.anImage3375 = null;
        }

        if (this.anImage3375 == null) {
            try {
                this.anImage3375 = this.createImage(var3, var4);
                this.aGraphics3376 = this.anImage3375.getGraphics();
            } catch (NullPointerException var7) {
                return;
            }
        }

        this.aGraphics3376.setColor(this.aColor3370);
        this.aGraphics3376.fillRect(0, 0, var3, var4);
        int var5 = this.anInt3373;
        this.method866(this.aGraphics3376, var5, var5, var3 - var5 * 2, var4 - var5 * 2);
        if (var5 > 0) {
            this.aGraphics3376.setColor(this.aColor3369);

            for (int var6 = 0; var6 < var5; ++var6) {
                this.aGraphics3376.drawRect(var6, var6, var3 - var6 - 1, var4 - var6 - 1);
            }
        }

        var1.drawImage(this.anImage3375, 0, 0, this);
    }

    public void setBarType(int var1) {
        this.anInt3372 = var1;
        this.repaint();
    }

    public void setBorderSize(int var1) {
        this.anInt3373 = var1;
    }

    public void setBorderColor(Color var1) {
        this.aColor3369 = var1;
        this.repaint();
    }

    public void setBackgroundColor(Color var1) {
        this.aColor3370 = var1;
        this.setBackground(this.aColor3370);
        this.repaint();
    }

    public void setBarColor(Color var1) {
        this.aColor3371 = var1;
        this.repaint();
    }

    public void setProgress(double var1) {
        if (var1 < 1.0E-4D) {
            var1 = 0.0D;
        } else if (var1 > 0.9999D) {
            var1 = 1.0D;
        }

        this.aDouble3374 = var1;
        this.repaint();
    }

    public double getProgress() {
        return this.aDouble3374;
    }

    public int getProgressPercent() {
        int var1 = (int) (this.aDouble3374 * 100.0D + 0.5D);
        if (var1 == 0 && this.aDouble3374 > 0.0D) {
            var1 = 1;
        } else if (var1 == 100 && this.aDouble3374 < 1.0D) {
            var1 = 99;
        }

        return var1;
    }

    public boolean isCompleted() {
        return this.getProgressPercent() == 100;
    }

    private void method866(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = (int) ((double) var4 * this.aDouble3374 + 0.5D);
        if (var6 != 0) {
            if (this.anInt3372 == 0) {
                this.method867(var1, var2, var3, var6, var5);
            } else if (this.anInt3372 == 1) {
                this.method868(var1, var2, var3, var6, var5);
            } else if (this.anInt3372 == 2) {
                this.method869(var1, var2, var3, var6, var5);
            } else if (this.anInt3372 == 3) {
                this.method870(var1, var2, var3, var6, var5);
            }

        }
    }

    private void method867(Graphics var1, int var2, int var3, int var4, int var5) {
        var1.setColor(this.aColor3371);
        var1.fillRect(var2, var3, var4, var5);
    }

    private void method868(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = this.aColor3371.getRed();
        int var7 = this.aColor3371.getGreen();
        int var8 = this.aColor3371.getBlue();
        int var9 = (this.aColor3370.getRed() + var6) / 2;
        int var10 = (this.aColor3370.getGreen() + var7) / 2;
        int var11 = (this.aColor3370.getBlue() + var8) / 2;
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

    private void method869(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = var5 * 2 / 3;
        int var7 = (var4 + var6 / 2) / var6;
        if (this.aDouble3374 > 0.0D && var7 == 0) {
            var7 = 1;
        }

        if (this.aDouble3374 == 1.0D && var7 * var6 < var4) {
            ++var7;
        }

        var1.setColor(this.aColor3371);

        for (int var8 = 0; var8 < var7; ++var8) {
            var1.fillRect(var2 + var8 * var6 + 1, var3 + 1, var6 - 2, var5 - 2);
        }

    }

    private void method870(Graphics var1, int var2, int var3, int var4, int var5) {
        int var6 = this.aColor3371.getRed();
        int var7 = this.aColor3371.getGreen();
        int var8 = this.aColor3371.getBlue();
        var6 = (255 + var6) / 2;
        var7 = (255 + var7) / 2;
        var8 = (255 + var8) / 2;
        var1.setColor(this.aColor3371);
        var1.fillRect(var2, var3, var4, var5);
        var1.setColor(new Color(var6, var7, var8));
        Shape var9 = var1.getClip();
        var1.setClip(var2, var3, var4, var5);
        var1.fillRoundRect(var2, var3 - var5 / 2, var4, var5, 10, 10);
        var1.setClip(var9);
    }

}
