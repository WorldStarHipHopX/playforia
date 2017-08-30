package com.playray.colorgui;

import java.awt.Color;
import java.awt.Image;

public class MultiColorListItem {

    public static final int COLOR_BLACK = 0;
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_BLUE = 3;
    public static final int COLOR_YELLOW = 4;
    public static final int COLOR_MAGENTA = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;
    public static final int COLOR_WHITE = 8;
    private static final Color[] aColorArray2013;
    private Color aColor2014;
    private Color aColor2015;
    private Color aColor2016;
    private boolean aBoolean2017;
    private String[] aStringArray2018;
    private Image[] anImageArray2019;
    private Object anObject2020;
    private boolean aBoolean2021;
    private static final String[] aStringArray2022 = new String[3];


    public MultiColorListItem(String[] var1) {
        this(aColorArray2013[0], false, var1, (Object) null, false);
    }

    public MultiColorListItem(int var1, boolean var2, String[] var3) {
        this(aColorArray2013[var1], var2, var3, (Object) null, false);
    }

    public MultiColorListItem(int var1, String[] var2, Object var3) {
        this(aColorArray2013[var1], false, var2, var3, false);
    }

    public MultiColorListItem(int var1, boolean var2, String[] var3, Object var4) {
        this(aColorArray2013[var1], var2, var3, var4, false);
    }

    public MultiColorListItem(int var1, boolean var2, String[] var3, Object var4, boolean var5) {
        this(aColorArray2013[var1], var2, var3, var4, var5);
    }

    public MultiColorListItem(Color var1, boolean var2, String[] var3, Object var4, boolean var5) {
        this.aColor2014 = var1;
        this.aBoolean2017 = var2;
        this.aStringArray2018 = var3;
        this.anObject2020 = var4;
        this.aBoolean2021 = var5;
        this.anImageArray2019 = new Image[var3.length];
        this.aColor2015 = null;
    }

    public String toString() {
        String var1 = "[MultiColorListItem: strings={";

        for (int var2 = 0; var2 < this.aStringArray2018.length; ++var2) {
            var1 = var1 + this.aStringArray2018[var2];
            if (var2 < this.aStringArray2018.length - 1) {
                var1 = var1 + ',';
            }
        }

        var1 = var1 + "} data=\"" + this.anObject2020 + "\" selected=" + this.aBoolean2021 + "]";
        return var1;
    }

    public void setColor(int var1) {
        this.setColor(aColorArray2013[var1]);
    }

    public void setColor(Color var1) {
        this.aColor2014 = var1;
    }

    public void setOverrideColor(int var1) {
        this.setOverrideColor(var1 >= 0 ? aColorArray2013[var1] : null);
    }

    public void setOverrideColor(Color var1) {
        this.aColor2015 = var1;
    }

    public Color getColor() {
        return this.aColor2015 != null ? this.aColor2015 : this.aColor2014;
    }

    public void setBold(boolean var1) {
        this.aBoolean2017 = var1;
    }

    public boolean isBold() {
        return this.aBoolean2017;
    }

    public void setString(int var1, String var2) {
        this.aStringArray2018[var1] = var2;
    }

    public String getString(int var1) {
        return this.aStringArray2018[var1];
    }

    public String[] getStrings() {
        return this.aStringArray2018;
    }

    public void setImage(int var1, Image var2) {
        this.anImageArray2019[var1] = var2;
    }

    public Image getImage(int var1) {
        return this.anImageArray2019[var1];
    }

    public Image[] getImages() {
        return this.anImageArray2019;
    }

    public void setData(Object var1) {
        this.anObject2020 = var1;
    }

    public Object getData() {
        return this.anObject2020;
    }

    public void setSelected(boolean var1) {
        this.aBoolean2021 = var1;
    }

    public boolean isSelected() {
        return this.aBoolean2021;
    }

    public int getColumnCount() {
        return this.aStringArray2018.length;
    }

    public void setBackgroundColor(Color var1) {
        this.aColor2016 = var1;
    }

    public Color getBackgroundColor() {
        return this.aColor2016;
    }

    static {
        aStringArray2022[0] = "\" selected=";
        aStringArray2022[1] = "[MultiColorListItem: strings={";
        aStringArray2022[2] = "} data=\"";
        aColorArray2013 = new Color[]{new Color(0, 0, 0), new Color(240, 0, 0), new Color(0, 160, 0), new Color(0, 0, 255), new Color(144, 144, 0), new Color(176, 0, 176), new Color(0, 160, 176), new Color(112, 112, 112), new Color(255, 255, 255)};
    }
}
