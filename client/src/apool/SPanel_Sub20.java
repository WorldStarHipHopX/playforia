package apool;

import com.playray.client.SPanel;

public abstract class SPanel_Sub20 extends SPanel {

    protected Class60 aClass60_4028;
    protected SynchronizedInt aSynchronizedInt_4029;
    protected int anInt4030;
    protected int anInt4031;
    protected SPanel_Sub32 aSPanel_Sub32_4032;
    protected GameSpinBallPanel aSPanel__4033;
    protected SynchronizedInt aSynchronizedInt_4034;
    protected SynchronizedBool aSynchronizedBool_4035;
    protected SynchronizedBool aSynchronizedBool_4036;
    protected SynchronizedBool aSynchronizedBool_4037;
    public static int anInt4038;
    private static final String[] aStringArray4039 = new String[6];


    public SPanel_Sub20(Class60 var1, int var2, boolean var3) {
        super(false);
        this.aClass60_4028 = var1;
        this.aSynchronizedInt_4029 = new SynchronizedInt(var2);
        this.anInt4030 = var1.anInt1201;
        this.anInt4031 = var1.anInt1202;
        this.setSize(this.anInt4030, this.anInt4031);
        this.setBackground(var1.imageManager.method1983("game_" + (var3 ? "snooker" : "pool") + "-bg"));
        this.aSynchronizedInt_4034 = new SynchronizedInt();
        this.aSynchronizedBool_4035 = new SynchronizedBool();
        this.aSynchronizedBool_4036 = new SynchronizedBool();
        this.aSynchronizedBool_4037 = new SynchronizedBool();
    }

    public abstract void method2522(String[] var1);

    protected void method2523(String var1) {
        Conn var2 = this.aClass60_4028.connection;
        if (var2 != null) {
            var2.method1475("game\t" + var1);
        }

    }

    protected void method2524(String var1) {
        if (this.method2525()) {
            this.method2523(var1);
        }

    }

    protected boolean method2525() {
        return true;
    }

    public abstract void method2526(String var1);

    protected boolean method2527(boolean var1) {
        return true;
    }

    protected boolean method2528() {
        return false;
    }

    protected void method2529() {
    }

    protected abstract void method2530();

    protected void method2531() {
    }

    protected void method2532(int var1) {
    }

    protected abstract void method2533(int var1, boolean var2);

    protected abstract void method2534();

    protected abstract void method2535(int var1, boolean var2);

    protected abstract void method2536(int var1);

    protected void method2537() {
    }

    protected int method2538() {
        return this.aSynchronizedInt_4034.method1467();
    }

    protected abstract int method2539();

    protected String method2540() {
        return null;
    }

    protected abstract String method2541();

    protected void method2542(boolean var1) {
        if (this.method2525()) {
            this.aClass60_4028.gameApplet.method2323(var1);
        }

    }

    protected boolean method2543(double var1, double var3) {
        return this.aSPanel_Sub32_4032.method2660(var1, var3);
    }

    protected void method2544() {
        this.aSPanel_Sub32_4032.method2655();
    }

    protected abstract void method2545();

    protected void method2546() {
        this.aClass60_4028.gameApplet.method2304(0);
        this.aSPanel_Sub32_4032.method2668();
        this.method2523("back");
        this.aClass60_4028.gameApplet.method2322();
    }
}
