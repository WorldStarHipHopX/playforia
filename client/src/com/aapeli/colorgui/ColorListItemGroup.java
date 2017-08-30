package com.aapeli.colorgui;

import java.awt.Image;

public class ColorListItemGroup {

    private String aString1566;
    private Image anImage1567;
    private int anInt1568;


    public ColorListItemGroup(String var1, Image var2, int var3) {
        this.aString1566 = var1;
        this.anImage1567 = var2;
        this.anInt1568 = var3;
    }

    public String getText() {
        return this.aString1566;
    }

    public Image getIcon() {
        return this.anImage1567;
    }

    public int getSortValue() {
        return this.anInt1568;
    }

    public void changeSortValue(int var1) {
        this.anInt1568 += var1;
    }
}
