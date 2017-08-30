package com.aapeli.colorgui;

import com.aapeli.colorgui.RadioButtonGroup;
import com.aapeli.colorgui.RoundButton;

import java.awt.event.MouseEvent;

public class RoundRadioButton extends RoundButton {

    private RadioButtonGroup aRadioButtonGroup4732;
    private boolean aBoolean4733;
    private boolean aBoolean4734;
    private boolean aBoolean4735;


    public RoundRadioButton() {
        this((String) null, (RadioButtonGroup) null);
    }

    public RoundRadioButton(RadioButtonGroup var1) {
        this((String) null, var1);
    }

    public RoundRadioButton(String var1) {
        this(var1, (RadioButtonGroup) null);
    }

    public RoundRadioButton(String var1, RadioButtonGroup var2) {
        super(var1);
        this.aRadioButtonGroup4732 = var2;
        if (var2 != null) {
            var2.method1757(this);
        }

        this.aBoolean4733 = this.aBoolean4734 = false;
        this.aBoolean4735 = false;
    }

    public void mousePressed(MouseEvent var1) {
        if (this.setState(!this.aBoolean4733)) {
            this.processActionEvent();
        }

    }

    public void mouseReleased(MouseEvent var1) {
    }

    public boolean setState(boolean var1) {
        if (this.aBoolean4733 == var1) {
            return true;
        } else if (this.aRadioButtonGroup4732 != null && !this.aRadioButtonGroup4732.method1758(var1)) {
            return false;
        } else {
            this.realSetState(var1);
            return true;
        }
    }

    public boolean getState() {
        return this.aBoolean4733;
    }

    public void click() {
        this.mousePressed((MouseEvent) null);
    }

    public void boldSelected(boolean var1) {
        this.aBoolean4734 = var1;
    }

    public boolean isNormalState() {
        return !this.aBoolean4733;
    }

    public boolean isBolded() {
        return this.aBoolean4733 && this.aBoolean4734 || this.aBoolean4735;
    }

    public void realSetState(boolean var1) {
        this.aBoolean4733 = var1;
        this.repaint();
    }
}
