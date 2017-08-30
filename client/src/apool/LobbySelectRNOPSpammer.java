package apool;

import apool.SPanel_Sub23;
import com.playray.tools.Tools;

class LobbySelectRNOPSpammer implements Runnable {

    private boolean aBoolean1300;
    private Thread aThread1301;
    private final SPanel_Sub23 aSPanel_Sub23_1302;


    protected LobbySelectRNOPSpammer(SPanel_Sub23 var1) {
        this.aSPanel_Sub23_1302 = var1;
        this.aBoolean1300 = true;
        this.aThread1301 = new Thread(this);
        this.aThread1301.setDaemon(true);
        this.aThread1301.start();
    }

    public void run() {
        int var1 = 10000;

        do {
            this.aSPanel_Sub23_1302.method2602();
            Tools.sleep((long) var1);
            if (var1 < 120000) {
                var1 += 5000;
            }
        } while (this.aBoolean1300);

    }

    protected void method1546() {
        this.aBoolean1300 = false;
        this.aThread1301.interrupt();
    }
}
