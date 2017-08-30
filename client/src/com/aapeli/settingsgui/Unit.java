package com.aapeli.settingsgui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Unit implements FocusListener, ItemListener, ActionListener {

    private LobbyRoomSettingsPanel anLobbyRoomSettingsPanel__1691;
    private String aString1692;
    private boolean aBoolean1693;
    private double aDouble1694;
    private int anInt1695;
    public static boolean aBoolean1696;


    protected Unit(String var1) {
        this.aString1692 = var1;
        this.aBoolean1693 = true;
        this.aDouble1694 = 1.0D;
    }

    public void focusGained(FocusEvent var1) {
    }

    public void focusLost(FocusEvent var1) {
        this.anLobbyRoomSettingsPanel__1691.method939(this);
    }

    public void itemStateChanged(ItemEvent var1) {
        this.anLobbyRoomSettingsPanel__1691.method938(this);
    }

    public void actionPerformed(ActionEvent var1) {
        this.anLobbyRoomSettingsPanel__1691.method940(this);
    }

    public void setRelativeWidth(double var1) {
        if (var1 <= 0.0D || var1 > 1.0D) {
            var1 = 1.0D;
        }

        this.aDouble1694 = var1;
    }

    protected void method1829(LobbyRoomSettingsPanel var1) {
        this.anLobbyRoomSettingsPanel__1691 = var1;
    }

    protected boolean method1830(boolean var1) {
        if (var1 == this.aBoolean1693) {
            return false;
        } else {
            this.aBoolean1693 = var1;
            Component var2 = this.method1841();
            if (var2 != null) {
                var2.setVisible(var1);
            }

            return true;
        }
    }

    protected boolean method1831() {
        return this.aBoolean1693;
    }

    protected void method1832(int var1) {
        this.anInt1695 = var1;
    }

    protected int method1833() {
        return this.anInt1695;
    }

    protected double method1834() {
        return this.aDouble1694;
    }

    protected void method1835(Image var1, int var2, int var3) {
    }

    protected int method1836() {
        return 0;
    }

    protected boolean method1837() {
        return false;
    }

    protected String method1838() {
        return this.aString1692;
    }

    protected int method1839() {
        return 0;
    }

    protected int method1840() {
        return 1;
    }

    protected Component method1841() {
        return null;
    }

    protected Component[] method1842() {
        return null;
    }

    protected int getItemState() {
        return -1;
    }

    protected boolean setItemState(int var1) {
        return false;
    }

    protected boolean method1843() {
        return false;
    }

    protected String method1844() {
        return null;
    }

    protected void method1845(String var1) {
    }

    protected void method1846(Color var1, Color var2) {
    }
}
