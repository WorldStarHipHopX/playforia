package com.playray.colorgui;

import java.awt.Image;

public class ColorListItemGroup {

    private String aString1989;
    private Image anImage1990;
    private int anInt1991;


    public ColorListItemGroup(String var1, Image var2, int var3) {
        this.aString1989 = var1;
        this.anImage1990 = var2;
        this.anInt1991 = var3;
    }

    public String getText() {
        return this.aString1989;
    }

    public Image getIcon() {
        return this.anImage1990;
    }

    public int getSortValue() {
        return this.anInt1991;
    }

    public void changeSortValue(int var1) {
        this.anInt1991 += var1;
    }
}
