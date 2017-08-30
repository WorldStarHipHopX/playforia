package com.playray.settingsgui;

import com.playray.colorgui.ColorCheckbox;
import com.playray.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;

public final class UnitCheckbox extends Unit {

    private ColorCheckbox aColorCheckbox3620;


    public UnitCheckbox(String var1) {
        super((String) null);
        this.aColorCheckbox3620 = new ColorCheckbox(var1);
        this.aColorCheckbox3620.addItemListener(this);
    }

    public int getItemState() {
        return this.aColorCheckbox3620.getState() ? 1 : 0;
    }

    public boolean setItemState(int var1) {
        if (this.getItemState() == var1) {
            return false;
        } else {
            this.aColorCheckbox3620.setState(var1 == 1);
            return true;
        }
    }

    protected int method2226() {
        return 20;
    }

    protected Component method2231() {
        return this.aColorCheckbox3620;
    }

    protected boolean method2233() {
        return true;
    }

    protected String method2234() {
        return this.aColorCheckbox3620.getState() ? "t" : "f";
    }

    protected void method2235(String var1) {
        this.aColorCheckbox3620.setState(var1.equals("t"));
    }

    protected void method2236(Color var1, Color var2) {
        this.aColorCheckbox3620.setBackground(var1);
        this.aColorCheckbox3620.setForeground(var2);
    }
}
