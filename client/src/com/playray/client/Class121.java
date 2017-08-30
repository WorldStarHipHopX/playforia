package com.playray.client;

import com.playray.client.SwingUpdateTarget;

final class Class121 implements Runnable {

    private final SwingUpdateTarget aSwingUpdateTarget1862;
    private final Object anObject1863;


    Class121(SwingUpdateTarget var1, Object var2) {
        this.aSwingUpdateTarget1862 = var1;
        this.anObject1863 = var2;
    }

    public void run() {
        this.aSwingUpdateTarget1862.updateUI(this.anObject1863);
    }
}
