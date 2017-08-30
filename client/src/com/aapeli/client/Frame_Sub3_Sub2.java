package com.aapeli.client;

import com.aapeli.client.Class85;
import com.aapeli.client.Frame_Sub3;
import com.aapeli.client.IPanel_Sub41;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;

import java.awt.Component;

class Frame_Sub3_Sub2 extends Frame_Sub3 {

    private Class85 aClass85_2887;
    private IPanel_Sub41 anIPanel_Sub41_2888;
    private static final String aString2889 = "RegRemind_Title";


    protected Frame_Sub3_Sub2(Parameters var1, TextManager var2, ImageManager var3, Class85 var4) {
        super(var2);
        this.aClass85_2887 = var4;
        this.anIPanel_Sub41_2888 = new IPanel_Sub41(var1, var2, var3, this);
    }

    protected void method240(Component var1) {
        this.method238(var1, super.aTextManager187.getShared("RegRemind_Title"), this.anIPanel_Sub41_2888);
    }

    protected void close() {
        super.close();
        this.aClass85_2887.method1680();
        this.anIPanel_Sub41_2888 = null;
        this.aClass85_2887 = null;
    }

}
