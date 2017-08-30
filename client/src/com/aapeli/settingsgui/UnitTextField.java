package com.aapeli.settingsgui;

import com.aapeli.client.FilterTextField;
import com.aapeli.client.InputTextField;
import com.aapeli.client.TextManager;
import com.aapeli.settingsgui.Unit;
import com.aapeli.tools.Tools;

import java.awt.Color;
import java.awt.Component;

public final class UnitTextField extends Unit {

    private InputTextField anInputTextField3605;


    public UnitTextField(String var1, int var2) {
        this(var1, (TextManager) null, "", var2);
    }

    public UnitTextField(String var1, String var2, int var3) {
        this(var1, (TextManager) null, var2, var3);
    }

    public UnitTextField(String var1, TextManager var2, int var3) {
        this(var1, var2, "", var3);
    }

    public UnitTextField(String var1, TextManager var2, String var3, int var4) {
        super(var1);
        if (var2 != null) {
            this.anInputTextField3605 = new FilterTextField(var2, var3, var4);
        } else {
            this.anInputTextField3605 = new InputTextField(var3, var4);
        }

        this.anInputTextField3605.setBackground(Color.white);
        this.anInputTextField3605.setForeground(Color.black);
        this.anInputTextField3605.addFocusListener(this);
    }

    protected int method1836() {
        return 25;
    }

    protected int method1839() {
        return 2;
    }

    protected Component method1841() {
        return this.anInputTextField3605;
    }

    protected boolean method1843() {
        return true;
    }

    protected String method1844() {
        String var1 = this.anInputTextField3605.getInputText(false);
        if (var1.length() < 1) {
            var1 = "-";
        }

        return Tools.changeToSaveable(var1);
    }

    protected void method1845(String var1) {
        this.anInputTextField3605.setText(Tools.changeFromSaveable(var1));
    }
}
