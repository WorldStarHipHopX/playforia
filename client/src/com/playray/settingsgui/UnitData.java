package com.playray.settingsgui;

import com.playray.settingsgui.Unit;
import com.playray.tools.Tools;

public final class UnitData extends Unit {

    private String aString3625;


    public UnitData() {
        this((String) null);
    }

    public UnitData(String var1) {
        super((String) null);
        this.aString3625 = var1;
    }

    protected int method2226() {
        return 25;
    }

    protected boolean method2233() {
        return true;
    }

    protected String method2234() {
        return this.aString3625 == null ? "-" : (this.aString3625.length() == 0 ? "-" : Tools.changeToSaveable(this.aString3625));
    }

    protected void method2235(String var1) {
        this.aString3625 = Tools.changeFromSaveable(var1);
    }
}
