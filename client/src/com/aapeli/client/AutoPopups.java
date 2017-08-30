package com.aapeli.client;

import com.aapeli.applet.AApplet;
import com.aapeli.colorgui.ColorButton;

public class AutoPopups {

    private Class78 aClass78_1327;
    private Class88 aClass88_1328;
    private Class85 aClass85_1329;
    private long aLong1330;
    private static final String aString1331 = "facebook";


    public AutoPopups(AApplet var1) {
        if (!var1.param.getSiteName().equalsIgnoreCase("facebook")) {
            this.aClass78_1327 = new Class78(var1);
            this.aClass88_1328 = new Class88(var1.param, var1.textManager, var1.imageManager);
        }

        this.aLong1330 = 0L;
    }

    public AutoPopups(Parameters var1, TextManager var2, ImageManager var3) {
        if (!var1.getSiteName().equalsIgnoreCase("facebook")) {
            this.aClass88_1328 = new Class88(var1, var2, var3);
        }

    }

    public ColorButton getTellFriendButton() {
        return this.aClass88_1328 != null ? this.aClass88_1328.method1699() : null;
    }

    public void gameFinished(boolean var1) {
        synchronized (this) {
            if (this.method1561()) {
                if (this.aClass78_1327 != null && this.aClass78_1327.method1599(var1)) {
                    this.method1562();
                } else if (this.aClass88_1328 != null && this.aClass88_1328.method1700()) {
                    this.method1562();
                } else if (this.aClass85_1329 != null && !var1 && this.aClass85_1329.method1678()) {
                    this.method1562();
                }
            }
        }
    }

    public void personalRecord() {
        synchronized (this) {
            if (this.method1561()) {
                if (this.aClass78_1327 != null && this.aClass78_1327.method1600()) {
                    this.method1562();
                }

            }
        }
    }

    public void rankingChanged(int var1, int var2) {
        synchronized (this) {
            if (this.method1561()) {
                if (this.aClass78_1327 != null && this.aClass78_1327.method1601(var1, var2)) {
                    this.method1562();
                }

            }
        }
    }

    public void close() {
        synchronized (this) {
            if (this.aClass78_1327 != null) {
                this.aClass78_1327.method1602();
            }

            if (this.aClass88_1328 != null) {
                this.aClass88_1328.method1701();
            }

            if (this.aClass85_1329 != null) {
                this.aClass85_1329.method1679();
            }

        }
    }

    private boolean method1561() {
        return System.currentTimeMillis() > this.aLong1330 + 15000L;
    }

    private void method1562() {
        this.aLong1330 = System.currentTimeMillis();
    }

}
