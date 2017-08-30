package com.playray.settingsgui;

import com.playray.client.FilterTextField;
import com.playray.client.InputTextField;
import com.playray.client.TextManager;
import com.playray.settingsgui.Unit;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Component;

public final class UnitTextField extends Unit {

    private InputTextField anInputTextField3631;


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
            this.anInputTextField3631 = new FilterTextField(var2, var3, var4);
        } else {
            this.anInputTextField3631 = new InputTextField(var3, var4);
        }

        this.anInputTextField3631.setBackground(Color.white);
        this.anInputTextField3631.setForeground(Color.black);
        this.anInputTextField3631.addFocusListener(this);
    }

    protected int method2226() {
        return 25;
    }

    protected int method2229() {
        return 2;
    }

    protected Component method2231() {
        return this.anInputTextField3631;
    }

    protected boolean method2233() {
        return true;
    }

    protected String method2234() {
        String var1 = this.anInputTextField3631.getInputText(false);
        if (var1.length() < 1) {
            var1 = "-";
        }

        return Tools.changeToSaveable(var1);
    }

    protected void method2235(String var1) {
        this.anInputTextField3631.getTextField().setText(Tools.changeFromSaveable(var1));
    }
}
