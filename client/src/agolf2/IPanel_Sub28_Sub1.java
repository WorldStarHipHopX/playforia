package agolf2;

import com.aapeli.multiuser.UserList;

import java.awt.LayoutManager;
import java.util.Random;

public abstract class IPanel_Sub28_Sub1 extends IPanel_Sub28 {

    protected Class58_Sub1 aClass58_Sub1_3641;
    protected GameOverPanel anGameOverPanel__3642;
    protected IPanel_Sub31 anIPanel_Sub31_3643;
    private IPanel_Sub34 anIPanel_Sub34_3644;
    protected ChatGame_Sub1 aChatGame_Sub1_3645;
    protected GameRatePanel anGameRatePanel__3646;
    protected IPanel_Sub29 anIPanel_Sub29_3647;
    private SynchronizedBool aSynchronizedBool_3648;
    private SynchronizedBool aSynchronizedBool_3649;
    private Class45 aClass45_3650;
    private Object anObject3651;
    public static boolean aBoolean3652;
    private static final String[] aStringArray3653 = new String[22];


    public IPanel_Sub28_Sub1(Class58_Sub1 var1, int var2, int var3, int var4, boolean var5) {
        super(var1, var2, var3, var4, var5);
        this.aClass58_Sub1_3641 = var1;
        this.aSynchronizedBool_3648 = new SynchronizedBool(false);
        this.aSynchronizedBool_3649 = new SynchronizedBool(false);
        this.anObject3651 = new Object();
        this.method704(var5);
        this.method679(this.anGameOverPanel__3642);
    }

    protected void method680(GameBall var1) {
        if (this.anInt2329 != 0) {
            this.anIPanel_Sub31_3643.method732(this.aSynchronizedInteger_2333.method1174(), false);
            int[] var2 = this.method688(var1);
            this.method695("aimready\t" + var2[0] + "\t" + var2[1]);
        } else {
            var1.method1238();
            this.anIPanel_Sub31_3643.method733(0);
            this.method689(new Random());
        }

    }

    protected void method681(Canvas_Sub6_Sub2 var1) {
        this.aClass43_Sub1_2331.method1300();
        this.method707();
        var1.method207();
        var1.method208();
        this.method696();
        if (this.method685() && this.aClass43_Sub1_2331.method1325()[this.aSynchronizedInteger_2333.method1174()].method1244()) {
            this.anIPanel_Sub29_3647.method718();
        }

        this.anIPanel_Sub36_2326.method772();
    }

    protected abstract boolean method692(String[] var1);

    protected abstract void method693();

    protected abstract void method694();

    protected abstract void method695(String var1);

    protected void method696() {
        if (this.method685()) {
            this.method695("strikeready");
        }

    }

    protected void method697(boolean var1) {
        Object var2 = this.anObject3651;
        synchronized (this.anObject3651) {
            this.method682();
        }

        if (var1) {
            this.method695("quit");
        } else {
            this.aClass58_Sub1_3641.anAApplet_Sub3_Sub1_3567.method64(true);
        }

    }

    public void method698(String var1) {
        this.aChatGame_Sub1_3645.broadcastMessage(var1);
    }

    public void method699(String[] var1) {
        Object var2 = this.anObject3651;
        synchronized (this.anObject3651) {
            if (!this.aBoolean2339) {
                boolean var3 = false;
                if (this.method692(var1)) {
                    var3 = true;
                }

                if (this.aChatGame_Sub1_3645.method904(var1)) {
                    var3 = true;
                }

                int var5;
                if (var1[1].equals("gameinfo")) {
                    String var15 = var1[2];
                    var5 = Integer.parseInt(var1[3]);
                    this.aSynchronizedBool_3648.method1167(var1[4].equals("t"));
                    if (var1[5].equals("t")) {
                        this.anIPanel_Sub31_3643.method729();
                    }

                    this.aSynchronizedBool_3649.method1167(var1[6].equals("t"));
                    this.anIPanel_Sub34_3644.method757(var5);
                    this.aChatGame_Sub1_3645.method900(var15);
                } else if (var1[1].equals("local")) {
                    this.method684(Integer.parseInt(var1[2]));
                } else {
                    int var8;
                    int var12;
                    if (var1[1].equals("players")) {
                        var12 = (var1.length - 2) / 2;
                        String[] var16 = new String[var12];
                        String[] var17 = new String[var12];
                        String[] var18 = new String[var12];

                        for (var8 = 0; var8 < var12; ++var8) {
                            var16[var8] = var1[2 + var8 * 2];
                            var17[var8] = UserList.getNickFromUserInfo(var16[var8]);
                            var18[var8] = var1[2 + var8 * 2 + 1];
                        }

                        if (this.method685()) {
                            this.aChatGame_Sub1_3645.method903(var12, var16, var17, this.aSynchronizedInteger_2333.method1174());
                        }

                        this.anIPanel_Sub31_3643.method727(this.anIPanel_Sub34_3644.method758(), var17);
                        this.anGameOverPanel__3642.method768(var18, var17);
                    } else if (var1[1].equals("gamestart")) {
                        this.aChatGame_Sub1_3645.method901();
                        this.anIPanel_Sub31_3643.method728();
                        this.anIPanel_Sub29_3647.method714();
                        this.anGameRatePanel__3646.method752();
                    } else if (var1[1].equals("trackstart")) {
                        this.method709();
                        this.method690();
                        this.anIPanel_Sub31_3643.method736();
                        this.method705(var1);
                        this.anGameOverPanel__3642.method767().method202(this.aSynchronizedInteger_2333.method1174());
                        this.anIPanel_Sub29_3647.method715(this.aSynchronizedBool_3648.method1168(), this.method685());
                        if (this.method685()) {
                            this.method695("trackready");
                        }

                    } else if (var1[1].equals("aimstart")) {
                        this.method709();
                        GameBall_Sub1[] var13 = this.aClass43_Sub1_2331.method1325();

                        for (var5 = 0; var5 < var13.length; ++var5) {
                            var13[var5].method1235();
                        }

                        this.method701(var1);
                    } else if (var1[1].equals("aimready")) {
                        var12 = Integer.parseInt(var1[2]);
                        GameBall_Sub1[] var14 = this.aClass43_Sub1_2331.method1325();
                        var14[var12].method1239(Integer.parseInt(var1[3]), Integer.parseInt(var1[4]));
                        this.anIPanel_Sub31_3643.method732(var12, false);
                    } else if (var1[1].equals("cancelaim")) {
                        this.method690();
                    } else if (var1[1].equals("strikestart")) {
                        this.method709();

                        for (var12 = 3; var12 < var1.length; ++var12) {
                            this.anIPanel_Sub31_3643.method733(Integer.parseInt(var1[var12]));
                        }

                        this.method689(new Random(Long.parseLong(var1[2])));
                    } else if (var1[1].equals("trackend")) {
                        this.method706(var1);
                    } else if (!var1[1].equals("gameover")) {
                        if (var1[1].equals("playerdata")) {
                            this.anIPanel_Sub31_3643.method745(Integer.parseInt(var1[2]), var1);
                        } else if (var1[1].equals("balldata")) {
                            this.aClass43_Sub1_2331.method1325()[Integer.parseInt(var1[2])].method1248(var1[3]);
                        }
                    } else {
                        this.method709();
                        this.method690();
                        this.anIPanel_Sub31_3643.method730(-1);
                        this.anIPanel_Sub29_3647.method716();
                        boolean var4 = var1[2].equals("t");
                        var5 = var1.length - 3;
                        String var6 = null;
                        if (var5 > 0) {
                            if (var5 < this.anIPanel_Sub31_3643.method742()) {
                                boolean var7 = false;
                                var6 = "";

                                for (int var9 = 3; var9 < var1.length; ++var9) {
                                    if (var9 > 3) {
                                        var6 = var6 + ", ";
                                    }

                                    var8 = Integer.parseInt(var1[var9]);
                                    this.anIPanel_Sub31_3643.method746(var8, true);
                                    var6 = var6 + this.anIPanel_Sub31_3643.method744(var8).method1327();
                                    if (var8 == this.aSynchronizedInteger_2333.method1174()) {
                                        var7 = true;
                                    }
                                }

                                this.aClass58_Sub1_3641.aClass39_Sub1_1191.method1234("game_" + (var7 ? "win" : "lose"));
                            } else {
                                this.aClass58_Sub1_3641.aClass39_Sub1_1191.method1234("game_draw");
                            }
                        }

                        this.anGameOverPanel__3642.method781(var5, var6, var4);
                        this.aChatGame_Sub1_3645.method902();
                    }
                }
            }
        }
    }

    protected void method700(int var1, String var2, int var3, Random var4) {
        this.anIPanel_Sub31_3643.method730(var1);
        this.anGameOverPanel__3642.method769();
        this.method691(false);
        this.aClass52_2330 = new Class52(this.aClass58_Sub1_3641.aClass39_Sub1_1191);
        this.aClass52_2330.method1405(var2);
        this.aClass43_Sub1_2331 = new Class43_Sub1(this.aClass58_Sub1_3641.aClass39_Sub1_1191, this.aClass52_2330, this.anIPanel_Sub31_3643.method742(), this.aSynchronizedBool_3649.method1168(), false);
        this.aClass43_Sub1_2331.method1297(var4, var3);
        this.method707();
        this.anGameOverPanel__3642.method771(this.aClass52_2330, this.aClass43_Sub1_2331, this.method685());
        this.aClass43_Sub1_2331.method1324();
    }

    protected void method701(String[] var1) {
        this.method707();
        boolean var2 = true;
        int var3 = Integer.parseInt(var1[2]);

        for (int var4 = 3; var4 < var1.length; ++var4) {
            int var5 = Integer.parseInt(var1[var4]);
            if (var2) {
                this.anGameOverPanel__3642.method767().method202(var5);
            }

            this.anIPanel_Sub31_3643.method732(var5, true);
            if (var3 > 0) {
                this.anIPanel_Sub31_3643.method744(var5).method1342(var3);
            }

            if (var5 == this.aSynchronizedInteger_2333.method1174()) {
                this.aSynchronizedBool_2334.method1167(true);
                this.aSynchronizedInteger_2335.set(0);
                this.anGameOverPanel__3642.method767().method200();
                this.method11(this.anInt2336, this.anInt2337);
                var2 = false;
                if (this.anIPanel_Sub31_3643.method742() > 1 && this.aClass58_Sub1_3641.aClass59_Sub1_3569.beepOnTurn) {
                    this.aClass58_Sub1_3641.aSoundManager1189.playNotify();
                }
            }
        }

        if (var3 > 0) {
            this.method708();
        }

    }

    protected boolean method702() {
        return this.aClass45_3650 != null;
    }

    protected void method703() {
        this.anIPanel_Sub31_3643.method747();
        Canvas_Sub6_Sub2 var1 = this.anGameOverPanel__3642.method767();
        if (var1 != null) {
            var1.repaint();
        }

    }

    private void method704(boolean var1) {
        this.setLayout((LayoutManager) null);
        int var2 = this.anInt2328 - 5 - 100 - 5 - 2 - 420 - 2 - 5 - 5;
        this.anIPanel_Sub31_3643 = new IPanel_Sub31(this.aClass58_Sub1_3641, this, var2);
        this.anIPanel_Sub31_3643.setLocation(5, 5);
        this.add(this.anIPanel_Sub31_3643);
        if (this.anInt2329 != 0) {
            this.anIPanel_Sub34_3644 = new IPanel_Sub34(this.aClass58_Sub1_3641, this.anInt2327 - 5 - 10 - 540 - 5, var2);
            this.anIPanel_Sub34_3644.setLocation(555, 5);
            this.add(this.anIPanel_Sub34_3644);
        }

        this.anGameOverPanel__3642 = new GameOverPanel(this.aClass58_Sub1_3641, this, this.anIPanel_Sub31_3643, this.anInt2327 - 5 - 5, 424);
        this.anGameOverPanel__3642.setLocation(5, this.anInt2328 - 5 - 100 - 5 - 2 - 420 - 2);
        this.add(this.anGameOverPanel__3642);
        if (this.anInt2329 != 0) {
            this.aChatGame_Sub1_3645 = new ChatGame_Sub1(this.aClass58_Sub1_3641, this, var1);
            this.aChatGame_Sub1_3645.setLocation(5, this.anInt2328 - 5 - 100);
            this.add(this.aChatGame_Sub1_3645);
            this.anGameRatePanel__3646 = new GameRatePanel(this.aClass58_Sub1_3641, this, this.anInt2327 - 5 - 115 - 10 - 10 - 480 - 5, 100);
            this.anGameRatePanel__3646.setLocation(495, this.anInt2328 - 5 - 100);
            this.add(this.anGameRatePanel__3646);
        }

        this.anIPanel_Sub29_3647 = new IPanel_Sub29(this.aClass58_Sub1_3641, this, this.anInt2329, 100);
        this.anIPanel_Sub29_3647.setLocation(this.anInt2327 - 5 - 115, this.anInt2328 - 5 - 100);
        this.add(this.anIPanel_Sub29_3647);
        this.aFrame_Sub2_2332 = new GameSettingsFrame(this.aClass58_Sub1_3641, this);
    }

    private void method705(String[] var1) {
        int var2 = Integer.parseInt(var1[2]);
        String var3 = var1[3];
        String var4 = var1[4];
        String var5 = var1[5];
        long var6 = Long.parseLong(var1[6]);
        boolean var8 = var1[7].equals("t");
        int var9 = Integer.parseInt(var1[8]);
        long var10 = Long.parseLong(var1[9]);
        int var12 = Integer.parseInt(var1[10]);
        int var13 = Integer.parseInt(var1[11]);
        String var14 = var1[12];
        long var15 = Long.parseLong(var1[13]);
        String var17 = var1[14];
        long var18 = Long.parseLong(var1[15]);
        int var20 = Integer.parseInt(var1[16]);
        long var21 = Long.parseLong(var1[17]);
        Random var23 = new Random(var21);
        this.anIPanel_Sub34_3644.method759(var2, var4, var3, var6, var8, var9, var10, var12, var13, var14, var15, var17, var18);
        this.method700(var2, var5, var20, var23);
    }

    private void method706(String[] var1) {
        int var2 = Integer.parseInt(var1[2]);
        int var3 = Integer.parseInt(var1[3]);
        int var4 = Integer.parseInt(var1[4]);
        this.anGameRatePanel__3646.method751(this.anIPanel_Sub34_3644.method760(), this.anIPanel_Sub34_3644.method761(), this.anGameOverPanel__3642.method767().method209(), var2, var3, this.method685(), this.anIPanel_Sub34_3644.method762(), var4);
    }

    private void method707() {
        boolean[] var1 = this.anIPanel_Sub31_3643.method735();
        GameBall_Sub1[] var2 = this.aClass43_Sub1_2331.method1325();

        for (int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3]) {
                var2[var3].method1246();
            }
        }

    }

    private void method708() {
        this.method710();
        this.aClass45_3650 = new Class45(this);
        this.anIPanel_Sub31_3643.repaint();
    }

    private void method709() {
        this.anIPanel_Sub31_3643.method731();
        this.method710();
        this.anIPanel_Sub31_3643.repaint();
    }

    private void method710() {
        if (this.aClass45_3650 != null) {
            this.aClass45_3650.method1347();
            this.aClass45_3650 = null;
        }

    }

    static {
        aStringArray3653[0] = "win";
        aStringArray3653[1] = "gamestart";
        aStringArray3653[2] = "trackstart";
        aStringArray3653[3] = "playerdata";
        aStringArray3653[4] = "trackend";
        aStringArray3653[5] = "trackready";
        aStringArray3653[6] = "balldata";
        aStringArray3653[7] = "game_";
        aStringArray3653[8] = "gameinfo";
        aStringArray3653[9] = "aimready";
        aStringArray3653[10] = ", ";
        aStringArray3653[11] = "gameover";
        aStringArray3653[12] = "strikestart";
        aStringArray3653[13] = "aimstart";
        aStringArray3653[14] = "players";
        aStringArray3653[15] = "cancelaim";
        aStringArray3653[16] = "lose";
        aStringArray3653[17] = "local";
        aStringArray3653[18] = "game_draw";
        aStringArray3653[19] = "strikeready";
        aStringArray3653[20] = "aimready\t";
        aStringArray3653[21] = "quit";
    }
}
