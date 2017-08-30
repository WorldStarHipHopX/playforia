package com.aapeli.settingsgui;

import com.aapeli.settingsgui.Unit;

public final class UnitLabel extends Unit {

    public static final int POSITION_MIDDLE = 1;
    public static final int POSITION_LEFT = 2;
    public static final int POSITION_RIGHT = 3;
    public static final int LABELSIZE_SMALL = 0;
    public static final int LABELSIZE_NORMAL = 1;
    public static final int LABELSIZE_BOLD = 2;
    public static final int LABELSIZE_BIG = 3;
    private int anInt3600 = 1;
    private int anInt3601 = 1;
    private String[] aStringArray3602;
    private int anInt3603;


    public UnitLabel(String var1) {
        super(var1);
    }

    public UnitLabel(String[] var1) {
        super((String) null);
        this.aStringArray3602 = var1;
        this.anInt3603 = 0;
    }

    public void setLabelPosition(int var1) {
        this.anInt3600 = var1;
    }

    public void setLabelSize(int var1) {
        this.anInt3601 = var1;
    }

    protected int method1836() {
        return 14 - (this.anInt3601 == 0 ? 1 : 0) + 2;
    }

    protected boolean method1837() {
        return true;
    }

    protected String method1838() {
        return this.aStringArray3602 == null ? super.method1838() : this.aStringArray3602[this.anInt3603];
    }

    protected int method1839() {
        return this.anInt3600;
    }

    protected int method1840() {
        return this.anInt3601;
    }

    protected boolean setItemState(int var1) {
        if (this.anInt3603 == var1) {
            return false;
        } else {
            this.anInt3603 = var1;
            return true;
        }
    }
}
