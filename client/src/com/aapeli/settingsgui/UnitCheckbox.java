package com.aapeli.settingsgui;

import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;

public final class UnitCheckbox extends Unit {

    private ColorCheckbox aColorCheckbox3594;


    public UnitCheckbox(String var1) {
        super((String) null);
        this.aColorCheckbox3594 = new ColorCheckbox(var1);
        this.aColorCheckbox3594.addItemListener(this);
    }

    protected void method1835(Image var1, int var2, int var3) {
        Point var4 = this.aColorCheckbox3594.getLocation();
        this.aColorCheckbox3594.setBackgroundImage(var1, var2 + var4.x, var3 + var4.y);
    }

    public int getItemState() {
        return this.aColorCheckbox3594.getState() ? 1 : 0;
    }

    public boolean setItemState(int var1) {
        if (this.getItemState() == var1) {
            return false;
        } else {
            this.aColorCheckbox3594.setState(var1 == 1);
            return true;
        }
    }

    protected int method1836() {
        return 20;
    }

    protected Component method1841() {
        return this.aColorCheckbox3594;
    }

    protected boolean method1843() {
        return true;
    }

    protected String method1844() {
        return this.aColorCheckbox3594.getState() ? "t" : "f";
    }

    protected void method1845(String var1) {
        this.aColorCheckbox3594.setState(var1.equals("t"));
    }

    protected void method1846(Color var1, Color var2) {
        this.aColorCheckbox3594.setBackground(var1);
        this.aColorCheckbox3594.setForeground(var2);
    }
}
