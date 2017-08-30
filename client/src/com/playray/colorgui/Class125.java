package com.playray.colorgui;

import com.playray.colorgui.ColorCheckbox;
import com.playray.tools.Tools;

class Class125 implements Runnable {

    private ColorCheckbox aColorCheckbox1961;
    private boolean aBoolean1962;
    private final ColorCheckbox aColorCheckbox1963;


    protected Class125(ColorCheckbox var1, ColorCheckbox var2) {
        this.aColorCheckbox1963 = var1;
        this.aColorCheckbox1961 = var2;
        this.aBoolean1962 = true;
        Thread var3 = new Thread(this);
        var3.setDaemon(true);
        var3.start();
    }

    public void run() {
        do {
            this.aColorCheckbox1961.method2836();
            Tools.sleep(25L);
        } while (this.aBoolean1962);

    }

    protected void method2066() {
        this.aBoolean1962 = false;
    }
}
