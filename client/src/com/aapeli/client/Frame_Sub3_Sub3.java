package com.aapeli.client;

import com.aapeli.client.Class88;
import com.aapeli.client.Frame_Sub3;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Panel_Sub24;
import com.aapeli.client.TextManager;

import java.awt.Component;

class Frame_Sub3_Sub3 extends Frame_Sub3 {

    private Class88 aClass88_2890;
    private Panel_Sub24 aPanel_Sub24_2891;
    private static final String aString2892 = "TellFriend_Title";


    protected Frame_Sub3_Sub3(TextManager var1, ImageManager var2, Class88 var3) {
        super(var1);
        this.aClass88_2890 = var3;
        this.aPanel_Sub24_2891 = new Panel_Sub24(var1, var2, var3, this);
    }

    protected void method241(Component var1) {
        this.method238(var1, super.aTextManager187.getShared("TellFriend_Title"), this.aPanel_Sub24_2891);
    }

    protected void close() {
        super.close();
        this.aClass88_2890.method1703();
        this.aPanel_Sub24_2891 = null;
        this.aClass88_2890 = null;
    }

}
