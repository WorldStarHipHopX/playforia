package com.aapeli.client;

import com.aapeli.client.Frame_Sub3_Sub2;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;

class Class85 {

    private Parameters aParameters1465;
    private TextManager aTextManager1466;
    private ImageManager anImageManager1467;
    private int[] anIntArray1468;
    private boolean aBoolean1469;
    private int anInt1470;
    private int anInt1471;
    private Frame_Sub3_Sub2 aFrame_Sub3_Sub2_1472;


    protected boolean method1678() {
        if (!this.aBoolean1469) {
            return false;
        } else {
            try {
                if (this.aParameters1465.getSession() != null) {
                    this.aBoolean1469 = false;
                    return false;
                }

                ++this.anInt1470;
                if (this.anInt1470 == this.anIntArray1468[this.anInt1471]) {
                    ++this.anInt1471;
                    if (this.anInt1471 == this.anIntArray1468.length) {
                        this.aBoolean1469 = false;
                    }

                    this.method1681();
                    return true;
                }
            } catch (Exception var2) {
                this.aBoolean1469 = false;
            }

            return false;
        }
    }

    protected void method1679() {
        try {
            if (this.aFrame_Sub3_Sub2_1472 != null) {
                this.aFrame_Sub3_Sub2_1472.close();
            }
        } catch (Exception var2) {
            ;
        }

    }

    protected void method1680() {
        this.aFrame_Sub3_Sub2_1472 = null;
    }

    private void method1681() {
        this.aFrame_Sub3_Sub2_1472 = new Frame_Sub3_Sub2(this.aParameters1465, this.aTextManager1466, this.anImageManager1467, this);
        this.aFrame_Sub3_Sub2_1472.method240(this.aParameters1465.getApplet());
    }
}
