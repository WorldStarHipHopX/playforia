package com.aapeli.settingsgui;

import com.aapeli.settingsgui.Unit;
import com.aapeli.tools.Tools;

public final class UnitData extends Unit {

    private String aString3599;


    public UnitData() {
        this((String) null);
    }

    public UnitData(String var1) {
        super((String) null);
        this.aString3599 = var1;
    }

    protected int method1836() {
        return 25;
    }

    protected boolean method1843() {
        return true;
    }

    protected String method1844() {
        return this.aString3599 == null ? "-" : (this.aString3599.length() == 0 ? "-" : Tools.changeToSaveable(this.aString3599));
    }

    protected void method1845(String var1) {
        this.aString3599 = Tools.changeFromSaveable(var1);
    }
}
