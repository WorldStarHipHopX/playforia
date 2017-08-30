package com.playray.colorgui;

import com.playray.colorgui.ColorButton;
import com.playray.tools.Tools;

class Class124 implements Runnable {

    private ColorButton aColorButton1958;
    private boolean aBoolean1959;
    private final ColorButton aColorButton1960;


    protected Class124(ColorButton var1, ColorButton var2) {
        this.aColorButton1960 = var1;
        this.aColorButton1958 = var2;
        this.aBoolean1959 = true;
    }

    public void run() {
        boolean var1 = false;

        do {
            Tools.sleep(500L);
            var1 = !var1;
            if (this.aBoolean1959) {
                this.aColorButton1958.innerSetFlashState(var1);
            }
        } while (this.aBoolean1959);

    }

    protected void method2065() {
        this.aBoolean1959 = false;
    }
}
