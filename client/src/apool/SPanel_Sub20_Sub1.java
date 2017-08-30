package apool;

import com.playray.tools.Tools;

import java.util.Vector;

public abstract class SPanel_Sub20_Sub1 extends SPanel_Sub20 {

    protected SPanel_Sub30 aSPanel_Sub30_4834;
    protected GameChatPanel aSPanel__4835;
    protected SPanel_Sub26 aSPanel_Sub26_4836;
    protected GameControlPanel_Sub14_Sub1 aSPanel_Sub14_Sub1_4837;
    private String aString4838;
    protected int anInt4839 = -1;
    protected int anInt4840;
    private String[] aStringArray4841 = new String[2];
    private int[] anIntArray4842 = new int[2];
    private int anInt4843;
    private Object anObject4844;
    private boolean aBoolean4845;
    protected boolean aBoolean4846;
    private boolean aBoolean4847;
    private boolean aBoolean4848;
    private boolean aBoolean4849;
    private Vector aVector4850;
    protected int anInt4851;
    protected boolean aBoolean4852;
    protected boolean aBoolean4853;
    private SynchronizedInt aSynchronizedInt_4854;
    private SynchronizedInt aSynchronizedInt_4855;
    private static final String[] aStringArray4856 = new String[64];


    protected SPanel_Sub20_Sub1(Class60 var1, int var2) {
        super(var1, var2, var2 == 4);
        this.anIntArray4842[0] = this.anIntArray4842[1] = this.anInt4843 = 0;
        this.aBoolean4847 = false;
        this.aVector4850 = new Vector();
        this.anObject4844 = new Object();
        this.aSynchronizedInt_4854 = new SynchronizedInt();
        this.aSynchronizedInt_4855 = new SynchronizedInt();
    }

    public void updateUI(Object var1) {
        String[] var2 = (String[]) ((String[]) var1);
        if (var2[1].equals("players")) {
            this.aStringArray4841[0] = var2[2];
            this.aStringArray4841[1] = var2[3];
            this.anInt4839 = Integer.parseInt(var2[6]);
            boolean var4 = var2[7].equals("t");
            this.aBoolean4846 = this.anInt4839 >= 0;
            this.aString4838 = this.aBoolean4846 ? this.aStringArray4841[this.anInt4839] : var2[7];
            this.aSPanel_Sub30_4834.method2635(this.aStringArray4841[0], this.aStringArray4841[1], var2[4], var2[5], this.anInt4839);
            this.aSPanel__4835.method2604(this.aBoolean4846, this.aBoolean4846 && var4);
            this.aSPanel_Sub26_4836.method2614(this.aBoolean4846, var4);
            if (this.aBoolean4846) {
                this.add(super.aSPanel__4033);
            } else {
                if (var2[8].equals("f")) {
                    this.aSPanel_Sub30_4834.method2646(0);
                }

                if (var2[9].equals("f")) {
                    this.aSPanel_Sub30_4834.method2646(1);
                }
            }

            this.aSPanel_Sub14_Sub1_4837.method2478(this.aBoolean4846);
            super.aClass60_4028.gameApplet.method2319(this.aStringArray4841, GameApplet.aStringArray4805[super.aSynchronizedInt_4029.method1467()].toLowerCase());
        } else if (var2[1].equals("aspec")) {
            this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("Game_SpectatorsAllowed"));
            this.aSPanel_Sub26_4836.method2615();
            this.aSPanel__4835.method2606();
        } else {
            if (var2[1].equals("quit")) {
                int var3 = Integer.parseInt(var2[2]);
                if (this.anInt4839 >= 0) {
                    this.aSPanel__4835.method2608(1, super.aClass60_4028.textManager.method2039("Game_OpponentLeft"));
                    this.aSPanel_Sub14_Sub1_4837.method2485(true);
                    this.aSPanel_Sub14_Sub1_4837.method2481();
                    this.aSPanel_Sub26_4836.method2616();
                } else {
                    this.aSPanel__4835.method2608(1, super.aClass60_4028.textManager.method2040("Game_PlayerLeft", this.aStringArray4841[var3]));
                }

                this.aSPanel_Sub30_4834.method2647();
                this.aSPanel_Sub30_4834.method2646(var3);
                super.aSPanel_Sub32_4032.method2665(this.anInt4839 >= 0 ? super.aClass60_4028.textManager.method2039("Game_OpponentLeft") : super.aClass60_4028.textManager.method2040("Game_PlayerLeft", this.aStringArray4841[var3]));
            }

        }
    }

    protected void method2547(boolean var1) {
        this.aSPanel__4835 = new GameChatPanel(super.aClass60_4028, this, var1, 620, 128);
        this.aSPanel__4835.setLocation(5, 417);
        this.add(this.aSPanel__4835);
        super.aSPanel__4033 = new GameSpinBallPanel(super.aClass60_4028, this);
        super.aSPanel__4033.setLocation(630, 80);
        this.aSPanel_Sub14_Sub1_4837 = new GameControlPanel_Sub14_Sub1(super.aClass60_4028, this, 125, 128);
        this.aSPanel_Sub14_Sub1_4837.setLocation(630, 417);
        this.add(this.aSPanel_Sub14_Sub1_4837);
    }

    protected abstract void method2548();

    public void method2522(String[] var1) {
        boolean var2;
        if (var1[1].equals("say")) {
            var2 = false;
            if (var1[2].equals("s")) {
                if (this.aSPanel_Sub26_4836.method2619(var1[3])) {
                    return;
                }

                if (!this.aVector4850.contains(var1[3])) {
                    this.aVector4850.addElement(var1[3]);
                }

                var2 = true;
            }

            this.aSPanel__4835.method2609(var2 ? 4 : 0, var1[3], var1[4], false);
        } else if (var1[1].equals("sayoo")) {
            this.aSPanel__4835.method2610(5, var1[2], this.aStringArray4841[this.anInt4839], var1[3], false);
        } else if (var1[1].equals("oaspec")) {
            this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("Game_OpponentAllowSpectators"));
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_OAS_Help"));
            this.aBoolean4847 = true;
        } else if (var1[1].equals("start")) {
            if (!this.aBoolean4846) {
                this.method2559();
            }

            this.method2558(Long.parseLong(var1[2]));
        } else if (var1[1].equals("turn")) {
            if (!this.aBoolean4846) {
                this.method2559();
            }

            this.method2549(Integer.parseInt(var1[2]));
        } else if (var1[1].equals("setwhiteball")) {
            if (!this.aBoolean4846) {
                this.method2559();
            }

            super.aSPanel_Sub32_4032.method2661(var1[2]);
        } else if (var1[1].equals("setpainted")) {
            if (!this.aBoolean4846) {
                this.method2559();
            }

            super.aSPanel_Sub32_4032.method2662(Integer.parseInt(var1[2]));
        } else if (var1[1].equals("currentmouse")) {
            super.aSPanel_Sub32_4032.method2663(Integer.parseInt(var1[2]), Integer.parseInt(var1[3]));
        } else if (var1[1].equals("beginstroke")) {
            super.aSPanel_Sub32_4032.method2664(var1[2]);
            this.aSPanel_Sub30_4834.method2647();
        } else if (var1[1].equals("pass")) {
            ((SPanel_Sub20_Sub1_Sub2) ((SPanel_Sub20_Sub1_Sub2) this)).method2562(Integer.parseInt(var1[2]));
        } else {
            var2 = var1[1].equals("timeout");
            int var3;
            if (!var2 && !var1[1].equals("concede")) {
                if (var1[1].equals("readyfornewgame")) {
                    if (this.anInt4839 >= 0) {
                        if (var1[2].equals("t")) {
                            this.aSPanel_Sub14_Sub1_4837.method2484();
                        } else {
                            this.aSPanel_Sub14_Sub1_4837.method2483();
                        }
                    }

                } else if (var1[1].equals("newgame")) {
                    this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("Game_OpponentWantNewGame"));
                    this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_OWNG_Help"));
                    this.aBoolean4848 = true;
                } else if (var1[1].equals("resulterror")) {
                    super.aSPanel_Sub32_4032.method2669();
                } else {
                    int var4;
                    if (var1[1].equals("slist")) {
                        var3 = var1.length - 2;

                        for (var4 = 0; var4 < var3; ++var4) {
                            this.aSPanel_Sub26_4836.method2617(var1[2 + var4].trim(), var4 == 0, var1[2 + var4].indexOf(126) != 0, var1[2 + var4].indexOf(32) == 0);
                        }

                    } else if (var1[1].equals("sjoin")) {
                        this.aSPanel_Sub26_4836.method2617(var1[2].trim(), false, var1[2].indexOf(126) != 0, var1[2].indexOf(32) == 0);
                    } else if (var1[1].equals("spart")) {
                        this.aSPanel_Sub26_4836.method2618(var1[2]);
                    } else {
                        if (this.anInt4839 == -1) {
                            if (var1[1].equals("specball")) {
                                super.aSPanel_Sub32_4032.method2670(var1[2]);
                                return;
                            }

                            if (var1[1].equals("specdata")) {
                                this.method2557(var1[2]);
                                return;
                            }

                            if (var1[1].equals("specwinner")) {
                                this.anInt4851 = Integer.parseInt(var1[2]);
                                this.aSPanel_Sub30_4834.method2643(this.anInt4851);
                                super.aSPanel_Sub32_4032.method2667();
                                this.method2542(true);
                                return;
                            }

                            if (var1[1].equals("specscore")) {
                                this.anIntArray4842[0] = Integer.parseInt(var1[2]);
                                this.anIntArray4842[1] = Integer.parseInt(var1[3]);
                                this.anInt4843 = Integer.parseInt(var1[4]);
                                return;
                            }
                        }

                        if (var1[1].equals("bet")) {
                            if (var1[2].equals("note")) {
                                this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2041("CoinGame_Start", var1[3], var1[4]));
                                var3 = Integer.parseInt(var1[3]);
                                super.aSPanel_Sub32_4032.method2683(var3, var3);
                                return;
                            }

                            if (var1[2].equals("draw")) {
                                this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("CoinGame_Draw"));
                                return;
                            }

                            if (var1[2].equals("winner")) {
                                this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2041("CoinGame_Winner", var1[3], var1[4]));
                                var3 = Integer.parseInt(var1[5]);
                                var4 = Integer.parseInt(var1[4]);
                                super.aSPanel_Sub32_4032.method2683(var3 == 0 ? var4 : 0, var3 == 1 ? var4 : 0);
                                return;
                            }

                            if (var1[2].equals("nocoinsfornew")) {
                                this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("CoinGame_NoCoinsForNew"));
                                this.aSPanel_Sub14_Sub1_4837.method2485(false);
                                return;
                            }

                            if (var1[2].equals("newcantstart")) {
                                this.aSPanel__4835.method2608(6, super.aClass60_4028.textManager.method2039("CoinGame_NewCantStart"));
                                return;
                            }
                        }

                        this.callUpdateUI(var1);
                    }
                }
            } else {
                var3 = Integer.parseInt(var1[2]);
                this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_" + (this.aBoolean4846 ? (var3 == this.anInt4839 ? "Opponent" : "You") : "Player") + (var2 ? "TimeOut" : "Concede")));
                this.method2556(var3);
            }
        }
    }

    protected int method2549(int var1) {
        this.anInt4840 = var1;
        this.aBoolean4845 = false;
        this.aSynchronizedInt_4854.method1463(0);
        this.aSynchronizedInt_4855.method1463(-1);
        int var2 = super.aSPanel_Sub32_4032.method2659(2, super.aSynchronizedInt_4029.method1467(), var1 == this.anInt4839);
        super.aSPanel__4033.method2627(var1 == this.anInt4839);
        this.aSPanel_Sub30_4834.method2638(var1);
        if (this.aBoolean4846 && this.aBoolean4849) {
            this.aSPanel_Sub14_Sub1_4837.method2480();
        }

        return var2;
    }

    protected void method2532(int var1) {
        if (var1 == 0 && this.aSynchronizedInt_4855.method1467() == -1) {
            this.aSynchronizedInt_4855.method1463(0);
        }

    }

    protected void method2535(int var1, boolean var2) {
        if (var1 != 0) {
            this.aSynchronizedInt_4854.method1464();
            if (this.aSynchronizedInt_4855.method1467() >= 0) {
                this.aSynchronizedInt_4855.method1464();
            } else {
                this.aSynchronizedInt_4855.method1463(-2);
            }
        }

    }

    protected String method2541() {
        return this.aSynchronizedInt_4854.method1467() + "," + this.aSynchronizedInt_4855.method1467() + ",";
    }

    protected boolean method2525() {
        return this.anInt4839 >= 0;
    }

    public void method2526(String var1) {
        this.aSPanel__4835.method2611(var1);
    }

    protected boolean method2527(boolean var1) {
        Object var2 = this.anObject4844;
        synchronized (this.anObject4844) {
            if (this.aBoolean4845) {
                return false;
            }

            this.aBoolean4845 = true;
        }

        if (var1) {
            this.aSPanel_Sub30_4834.method2647();
        } else {
            super.aSPanel_Sub32_4032.method2666();
        }

        if (!var1) {
            this.method2524("timeout");
        }

        return true;
    }

    protected void method2530() {
        if (this.aBoolean4846 && this.aBoolean4849) {
            this.aSPanel_Sub14_Sub1_4837.method2481();
        }

        this.aBoolean4849 = true;
        super.aSPanel__4033.method2628(false);
        super.aSynchronizedBool_4036.method1459(false);
        super.aSynchronizedBool_4037.method1459(false);
        this.aBoolean4852 = true;
        super.aSynchronizedInt_4034.method1463(0);
        this.aBoolean4853 = false;
    }

    protected int method2539() {
        return this.anInt4851 >= 0 ? this.anInt4851 : (!this.aBoolean4852 && super.aSynchronizedInt_4034.method1467() <= 0 ? -2 : -1);
    }

    protected abstract String method2550();

    protected String method2551() {
        return this.aString4838;
    }

    protected String method2552() {
        return this.aStringArray4841[1 - this.anInt4839];
    }

    protected void method2553() {
        if (!this.aBoolean4847) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_YouAllowSpectators"));
        }

        this.method2524("aspec");
    }

    protected void method2554(String var1) {
        if (!this.aVector4850.contains(var1)) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("GameSpectator_CantKickBanQuietSpectator"));
        } else {
            this.method2524("skickban\t" + var1);
        }
    }

    protected void method2555() {
        this.aSPanel_Sub14_Sub1_4837.method2482();
        this.aSPanel_Sub30_4834.method2647();
        this.method2524("concede");
    }

    protected void method2545() {
        this.aSPanel_Sub14_Sub1_4837.method2485(false);
        if (!this.aBoolean4848) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_YouWantNewGame"));
        }

        this.method2524("newgame");
    }

    protected void method2546() {
        this.aSPanel_Sub30_4834.method2647();
        super.method2546();
    }

    protected void method2556(int var1) {
        this.aSPanel_Sub30_4834.method2643(var1);
        if (var1 == 2) {
            if (this.anInt4839 >= 0 && super.aClass60_4028.aClass61_1207.playSounds) {
                super.aClass60_4028.soundManager.play("game-draw");
            }

            ++this.anInt4843;
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_Draw"));
        } else {
            ++this.anIntArray4842[var1];
            if (this.anInt4839 == -1) {
                this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2040("Game_PlayerWon", this.aStringArray4841[var1]));
            } else if (var1 == this.anInt4839) {
                if (super.aClass60_4028.aClass61_1207.playSounds) {
                    super.aClass60_4028.soundManager.play("game-win");
                }

                this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_YouWon"));
            } else {
                if (super.aClass60_4028.aClass61_1207.playSounds) {
                    super.aClass60_4028.soundManager.play("game-lose");
                }

                this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_OpponentWon"));
            }

            boolean[] var2 = new boolean[]{var1 == 0, var1 == 1};
            super.aClass60_4028.gameApplet.method2320(var2);
        }

        if (this.anInt4843 == 0) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2043("Game_CurrentScore", this.aStringArray4841[0], "" + this.anIntArray4842[0], this.aStringArray4841[1], "" + this.anIntArray4842[1]));
        } else if (this.anInt4843 == 1) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2043("Game_CurrentScoreWith1Draw", this.aStringArray4841[0], "" + this.anIntArray4842[0], this.aStringArray4841[1], "" + this.anIntArray4842[1]));
        } else {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2044("Game_CurrentScoreWithXDraws", this.aStringArray4841[0], "" + this.anIntArray4842[0], this.aStringArray4841[1], "" + this.anIntArray4842[1], "" + this.anInt4843));
        }

        if (this.anInt4839 >= 0) {
            this.aSPanel_Sub14_Sub1_4837.method2482();
        }

        super.aSPanel_Sub32_4032.method2667();
        this.method2542(true);
    }

    protected abstract void method2557(String var1);

    private void method2558(long var1) {
        if (this.anInt4839 >= 0) {
            this.aSPanel_Sub14_Sub1_4837.method2479();
        }

        if (this.anIntArray4842[0] > 0 || this.anIntArray4842[1] > 0 || this.anInt4843 > 0) {
            this.aSPanel__4835.method2607(super.aClass60_4028.textManager.method2039("Game_NewGameStarted"));
            super.aClass60_4028.gameApplet.method2321();
        }

        this.method2548();
        this.anInt4851 = -1;
        this.aSPanel_Sub30_4834.method2636();
        super.aSPanel_Sub32_4032.method2656(2, super.aSynchronizedInt_4029.method1467(), new Class66(var1));
        this.aBoolean4848 = false;
        this.aBoolean4849 = false;
    }

    private void method2559() {
        int var1 = 0;

        while (super.aSPanel_Sub32_4032.method2682()) {
            Tools.sleep(100L);
            ++var1;
            if (var1 == 150) {
                break;
            }
        }

    }

    static {
        aStringArray4856[0] = "timeout";
        aStringArray4856[1] = "nocoinsfornew";
        aStringArray4856[2] = "newgame";
        aStringArray4856[3] = "specball";
        aStringArray4856[4] = "CoinGame_Winner";
        aStringArray4856[5] = "sjoin";
        aStringArray4856[6] = "CoinGame_Draw";
        aStringArray4856[7] = "Game_OpponentAllowSpectators";
        aStringArray4856[8] = "Concede";
        aStringArray4856[9] = "oaspec";
        aStringArray4856[10] = "You";
        aStringArray4856[11] = "specscore";
        aStringArray4856[12] = "slist";
        aStringArray4856[13] = "beginstroke";
        aStringArray4856[14] = "spart";
        aStringArray4856[15] = "Game_OWNG_Help";
        aStringArray4856[16] = "draw";
        aStringArray4856[17] = "readyfornewgame";
        aStringArray4856[18] = "setpainted";
        aStringArray4856[19] = "specwinner";
        aStringArray4856[20] = "Game_OAS_Help";
        aStringArray4856[21] = "say";
        aStringArray4856[22] = "turn";
        aStringArray4856[23] = "Game_OpponentWantNewGame";
        aStringArray4856[24] = "CoinGame_NewCantStart";
        aStringArray4856[25] = "currentmouse";
        aStringArray4856[26] = "note";
        aStringArray4856[27] = "newcantstart";
        aStringArray4856[28] = "TimeOut";
        aStringArray4856[29] = "setwhiteball";
        aStringArray4856[30] = "Game_";
        aStringArray4856[31] = "bet";
        aStringArray4856[32] = "pass";
        aStringArray4856[33] = "CoinGame_NoCoinsForNew";
        aStringArray4856[34] = "Opponent";
        aStringArray4856[35] = "resulterror";
        aStringArray4856[36] = "sayoo";
        aStringArray4856[37] = "start";
        aStringArray4856[38] = "concede";
        aStringArray4856[39] = "specdata";
        aStringArray4856[40] = "CoinGame_Start";
        aStringArray4856[41] = "Player";
        aStringArray4856[42] = "winner";
        aStringArray4856[43] = "skickban\t";
        aStringArray4856[44] = "GameSpectator_CantKickBanQuietSpectator";
        aStringArray4856[45] = "Game_OpponentLeft";
        aStringArray4856[46] = "aspec";
        aStringArray4856[47] = "quit";
        aStringArray4856[48] = "Game_SpectatorsAllowed";
        aStringArray4856[49] = "players";
        aStringArray4856[50] = "Game_PlayerLeft";
        aStringArray4856[51] = "Game_NewGameStarted";
        aStringArray4856[52] = "Game_YouAllowSpectators";
        aStringArray4856[53] = "Game_YouWantNewGame";
        aStringArray4856[54] = "game-draw";
        aStringArray4856[55] = "Game_Draw";
        aStringArray4856[56] = "Game_CurrentScoreWithXDraws";
        aStringArray4856[57] = "Game_YouWon";
        aStringArray4856[58] = "game-win";
        aStringArray4856[59] = "game-lose";
        aStringArray4856[60] = "Game_OpponentWon";
        aStringArray4856[61] = "Game_CurrentScore";
        aStringArray4856[62] = "Game_CurrentScoreWith1Draw";
        aStringArray4856[63] = "Game_PlayerWon";
    }
}
