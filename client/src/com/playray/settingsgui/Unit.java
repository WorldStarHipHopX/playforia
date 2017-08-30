package com.playray.settingsgui;

import com.playray.settingsgui.SPanel_Sub50;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Unit implements FocusListener, ItemListener, ActionListener {

    private SPanel_Sub50 aSPanel_Sub50_2194;
    private String aString2195;
    private boolean aBoolean2196;
    private double aDouble2197;
    private int anInt2198;
    public static boolean aBoolean2199;


    protected Unit(String var1) {
        this.aString2195 = var1;
        this.aBoolean2196 = true;
        this.aDouble2197 = 1.0D;
    }

    public void focusGained(FocusEvent var1) {
    }

    public void focusLost(FocusEvent var1) {
        if (this.aSPanel_Sub50_2194 != null) {
            this.aSPanel_Sub50_2194.method3005(this);
        }
    }

    public void itemStateChanged(ItemEvent var1) {
        if (this.aSPanel_Sub50_2194 != null) {
            this.aSPanel_Sub50_2194.method3004(this);
        }
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aSPanel_Sub50_2194 != null) {
            this.aSPanel_Sub50_2194.method3006(this);
        }
    }

    public void setRelativeWidth(double var1) {
        if (var1 <= 0.0D || var1 > 1.0D) {
            var1 = 1.0D;
        }

        this.aDouble2197 = var1;
    }

    public boolean setVisible(boolean var1) {
        if (var1 == this.aBoolean2196) {
            return false;
        } else {
            this.aBoolean2196 = var1;
            Component var2 = this.method2231();
            if (var2 != null) {
                var2.setVisible(var1);
            }

            return true;
        }
    }

    protected void method2221(SPanel_Sub50 var1) {
        this.aSPanel_Sub50_2194 = var1;
    }

    protected boolean method2222() {
        return this.aBoolean2196;
    }

    protected void method2223(int var1) {
        this.anInt2198 = var1;
    }

    protected int method2224() {
        return this.anInt2198;
    }

    protected double method2225() {
        return this.aDouble2197;
    }

    protected int method2226() {
        return 0;
    }

    protected boolean method2227() {
        return false;
    }

    protected String method2228() {
        return this.aString2195;
    }

    protected int method2229() {
        return 0;
    }

    protected int method2230() {
        return 1;
    }

    protected Component method2231() {
        return null;
    }

    protected Component[] method2232() {
        return null;
    }

    protected int getItemState() {
        return -1;
    }

    protected boolean setItemState(int var1) {
        return false;
    }

    protected boolean method2233() {
        return false;
    }

    protected String method2234() {
        return null;
    }

    protected void method2235(String var1) {
    }

    protected void method2236(Color var1, Color var2) {
    }
}
