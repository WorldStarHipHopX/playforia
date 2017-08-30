package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.Class111;
import com.playray.client.Class122;
import com.playray.colorgui.ColorButton;

public class AutoPopups {

    private Class111 aClass111_1774;
    private Class122 aClass122_1775;
    private long aLong1776;
    private static final String aString1777 = "facebook";


    public AutoPopups(AApplet var1) {
        if (!var1.param.getSiteName().equalsIgnoreCase("facebook")) {
            this.aClass111_1774 = new Class111(var1);
            this.aClass122_1775 = new Class122(var1);
        }

        this.aLong1776 = 0L;
    }

    public ColorButton getTellFriendButton() {
        return this.aClass122_1775 != null ? this.aClass122_1775.method1991() : null;
    }

    public void gameFinished(boolean var1) {
        synchronized (this) {
            if (this.method1897()) {
                if (this.aClass111_1774 != null && this.aClass111_1774.method1899(var1)) {
                    this.method1898();
                } else if (this.aClass122_1775 != null && this.aClass122_1775.method1992()) {
                    this.method1898();
                }
            }
        }
    }

    public void personalRecord() {
        synchronized (this) {
            if (this.method1897()) {
                if (this.aClass111_1774 != null && this.aClass111_1774.method1900()) {
                    this.method1898();
                }

            }
        }
    }

    public void rankingChanged(int var1, int var2) {
        synchronized (this) {
            if (this.method1897()) {
                if (this.aClass111_1774 != null && this.aClass111_1774.method1901(var1, var2)) {
                    this.method1898();
                }

            }
        }
    }

    public void close() {
        synchronized (this) {
            if (this.aClass111_1774 != null) {
                this.aClass111_1774.method1902();
            }

            if (this.aClass122_1775 != null) {
                this.aClass122_1775.method1993();
            }

        }
    }

    private boolean method1897() {
        return System.currentTimeMillis() > this.aLong1776 + 15000L;
    }

    private void method1898() {
        this.aLong1776 = System.currentTimeMillis();
    }

}
