package com.playray.settingsgui;

import com.playray.colorgui.GlossyButton;
import com.playray.settingsgui.Unit;

import java.awt.Component;

public final class UnitButton extends Unit {

    private GlossyButton aGlossyButton3619;


    public UnitButton(String var1, int var2) {
        super((String) null);
        this.aGlossyButton3619 = new GlossyButton(var1, var2);
        this.aGlossyButton3619.addActionListener(this);
    }

    public void setButtonLabel(String var1) {
        this.aGlossyButton3619.setLabel(var1);
    }

    protected int method2226() {
        return 25;
    }

    protected Component method2231() {
        return this.aGlossyButton3619;
    }
}
