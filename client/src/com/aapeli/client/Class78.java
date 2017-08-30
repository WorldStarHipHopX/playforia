package com.aapeli.client;

import com.aapeli.applet.AApplet;

class Class78 {

    private AApplet anAApplet1363;
    private Frame_Sub3_Sub1 frame;
    private boolean aBoolean1365;


    protected Class78(AApplet var1) {
        this.anAApplet1363 = var1;
        this.aBoolean1365 = false;
    }

    protected boolean method1599(boolean var1) {
        try {
            return this.aBoolean1365 ? false : (this.anAApplet1363.param.getSession() != null ? false : false);
        } catch (Exception var3) {
            return false;
        }
    }

    protected boolean method1600() {
        try {
            if (this.aBoolean1365) {
                return false;
            } else if (this.anAApplet1363.param.getSession() == null) {
                return false;
            } else {
                this.frame = new Frame_Sub3_Sub1(this.anAApplet1363, this, 1, 1);
                this.frame.method239(this.anAApplet1363);
                this.aBoolean1365 = true;
                return true;
            }
        } catch (Exception var2) {
            return false;
        }
    }

    protected boolean method1601(int var1, int var2) {
        try {
            if (this.aBoolean1365) {
                return false;
            } else if (this.anAApplet1363.param.getSession() == null) {
                return false;
            } else if (var1 <= 0 && var2 != 0) {
                this.frame = new Frame_Sub3_Sub1(this.anAApplet1363, this, 1, 2);
                this.frame.method239(this.anAApplet1363);
                this.aBoolean1365 = true;
                return true;
            } else {
                return false;
            }
        } catch (Exception var4) {
            return false;
        }
    }

    protected void method1602() {
        try {
            if (this.frame != null) {
                this.frame.close();
            }
        } catch (Exception var2) {
            ;
        }

    }

    protected void method1603() {
        this.frame = null;
    }
}
