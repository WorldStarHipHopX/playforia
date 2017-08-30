package com.aapeli.settingsgui;

import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;

public final class UnitButton extends Unit {

    private Component aComponent3593;


    public UnitButton(String var1, Color var2) {
        this(var1, var2, false);
    }

    public UnitButton(String var1, Color var2, boolean var3) {
        super((String) null);
        if (var3) {
            RoundButton var4 = new RoundButton(var1);
            var4.setBackground(var2);
            var4.addActionListener(this);
            this.aComponent3593 = var4;
        } else {
            ColorButton var5 = new ColorButton(var1);
            var5.setBackground(var2);
            var5.addActionListener(this);
            this.aComponent3593 = var5;
        }

    }

    public void setButtonLabel(String var1) {
        if (this.aComponent3593 instanceof RoundButton) {
            ((RoundButton) ((RoundButton) this.aComponent3593)).setLabel(var1);
        } else {
            ((ColorButton) ((ColorButton) this.aComponent3593)).setLabel(var1);
        }

    }

    protected int method1836() {
        return 25;
    }

    protected Component method1841() {
        return this.aComponent3593;
    }
}
