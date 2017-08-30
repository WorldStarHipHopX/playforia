package com.aapeli.colorgui;

import com.aapeli.colorgui.RadioButton;
import com.aapeli.colorgui.TabBar;

import java.awt.Component;
import java.awt.Image;

public final class TabBarItem {

    private RadioButton aRadioButton1591;
    private Component aComponent1592;
    private int anInt1593;
    private boolean aBoolean1594;


    public TabBarItem(TabBar var1, String var2, Component var3) {
        this(var1, (Image) null, var2, var3);
    }

    public TabBarItem(TabBar var1, Image var2, String var3, Component var4) {
        this.aRadioButton1591 = var1.method876(var2, var3);
        this.aComponent1592 = var4;
        this.anInt1593 = 0;
        this.aBoolean1594 = false;
    }

    public void setTabID(int var1) {
        this.anInt1593 = var1;
    }

    public int getTabID() {
        return this.anInt1593;
    }

    public void setComponentAutoSize(boolean var1) {
        this.aBoolean1594 = var1;
    }

    public boolean isComponentAutoSize() {
        return this.aBoolean1594;
    }

    public RadioButton getButton() {
        return this.aRadioButton1591;
    }

    public Component getComponent() {
        return this.aComponent1592;
    }
}
