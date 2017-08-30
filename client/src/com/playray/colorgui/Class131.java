package com.playray.colorgui;

import com.playray.colorgui.RoundButton;
import com.playray.tools.Tools;

class Class131 implements Runnable {

    private RoundButton aRoundButton2006;
    private boolean aBoolean2007;
    private final RoundButton aRoundButton2008;


    protected Class131(RoundButton var1, RoundButton var2) {
        this.aRoundButton2008 = var1;
        this.aRoundButton2006 = var2;
        this.aBoolean2007 = true;
    }

    public void run() {
        boolean var1 = false;

        do {
            Tools.sleep(500L);
            var1 = !var1;
            if (this.aBoolean2007) {
                this.aRoundButton2006.innerSetFlashState(var1);
            }
        } while (this.aBoolean2007);

    }

    protected void method2084() {
        this.aBoolean2007 = false;
    }
}
