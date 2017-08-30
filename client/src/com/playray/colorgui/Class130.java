package com.playray.colorgui;

import com.playray.colorgui.GlossyButton;
import com.playray.tools.Tools;

class Class130 implements Runnable {

    private GlossyButton aGlossyButton2003;
    private boolean aBoolean2004;
    private final GlossyButton aGlossyButton2005;


    protected Class130(GlossyButton var1, GlossyButton var2) {
        this.aGlossyButton2005 = var1;
        this.aGlossyButton2003 = var2;
        this.aBoolean2004 = true;
    }

    public void run() {
        int var1 = 0;

        do {
            Tools.sleep(500L);
            var1 = -var1;
            if (var1 >= 0) {
                ++var1;
            }

            if (this.aBoolean2004) {
                this.aGlossyButton2003.method2877(var1);
            }
        } while (this.aBoolean2004);

    }

    protected void method2083() {
        this.aBoolean2004 = false;
    }
}
