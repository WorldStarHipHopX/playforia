package com.playray.colorgui;

import com.playray.colorgui.RadioButton;

import java.util.Enumeration;
import java.util.Vector;

public final class RadioButtonGroup {

    private Vector aVector2023;
    private boolean aBoolean2024;


    public RadioButtonGroup() {
        this(false);
    }

    public RadioButtonGroup(boolean var1) {
        this.aVector2023 = new Vector();
        this.aBoolean2024 = var1;
    }

    protected void method2088(RadioButton var1) {
        this.aVector2023.addElement(var1);
    }

    protected boolean method2089(boolean var1) {
        if (var1) {
            this.method2090();
            return true;
        } else {
            return this.aBoolean2024;
        }
    }

    private void method2090() {
        Enumeration var1 = this.aVector2023.elements();

        while (var1.hasMoreElements()) {
            ((RadioButton) ((RadioButton) var1.nextElement())).realSetState(false);
        }

    }
}
