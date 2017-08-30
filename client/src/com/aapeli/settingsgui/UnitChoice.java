package com.aapeli.settingsgui;

import com.aapeli.colorgui.Choicer;
import com.aapeli.settingsgui.Unit;

import java.awt.Component;
import java.util.Vector;

public final class UnitChoice extends Unit {

    private Choicer aChoicer3597 = new Choicer();
    private Vector aVector3598;


    public UnitChoice(String var1) {
        super(var1);
        this.aChoicer3597.addItemListener(this);
        this.aVector3598 = new Vector();
    }

    public synchronized void addItem(String var1) {
        this.aChoicer3597.addItem(var1);
    }

    public synchronized void addInvisibleItem() {
        this.aVector3598.addElement(new Integer(this.aChoicer3597.getItemCount()));
    }

    public synchronized int getItemState() {
        int var1 = this.aChoicer3597.getSelectedIndex();
        int var2 = this.aVector3598.size();

        for (int var4 = 0; var4 < var2; ++var4) {
            Integer var3 = (Integer) ((Integer) this.aVector3598.elementAt(var4));
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
            int var2 = this.aVector3598.size();
            int var4 = 0;

            for (int var6 = 0; var6 < var2; ++var6) {
                Integer var5 = (Integer) ((Integer) this.aVector3598.elementAt(var6));
                int var3 = var5.intValue();
                if (var3 == var1) {
                    return false;
                }

                if (var3 < var1) {
                    ++var4;
                }
            }

            this.aChoicer3597.setSelectedIndex(var1 - var4);
            return true;
        }
    }

    protected int method1836() {
        return 20;
    }

    protected int method1839() {
        return 2;
    }

    protected Component method1841() {
        return this.aChoicer3597;
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
}
