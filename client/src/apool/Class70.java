package apool;

import apool.SPanel_Sub32;
import com.playray.tools.Tools;

class Class70 implements Runnable {

    private SPanel_Sub32 aSPanel_Sub32_1264;
    private int anInt1265;
    private final SPanel_Sub32 aSPanel_Sub32_1266;


    protected Class70(SPanel_Sub32 var1, SPanel_Sub32 var2, int var3) {
        this.aSPanel_Sub32_1266 = var1;
        this.aSPanel_Sub32_1264 = var2;
        this.anInt1265 = var3;
        Thread var4 = new Thread(this);
        var4.setDaemon(true);
        var4.start();
    }

    public void run() {
        Tools.sleep((long) (this.anInt1265 * 3000));
        this.aSPanel_Sub32_1264.method2725(this.anInt1265);
    }
}
