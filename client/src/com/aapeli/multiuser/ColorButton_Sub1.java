package com.aapeli.multiuser;

import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Graphics;

class ColorButton_Sub1 extends ColorButton {

    private boolean aBoolean4726 = false;


    protected ColorButton_Sub1(String var1) {
        super(var1);
    }

    public void clearBackground(Graphics var1, int var2, int var3) {
        var1.fillRect(1, 1, var2 - 1, var3 - 1);
    }

    public void drawBorder(Graphics var1, int var2, int var3) {
        boolean var4 = this.isNormalState();
        Color[] var5 = this.getLightAndDarkBorderColors();
        if (!this.aBoolean4726) {
            var1.setColor(var4 ? var5[0] : var5[1]);
            var1.drawLine(0, 0, var2 - 2, 0);
            var1.drawLine(0, 0, 0, var3 - 1);
            var1.setColor(var4 ? var5[1] : var5[0]);
            var1.drawLine(var2 - 1, var3 - 1, 1, var3 - 1);
            var1.drawLine(var2 - 1, var3 - 1, var2 - 1, 0);
        } else {
            var1.setColor(var4 ? var5[0] : var5[1]);
            var1.drawLine(1, 0, var2 - 2, 0);
            var1.drawLine(0, 1, 0, var3 - 1);
            var1.setColor(var4 ? var5[1] : var5[0]);
            var1.drawLine(var2 - 1, var3 - 1, 1, var3 - 1);
            var1.drawLine(var2 - 1, var3 - 1, var2 - 1, 1);
        }

    }

    public void setPixelRoundedUpperCorners() {
        this.aBoolean4726 = true;
        this.repaint();
    }
}
