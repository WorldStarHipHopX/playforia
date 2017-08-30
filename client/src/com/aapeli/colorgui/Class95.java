package com.aapeli.colorgui;

import com.aapeli.colorgui.RoundButton;
import com.aapeli.tools.Tools;

class Class95 implements Runnable {

    private RoundButton aRoundButton1577;
    private boolean aBoolean1578;
    private final RoundButton aRoundButton1579;


    protected Class95(RoundButton var1, RoundButton var2) {
        this.aRoundButton1579 = var1;
        this.aRoundButton1577 = var2;
        this.aBoolean1578 = true;
    }

    public void run() {
        boolean var1 = false;

        do {
            Tools.sleep(500L);
            var1 = !var1;
            if (this.aBoolean1578) {
                this.aRoundButton1577.innerSetFlashState(var1);
            }
        } while (this.aBoolean1578);

    }

    protected void method1755() {
        this.aBoolean1578 = false;
    }
}
