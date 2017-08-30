package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.ChallengeFloodProtection;
import com.playray.multiuser.UserList;
import com.playray.multiuser.UserListItem;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

class LobbyHeaderPanel extends SPanel implements ItemListener, ActionListener {

    private static final int[] anIntArray4003 = new int[]{15, 30, 45, 60, 90, 120, 180, 240, 300};
    private static final int[] anIntArray4004 = new int[]{7, 10, 15, 20, 30, 40, 50, 75, 100, 150, 200};
    private Class60 aClass60_4005;
    private SPanel_Sub21 aSPanel_Sub21_4006;
    private boolean aBoolean4007;
    private int anInt4008;
    private int anInt4009;
    private int anInt4010;
    private String aString4011;
    private int anInt4012;
    private int anInt4013;
    private int anInt4014;
    private int anInt4015;
    private GlossyButton aGlossyButton4016;
    private GlossyButton aGlossyButton4017;
    private GlossyButton aGlossyButton4018;
    private GlossyButton aGlossyButton4019;
    private JComboBox aJComboBox4020;
    private JComboBox aJComboBox4021;
    private JComboBox aJComboBox4022;
    private JComboBox aJComboBox4023;
    private int[][] anIntArrayArray4024;
    private boolean aBoolean4025;
    private ChallengeFloodProtection aChallengeFloodProtection4026;


    protected LobbyHeaderPanel(Class60 var1, SPanel_Sub21 var2, boolean var3, int var4, int var5) {
        this.aClass60_4005 = var1;
        this.aSPanel_Sub21_4006 = var2;
        this.aBoolean4007 = var3;
        this.anInt4008 = var4;
        this.anInt4009 = var5;
        this.setSize(var4, var5);
        this.method2510();
        this.updateUI((Object) null);
        this.method2507();
        this.aChallengeFloodProtection4026 = new ChallengeFloodProtection();
        this.aBoolean4025 = true;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4025) {
            this.aBoolean4025 = false;
            GameApplet.method2302(var1, this.anInt4008, this.anInt4009, this);
        }

        var1.setColor(GameApplet.aColor4808);
        Font var2 = null;
        String var3 = null;
        if (this.anInt4010 == 0) {
            var2 = GameApplet.aFont4817;
            var3 = this.aClass60_4005.textManager.method2039("Lobby_Header_ChallengeInstructions");
        } else if (this.anInt4010 == 1) {
            var2 = GameApplet.aFont4815;
            var3 = this.aClass60_4005.textManager.method2040("Lobby_Header_ChallengeSent", this.aString4011);
        } else if (this.anInt4010 == 2) {
            var2 = GameApplet.aFont4815;
            var3 = this.aClass60_4005.textManager.method2040("Lobby_Header_ChallengeReceived", this.aString4011);
        }

        if (var3 != null) {
            var1.setFont(var2);
            var1.drawString(var3, 5, 18);
        }

        var1.setFont(GameApplet.aFont4816);
        byte var4 = 66;
        byte var5 = 22;
        StringDraw.drawString(var1, this.aClass60_4005.textManager.method2039("Lobby_Header_AllowSpectators"), 5, var4, -1);
        if (this.anInt4010 != 0) {
            var1.drawString(this.aClass60_4005.textManager.method2039("Lobby_Header_AllowSpectators" + (this.anInt4012 == 1 ? "Yes" : "No")), 105, var4);
        }

        StringDraw.drawString(var1, this.aClass60_4005.textManager.method2039("Lobby_Header_Timelimit"), 5, var4 + var5, -1);
        if (this.anInt4010 != 0) {
            var1.drawString(this.method2521(this.anInt4013), 105, var4 + var5);
        }

        if (this.aBoolean4007) {
            StringDraw.drawString(var1, this.aClass60_4005.textManager.method2039("Lobby_Header_ScoreLimit") + " ", 5, var4 + var5 * 2, -1);
            if (this.anInt4010 != 0) {
                var1.drawString("" + this.anInt4014, 105, var4 + var5 * 2);
            }
        }

        if (this.aClass60_4005.aClass61_1207.aBoolean1217) {
            var1.setColor(GameApplet.aColor4811);
            StringDraw.drawString(var1, this.aClass60_4005.textManager.method2039("Lobby_Header_GameBet"), 5, var4 - var5, -1);
            if (this.anInt4010 == 0) {
                int[] var6 = this.method2513();
                if (var6 != null) {
                    var1.setFont(GameApplet.aFont4817);
                    var3 = this.aClass60_4005.textManager.method2046("Lobby_Header_BetWinValuesSideNote", var6[0], var6[1]);
                    short var7 = 205;
                    StringDraw.drawStringWithMaxWidth(var1, var3, var7, var4 - var5, -1, this.anInt4008 - 10 - var7);
                }
            } else {
                int var8 = this.method2514(this.anInt4015);
                StringDraw.drawString(var1, this.aClass60_4005.textManager.method2046("Lobby_Header_BetWinValues", this.anInt4015, var8), 105, var4 - var5, -1);
            }
        }

    }

    public void updateUI(Object var1) {
        if (var1 != null) {
            Object[] var2 = (Object[]) ((Object[]) var1);
            this.anInt4010 = ((Integer) ((Integer) var2[0])).intValue();
            this.aString4011 = (String) ((String) var2[1]);
            this.anInt4012 = ((Integer) ((Integer) var2[2])).intValue();
            this.anInt4013 = ((Integer) ((Integer) var2[3])).intValue();
            this.anInt4014 = ((Integer) ((Integer) var2[4])).intValue();
            this.anInt4015 = ((Integer) ((Integer) var2[5])).intValue();
        } else {
            this.anInt4010 = 0;
        }

        this.removeAll();
        if (this.anInt4010 == 0) {
            this.add(this.aJComboBox4023);
            this.add(this.aJComboBox4020);
            this.add(this.aJComboBox4021);
            if (this.aBoolean4007) {
                this.add(this.aJComboBox4022);
            }

            this.add(this.aGlossyButton4016);
        } else if (this.anInt4010 == 1) {
            this.add(this.aGlossyButton4017);
        } else if (this.anInt4010 == 2) {
            this.add(this.aGlossyButton4019);
            this.add(this.aGlossyButton4018);
        }

        this.repaint();
    }

    public void itemStateChanged(ItemEvent var1) {
        this.aSPanel_Sub21_4006.method2576();
        this.aClass60_4005.aClass61_1207.anInt1218 = this.aJComboBox4020.getSelectedIndex();
        this.aClass60_4005.aClass61_1207.anInt1219 = this.aJComboBox4021.getSelectedIndex();
        this.aClass60_4005.aClass61_1207.anInt1220 = this.aJComboBox4022.getSelectedIndex();
        this.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.method2512()) {
            this.aSPanel_Sub21_4006.method2576();
            Object var2 = var1.getSource();
            if (this.anInt4010 == 0 && var2 == this.aGlossyButton4016) {
                this.method2517();
            } else if (this.anInt4010 == 1 && var2 == this.aGlossyButton4017) {
                this.method2518();
            } else if (this.anInt4010 == 2) {
                if (var2 == this.aGlossyButton4019) {
                    this.method2520();
                } else if (var2 == this.aGlossyButton4018) {
                    this.method2519();
                }
            }

        }
    }

    protected boolean method2505(String[] var1) {
        if (var1[1].equals("betwin")) {
            this.method2511(var1);
            return true;
        } else if (var1[1].equals("challenge")) {
            UserList var9 = this.aSPanel_Sub21_4006.method2582();
            UserListItem var3 = var9 != null ? var9.getUser(var1[2]) : null;
            boolean var4 = var3 != null ? var3.isIgnore() : false;
            if (var3 != null && !this.aClass60_4005.aClass61_1207.aBoolean1226 && !var4 && this.aClass60_4005.gameApplet.aSynchronizedBool_4803.method1460()) {
                if (!this.method2512()) {
                    this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\tnochallenges");
                    return true;
                } else {
                    int var5 = Integer.parseInt(var1[6]);
                    if ((!this.aClass60_4005.aClass61_1207.aBoolean1217 || var5 != 0) && (this.aClass60_4005.aClass61_1207.aBoolean1217 || var5 <= 0)) {
                        if (var5 > 0 && !this.aClass60_4005.gameApplet.method2309()) {
                            this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\tnochallenges");
                            return true;
                        } else if (this.anInt4010 == 1) {
                            this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\twaitingreply");
                            return true;
                        } else if (this.anInt4010 == 2) {
                            this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\tansweringother");
                            return true;
                        } else {
                            this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2040("Lobby_Header_ChallengeReceived", var1[2]));
                            int var6 = Integer.parseInt(var1[3]);
                            int var7 = Integer.parseInt(var1[4]);
                            int var8 = Integer.parseInt(var1[5]);
                            this.method2515(2, var1[2], var6, var7, var8, var5);
                            if (this.aClass60_4005.aClass61_1207.aBoolean1227) {
                                this.aClass60_4005.soundManager.playChallenge();
                            }

                            return true;
                        }
                    } else {
                        this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\tnochallenges");
                        return true;
                    }
                }
            } else {
                this.aSPanel_Sub21_4006.method2580("cfail\t" + var1[2] + "\tnochallenges");
                return true;
            }
        } else if (var1[1].equals("cfail")) {
            this.method2516();
            if (var1[2].equals("nosuchuser")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_NoSuchUser"));
            } else if (var1[2].equals("nochallenges")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_NoChallenges"));
            } else if (var1[2].equals("waitingreply")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_WaitingReply"));
            } else if (var1[2].equals("answeringother")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_AnsweringOther"));
            } else if (var1[2].equals("userleft")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_UserLeft"));
            } else if (var1[2].equals("refuse")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_Refused"));
            } else if (var1[2].equals("sameipcoin")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_SameIpCoinGame"));
            }

            return true;
        } else if (var1[1].equals("cfailcoin")) {
            this.method2516();
            if (var1[2].equals("younocoins")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_YouNoCoins"));
            } else if (var1[2].equals("oppnocoins")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_OppNoCoins"));
            }

            return true;
        } else if (var1[1].equals("cancel")) {
            String var2 = this.method2516();
            if (var2 != null) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2040("Lobby_Header_Cancelled", var2));
            }

            return true;
        } else if (var1[1].equals("afail")) {
            this.method2516();
            if (var1[2].equals("nouser")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_AcceptFailNoUser"));
            } else if (var1[2].equals("nochal")) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_AcceptFailNoChallenge"));
            }

            return true;
        } else {
            return false;
        }
    }

    protected void method2506() {
        if (this.anInt4010 == 2) {
            this.method2519();
        }

    }

    protected void method2507() {
        this.method2508();
        this.aJComboBox4023.setVisible(this.aClass60_4005.aClass61_1207.aBoolean1217);
        this.repaint();
    }

    protected void method2508() {
        if (this.anInt4010 == 1) {
            this.method2518();
        } else if (this.anInt4010 == 2) {
            this.method2519();
        }

    }

    protected int method2509() {
        return this.anIntArrayArray4024 == null ? 1 : this.anIntArrayArray4024[0][0];
    }

    private void method2510() {
        byte var1 = 30;
        byte var2 = 22;
        this.aJComboBox4023 = new JComboBox();
        this.aJComboBox4023.setBounds(105, var1, 90, 20);
        this.aJComboBox4023.setBackground(GameApplet.aColor4811);
        this.aJComboBox4023.addItem(this.aClass60_4005.textManager.method2039("Lobby_Header_BetNone"));
        this.aJComboBox4020 = new JComboBox();
        this.aJComboBox4020.setBounds(105, var1 + var2, 90, 20);
        this.aJComboBox4020.addItem(this.aClass60_4005.textManager.method2039("Lobby_Header_AllowSpectatorsNo"));
        this.aJComboBox4020.addItem(this.aClass60_4005.textManager.method2039("Lobby_Header_AllowSpectatorsYes"));
        this.aJComboBox4020.setSelectedIndex(this.aClass60_4005.aClass61_1207.anInt1218);
        this.aJComboBox4020.addItemListener(this);
        this.aJComboBox4021 = new JComboBox();
        this.aJComboBox4021.setBounds(105, var1 + var2 * 2, 90, 20);

        int var3;
        for (var3 = 0; var3 < anIntArray4003.length; ++var3) {
            this.aJComboBox4021.addItem(this.method2521(anIntArray4003[var3]));
        }

        this.aJComboBox4021.setSelectedIndex(this.aClass60_4005.aClass61_1207.anInt1219);
        this.aJComboBox4021.addItemListener(this);
        this.aJComboBox4022 = new JComboBox();
        this.aJComboBox4022.setBounds(105, var1 + var2 * 3, 90, 20);

        for (var3 = 0; var3 < anIntArray4004.length; ++var3) {
            this.aJComboBox4022.addItem("" + anIntArray4004[var3]);
        }

        this.aJComboBox4022.setSelectedIndex(this.aClass60_4005.aClass61_1207.anInt1220);
        this.aJComboBox4022.addItemListener(this);
        this.aGlossyButton4016 = new GlossyButton(this.aClass60_4005.textManager.method2039("Lobby_Header_ChallengeButton"), 1);
        this.aGlossyButton4016.setBounds(5, this.anInt4009 - 5 - 25, 170, 25);
        this.aGlossyButton4016.addActionListener(this);
        this.aGlossyButton4017 = new GlossyButton(this.aClass60_4005.textManager.method2039("Lobby_Header_CancelButton"), 4);
        this.aGlossyButton4017.setBounds(5, this.anInt4009 - 5 - 25, 170, 25);
        this.aGlossyButton4017.addActionListener(this);
        this.aGlossyButton4019 = new GlossyButton(this.aClass60_4005.textManager.method2039("Lobby_Header_AcceptButton"), 1);
        this.aGlossyButton4019.setBounds(150, this.anInt4009 - 5 - 25, 120, 25);
        this.aGlossyButton4019.addActionListener(this);
        this.aGlossyButton4018 = new GlossyButton(this.aClass60_4005.textManager.method2039("Lobby_Header_RefuseButton"), 2);
        this.aGlossyButton4018.setBounds(275, this.anInt4009 - 5 - 25, 120, 25);
        this.aGlossyButton4018.addActionListener(this);
    }

    private void method2511(String[] var1) {
        int var2 = (var1.length - 2) / 2;
        this.anIntArrayArray4024 = new int[var2][2];

        for (int var3 = 0; var3 < var2; ++var3) {
            this.anIntArrayArray4024[var3][0] = Integer.parseInt(var1[2 + var3 * 2]);
            this.anIntArrayArray4024[var3][1] = Integer.parseInt(var1[2 + var3 * 2 + 1]);
            this.aJComboBox4023.addItem(this.aClass60_4005.textManager.getWithQuantity("Lobby_Header_BetCoins", new String[]{"" + this.anIntArrayArray4024[var3][0]}, this.anIntArrayArray4024[var3][0]));
        }

        this.aJComboBox4023.setSelectedIndex(0);
        this.aJComboBox4023.addItemListener(this);
    }

    private boolean method2512() {
        return this.anIntArrayArray4024 != null;
    }

    private int[] method2513() {
        if (this.aJComboBox4023 == null) {
            return null;
        } else if (this.anIntArrayArray4024 == null) {
            return null;
        } else {
            int var1 = this.aJComboBox4023.getSelectedIndex();
            return var1 == 0 ? null : this.anIntArrayArray4024[var1 - 1];
        }
    }

    private int method2514(int var1) {
        if (this.anIntArrayArray4024 == null) {
            return -1;
        } else {
            for (int var2 = 0; var2 < this.anIntArrayArray4024.length; ++var2) {
                if (var1 == this.anIntArrayArray4024[var2][0]) {
                    return this.anIntArrayArray4024[var2][1];
                }
            }

            return -1;
        }
    }

    protected void method2515(int var1, String var2, int var3, int var4, int var5, int var6) {
        this.callUpdateUI(new Object[]{new Integer(var1), var2, new Integer(var3), new Integer(var4), new Integer(var5), new Integer(var6)});
    }

    private String method2516() {
        String var1 = this.anInt4010 != 0 ? this.aString4011 : null;
        this.callUpdateUI((Object) null);
        return var1;
    }

    private void method2517() {
        if (this.anInt4010 == 0) {
            UserListItem var1 = this.aSPanel_Sub21_4006.method2582().getSelectedUser();
            if (var1 == null) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_SelectFirst"));
            } else if (var1.isLocal()) {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_CantChallengeSelf"));
            } else if (!var1.isNotAcceptingChallenges() && this.aClass60_4005.gameApplet.aSynchronizedBool_4803.method1460()) {
                if (var1.getAfterNickIcon() == null) {
                    if (this.aClass60_4005.aClass61_1207.aBoolean1217) {
                        this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_OnlyNoCoinChallenges"));
                        return;
                    }
                } else if (!this.aClass60_4005.aClass61_1207.aBoolean1217) {
                    this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_OnlyCoinChallenges"));
                    return;
                }

                if (this.aClass60_4005.aClass61_1207.aBoolean1217 && !this.aClass60_4005.gameApplet.method2309()) {
                    this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_YouNoCoinsWorm"));
                } else {
                    String var2 = var1.getNick();
                    int var3 = 0;
                    if (this.aClass60_4005.aClass61_1207.aBoolean1217) {
                        int[] var4 = this.method2513();
                        if (var4 == null) {
                            this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_NeedSelectBet"));
                            return;
                        }

                        var3 = var4[0];
                    }

                    if (!this.aChallengeFloodProtection4026.isOkToChallenge(var2)) {
                        this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.getShared("Chat_MessageChallengeFlood"));
                    } else {
                        int var7 = this.aJComboBox4020.getSelectedIndex();
                        int var5 = anIntArray4003[this.aJComboBox4021.getSelectedIndex()];
                        int var6 = anIntArray4004[this.aJComboBox4022.getSelectedIndex()];
                        this.aSPanel_Sub21_4006.method2580("challenge\t" + var2 + "\t" + var7 + "\t" + var5 + "\t" + var6 + "\t" + var3);
                        this.method2515(1, var2, var7, var5, var6, var3);
                    }
                }
            } else {
                this.aSPanel_Sub21_4006.method2579(this.aClass60_4005.textManager.method2039("Lobby_Header_NoChallenges"));
            }
        }
    }

    private void method2518() {
        this.method2516();
        this.aSPanel_Sub21_4006.method2580("cancel\t" + this.aString4011);
    }

    private void method2519() {
        this.method2516();
        this.aSPanel_Sub21_4006.method2580("cfail\t" + this.aString4011 + "\trefuse");
    }

    private void method2520() {
        this.method2516();
        this.aSPanel_Sub21_4006.method2580("accept\t" + this.aString4011);
    }

    private String method2521(int var1) {
        return var1 == 0 ? this.aClass60_4005.textManager.method2039("Lobby_Header_TimeLimitNo") : this.aClass60_4005.textManager.getTime((long) var1);
    }
}
