package com.aapeli.colorgui;

import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItemGroup;

import java.awt.Color;
import java.awt.Image;

public class ColorListItem {

    public static final int COLOR_BLACK = 0;
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_BLUE = 3;
    public static final int COLOR_YELLOW = 4;
    public static final int COLOR_MAGENTA = 5;
    public static final int COLOR_CYAN = 6;
    public static final int COLOR_GRAY = 7;
    public static final int COLOR_WHITE = 8;
    private static final Color[] aColorArray1554 = new Color[]{new Color(0, 0, 0), new Color(240, 0, 0), new Color(0, 160, 0), new Color(0, 0, 255), new Color(144, 144, 0), new Color(176, 0, 176), new Color(0, 160, 176), new Color(112, 112, 112), new Color(255, 255, 255)};
    private Image anImage1555;
    private Color aColor1556;
    private boolean aBoolean1557;
    private String aString1558;
    private Image anImage1559;
    private Object anObject1560;
    private boolean aBoolean1561;
    private int anInt1562;
    private boolean aBoolean1563;
    private ColorListItemGroup aColorListItemGroup1564;
    private ColorList aColorList1565;


    public ColorListItem(String var1) {
        this((Image) null, 0, false, var1, (Object) null, false);
    }

    public ColorListItem(int var1, boolean var2, String var3) {
        this((Image) null, var1, var2, var3, (Object) null, false);
    }

    public ColorListItem(int var1, boolean var2, String var3, Object var4, boolean var5) {
        this((Image) null, aColorArray1554[var1], var2, var3, var4, var5);
    }

    public ColorListItem(Image var1, int var2, boolean var3, String var4, Object var5, boolean var6) {
        this(var1, aColorArray1554[var2], var3, var4, var5, var6);
    }

    public ColorListItem(Image var1, Color var2, boolean var3, String var4, Object var5, boolean var6) {
        this.anImage1555 = var1;
        this.aColor1556 = var2;
        this.aBoolean1557 = var3;
        this.aString1558 = var4;
        this.anObject1560 = var5;
        this.aBoolean1561 = var6;
        this.anInt1562 = 0;
        this.aBoolean1563 = false;
    }

    public static Color getColorById(int var0) {
        return aColorArray1554[var0];
    }

    public void setIcon(Image var1) {
        this.anImage1555 = var1;
    }

    public Image getIcon() {
        return this.anImage1555;
    }

    public void setIconAfterText(Image var1) {
        this.anImage1559 = var1;
    }

    public Image getIconAfterText() {
        return this.anImage1559;
    }

    public void setColor(int var1) {
        this.setColor(aColorArray1554[var1]);
    }

    public void setColor(Color var1) {
        this.aColor1556 = var1;
    }

    public Color getColor() {
        return this.aColor1556;
    }

    public void setBold(boolean var1) {
        this.aBoolean1557 = var1;
    }

    public boolean isBold() {
        return this.aBoolean1557;
    }

    public void setString(String var1) {
        this.aString1558 = var1;
    }

    public String getString() {
        return this.aString1558;
    }

    public void setData(Object var1) {
        this.anObject1560 = var1;
    }

    public Object getData() {
        return this.anObject1560;
    }

    public void setSelected(boolean var1) {
        this.aBoolean1561 = var1;
    }

    public boolean isSelected() {
        return this.aBoolean1561;
    }

    public void setValue(int var1) {
        this.anInt1562 = var1;
    }

    public int getValue() {
        return this.anInt1562;
    }

    public void setSortOverride(boolean var1) {
        this.aBoolean1563 = var1;
    }

    public boolean isSortOverride() {
        return this.aBoolean1563;
    }

    public void setGroup(ColorListItemGroup var1) {
        this.aColorListItemGroup1564 = var1;
    }

    public ColorListItemGroup getGroup() {
        return this.aColorListItemGroup1564;
    }

    public void setColorListReference(ColorList var1) {
        this.aColorList1565 = var1;
    }

    public ColorList getColorListReference() {
        return this.aColorList1565;
    }

}
