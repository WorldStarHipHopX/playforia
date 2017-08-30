package apool;

public abstract class SPanel_Sub20_Sub2 extends SPanel_Sub20 {

    protected SPanel_Sub34_Sub1 aSPanel_Sub34_Sub1_4857;
    protected GameControlPanel_Sub14_Sub2 aSPanel_Sub14_Sub2_4858;
    protected GameEditPanel aSPanel__4859;
    protected boolean aBoolean4860;
    private Class74 aClass74_4861;
    private Class74 aClass74_4862;
    private Class74 aClass74_4863;
    private int anInt4864;
    private static final String[] aStringArray4865 = new String[4];


    protected SPanel_Sub20_Sub2(Class60 var1, int var2) {
        super(var1, var2, var2 == 5);
        this.method2570();
    }

    public void method2522(String[] var1) {
        if (var1[1].equals("player")) {
            this.aSPanel_Sub34_Sub1_4857.method2739(var1[2], var1[3]);
        } else if (var1[1].equals("start")) {
            this.method2571(Long.parseLong(var1[2]));
        } else {
            if (var1[1].equals("turn")) {
                super.aSPanel_Sub32_4032.method2659(1, super.aSynchronizedInt_4029.method1467(), true);
                super.aSPanel__4033.method2627(true);
            }

        }
    }

    public void method2526(String var1) {
    }

    protected void method2529() {
        super.method2529();
        this.method2572(2);
    }

    protected void method2530() {
        this.method2572(1);
        this.aSPanel_Sub14_Sub2_4858.method2488(false);
        if (this.aSPanel__4859 != null) {
            this.aSPanel__4859.method2502();
        }

        super.aSPanel__4033.method2628(false);
        super.aSynchronizedBool_4036.method1459(false);
        super.aSynchronizedBool_4037.method1459(false);
        super.aSynchronizedInt_4034.method1463(0);
    }

    protected void method2531() {
        this.aSPanel_Sub34_Sub1_4857.method2741();
    }

    protected void method2533(int var1, boolean var2) {
    }

    protected void method2534() {
    }

    protected void method2537() {
        this.method2572(2);
        this.aSPanel_Sub14_Sub2_4858.method2488(true);
        if (this.aBoolean4860) {
            super.aSPanel_Sub32_4032.method2667();
            this.method2542(false);
        }

    }

    protected int method2539() {
        return this.aBoolean4860 ? this.aSPanel_Sub34_Sub1_4857.method2743() : -1;
    }

    protected void method2545() {
        this.aSPanel_Sub14_Sub2_4858.method2488(false);
        super.aSPanel_Sub32_4032.method2666();
        this.method2523("newgame");
    }

    protected void method2565() {
        if (this.aSPanel__4859 != null) {
            this.aSPanel__4859.method2501();
        }

    }

    protected boolean method2566() {
        if (this.aSPanel_Sub34_Sub1_4857.method2746(super.aSPanel_Sub32_4032.method2686())) {
            return true;
        } else {
            this.method2572(3);
            return false;
        }
    }

    protected void method2567(boolean var1) {
        super.aSPanel_Sub32_4032.method2687(var1);
    }

    protected void method2568(int var1) {
        this.aSPanel_Sub34_Sub1_4857.method2742(var1, false);
        super.aSPanel_Sub32_4032.method2679(var1);
    }

    protected void method2569() {
        if (this.aClass74_4861 != null || this.aClass74_4862 != null || this.aClass74_4863 != null) {
            Class74 var1 = null;

            do {
                --this.anInt4864;
                if (this.anInt4864 == 0) {
                    this.anInt4864 = 3;
                }

                if (this.anInt4864 == 1) {
                    var1 = this.aClass74_4861;
                } else if (this.anInt4864 == 2) {
                    var1 = this.aClass74_4862;
                } else if (this.anInt4864 == 3) {
                    var1 = this.aClass74_4863;
                }
            } while (var1 == null);

            var1.method1545(super.aSPanel_Sub32_4032, this.aSPanel_Sub34_Sub1_4857);
        }
    }

    protected void method2570() {
        this.aSPanel_Sub34_Sub1_4857 = new SPanel_Sub34_Sub1(super.aClass60_4028, this, super.aSynchronizedInt_4029.method1467(), 750, 70);
        this.aSPanel_Sub34_Sub1_4857.setLocation(5, 0);
        this.add(this.aSPanel_Sub34_Sub1_4857);
        super.aSPanel__4033 = new GameSpinBallPanel(super.aClass60_4028, this);
        super.aSPanel__4033.setLocation(630, 80);
        this.add(super.aSPanel__4033);
    }

    protected void method2571(long var1) {
        this.aSPanel_Sub14_Sub2_4858.method2488(false);
        if (this.aSPanel__4859 != null) {
            this.aSPanel__4859.method2500();
        }

        this.aBoolean4860 = false;
        super.aSynchronizedBool_4035.method1459(false);
        this.aSPanel_Sub34_Sub1_4857.method2740();
        super.aSPanel_Sub32_4032.method2656(1, super.aSynchronizedInt_4029.method1467(), new Class66(var1));
    }

    private void method2572(int var1) {
        if (super.aSynchronizedInt_4029.method1467() == 0 || super.aSynchronizedInt_4029.method1467() == 5) {
            Class74 var2 = new Class74(super.aSPanel_Sub32_4032, this.aSPanel_Sub34_Sub1_4857);
            if (var1 == 1) {
                this.aClass74_4861 = var2;
                this.aClass74_4862 = this.aClass74_4863 = null;
            } else if (var1 == 2) {
                this.aClass74_4862 = var2;
                this.aClass74_4863 = null;
            } else if (var1 == 3) {
                this.aClass74_4863 = var2;
            }

            this.anInt4864 = var1;
        }
    }

    static {
        aStringArray4865[0] = "newgame";
        aStringArray4865[1] = "player";
        aStringArray4865[2] = "turn";
        aStringArray4865[3] = "start";
    }
}
