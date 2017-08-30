package apool;

public class SPanel_Sub20_Sub1_Sub1 extends SPanel_Sub20_Sub1 {

    private int[] anIntArray4985;
    private int anInt4986;
    private int anInt4987;
    private SynchronizedInt aSynchronizedInt_4988;
    private SynchronizedInt aSynchronizedInt_4989;
    private SynchronizedInt aSynchronizedInt_4990;
    private SynchronizedInt aSynchronizedInt_4991;


    public SPanel_Sub20_Sub1_Sub1(Class60 var1, int var2, int var3, int var4, boolean var5) {
        super(var1, var2);
        this.anInt4987 = var4;
        this.anIntArray4985 = new int[2];
        this.aSynchronizedInt_4988 = new SynchronizedInt();
        this.aSynchronizedInt_4989 = new SynchronizedInt();
        this.aSynchronizedInt_4990 = new SynchronizedInt();
        this.aSynchronizedInt_4991 = new SynchronizedInt();
        this.method2560(var3, var5);
    }

    protected void method2548() {
        super.aSynchronizedBool_4035.method1459(false);
        this.anIntArray4985[0] = this.anIntArray4985[1] = -1;
        this.anInt4986 = 0;
        this.aSynchronizedInt_4991.method1463(0);
    }

    protected int method2549(int var1) {
        int var2 = super.method2549(var1);
        if (super.aSynchronizedInt_4029.method1467() == 0 && this.anInt4986 < 2) {
            this.aSynchronizedInt_4988.method1463(0);
            this.aSynchronizedInt_4989.method1463(0);
        } else {
            this.aSynchronizedInt_4988.method1463(-1);
            this.aSynchronizedInt_4989.method1463(-1);
        }

        this.aSynchronizedInt_4990.method1463(0);
        return var2;
    }

    protected boolean method2528() {
        return super.aSynchronizedInt_4029.method1467() != 0 ? false : (this.anIntArray4985[super.anInt4840] == -1 ? false : this.method2561(this.anIntArray4985[super.anInt4840] * 8 + 1, this.anIntArray4985[super.anInt4840] * 8 + 7, false));
    }

    protected void method2533(int var1, boolean var2) {
        super.aSynchronizedBool_4036.method1459(true);
        super.aSynchronizedBool_4035.method1459(true);
        if (super.aSynchronizedInt_4029.method1467() == 1 || super.aSynchronizedInt_4029.method1467() == 3) {
            if (!var2) {
                super.aSynchronizedInt_4034.method1463(2);
            } else {
                super.aSynchronizedBool_4037.method1459(true);
            }

            if (super.aSynchronizedInt_4029.method1467() == 1) {
                if (this.aSynchronizedInt_4990.method1467() == 0 && var2 && var1 < 9) {
                    this.aSynchronizedInt_4990.method1463(1);
                } else {
                    this.aSynchronizedInt_4990.method1463(-1);
                }
            }
        }

    }

    protected void method2534() {
        if (!super.aSynchronizedBool_4035.method1460()) {
            super.aSynchronizedInt_4034.method1463(1);
        } else {
            if (super.aSynchronizedInt_4029.method1467() == 1 || super.aSynchronizedInt_4029.method1467() == 3) {
                super.aSynchronizedInt_4034.method1463(2);
            }

        }
    }

    protected void method2535(int var1, boolean var2) {
        super.method2535(var1, var2);
        if (super.aSynchronizedInt_4034.method1467() != 3) {
            if (super.aSynchronizedInt_4029.method1467() != 0) {
                if (super.aSynchronizedInt_4029.method1467() == 1) {
                    if (var1 > 0) {
                        if (var1 < 9) {
                            if (super.aSynchronizedInt_4034.method1467() == 0) {
                                super.aBoolean4852 = false;
                            }
                        } else {
                            if (super.aSynchronizedInt_4034.method1467() == 0) {
                                super.anInt4851 = super.anInt4840;
                                if (this.aSynchronizedInt_4991.method1467() == 0) {
                                    this.aSynchronizedInt_4991.method1463(1);
                                }
                            } else {
                                super.anInt4851 = 1 - super.anInt4840;
                                super.aBoolean4853 = true;
                                this.aSynchronizedInt_4991.method1463(-1);
                            }

                            if (this.aSynchronizedInt_4990.method1467() == 1) {
                                this.aSynchronizedInt_4990.method1463(2);
                            }
                        }

                        super.aSPanel_Sub30_4834.method2640(super.anInt4840, var1);
                    } else {
                        if (super.anInt4851 >= 0 && !super.aBoolean4853) {
                            super.anInt4851 = 1 - super.anInt4851;
                        }

                        super.aSynchronizedInt_4034.method1463(2);
                    }

                } else if (super.aSynchronizedInt_4029.method1467() == 2) {
                    if (var1 > 0) {
                        super.aSPanel_Sub30_4834.method2640(super.anInt4840, var1);
                        super.aSPanel_Sub30_4834.method2641(super.anInt4840, 1);
                        super.aBoolean4852 = false;
                    } else {
                        super.aSPanel_Sub30_4834.method2641(super.anInt4840, -1);
                        super.aSynchronizedInt_4034.method1463(2);
                    }

                } else {
                    if (super.aSynchronizedInt_4029.method1467() == 3) {
                        if (var1 > 0) {
                            int var3 = super.aSynchronizedBool_4037.method1460() ? super.anInt4840 : 1 - super.anInt4840;
                            super.aSPanel_Sub30_4834.method2640(var3, var1);
                            super.aSPanel_Sub30_4834.method2641(var3, var1);
                            if (super.aSynchronizedBool_4037.method1460()) {
                                super.aBoolean4852 = false;
                            }
                        } else {
                            super.aSynchronizedInt_4034.method1463(2);
                        }
                    }

                }
            } else {
                if (var1 > 0) {
                    if (var1 == 8 && this.anInt4986 < 2) {
                        super.aSynchronizedInt_4034.method1463(3);
                        this.anInt4986 = 1;
                        this.aSynchronizedInt_4988.method1463(-1);
                        if (this.aSynchronizedInt_4989.method1467() == 0) {
                            this.aSynchronizedInt_4989.method1463(1);
                        }

                        return;
                    }

                    if (this.anIntArray4985[0] == -1) {
                        if (var1 != 8) {
                            this.anIntArray4985[super.anInt4840] = var1 / 8;
                            this.anIntArray4985[1 - super.anInt4840] = 1 - this.anIntArray4985[super.anInt4840];
                            super.aSPanel_Sub30_4834.method2639(this.anIntArray4985);
                            super.aBoolean4852 = false;
                            if (this.aSynchronizedInt_4988.method1467() >= 0) {
                                this.aSynchronizedInt_4988.method1464();
                            }
                        } else {
                            super.anInt4851 = 1 - super.anInt4840;
                            super.aBoolean4853 = true;
                            this.aSynchronizedInt_4988.method1463(-1);
                        }
                    } else if (var1 != 8) {
                        if (this.anIntArray4985[super.anInt4840] == var1 / 8) {
                            super.aBoolean4852 = false;
                            if (this.aSynchronizedInt_4988.method1467() >= 0) {
                                this.aSynchronizedInt_4988.method1464();
                            }
                        } else {
                            super.aBoolean4852 = true;
                            this.aSynchronizedInt_4988.method1463(-1);
                        }
                    } else {
                        if (this.method2561(this.anIntArray4985[super.anInt4840] * 8 + 1, this.anIntArray4985[super.anInt4840] * 8 + 7, true) && var2 && super.aSynchronizedInt_4034.method1467() == 0) {
                            super.anInt4851 = super.anInt4840;
                        } else {
                            super.anInt4851 = 1 - super.anInt4840;
                            super.aBoolean4853 = true;
                        }

                        this.aSynchronizedInt_4988.method1463(-1);
                    }

                    super.aSPanel_Sub30_4834.method2640(var1 != 8 ? this.anIntArray4985[var1 / 8] : super.anInt4840, var1);
                } else {
                    if (super.anInt4851 >= 0 && !super.aBoolean4853) {
                        super.anInt4851 = 1 - super.anInt4851;
                    }

                    super.aSynchronizedInt_4034.method1463(2);
                    this.aSynchronizedInt_4988.method1463(-1);
                }

            }
        }
    }

    protected void method2536(int var1) {
        if (super.aSynchronizedInt_4029.method1467() == 0) {
            if (this.anInt4986 == 0 && super.aSynchronizedBool_4035.method1460()) {
                this.anInt4986 = 2;
            } else if (this.anInt4986 == 1) {
                super.aSPanel_Sub30_4834.method2637();
                this.anIntArray4985[0] = this.anIntArray4985[1] = -1;
                this.anInt4986 = 0;
                super.aSynchronizedBool_4035.method1459(false);
            }
        }

        if (super.aSynchronizedInt_4029.method1467() == 1 && this.aSynchronizedInt_4991.method1467() == 0) {
            this.aSynchronizedInt_4991.method1463(-1);
        }

        int var2;
        int var3;
        if (super.aSynchronizedInt_4029.method1467() == 2) {
            var2 = super.aSPanel_Sub30_4834.method2642(0);
            var3 = super.aSPanel_Sub30_4834.method2642(1);
            if (var2 >= this.anInt4987) {
                super.anInt4851 = 0;
            }

            if (var3 >= this.anInt4987) {
                super.anInt4851 = 1;
            }

            if (var2 == var3 && var2 >= this.anInt4987) {
                super.anInt4851 = 2;
            }

            if (super.anInt4851 == -1 && var1 <= 1 && super.aSPanel_Sub32_4032.method2680(1, super.aSPanel_Sub30_4834.method2648())) {
                super.aSynchronizedInt_4034.method1463(2);
            }
        }

        if (super.aSynchronizedInt_4029.method1467() == 3) {
            var2 = super.aSPanel_Sub30_4834.method2642(0);
            var3 = super.aSPanel_Sub30_4834.method2642(1);
            if (var2 > 60 || var3 > 60) {
                super.anInt4851 = var2 > var3 ? 0 : 1;
            }

            if (var2 == 60 && var3 == 60) {
                super.anInt4851 = 2;
            }
        }

        if (super.anInt4851 >= 0) {
            this.method2556(super.anInt4851);
        }

    }

    protected String method2541() {
        String var1 = super.method2541();
        if (super.aSynchronizedInt_4029.method1467() == 0) {
            var1 = var1 + this.aSynchronizedInt_4988.method1467() + "," + this.aSynchronizedInt_4989.method1467();
        } else if (super.aSynchronizedInt_4029.method1467() == 1) {
            var1 = var1 + this.aSynchronizedInt_4990.method1467() + "," + this.aSynchronizedInt_4991.method1467();
        } else if (super.aSynchronizedInt_4029.method1467() == 2 || super.aSynchronizedInt_4029.method1467() == 3) {
            var1 = var1 + super.aSPanel_Sub30_4834.method2642(0) + "," + super.aSPanel_Sub30_4834.method2642(1);
        }

        return var1;
    }

    protected String method2550() {
        return "-";
    }

    protected String method2540() {
        String var1 = super.aSynchronizedBool_4035.method1460() ? "t" : "f";
        int var2 = super.aSynchronizedInt_4029.method1467();
        if (var2 == 0) {
            var1 = var1 + (this.anIntArray4985[0] + 1) + "" + (this.anIntArray4985[1] + 1);
        }

        var1 = var1 + super.aSPanel_Sub30_4834.method2644(var2);
        return var1;
    }

    protected void method2557(String var1) {
        super.aSynchronizedBool_4035.method1459(var1.charAt(0) == 116);
        var1 = var1.substring(1);
        int var2 = super.aSynchronizedInt_4029.method1467();
        if (var2 == 0) {
            this.anIntArray4985[0] = Integer.parseInt(var1.substring(0, 1)) - 1;
            this.anIntArray4985[1] = Integer.parseInt(var1.substring(1, 2)) - 1;
            super.aSPanel_Sub30_4834.method2639(this.anIntArray4985);
            var1 = var1.substring(2);
        }

        super.aSPanel_Sub30_4834.method2645(var2, var1);
    }

    private void method2560(int var1, boolean var2) {
        super.method2547(var2);
        super.aSPanel_Sub30_4834 = new SPanel_Sub30(super.aClass60_4028, this, var1, this.anInt4987, false, 750, 70);
        super.aSPanel_Sub30_4834.setLocation(5, 0);
        this.add(super.aSPanel_Sub30_4834);
        super.aSPanel_Sub32_4032 = new SPanel_Sub32_Sub1(super.aClass60_4028, this, (GameReplay) null, false);
        super.aSPanel_Sub32_4032.setLocation(5, 80);
        this.add(super.aSPanel_Sub32_4032);
        Class71 var3 = new Class71(super.aClass60_4028, this, super.aSPanel_Sub32_4032, true, false);
        super.aSPanel_Sub32_4032.method2649(var3);
        super.aSPanel_Sub26_4836 = new SPanel_Sub26(super.aClass60_4028, this, var2, 125, 220);
        super.aSPanel_Sub26_4836.setLocation(630, 190);
        this.add(super.aSPanel_Sub26_4836);
    }

    private boolean method2561(int var1, int var2, boolean var3) {
        for (int var4 = var1; var4 <= var2; ++var4) {
            if (super.aSPanel_Sub32_4032.aClass65Array4153[var4].method1482()) {
                if (!var3) {
                    return false;
                }

                if (!super.aSPanel_Sub32_4032.aClass65Array4153[var4].method1515()) {
                    return false;
                }
            }
        }

        return true;
    }
}
