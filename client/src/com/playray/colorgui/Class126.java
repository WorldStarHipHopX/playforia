package com.playray.colorgui;

import com.playray.client.StringDraw;
import com.playray.colorgui.ColorList;
import com.playray.colorgui.ColorListItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

class Class126 {

    private int anInt1964;
    private int anInt1965;
    private int anInt1966;
    private int anInt1967;
    private int anInt1968;
    private Font aFont1969;
    private Font aFont1970;
    private ColorListItem aColorListItem1971;
    private Color aColor1972;
    private String aString1973;
    private Image anImage1974;
    private boolean aBoolean1975;


    protected Class126(int var1, int var2, int var3, int var4, int var5, Font var6, Font var7, ColorListItem var8) {
        this.anInt1964 = var1;
        this.anInt1965 = var2;
        this.anInt1966 = var3;
        this.anInt1967 = var4;
        this.anInt1968 = var5;
        this.aFont1969 = var6;
        this.aFont1970 = var7;
        this.aColorListItem1971 = var8;
        this.aBoolean1975 = false;
    }

    protected Class126(int var1, int var2, int var3, int var4, int var5, Font var6, Color var7, String var8, Image var9) {
        this.anInt1964 = var1;
        this.anInt1965 = var2;
        this.anInt1966 = var3;
        this.anInt1967 = var4;
        this.anInt1968 = var5;
        this.aFont1969 = var6;
        this.aColor1972 = var7;
        this.aString1973 = var8;
        this.anImage1974 = var9;
        this.aBoolean1975 = var9 != null;
    }

    protected void method2067(Graphics var1, ColorList var2) {
        if (this.aColorListItem1971 != null) {
            this.method2070(var1, var2);
        } else {
            this.method2071(var1, var2);
        }

    }

    protected boolean method2068(int var1) {
        return var1 >= this.anInt1965 && var1 < this.anInt1965 + this.anInt1967;
    }

    protected ColorListItem method2069() {
        return this.aColorListItem1971;
    }

    private void method2070(Graphics var1, ColorList var2) {
        Color var3 = this.aColorListItem1971.getColor();
        if (this.aColorListItem1971.isSelected()) {
            var1.setColor(var3);
            var1.fillRect(this.anInt1964, this.anInt1965, this.anInt1966, this.anInt1967);
            var3 = this.method2073(var3);
        }

        this.method2072(var1, var2, this.aColorListItem1971.getIcon(), var3, this.aColorListItem1971.isBold() ? this.aFont1970 : this.aFont1969, this.aColorListItem1971.getString(), this.aColorListItem1971.getIconAfterText());
    }

    private void method2071(Graphics var1, ColorList var2) {
        if (this.aBoolean1975) {
            var1.setColor(new Color(0, 0, 0, 32 * var2.getAlpha() / 255));
            var1.fillRect(this.anInt1964, this.anInt1965, this.anInt1966, this.anInt1967);
        }

        this.method2072(var1, var2, this.anImage1974, this.aColor1972, this.aFont1969, this.aString1973, (Image) null);
    }

    private void method2072(Graphics var1, ColorList var2, Image var3, Color var4, Font var5, String var6, Image var7) {
        int var8 = 4;
        if (var3 != null) {
            var1.drawImage(var3, var8, this.anInt1965 + this.anInt1967 / 2 - var3.getHeight(var2) / 2, var2);
            int var9 = this.anInt1968 > 0 ? this.anInt1968 : var3.getWidth((ImageObserver) null);
            var8 += var9 + 3;
        }

        var1.setColor(var4);
        var1.setFont(var5);
        var8 += StringDraw.drawString(var1, var6, var8, this.anInt1965 + this.anInt1967 * 3 / 4 + 1, -1);
        if (var7 != null) {
            var8 += 4;
            var1.drawImage(var7, var8, this.anInt1965 + this.anInt1967 / 2 - var7.getHeight(var2) / 2, var2);
        }

    }

    private Color method2073(Color var1) {
        int var2 = var1.getRed();
        int var3 = var1.getGreen();
        int var4 = var1.getBlue();
        return new Color(255 - var2, 255 - var3, 255 - var4);
    }
}
