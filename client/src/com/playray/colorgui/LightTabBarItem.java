package com.playray.colorgui;

import com.playray.colorgui.LightTabBar;
import com.playray.colorgui.SPanel_Sub42;

import java.awt.Component;
import java.awt.Image;

public final class LightTabBarItem {

    private LightTabBar aLightTabBar2009;
    private SPanel_Sub42 aSPanel_Sub42_2010;
    private Component aComponent2011;
    private int anInt2012;


    public LightTabBarItem(Image var1, String[] var2, Component var3) {
        this.aSPanel_Sub42_2010 = new SPanel_Sub42(this, var1, var2);
        this.aComponent2011 = var3;
        this.anInt2012 = 0;
    }

    protected void method2085(LightTabBar var1) {
        this.aLightTabBar2009 = var1;
    }

    protected void method2086() {
        this.aLightTabBar2009.method2893(this);
    }

    protected void method2087(boolean var1) {
        this.aSPanel_Sub42_2010.method2887(var1);
    }

    public SPanel_Sub42 getButton() {
        return this.aSPanel_Sub42_2010;
    }

    public Component getComponent() {
        return this.aComponent2011;
    }

    public void setTabID(int var1) {
        this.anInt2012 = var1;
    }

    public int getTabID() {
        return this.anInt2012;
    }
}
