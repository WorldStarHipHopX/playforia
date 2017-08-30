package apool;

public class SPanel_Sub20_Sub2_Sub1 extends SPanel_Sub20_Sub2 {

    private SPanel_Sub29 aSPanel_Sub29_5000;
    private GameReplay aGameReplay_5001;
    private boolean[] aBooleanArray5002;
    private int anInt5003;
    private static final String[] aStringArray5004 = new String[2];


    public SPanel_Sub20_Sub2_Sub1(Class60 var1, int var2, GameReplay var3) {
        super(var1, var3 != null ? var3.method1522() : var2);
        this.aGameReplay_5001 = var3;
        this.aBooleanArray5002 = new boolean[16];
    }

    public void method2522(String[] var1) {
        if (var1[1].equals("toplist")) {
            this.aSPanel_Sub29_5000.method2629(var1);
        } else if (var1[1].equals("start")) {
            this.method2571(this.aGameReplay_5001 != null ? this.aGameReplay_5001.method1523() : Long.parseLong(var1[2]));
        } else {
            super.method2522(var1);
        }
    }

    protected void method2530() {
        super.method2530();

        for (int var1 = 0; var1 < 16; ++var1) {
            this.aBooleanArray5002[var1] = false;
        }

        this.anInt5003 = 0;
    }

    protected void method2533(int var1, boolean var2) {
        super.aSynchronizedBool_4036.method1459(true);
        if (!super.aSynchronizedBool_4035.method1460() && !var2 && super.aSynchronizedInt_4029.method1467() > 0) {
            super.aSynchronizedInt_4034.method1463(3);
        } else {
            super.aSynchronizedBool_4035.method1459(true);
            if (super.aSynchronizedInt_4029.method1467() == 2 && var2) {
                super.aSynchronizedBool_4037.method1459(true);
            }

        }
    }

    protected void method2534() {
        if (!super.aSynchronizedBool_4035.method1460() && super.aSynchronizedInt_4029.method1467() != 0) {
            super.aSynchronizedInt_4034.method1463(1);
        }

    }

    protected void method2535(int var1, boolean var2) {
        if (super.aSynchronizedInt_4034.method1467() != 3) {
            if (super.aSynchronizedInt_4029.method1467() != 0 && super.aSynchronizedInt_4029.method1467() != 1 && super.aSynchronizedInt_4029.method1467() != 3) {
                if (super.aSynchronizedInt_4029.method1467() == 2) {
                    if (var1 > 0) {
                        super.aSPanel_Sub34_Sub1_4857.method2742(var1, true);
                        if (!super.aSynchronizedBool_4037.method1460()) {
                            this.aBooleanArray5002[var1] = true;
                        }
                    } else {
                        super.aSynchronizedInt_4034.method1463(2);
                    }

                } else {
                    if (super.aSynchronizedInt_4029.method1467() == 4) {
                        if (var1 > 0) {
                            super.aSPanel_Sub34_Sub1_4857.method2742(var1, true);
                            if (this.anInt5003 == 0) {
                                this.anInt5003 = 1;
                            }
                        } else {
                            this.anInt5003 = -1;
                        }
                    }

                }
            } else {
                if (var1 > 0) {
                    super.aSPanel_Sub34_Sub1_4857.method2742(var1, true);
                } else {
                    super.aSynchronizedInt_4034.method1463(2);
                }

            }
        }
    }

    protected void method2536(int var1) {
        if (super.aSynchronizedInt_4029.method1467() > 0) {
            int var2;
            if (super.aSynchronizedInt_4034.method1467() >= 2) {
                for (var2 = 1; var2 < 16; ++var2) {
                    if (!super.aSPanel_Sub32_4032.aClass65Array4153[var2].method1482() && !this.aBooleanArray5002[var2]) {
                        this.aBooleanArray5002[var2] = true;
                        var2 = 16;
                    }
                }
            }

            for (var2 = 1; var2 < 16; ++var2) {
                if (this.aBooleanArray5002[var2]) {
                    super.aSPanel_Sub34_Sub1_4857.method2742(var2, false);
                    super.aSPanel_Sub32_4032.method2679(var2);
                    ++var1;
                }
            }

            if (super.aSynchronizedInt_4029.method1467() == 3 && var1 <= 1 && super.aSPanel_Sub34_Sub1_4857.method2744() + var1 < 99) {
                super.aSPanel_Sub34_Sub1_4857.method2745();
                if (super.aSPanel_Sub32_4032.method2680(2, (boolean[][]) null)) {
                    super.aSynchronizedInt_4034.method1463(2);
                }
            }

            if (super.aSynchronizedInt_4029.method1467() == 4 && var1 <= 3) {
                super.aSPanel_Sub34_Sub1_4857.method2745();
                if (super.aSPanel_Sub32_4032.method2680(3, (boolean[][]) null)) {
                    super.aSynchronizedInt_4034.method1463(2);
                }
            }
        }

        if (super.aSynchronizedInt_4029.method1467() == 0 && var1 == 0 && super.aSPanel__4859 != null) {
            super.aSPanel__4859.method2503();
        }

        if ((super.aSynchronizedInt_4029.method1467() == 1 || super.aSynchronizedInt_4029.method1467() == 2) && var1 == 0) {
            super.aBoolean4860 = true;
        }

        if (super.aSynchronizedInt_4029.method1467() == 3 && super.aSPanel_Sub34_Sub1_4857.method2744() >= 99) {
            super.aBoolean4860 = true;
        }

        if (super.aSynchronizedInt_4029.method1467() == 4 && super.aSPanel_Sub34_Sub1_4857.method2743() > 1 && this.anInt5003 < 1) {
            super.aBoolean4860 = true;
        }

    }

    protected void method2537() {
        if (super.aBoolean4860 && super.aSynchronizedInt_4029.method1467() != 4) {
            super.aSPanel_Sub32_4032.method2673();
        }

        super.method2537();
    }

    protected String method2541() {
        return "-";
    }

    protected void method2570() {
        super.method2570();
        super.aSPanel_Sub32_4032 = new SPanel_Sub32_Sub1(super.aClass60_4028, this, this.aGameReplay_5001, true);
        super.aSPanel_Sub32_4032.setLocation(5, 80);
        this.add(super.aSPanel_Sub32_4032);
        Class71 var1 = new Class71(super.aClass60_4028, this, super.aSPanel_Sub32_4032, false, false);
        super.aSPanel_Sub32_4032.method2649(var1);
        if (super.aSynchronizedInt_4029.method1467() > 0) {
            this.aSPanel_Sub29_5000 = new SPanel_Sub29(super.aClass60_4028, 620, 128);
            this.aSPanel_Sub29_5000.setLocation(5, 417);
            this.add(this.aSPanel_Sub29_5000);
        }

        super.aSPanel_Sub14_Sub2_4858 = new GameControlPanel_Sub14_Sub2(super.aClass60_4028, this, 125, 128);
        super.aSPanel_Sub14_Sub2_4858.setLocation(630, 417);
        this.add(super.aSPanel_Sub14_Sub2_4858);
        if (super.aSynchronizedInt_4029.method1467() == 0) {
            super.aSPanel__4859 = new GameEditPanel(super.aClass60_4028, this, 620, 128);
            super.aSPanel__4859.setLocation(5, 417);
            this.add(super.aSPanel__4859);
        }

    }

    static {
        aStringArray5004[0] = "start";
        aStringArray5004[1] = "toplist";
    }
}
