package com.playray.settingsgui;

import com.playray.settingsgui.Unit;

public final class UnitLabel extends Unit {

    public static final int POSITION_MIDDLE = 1;
    public static final int POSITION_LEFT = 2;
    public static final int POSITION_RIGHT = 3;
    public static final int LABELSIZE_SMALL = 0;
    public static final int LABELSIZE_NORMAL = 1;
    public static final int LABELSIZE_BOLD = 2;
    public static final int LABELSIZE_BIG = 3;
    private int anInt3626 = 1;
    private int anInt3627 = 1;
    private String[] aStringArray3628;
    private int anInt3629;


    public UnitLabel(String var1) {
        super(var1);
    }

    public UnitLabel(String[] var1) {
        super((String) null);
        this.aStringArray3628 = var1;
        this.anInt3629 = 0;
    }

    public void setLabelPosition(int var1) {
        this.anInt3626 = var1;
    }

    public void setLabelSize(int var1) {
        this.anInt3627 = var1;
    }

    protected int method2226() {
        return 14 - (this.anInt3627 == 0 ? 1 : 0) + 2;
    }

    protected boolean method2227() {
        return true;
    }

    protected String method2228() {
        return this.aStringArray3628 == null ? super.method2228() : this.aStringArray3628[this.anInt3629];
    }

    protected int method2229() {
        return this.anInt3626;
    }

    protected int method2230() {
        return this.anInt3627;
    }

    protected boolean setItemState(int var1) {
        if (this.anInt3629 == var1) {
            return false;
        } else {
            this.anInt3629 = var1;
            return true;
        }
    }
}
