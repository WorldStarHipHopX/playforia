package com.playray.colorgui;

import com.playray.colorgui.ColorButton;
import com.playray.colorgui.RadioButtonGroup;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class RadioButton extends ColorButton {

    private RadioButtonGroup aRadioButtonGroup4939;
    private boolean aBoolean4940;
    private boolean aBoolean4941;
    private boolean aBoolean4942;


    public RadioButton() {
        this((String) null, (RadioButtonGroup) null);
    }

    public RadioButton(RadioButtonGroup var1) {
        this((String) null, var1);
    }

    public RadioButton(String var1) {
        this(var1, (RadioButtonGroup) null);
    }

    public RadioButton(String var1, RadioButtonGroup var2) {
        super(var1);
        this.aRadioButtonGroup4939 = var2;
        if (var2 != null) {
            var2.method2088(this);
        }

        this.aBoolean4940 = this.aBoolean4941 = false;
        this.aBoolean4942 = false;
    }

    public RadioButton(String var1, RadioButtonGroup var2, boolean var3) {
        super(var1);
        this.aRadioButtonGroup4939 = var2;
        var2.method2088(this);
        this.aBoolean4940 = var3;
        this.aBoolean4941 = false;
        this.setBackgroundFade(false);
        this.setBorderType(2);
        this.aBoolean4942 = true;
    }

    public void mousePressed(MouseEvent var1) {
        if (this.setState(!this.aBoolean4940)) {
            this.processActionEvent();
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public boolean setState(boolean var1) {
        if (this.aBoolean4940 == var1) {
            return true;
        } else if (this.aRadioButtonGroup4939 != null && !this.aRadioButtonGroup4939.method2089(var1)) {
            return false;
        } else {
            this.realSetState(var1);
            return true;
        }
    }

    public boolean getState() {
        return this.aBoolean4940;
    }

    public void click() {
        this.mousePressed((MouseEvent) null);
    }

    public void boldSelected(boolean var1) {
        this.aBoolean4941 = var1;
    }

    public boolean isNormalState() {
        return !this.aBoolean4940;
    }

    public boolean isHighlighted() {
        return this.aBoolean4940 ? true : super.isHighlighted();
    }

    public boolean isBolded() {
        return this.aBoolean4940 && this.aBoolean4941 || this.aBoolean4942;
    }

    public void clearBackground(Graphics var1, int var2, int var3) {
        if (!this.aBoolean4942) {
            super.clearBackground(var1, var2, var3);
        } else {
            int var4 = this.getBorderType();
            var4 = var4 == 0 ? 0 : (var4 == 1 ? 1 : 2);
            var1.fillRect(var4, var4, var2 - var4 - var4, var3 - var4);
        }
    }

    public void drawBorder(Graphics var1, int var2, int var3) {
        if (!this.aBoolean4942) {
            super.drawBorder(var1, var2, var3);
        } else {
            int var4 = this.getBorderType();
            if (var4 != 0) {
                boolean var5 = var4 == 2;
                if (!this.aBoolean4940) {
                    if (var5) {
                        var1.drawRect(0, 2, var2 - 1, var3 - 3);
                        var1.drawRect(1, 1, var2 - 3, var3 - 3);
                    } else {
                        var1.drawLine(1, 1, var2 - 2, 1);
                        var1.drawLine(0, 2, 0, var3 - 1);
                        var1.drawLine(var2 - 1, 2, var2 - 1, var3 - 1);
                        var1.drawLine(0, var3 - 1, var2 - 1, var3 - 1);
                    }
                } else if (var5) {
                    var1.drawLine(1, 0, var2 - 2, 0);
                    var1.drawLine(0, 1, var2 - 1, 1);
                    var1.drawLine(0, 1, 0, var3 - 1);
                    var1.drawLine(1, 0, 1, var3 - 1);
                    var1.drawLine(var2 - 1, 1, var2 - 1, var3 - 1);
                    var1.drawLine(var2 - 2, 0, var2 - 2, var3 - 1);
                } else {
                    var1.drawLine(1, 0, var2 - 2, 0);
                    var1.drawLine(0, 1, 0, var3 - 1);
                    var1.drawLine(var2 - 1, 1, var2 - 1, var3 - 1);
                }

            }
        }
    }

    public int drawIcon(Graphics var1, Image var2, int var3) {
        int var4 = var3;
        if (var3 < 5) {
            var4 = 5;
        }

        var1.drawImage(var2, var4, var3, this);
        return var4;
    }

    public void realSetState(boolean var1) {
        this.aBoolean4940 = var1;
        this.repaint();
    }
}
