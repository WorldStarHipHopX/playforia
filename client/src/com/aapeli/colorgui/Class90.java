package com.aapeli.colorgui;

import com.aapeli.colorgui.ColorButton;
import com.aapeli.tools.Tools;

class Class90 implements Runnable {

    private ColorButton aColorButton1533;
    private boolean aBoolean1534;
    private final ColorButton aColorButton1535;


    protected Class90(ColorButton var1, ColorButton var2) {
        this.aColorButton1535 = var1;
        this.aColorButton1533 = var2;
        this.aBoolean1534 = true;
    }

    public void run() {
        boolean var1 = false;

        do {
            Tools.sleep(500L);
            var1 = !var1;
            if (this.aBoolean1534) {
                this.aColorButton1533.innerSetFlashState(var1);
            }
        } while (this.aBoolean1534);

    }

    protected void method1738() {
        this.aBoolean1534 = false;
    }
}
