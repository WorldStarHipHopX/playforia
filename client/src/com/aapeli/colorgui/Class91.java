package com.aapeli.colorgui;

import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

class Class91 {

    private int anInt1536;
    private int anInt1537;
    private int anInt1538;
    private int anInt1539;
    private int anInt1540;
    private boolean aBoolean1541;
    private Font aFont1542;
    private Font aFont1543;
    private ColorListItem aColorListItem1544;
    private Color aColor1545;
    private String aString1546;
    private Image anImage1547;
    private boolean aBoolean1548;


    protected Class91(int var1, int var2, int var3, int var4, int var5, boolean var6, Font var7, Font var8, ColorListItem var9) {
        this.anInt1536 = var1;
        this.anInt1537 = var2;
        this.anInt1538 = var3;
        this.anInt1539 = var4;
        this.anInt1540 = var5;
        this.aBoolean1541 = var6;
        this.aFont1542 = var7;
        this.aFont1543 = var8;
        this.aColorListItem1544 = var9;
        this.aBoolean1548 = false;
    }

    protected Class91(int var1, int var2, int var3, int var4, int var5, boolean var6, Font var7, Color var8, String var9, Image var10) {
        this.anInt1536 = var1;
        this.anInt1537 = var2;
        this.anInt1538 = var3;
        this.anInt1539 = var4;
        this.anInt1540 = var5;
        this.aBoolean1541 = var6;
        this.aFont1542 = var7;
        this.aColor1545 = var8;
        this.aString1546 = var9;
        this.anImage1547 = var10;
        this.aBoolean1548 = var10 != null;
    }

    protected void method1739(Graphics var1, ColorList var2) {
        if (this.aColorListItem1544 != null) {
            this.method1742(var1, var2);
        } else {
            this.method1743(var1, var2);
        }

    }

    protected boolean method1740(int var1) {
        return var1 >= this.anInt1537 && var1 < this.anInt1537 + this.anInt1539;
    }

    protected ColorListItem method1741() {
        return this.aColorListItem1544;
    }

    private void method1742(Graphics var1, ColorList var2) {
        Color var3 = this.aColorListItem1544.getColor();
        if (this.aColorListItem1544.isSelected()) {
            var1.setColor(var3);
            var1.fillRect(this.anInt1536, this.anInt1537, this.anInt1538, this.anInt1539);
            var3 = this.method1745(var3);
        }

        this.method1744(var1, var2, this.aColorListItem1544.getIcon(), var3, this.aColorListItem1544.isBold() ? this.aFont1543 : this.aFont1542, this.aColorListItem1544.getString(), this.aColorListItem1544.getIconAfterText());
    }

    private void method1743(Graphics var1, ColorList var2) {
        if (this.aBoolean1548) {
            var1.setColor(new Color(224, 224, 224));
            var1.fillRect(this.anInt1536, this.anInt1537, this.anInt1538, this.anInt1539);
        }

        this.method1744(var1, var2, this.anImage1547, this.aColor1545, this.aFont1542, this.aString1546, (Image) null);
    }

    private void method1744(Graphics var1, ColorList var2, Image var3, Color var4, Font var5, String var6, Image var7) {
        int var8 = 4;
        if (var3 != null) {
            var1.drawImage(var3, var8, this.anInt1537 + this.anInt1539 / 2 - var3.getHeight(var2) / 2, var2);
            int var9 = this.anInt1540 > 0 ? this.anInt1540 : var3.getWidth((ImageObserver) null);
            var8 += var9 + 3;
        }

        var1.setColor(var4);
        var1.setFont(var5);
        var8 += StringDraw.drawString(var1, var6, var8, this.anInt1537 + this.anInt1539 * 3 / 4 + 1, -1);
        if (var7 != null) {
            var8 += 4;
            var1.drawImage(var7, var8, this.anInt1537 + this.anInt1539 / 2 - var7.getHeight(var2) / 2, var2);
        }

    }

    private Color method1745(Color var1) {
        if (!this.aBoolean1541) {
            return ColorList.aColor650;
        } else {
            int var2 = var1.getRed();
            int var3 = var1.getGreen();
            int var4 = var1.getBlue();
            return new Color(255 - var2, 255 - var3, 255 - var4);
        }
    }
}
