package com.playray.colorgui;

import com.playray.colorgui.ColorCheckbox;

import java.util.Enumeration;
import java.util.Vector;

public final class ColorCheckboxGroup {

    private Vector aVector1976 = new Vector();


    protected void method2074(ColorCheckbox var1) {
        this.aVector1976.addElement(var1);
    }

    protected boolean method2075(boolean var1) {
        if (var1) {
            this.method2076();
            return true;
        } else {
            return false;
        }
    }

    private void method2076() {
        Enumeration var1 = this.aVector1976.elements();

        while (var1.hasMoreElements()) {
            ((ColorCheckbox) ((ColorCheckbox) var1.nextElement())).realSetState(false);
        }

    }
}
