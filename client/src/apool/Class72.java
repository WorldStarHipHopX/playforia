package apool;

import apool.Class71;
import com.playray.tools.Tools;

class Class72 implements Runnable {

    private int anInt1279;
    private int anInt1280;
    private double aDouble1281;
    private double aDouble1282;
    private double aDouble1283;
    private double aDouble1284;
    private boolean aBoolean1285;
    private Thread aThread1286;
    private int anInt1287;
    private long aLong1288;
    private final Class71 aClass71_1289;

    protected Class72(Class71 var1) {
        this.aClass71_1289 = var1;
        this.aDouble1283 = this.aDouble1284 = 0.0D;
        this.anInt1287 = 350;
        this.aLong1288 = 0L;
        this.aBoolean1285 = true;
        this.aThread1286 = new Thread(this);
        this.aThread1286.setDaemon(true);
        this.aThread1286.start();
    }

    public void run() {
        do {
            Tools.sleep(100L);
            if (this.aBoolean1285) {
                this.method1543();
            }
        } while (this.aBoolean1285);

    }

    protected void method1541() {
        this.aBoolean1285 = false;
        this.aThread1286.interrupt();
    }

    protected synchronized void method1542(double var1, double var3, int var5, int var6) {
        this.aDouble1281 = var1;
        this.aDouble1282 = var3;
        this.anInt1279 = var5;
        this.anInt1280 = var6;
    }

    private synchronized void method1543() {
        double var1 = this.aDouble1283 - this.aDouble1281;
        double var3 = this.aDouble1284 - this.aDouble1282;
        if (Math.sqrt(var1 * var1 + var3 * var3) >= 2.0D) {
            long var5 = System.currentTimeMillis();
            if (var5 >= this.aLong1288 + (long) this.anInt1287) {
                this.aClass71_1289.aSPanel_Sub20_1267.method2524("currentmouse\t" + this.anInt1279 + "\t" + this.anInt1280);
                this.aDouble1283 = this.aDouble1281;
                this.aDouble1284 = this.aDouble1282;
                this.aLong1288 = var5;
                if (this.anInt1287 < 900) {
                    this.anInt1287 += 100;
                }

            }
        }
    }

}
