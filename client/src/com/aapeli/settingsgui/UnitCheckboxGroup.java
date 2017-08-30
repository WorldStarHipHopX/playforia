package com.aapeli.settingsgui;

import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.ColorCheckboxGroup;
import com.aapeli.settingsgui.Unit;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

public final class UnitCheckboxGroup extends Unit {

    private ColorCheckboxGroup aColorCheckboxGroup3595 = new ColorCheckboxGroup();
    private Vector aVector3596 = new Vector();


    public UnitCheckboxGroup(String var1) {
        super(var1);
    }

    public void addItem(String var1) {
        ColorCheckbox var2 = new ColorCheckbox(var1);
        var2.setGroup(this.aColorCheckboxGroup3595);
        var2.addItemListener(this);
        this.aVector3596.addElement(var2);
    }

    public int getItemState() {
        int var1 = this.aVector3596.size();

        for (int var2 = 0; var2 < var1; ++var2) {
            if (((ColorCheckbox) ((ColorCheckbox) this.aVector3596.elementAt(var2))).getState()) {
                return var2;
            }
        }

        return -1;
    }

    public boolean setItemState(int var1) {
        if (this.getItemState() == var1) {
            return false;
        } else {
            ((ColorCheckbox) ((ColorCheckbox) this.aVector3596.elementAt(var1))).setState(true);
            return true;
        }
    }

    protected int method1836() {
        return 20;
    }

    protected int method1839() {
        return 2;
    }

    protected Component[] method1842() {
        int var1 = this.aVector3596.size();
        Component[] var2 = new Component[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (ColorCheckbox) ((ColorCheckbox) this.aVector3596.elementAt(var3));
        }

        return var2;
    }

    protected boolean method1843() {
        return true;
    }

    protected String method1844() {
        return "" + this.getItemState();
    }

    protected void method1845(String var1) {
        this.setItemState(Integer.parseInt(var1));
    }

    protected void method1846(Color var1, Color var2) {
        int var3 = this.aVector3596.size();

        for (int var4 = 0; var4 < var3; ++var4) {
            this.method1847((ColorCheckbox) ((ColorCheckbox) this.aVector3596.elementAt(var4)), var1, var2);
        }

    }

    private void method1847(ColorCheckbox var1, Color var2, Color var3) {
        var1.setBackground(var2);
        var1.setForeground(var3);
    }
}
