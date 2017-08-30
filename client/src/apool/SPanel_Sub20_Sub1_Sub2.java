package apool;

public class SPanel_Sub20_Sub1_Sub2 extends SPanel_Sub20_Sub1 {

    private SPanel_Sub34_Sub3 aSPanel_Sub34_Sub3_4992;
    private int anInt4993;
    private int anInt4994;
    private boolean aBoolean4995;
    private boolean aBoolean4996;
    private boolean aBoolean4997;
    private boolean[] aBooleanArray4998 = new boolean[22];
    private static final String[] aStringArray4999 = new String[12];


    public SPanel_Sub20_Sub1_Sub2(Class60 var1, int var2, boolean var3) {
        super(var1, 4);
        this.method2564(var2, var3);
    }

    protected void method2548() {
        this.anInt4993 = 1;
        this.aBoolean4995 = false;
        this.aBoolean4996 = false;
    }

    protected int method2549(int var1) {
        int var2 = super.method2549(var1);
        this.anInt4993 = this.aBoolean4996 ? 2 : (var2 <= 15 ? 1 : var2);
        this.aSPanel_Sub34_Sub3_4992.method2762(this.anInt4993, this.aBoolean4995);
        if (var1 == super.anInt4839 && this.aBoolean4997) {
            this.aSPanel_Sub34_Sub3_4992.method2772();
        }

        for (int var3 = 0; var3 < 22; ++var3) {
            this.aBooleanArray4998[var3] = false;
        }

        return var2;
    }

    protected void method2562(int var1) {
        super.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_" + (super.aBoolean4846 ? (var1 == super.anInt4839 ? "You" : "Opponent") : "Player") + "Pass"));
        this.aBoolean4997 = false;
    }

    protected boolean method2528() {
        return false;
    }

    protected void method2529() {
        this.aSPanel_Sub34_Sub3_4992.method2773();
    }

    protected void method2530() {
        this.aSPanel_Sub34_Sub3_4992.method2773();
        super.method2530();
    }

    protected void method2533(int var1, boolean var2) {
        if (this.anInt4993 == 1 && var1 >= 16) {
            this.aSPanel_Sub34_Sub3_4992.method2764(1, var1 - 14);
        }

        if (this.anInt4993 == 2 && var1 <= 15) {
            this.aSPanel_Sub34_Sub3_4992.method2764(1, 7);
        }

        if (this.anInt4993 > 2 && var1 != this.anInt4993) {
            this.aSPanel_Sub34_Sub3_4992.method2764(1, var1 - 14);
        }

        this.anInt4994 = var1;
    }

    protected void method2534() {
        this.aSPanel_Sub34_Sub3_4992.method2764(0, this.anInt4993 <= 2 ? 4 : this.anInt4993 - 14);
    }

    protected void method2535(int var1, boolean var2) {
        super.method2535(var1, var2);
        if (var1 == 0) {
            this.aSPanel_Sub34_Sub3_4992.method2764(3, this.anInt4993 <= 2 ? 4 : this.anInt4993 - 14);
        } else {
            int var3 = var1 <= 15 ? 1 : var1 - 14;
            if (this.anInt4993 == 1) {
                if (var1 >= 16) {
                    this.aSPanel_Sub34_Sub3_4992.method2764(2, var3);
                }
            } else {
                if (var1 <= 15 || var1 != this.anInt4994) {
                    this.aSPanel_Sub34_Sub3_4992.method2764(2, var3);
                }

                if (var1 >= 16 && var1 != this.anInt4993) {
                    this.aBooleanArray4998[var1] = true;
                }
            }

            this.aSPanel_Sub34_Sub3_4992.method2763(var3);
            if (this.anInt4993 <= 2 && var1 >= 16) {
                this.aBooleanArray4998[var1] = true;
            }

        }
    }

    protected void method2536(int var1) {
        this.aBoolean4997 = this.aSPanel_Sub34_Sub3_4992.method2766();
        int var2;
        if (!this.aBoolean4997) {
            var2 = this.aSPanel_Sub34_Sub3_4992.method2765();
            this.aBoolean4995 = var2 > 0;
            if (this.aBoolean4995) {
                super.aSPanel_Sub30_4834.method2641(super.anInt4840, var2);
                super.aBoolean4852 = false;
            }
        } else {
            int[] var4 = this.aSPanel_Sub34_Sub3_4992.method2767();
            String[] var3 = new String[]{"NoHitAtAll", "HitWrongBall", "PotWrongBall", "PotWhiteBall"};
            super.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("GameSnooker_Fault") + " " + super.aClass60_4028.textManager.method2039("GameSnooker_Fault" + var3[var4[0]]) + " " + super.aClass60_4028.textManager.method2045("GameSnooker_Penalty", var4[1]));
            super.aSPanel_Sub30_4834.method2641(1 - super.anInt4840, var4[1]);
            this.aBoolean4995 = false;
        }

        this.aBoolean4996 = this.anInt4993 == 1 && !super.aBoolean4852;
        this.aSPanel_Sub34_Sub3_4992.method2768();
        var2 = super.aSPanel_Sub30_4834.method2642(0);
        int var5 = super.aSPanel_Sub30_4834.method2642(1);
        if (var1 == 0 && var2 == var5) {
            this.aBooleanArray4998[21] = true;
            this.aBoolean4995 = false;
            super.aBoolean4852 = true;
        }

        ((SPanel_Sub32_Sub2) ((SPanel_Sub32_Sub2) super.aSPanel_Sub32_4032)).method2728(this.aBooleanArray4998);
        if (var1 == 0 && var2 != var5) {
            super.anInt4851 = var2 > var5 ? 0 : 1;
            if (super.anInt4851 >= 0) {
                this.method2556(super.anInt4851);
            }
        }

    }

    protected String method2541() {
        return super.method2541() + this.aSPanel_Sub34_Sub3_4992.method2771();
    }

    protected String method2550() {
        return this.aBoolean4997 ? "t" : "f";
    }

    protected void method2563() {
        if (super.anInt4840 == super.anInt4839) {
            super.aSPanel_Sub32_4032.method2666();
            super.aSPanel_Sub14_Sub1_4837.method2481();
            super.aSPanel_Sub30_4834.method2647();
            this.method2523("pass");
        }
    }

    protected void method2556(int var1) {
        super.method2556(var1);
        if (super.anInt4839 >= 0) {
            this.aSPanel_Sub34_Sub3_4992.method2773();
        }

    }

    protected String method2540() {
        String var1 = (this.aBoolean4996 ? "t" : "f") + (this.aBoolean4995 ? "t" : "f");
        var1 = var1 + this.aSPanel_Sub34_Sub3_4992.method2769();
        var1 = var1 + super.aSPanel_Sub30_4834.method2644(super.aSynchronizedInt_4029.method1467());
        return var1;
    }

    protected void method2557(String var1) {
        this.aBoolean4996 = var1.charAt(0) == 116;
        this.aBoolean4995 = var1.charAt(1) == 116;
        this.aSPanel_Sub34_Sub3_4992.method2770(var1.substring(2, 4));
        super.aSPanel_Sub30_4834.method2645(super.aSynchronizedInt_4029.method1467(), var1.substring(4));
    }

    private void method2564(int var1, boolean var2) {
        super.method2547(var2);
        short var3 = 170;
        super.aSPanel_Sub30_4834 = new SPanel_Sub30(super.aClass60_4028, this, var1, -1, true, super.anInt4030 - 5 - var3 - 10 - 5, 70);
        super.aSPanel_Sub30_4834.setLocation(5, 0);
        this.add(super.aSPanel_Sub30_4834);
        this.aSPanel_Sub34_Sub3_4992 = new SPanel_Sub34_Sub3(super.aClass60_4028, this, var3, 70);
        this.aSPanel_Sub34_Sub3_4992.setLocation(super.anInt4030 - 5 - var3, 0);
        this.add(this.aSPanel_Sub34_Sub3_4992);
        super.aSPanel_Sub32_4032 = new SPanel_Sub32_Sub2(super.aClass60_4028, this);
        super.aSPanel_Sub32_4032.setLocation(15, 80);
        this.add(super.aSPanel_Sub32_4032);
        Class71 var4 = new Class71(super.aClass60_4028, this, super.aSPanel_Sub32_4032, true, true);
        super.aSPanel_Sub32_4032.method2649(var4);
        SPanel_Sub31 var5 = new SPanel_Sub31(super.aClass60_4028);
        var5.setLocation(630, 190);
        this.add(var5);
        super.aSPanel_Sub26_4836 = new SPanel_Sub26(super.aClass60_4028, this, var2, 125, 195);
        super.aSPanel_Sub26_4836.setLocation(630, 215);
        this.add(super.aSPanel_Sub26_4836);
    }

    static {
        aStringArray4999[0] = "PotWhiteBall";
        aStringArray4999[1] = "PotWrongBall";
        aStringArray4999[2] = "GameSnooker_Fault";
        aStringArray4999[3] = "GameSnooker_Penalty";
        aStringArray4999[4] = "HitWrongBall";
        aStringArray4999[5] = "NoHitAtAll";
        aStringArray4999[6] = "pass";
        aStringArray4999[7] = "You";
        aStringArray4999[8] = "Opponent";
        aStringArray4999[9] = "Pass";
        aStringArray4999[10] = "Game_";
        aStringArray4999[11] = "Player";
    }
}
