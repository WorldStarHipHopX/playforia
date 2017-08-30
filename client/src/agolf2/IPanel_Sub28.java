package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.tools.DelayTimer;
import com.aapeli.tools.Tools;

import java.util.Random;

public abstract class IPanel_Sub28 extends IPanel implements Interface5, Runnable {

    private Class58 aClass58_2325;
    protected IPanel_Sub36 anIPanel_Sub36_2326;
    protected int anInt2327;
    protected int anInt2328;
    protected int anInt2329;
    protected Class52 aClass52_2330;
    protected Class43_Sub1 aClass43_Sub1_2331;
    protected Frame_Sub2 aFrame_Sub2_2332;
    protected SynchronizedInteger aSynchronizedInteger_2333;
    protected SynchronizedBool aSynchronizedBool_2334;
    protected SynchronizedInteger aSynchronizedInteger_2335;
    protected int anInt2336;
    protected int anInt2337;
    protected boolean aBoolean2338;
    protected boolean aBoolean2339;
    public static boolean aBoolean2340;
    private static final String[] aStringArray2341 = new String[2];


    public IPanel_Sub28(Class58 var1, int var2, int var3, int var4, boolean var5) {
        this.aClass58_2325 = var1;
        this.anInt2329 = var2;
        this.anInt2327 = var3;
        this.anInt2328 = var4;
        this.setSize(var3, var4);
        this.aSynchronizedInteger_2333 = new SynchronizedInteger(-1);
        this.aSynchronizedBool_2334 = new SynchronizedBool(false);
        this.aSynchronizedInteger_2335 = new SynchronizedInteger(0);
        this.anInt2336 = this.anInt2337 = -1;
        this.aBoolean2339 = false;
        this.setBackground(var1.imageManager.getImage("background"));
    }

    protected void method679(IPanel_Sub36 var1) {
        this.anIPanel_Sub36_2326 = var1;
    }

    public void method11(int var1, int var2) {
        if (var1 >= 0 && var2 >= 0) {
            this.anInt2336 = var1;
            this.anInt2337 = var2;
            if (this.aSynchronizedBool_2334.method1168()) {
                GameBall_Sub1[] var3 = this.aClass43_Sub1_2331.method1325();
                int[] var4 = this.method688(var3[this.aSynchronizedInteger_2333.method1174()]);
                var3[this.aSynchronizedInteger_2333.method1174()].method1236(var4[0], var4[1]);
                int[] var5 = var3[this.aSynchronizedInteger_2333.method1174()].method1240();
                int[] var6 = var3[this.aSynchronizedInteger_2333.method1174()].method1241();
                if (var6 != null) {
                    this.anIPanel_Sub36_2326.method767().method203(var5[0], var5[1], var6[0], var6[1]);
                }
            }

        } else {
            this.method12();
        }
    }

    public void method12() {
        this.anInt2336 = this.anInt2337 = -1;
        if (this.aSynchronizedBool_2334.method1168()) {
            GameBall_Sub1[] var1 = this.aClass43_Sub1_2331.method1325();
            var1[this.aSynchronizedInteger_2333.method1174()].method1235();
            this.anIPanel_Sub36_2326.method767().method204();
        }

    }

    public void method13(int var1, int var2, boolean var3) {
        this.anInt2336 = var1;
        this.anInt2337 = var2;
        if (this.aSynchronizedBool_2334.method1168()) {
            if (var3) {
                this.aSynchronizedInteger_2335.method1172();
                if (this.aSynchronizedInteger_2335.method1174() == 4) {
                    this.aSynchronizedInteger_2335.set(0);
                }

                this.method11(var1, var2);
                return;
            }

            GameBall_Sub1 var4 = this.aClass43_Sub1_2331.method1325()[this.anInt2329 != 0 ? this.aSynchronizedInteger_2333.method1174() : 0];
            if (var4.method1237() < 4.5D) {
                return;
            }

            this.method690();
            this.method680(var4);
        }

    }

    protected abstract void method680(GameBall var1);

    public void run() {
        DelayTimer var1 = new DelayTimer(50);
        int var2 = 0;
        Canvas_Sub6_Sub2 var3 = this.anIPanel_Sub36_2326.method767();
        var3.method205();

        boolean var4;
        do {
            var4 = this.aClass43_Sub1_2331.method1299();
            if (!var4) {
                ++var2;
                if (var2 == 30) {
                    if (var1.doDelay() && this.aBoolean2338) {
                        var3.method207();
                    }

                    var2 = 0;
                }
            }
        } while (!var4 && this.aBoolean2338);

        if (this.aBoolean2338) {
            this.method681(var3);
            this.aBoolean2338 = false;
        }

    }

    protected abstract void method681(Canvas_Sub6_Sub2 var1);

    public void method682() {
        this.aBoolean2339 = true;
        this.aFrame_Sub2_2332.dispose();
        this.method683();
        this.method691(true);
    }

    protected void method683() {
        this.aSynchronizedBool_2334.method1167(false);
        this.aBoolean2338 = false;
    }

    protected void method684(int var1) {
        this.aSynchronizedInteger_2333.set(var1);
    }

    public boolean method685() {
        return this.aSynchronizedInteger_2333.method1174() >= 0;
    }

    public void method686() {
        this.aFrame_Sub2_2332.method236(this.aClass58_2325.gameApplet);
    }

    public void method687() {
        if (!this.aBoolean2338) {
            this.anIPanel_Sub36_2326.method772();
        }

    }

    protected int[] method688(GameBall var1) {
        int[] var2 = var1.method1240();
        int var3 = this.anInt2336 - var2[0];
        int var4 = this.anInt2337 - var2[1];
        if (this.aSynchronizedInteger_2335.method1174() == 1) {
            var3 = -var3;
            var4 = -var4;
        } else {
            int var5;
            if (this.aSynchronizedInteger_2335.method1174() == 2) {
                var5 = var3;
                var3 = -var4;
                var4 = var5;
            } else if (this.aSynchronizedInteger_2335.method1174() == 3) {
                var5 = var3;
                var3 = var4;
                var4 = -var5;
            }
        }

        return new int[]{var2[0] + var3, var2[1] + var4};
    }

    protected void method689(Random var1) {
        Tools.forcedRepaint(this.anIPanel_Sub36_2326.method767());
        this.aClass43_Sub1_2331.method1298(var1);
        this.aClass58_2325.aClass39_Sub1_1191.method1234("player_strike");
        this.aBoolean2338 = true;
        Thread var2 = new Thread(this);
        var2.setDaemon(true);
        var2.start();
    }

    protected void method690() {
        this.aSynchronizedBool_2334.method1167(false);
        Canvas_Sub6_Sub2 var1 = this.anIPanel_Sub36_2326.method767();
        if (var1 != null) {
            var1.method201();
            var1.method204();
        }

    }

    protected void method691(boolean var1) {
        boolean var2 = false;
        if (this.aClass43_Sub1_2331 != null) {
            this.aClass43_Sub1_2331.method1302();
            this.aClass43_Sub1_2331 = null;
            var2 = true;
        }

        if (this.aClass52_2330 != null) {
            this.aClass52_2330.method1408();
            this.aClass52_2330 = null;
            var2 = true;
        }

        if (var1) {
            this.anIPanel_Sub36_2326.method770();
            var2 = true;
        }

        if (var2) {
            System.gc();
        }

    }

    static {
        aStringArray2341[0] = "player_strike";
        aStringArray2341[1] = "background";
    }
}
