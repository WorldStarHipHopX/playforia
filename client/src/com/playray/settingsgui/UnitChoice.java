package com.playray.settingsgui;

import com.playray.settingsgui.Unit;

import java.awt.Component;
import java.util.Vector;
import javax.swing.JComboBox;

public final class UnitChoice extends Unit {

    private JComboBox aJComboBox3623 = new JComboBox();
    private Vector aVector3624;


    public UnitChoice(String var1) {
        super(var1);
        this.aJComboBox3623.addItemListener(this);
        this.aVector3624 = new Vector();
    }

    public synchronized void addItem(String var1) {
        this.aJComboBox3623.addItem(var1);
    }

    public synchronized void addInvisibleItem() {
        this.aVector3624.addElement(new Integer(this.aJComboBox3623.getItemCount()));
    }

    public synchronized int getItemState() {
        int var1 = this.aJComboBox3623.getSelectedIndex();
        int var2 = this.aVector3624.size();

        for (int var4 = 0; var4 < var2; ++var4) {
            Integer var3 = (Integer) ((Integer) this.aVector3624.elementAt(var4));
            if (var3.intValue() <= var1) {
                ++var1;
            }
        }

        return var1;
    }

    public synchronized boolean setItemState(int var1) {
        if (this.getItemState() == var1) {
            return false;
        } else {
            int var2 = this.aVector3624.size();
            int var4 = 0;

            for (int var6 = 0; var6 < var2; ++var6) {
                Integer var5 = (Integer) ((Integer) this.aVector3624.elementAt(var6));
                int var3 = var5.intValue();
                if (var3 == var1) {
                    return false;
                }

                if (var3 < var1) {
                    ++var4;
                }
            }

            this.aJComboBox3623.setSelectedIndex(var1 - var4);
            return true;
        }
    }

    protected int method2226() {
        return 20;
    }

    protected int method2229() {
        return 2;
    }

    protected Component method2231() {
        return this.aJComboBox3623;
    }

    protected boolean method2233() {
        return true;
    }

    protected String method2234() {
        return "" + this.getItemState();
    }

    protected void method2235(String var1) {
        this.setItemState(Integer.parseInt(var1));
    }
}
