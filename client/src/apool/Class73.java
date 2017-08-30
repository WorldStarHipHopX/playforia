package apool;

import apool.SPanel_Sub33;
import com.playray.tools.Tools;

class Class73 implements Runnable {

    private boolean aBoolean1291;
    private final SPanel_Sub33 aSPanel_Sub33_1292;


    protected Class73(SPanel_Sub33 var1) {
        this.aSPanel_Sub33_1292 = var1;
        this.aBoolean1291 = true;
        Thread var2 = new Thread(this);
        var2.setDaemon(true);
        var2.start();
    }

    public void run() {
        do {
            Tools.sleep(500L);
            if (this.aBoolean1291) {
                this.aSPanel_Sub33_1292.method2736();
                Tools.sleep(500L);
                if (this.aBoolean1291) {
                    this.aSPanel_Sub33_1292.method2736();
                    if (this.aSPanel_Sub33_1292.method2737()) {
                        this.aBoolean1291 = false;
                    }
                }
            }
        } while (this.aBoolean1291);

    }

    protected void method1544() {
        this.aBoolean1291 = false;
    }
}
