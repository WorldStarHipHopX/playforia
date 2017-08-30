package com.playray.client;

import com.playray.client.SwingUpdateTarget;

final class Class120 implements Runnable {

    private final SwingUpdateTarget aSwingUpdateTarget1860;
    private final Object anObject1861;


    Class120(SwingUpdateTarget var1, Object var2) {
        this.aSwingUpdateTarget1860 = var1;
        this.anObject1861 = var2;
    }

    public void run() {
        this.aSwingUpdateTarget1860.updateUI(this.anObject1861);
    }
}
