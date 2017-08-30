package com.playray.colorgui;

import com.playray.colorgui.GlossyButton;
import com.playray.tools.Tools;

class Class129 implements Runnable {

    private GlossyButton aGlossyButton2000;
    private boolean aBoolean2001;
    private final GlossyButton aGlossyButton2002;


    protected Class129(GlossyButton var1, GlossyButton var2) {
        this.aGlossyButton2002 = var1;
        this.aGlossyButton2000 = var2;
        this.aBoolean2001 = true;
        Thread var3 = new Thread(this);
        var3.setDaemon(true);
        var3.start();
    }

    public void run() {
        do {
            this.aGlossyButton2000.method2876();
            Tools.sleep(25L);
        } while (this.aBoolean2001);

    }

    protected void method2082() {
        this.aBoolean2001 = false;
    }
}
