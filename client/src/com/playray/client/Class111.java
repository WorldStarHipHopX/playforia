package com.playray.client;

import com.playray.applet.AApplet;
import com.playray.client.JFrame_Sub4_Sub1;

class Class111 {

    private AApplet anAApplet1778;
    private JFrame_Sub4_Sub1 aJFrame_Sub4_Sub1_1779;
    private boolean aBoolean1780;


    protected Class111(AApplet var1) {
        this.anAApplet1778 = var1;
        this.aBoolean1780 = false;
    }

    protected boolean method1899(boolean var1) {
        try {
            return this.aBoolean1780 ? false : (this.anAApplet1778.param.getSession() != null ? false : false);
        } catch (Exception var3) {
            return false;
        }
    }

    protected boolean method1900() {
        try {
            if (this.aBoolean1780) {
                return false;
            } else if (this.anAApplet1778.param.getSession() == null) {
                return false;
            } else {
                this.aJFrame_Sub4_Sub1_1779 = new JFrame_Sub4_Sub1(this.anAApplet1778, this, 1, 1);
                this.aJFrame_Sub4_Sub1_1779.method2343(this.anAApplet1778);
                this.aBoolean1780 = true;
                return true;
            }
        } catch (Exception var2) {
            return false;
        }
    }

    protected boolean method1901(int var1, int var2) {
        try {
            if (this.aBoolean1780) {
                return false;
            } else if (this.anAApplet1778.param.getSession() == null) {
                return false;
            } else if (var1 <= 0 && var2 != 0) {
                this.aJFrame_Sub4_Sub1_1779 = new JFrame_Sub4_Sub1(this.anAApplet1778, this, 1, 2);
                this.aJFrame_Sub4_Sub1_1779.method2343(this.anAApplet1778);
                this.aBoolean1780 = true;
                return true;
            } else {
                return false;
            }
        } catch (Exception var4) {
            return false;
        }
    }

    protected void method1902() {
        try {
            if (this.aJFrame_Sub4_Sub1_1779 != null) {
                this.aJFrame_Sub4_Sub1_1779.close();
            }
        } catch (Exception var2) {
            ;
        }

    }

    protected void method1903() {
        this.aJFrame_Sub4_Sub1_1779 = null;
    }
}
