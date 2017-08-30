package acannons;

import com.playray.client.FilterTextField;
import com.playray.client.InputTextField;
import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.ColorButton;
import com.playray.colorgui.GlossyButton;
import com.playray.colorgui.MultiColorList;
import com.playray.colorgui.MultiColorListItem;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

class LobbyCreateGamePanel extends SPanel implements ItemListener, ActionListener {

    private static final Color aColor3931;
    private ClientSettings aClientSettings_3932;
    private int anInt3933;
    private int anInt3934;
    private JComboBox aJComboBox3935;
    private JComboBox aJComboBox3936;
    private FilterTextField aFilterTextField3937;
    private InputTextField anInputTextField3938;
    private JComboBox aJComboBox3939;
    private JComboBox aJComboBox3940;
    private JComboBox aJComboBox3941;
    private JComboBox aJComboBox3942;
    private JComboBox aJComboBox3943;
    private JComboBox aJComboBox3944;
    private JComboBox aJComboBox3945;
    private GlossyButton aGlossyButton3946;
    private GlossyButton aGlossyButton3947;
    private GlossyButton aGlossyButton3948;
    private MultiColorList aMultiColorList3949;
    private GlossyButton aGlossyButton3950;
    private boolean aBoolean3951;
    private int anInt3952;
    private LobbyPasswordPanel aSPanel__3953;
    private String aString3954;
    private InputTextField anInputTextField3955;
    private ColorButton aColorButton3956;
    private static final String[] aStringArray3957 = new String[71];


    protected LobbyCreateGamePanel(ClientSettings var1, int var2, int var3) {
        this.aClientSettings_3932 = var1;
        this.anInt3933 = var2;
        this.anInt3934 = var3;
        this.setSize(var2, var3);
        this.method2460();
        this.method2461();
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(GameApplet.aColor4782);
        var1.setFont(GameApplet.fontDialog18);
        StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_JoinGameTitle"), this.anInt3933 * 3 / 4, 50, 0);
        byte var3;
        int var5;
        if (this.aClientSettings_3932.aPlayerInfo_764.aBoolean778) {
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_CreateGameTitle"), this.anInt3933 / 4 + 20, 33, 0);
            byte var2 = 60;
            var3 = 25;
            var1.setFont(GameApplet.fontDialog12);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_NumberOfPlayers"), this.anInt3933 / 2 - 185, var2, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_NumberOfRounds"), this.anInt3933 / 2 - 185, var2 + var3, 1);
            if (this.aClientSettings_3932.gameApplet.method2282()) {
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_GameName"), this.anInt3933 / 2 - 185, var2 + var3 * 2, 1);
            }

            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_GamePassword"), this.anInt3933 / 2 - 185, var2 + var3 * 3, 1);
            if (this.aClientSettings_3932.gameApplet.method2282()) {
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_OnlyFor"), this.anInt3933 / 2 - 185, var2 + var3 * 4, 1);
            }

            if (this.aBoolean3951) {
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAdd"), this.anInt3933 / 2 - 185, var2 + var3 * 5, 1);
                String var4 = null;
                var5 = this.aJComboBox3940.getSelectedIndex();
                if (var5 == 0) {
                    var4 = "Increasing";
                } else if (var5 == 1) {
                    var4 = "Constant";
                } else if (var5 == 2) {
                    var4 = "Decreasing";
                }

                var1.setFont(GameApplet.fontDialog11);
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAdd" + var4 + "Info"), this.anInt3933 / 4, var2 + var3 * 6 - 2, 0);
                var1.setFont(GameApplet.fontDialog12);
            }

            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayOrder"), this.anInt3933 / 2 - 185, var2 + var3 * 7, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_ThinkTime"), this.anInt3933 / 2 - 185, var2 + var3 * 8, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Wind"), this.anInt3933 / 2 - 185, var2 + var3 * 9, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Duds"), this.anInt3933 / 2 - 185, var2 + var3 * 10, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Scoring"), this.anInt3933 / 2 - 185, var2 + var3 * 11, 1);
        } else {
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_CreateGameTitle"), this.anInt3933 / 4 + 20, 50, 0);
            var1.setFont(GameApplet.fontDialog11);
            StringDraw.drawStringWithMaxWidth(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_QuickHelpMulti"), this.anInt3933 / 4 + 20, 80, 0, this.anInt3933 / 3);
            short var9 = 166;
            var3 = 30;
            var1.setFont(GameApplet.fontDialog12);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_NumberOfPlayers"), this.anInt3933 / 2 - 185, var9, 1);
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_NumberOfRounds"), this.anInt3933 / 2 - 185, var9 + var3, 1);
        }

        Object[] var10 = this.method2472();
        if (var10 != null) {
            int[] var11 = (int[]) ((int[]) var10[0]);
            int var13 = this.anInt3933 - 190;
            var5 = this.anInt3933 - 185;
            short var6 = 212;
            byte var7 = 18;
            String[] var8 = new String[]{"Decreasing", "Constant", "Increasing"};
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAdd"), var13, var6, 1);
            var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAdd" + var8[var11[3] + 1]), var5, var6);
            int var14 = var6 + var7;
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayOrder"), var13, var14, 1);
            var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayOrder" + (var11[4] == 0 ? "Turns" : "SameTime")), var5, var14);
            var14 += var7;
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_ThinkTime"), var13, var14, 1);
            if (var11[5] > 0) {
                var1.drawString("" + var11[5], var5, var14);
            } else {
                var1.setColor(aColor3931);
                var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_ThinkTimeUnlimited"), var5, var14);
                var1.setColor(GameApplet.aColor4782);
            }

            var14 += var7;
            if (var11[6] != 1) {
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Wind"), var13, var14, 1);
                var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_Wind" + (var11[6] == 0 ? "None" : "Random")), var5, var14);
                var14 += var7;
            }

            if (var11[7] == 1) {
                StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Duds"), var13, var14, 1);
                var1.setColor(aColor3931);
                var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_DudsYes"), var5, var14);
                var1.setColor(GameApplet.aColor4782);
                var14 += var7;
            }

            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_Scoring"), var13, var14, 1);
            var1.drawString(this.aClientSettings_3932.textManager.method2039("LobbyReal_Scoring" + (var11[8] == 0 ? "Survive" : (var11[8] == 1 ? "Destroy" : "Both"))), var5, var14);
            var14 += var7;
            StringDraw.drawString(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayerList"), var13, var14, 1);
            StringDraw.drawStringWithMaxWidth(var1, (String) ((String) var10[1]), var5, var14, -1, this.anInt3933 - var5 - 5);
            if (var11[9] == 0) {
                var1.setFont(GameApplet.fontDialog11);
                StringDraw.drawStringWithMaxWidth(var1, this.aClientSettings_3932.textManager.method2039("LobbyReal_GameStartedNote"), (var13 + var5) / 2, this.anInt3934 - 45, 0, 250);
                var1.setFont(GameApplet.fontDialog12);
            }
        }

        if (this.anInt3952 > 0) {
            String var12 = null;
            if (this.anInt3952 == 1) {
                var12 = "NotExist";
            } else if (this.anInt3952 == 2) {
                var12 = "AlreadyStarted";
            } else if (this.anInt3952 == 3) {
                var12 = "WrongPassword";
            } else if (this.anInt3952 == 4) {
                var12 = "RegOnly";
            }

            if (var12 != null) {
                var12 = this.aClientSettings_3932.textManager.method2039("LobbyReal_JoinError" + var12);
            }

            var1.setColor(aColor3931);
            StringDraw.drawString(var1, var12, this.anInt3933 * 3 / 4, this.anInt3934 - 5, 0);
        }

        if (this.aString3954 != null) {
            var1.setColor(new Color(255, 192, 160));
            var1.fillRect(395, this.anInt3934 - 19, this.anInt3933, 19);
            var1.setFont(GameApplet.fontDialog11);
            var1.setColor(Color.black);
            StringDraw.drawString(var1, "Creator: " + this.aString3954, 400, this.anInt3934 - 5, -1);
            int var10003 = this.anInt3934 - 5;
            StringDraw.drawString(var1, "Name: ", this.anInputTextField3955.getLocation().x, var10003, 1);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aMultiColorList3949) {
            this.method2464();
            if (var1.getID() == 2) {
                this.method2462((MultiColorListItem) ((MultiColorListItem) var1.getItem()));
            }
        } else if (var2 == this.aJComboBox3936) {
            if (this.aClientSettings_3932.aPlayerInfo_764.aBoolean778) {
                int var3 = this.aJComboBox3936.getSelectedIndex() + 1;
                if (this.aBoolean3951 && var3 == 1) {
                    this.aJComboBox3940.setVisible(false);
                    this.aBoolean3951 = false;
                }

                if (!this.aBoolean3951 && var3 > 1) {
                    this.aJComboBox3940.setVisible(true);
                    this.aBoolean3951 = true;
                }
            }

            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[1] = this.aJComboBox3936.getSelectedIndex();
        } else {
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[0] = this.aJComboBox3935.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[2] = this.aJComboBox3939.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[3] = this.aJComboBox3940.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[4] = this.aJComboBox3941.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[5] = this.aJComboBox3942.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[6] = this.aJComboBox3943.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[7] = this.aJComboBox3944.getSelectedIndex();
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[8] = this.aJComboBox3945.getSelectedIndex();
        }

        this.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aSPanel__3953 == null && this.aClientSettings_3932.gameApplet.aSynchronizedBool_4779.method1008()) {
            Object var2 = var1.getSource();
            if (var2 != this.aGlossyButton3947 && var2 != this.aGlossyButton3948) {
                String var3;
                if (var2 == this.aGlossyButton3946) {
                    this.aClientSettings_3932.gameApplet.setGameState(0);
                    var3 = this.aFilterTextField3937.getTextField().getText().trim();
                    String var6 = this.anInputTextField3938.getTextField().getText().trim();
                    if (var3.length() == 0) {
                        var3 = "-";
                    }

                    if (var6.length() == 0) {
                        var6 = "-";
                    }

                    this.aClientSettings_3932.lobbyPanel.method2453("create\t" + var3 + "\t" + var6 + "\t" + this.aJComboBox3939.getSelectedIndex() + "\t" + (this.aJComboBox3935.getSelectedIndex() + 2) + "\t" + (this.aJComboBox3936.getSelectedIndex() + 1) + "\t" + (1 - this.aJComboBox3940.getSelectedIndex()) + "\t" + this.aJComboBox3941.getSelectedIndex() + "\t" + LobbyPanel.anIntArray3924[this.aJComboBox3942.getSelectedIndex()] + "\t" + this.aJComboBox3943.getSelectedIndex() + "\t" + this.aJComboBox3944.getSelectedIndex() + "\t" + this.aJComboBox3945.getSelectedIndex());
                } else if (var2 == this.aGlossyButton3950) {
                    this.method2462(this.aMultiColorList3949.getSelectedItem());
                } else {
                    if (var2 == this.aColorButton3956) {
                        var3 = this.anInputTextField3955.getInputText(false);
                        if (var3.length() == 0) {
                            return;
                        }

                        Object[] var4 = this.method2472();
                        if (var4 == null) {
                            return;
                        }

                        if (var3.equals(var4[3])) {
                            return;
                        }

                        int[] var5 = (int[]) ((int[]) var4[0]);
                        this.aClientSettings_3932.lobbyPanel.method2453("changename\t" + var5[0] + "\t" + var3);
                    }

                }
            } else {
                this.aClientSettings_3932.aPlayerInfo_764.aBoolean778 = var2 == this.aGlossyButton3947;
                this.method2461();
                this.repaint();
            }
        }
    }

    protected void method2457(int var1) {
        this.anInt3952 = var1;
        this.repaint();
    }

    protected void method2458(int var1, String var2) {
        this.remove(this.aSPanel__3953);
        this.aSPanel__3953 = null;
        this.add(this.aMultiColorList3949);
        this.add(this.aGlossyButton3950);
        this.repaint();
        if (var2 != null) {
            this.aClientSettings_3932.gameApplet.setGameState(0);
            this.aClientSettings_3932.lobbyPanel.method2453("join\t" + var1 + "\t" + var2);
        }
    }

    protected boolean handlePacket(String[] var1) {
        if (var1[1].equals("gamelist")) {
            if (var1[2].equals("full")) {
                this.method2465(var1);
                this.repaint();
                return true;
            }

            if (var1[2].equals("add")) {
                this.method2466(var1);
                this.repaint();
                return true;
            }

            if (var1[2].equals("change")) {
                this.method2468(var1);
                this.repaint();
                return true;
            }

            if (var1[2].equals("remove")) {
                this.method2469(var1);
                this.repaint();
                return true;
            }
        }

        return false;
    }

    private void method2460() {
        this.aJComboBox3935 = new JComboBox();

        int var1;
        for (var1 = 2; var1 <= 8; ++var1) {
            this.aJComboBox3935.addItem("" + var1);
        }

        this.aJComboBox3935.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[0]);
        this.aJComboBox3935.addItemListener(this);
        this.aJComboBox3936 = new JComboBox();

        for (var1 = 1; var1 <= 20; ++var1) {
            this.aJComboBox3936.addItem("" + var1);
        }

        this.aJComboBox3936.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[1]);
        this.aJComboBox3936.addItemListener(this);
        this.aFilterTextField3937 = new FilterTextField(this.aClientSettings_3932.textManager, "-", 15);
        this.aFilterTextField3937.setBackground(Color.white);
        this.anInputTextField3938 = new InputTextField("-", 15);
        this.anInputTextField3938.setBackground(Color.white);
        this.aJComboBox3939 = new JComboBox();
        this.aJComboBox3939.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_OnlyForAll"));
        if (this.aClientSettings_3932.gameApplet.method2282()) {
            this.aJComboBox3939.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_OnlyForReg"));
        }

        var1 = this.aJComboBox3939.getItemCount();
        if (this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[2] >= var1) {
            this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[2] = var1 - 1;
        }

        this.aJComboBox3939.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[2]);
        this.aJComboBox3939.addItemListener(this);
        this.aJComboBox3940 = new JComboBox();
        this.aJComboBox3940.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAddIncreasing"));
        this.aJComboBox3940.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAddConstant"));
        this.aJComboBox3940.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WeaponAddDecreasing"));
        this.aJComboBox3940.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[3]);
        this.aJComboBox3940.addItemListener(this);
        this.aJComboBox3940.setVisible(false);
        this.add(this.aJComboBox3940);
        this.aJComboBox3941 = new JComboBox();
        this.aJComboBox3941.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayOrderTurns"));
        this.aJComboBox3941.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_PlayOrderSameTime"));
        this.aJComboBox3941.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[4]);
        this.aJComboBox3941.addItemListener(this);
        this.aJComboBox3942 = new JComboBox();

        for (int var2 = 0; var2 < LobbyPanel.anIntArray3924.length; ++var2) {
            if (LobbyPanel.anIntArray3924[var2] == 0) {
                this.aJComboBox3942.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_ThinkTimeUnlimited"));
            } else {
                this.aJComboBox3942.addItem("" + LobbyPanel.anIntArray3924[var2]);
            }
        }

        this.aJComboBox3942.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[5]);
        this.aJComboBox3942.addItemListener(this);
        this.aJComboBox3943 = new JComboBox();
        this.aJComboBox3943.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WindNone"));
        this.aJComboBox3943.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WindNormal"));
        this.aJComboBox3943.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_WindRandom"));
        this.aJComboBox3943.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[6]);
        this.aJComboBox3943.addItemListener(this);
        this.aJComboBox3944 = new JComboBox();
        this.aJComboBox3944.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_DudsNo"));
        this.aJComboBox3944.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_DudsYes"));
        this.aJComboBox3944.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[7]);
        this.aJComboBox3944.addItemListener(this);
        this.aJComboBox3945 = new JComboBox();
        this.aJComboBox3945.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_ScoringSurvive"));
        this.aJComboBox3945.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_ScoringDestroy"));
        this.aJComboBox3945.addItem(this.aClientSettings_3932.textManager.method2039("LobbyReal_ScoringBoth"));
        this.aJComboBox3945.setSelectedIndex(this.aClientSettings_3932.aPlayerInfo_764.anIntArray779[8]);
        this.aJComboBox3945.addItemListener(this);
        this.aGlossyButton3946 = new GlossyButton(this.aClientSettings_3932.textManager.method2039("LobbyReal_CreateGame"), 1);
        this.aGlossyButton3946.addActionListener(this);
        this.aGlossyButton3947 = new GlossyButton(this.aClientSettings_3932.textManager.method2039("LobbyReal_SettingsMore"), 3);
        this.aGlossyButton3947.addActionListener(this);
        this.aGlossyButton3948 = new GlossyButton(this.aClientSettings_3932.textManager.method2039("LobbyReal_SettingsLess"), 3);
        this.aGlossyButton3948.addActionListener(this);
        String[] var4 = new String[]{this.aClientSettings_3932.textManager.method2039("LobbyReal_ListTitleUserLimit"), this.aClientSettings_3932.textManager.method2039("LobbyReal_ListTitleGame"), this.aClientSettings_3932.textManager.method2039("LobbyReal_ListTitlePlayers"), this.aClientSettings_3932.textManager.method2039("LobbyReal_ListTitleRounds")};
        int[] var3 = new int[]{0, 0, 5, 5};
        this.aMultiColorList3949 = new MultiColorList(var4, var3, 2, this.anInt3933 / 2 - 50, 112);
        this.aMultiColorList3949.setLocation(this.anInt3933 / 2 + 30, 75);
        this.aMultiColorList3949.setSelectable(1);
        this.aMultiColorList3949.addItemListener(this);
        this.add(this.aMultiColorList3949);
        this.aGlossyButton3950 = new GlossyButton(this.aClientSettings_3932.textManager.method2039("LobbyReal_JoinGame"), 1);
        this.aGlossyButton3950.setBounds(this.anInt3933 * 3 / 4 - 50, 350, 100, 24);
        this.aGlossyButton3950.addActionListener(this);
        this.aGlossyButton3950.setVisible(false);
        this.add(this.aGlossyButton3950);
        if (this.aClientSettings_3932.gameApplet.method2283() >= 1) {
            this.anInputTextField3955 = new InputTextField(15);
            this.anInputTextField3955.setBounds(this.anInt3933 - 5 - 70 - 1 - 120, this.anInt3934 - 1 - 17, 120, 17);
            this.anInputTextField3955.setFullBoxTextField();
            this.anInputTextField3955.setVisible(false);
            this.add(this.anInputTextField3955);
            this.aColorButton3956 = new ColorButton("Change");
            this.aColorButton3956.setBounds(this.anInt3933 - 5 - 70, this.anInt3934 - 1 - 17, 70, 17);
            this.aColorButton3956.setBackground(new Color(255, 192, 0));
            this.aColorButton3956.addActionListener(this);
            this.aColorButton3956.setVisible(false);
            this.add(this.aColorButton3956);
        }

    }

    private void method2461() {
        this.remove(this.aJComboBox3935);
        this.remove(this.aJComboBox3936);
        this.remove(this.aFilterTextField3937);
        this.remove(this.anInputTextField3938);
        this.remove(this.aJComboBox3939);
        this.aJComboBox3940.setVisible(false);
        this.remove(this.aJComboBox3941);
        this.remove(this.aJComboBox3942);
        this.remove(this.aJComboBox3943);
        this.remove(this.aJComboBox3944);
        this.remove(this.aJComboBox3945);
        this.remove(this.aGlossyButton3946);
        this.remove(this.aGlossyButton3947);
        this.remove(this.aGlossyButton3948);
        byte var2;
        byte var3;
        if (this.aClientSettings_3932.aPlayerInfo_764.aBoolean778) {
            byte var1 = 45;
            var2 = 25;
            var3 = 20;
            this.aJComboBox3935.setBounds(this.anInt3933 / 2 - 170, var1, 100, var3);
            this.add(this.aJComboBox3935);
            this.aJComboBox3936.setBounds(this.anInt3933 / 2 - 170, var1 + var2, 100, var3);
            this.add(this.aJComboBox3936);
            this.aFilterTextField3937.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 2, 150, var3 - 2);
            if (this.aClientSettings_3932.gameApplet.method2282()) {
                this.add(this.aFilterTextField3937);
            }

            this.anInputTextField3938.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 3, 150, var3 - 2);
            this.add(this.anInputTextField3938);
            if (this.aClientSettings_3932.gameApplet.method2282()) {
                this.aJComboBox3939.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 4, 150, var3);
                this.add(this.aJComboBox3939);
            }

            int var4 = this.aJComboBox3936.getSelectedIndex() + 1;
            this.aBoolean3951 = var4 > 1;
            this.aJComboBox3940.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 5, 150, var3);
            if (this.aBoolean3951) {
                this.aJComboBox3940.setVisible(true);
            }

            this.aJComboBox3941.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 7, 150, var3);
            this.add(this.aJComboBox3941);
            this.aJComboBox3942.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 8, 100, var3);
            this.add(this.aJComboBox3942);
            this.aJComboBox3943.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 9, 100, var3);
            this.add(this.aJComboBox3943);
            this.aJComboBox3944.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 10, 100, var3);
            this.add(this.aJComboBox3944);
            this.aJComboBox3945.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 11, 150, var3);
            this.add(this.aJComboBox3945);
            this.aGlossyButton3946.setBounds(this.anInt3933 / 2 - 170, var1 + var2 * 13 + 2 - 15, 125, var3);
            this.add(this.aGlossyButton3946);
            this.aGlossyButton3948.setBounds(10, this.anInt3934 - 50, 75, 20);
            this.add(this.aGlossyButton3948);
        } else {
            short var5 = 150;
            var2 = 30;
            var3 = 24;
            this.aJComboBox3935.setBounds(this.anInt3933 / 2 - 170, var5, 100, var3);
            this.add(this.aJComboBox3935);
            this.aJComboBox3936.setBounds(this.anInt3933 / 2 - 170, var5 + var2, 100, var3);
            this.add(this.aJComboBox3936);
            this.aGlossyButton3946.setBounds(this.anInt3933 / 2 - 170, var5 + var2 * 3, 125, var3);
            this.add(this.aGlossyButton3946);
            this.aGlossyButton3947.setBounds(10, var5 + var2 * 2, 75, 20);
            this.add(this.aGlossyButton3947);
        }

    }

    private void method2462(MultiColorListItem var1) {
        this.anInt3952 = 0;
        this.repaint();
        if (var1 != null) {
            Object[] var2 = (Object[]) ((Object[]) var1.getData());
            int[] var3 = (int[]) ((int[]) var2[0]);
            if (var3[9] == 0) {
                this.repaint();
            } else if (var3[2] == 1 && !this.aClientSettings_3932.gameApplet.method2282()) {
                this.anInt3952 = 4;
                this.repaint();
            } else if (var3[1] == 1) {
                this.method2463(var3[0]);
            } else {
                this.aClientSettings_3932.gameApplet.setGameState(0);
                this.aClientSettings_3932.lobbyPanel.method2453("join\t" + var3[0]);
            }
        }
    }

    private void method2463(int var1) {
        this.remove(this.aMultiColorList3949);
        this.remove(this.aGlossyButton3950);
        this.aSPanel__3953 = new LobbyPasswordPanel(this.aClientSettings_3932, this, var1);
        this.aSPanel__3953.setLocation(this.anInt3933 * 3 / 4 - 100, this.anInt3934 / 2 - 30 - 50);
        this.add(this.aSPanel__3953);
    }

    private void method2464() {
        boolean var1 = false;
        Object[] var2 = this.method2472();
        if (var2 != null) {
            int[] var3 = (int[]) ((int[]) var2[0]);
            if (var3[9] == 1) {
                var1 = true;
            }
        }

        this.aGlossyButton3950.setVisible(var1);
        if (var2 != null && this.aClientSettings_3932.gameApplet.method2283() == 1) {
            this.aString3954 = (String) ((String) var2[2]);
            this.anInputTextField3955.getTextField().setText((String) ((String) var2[3]));
            this.anInputTextField3955.setVisible(true);
            this.aColorButton3956.setVisible(true);
        } else if (this.aString3954 != null) {
            this.aString3954 = null;
            this.anInputTextField3955.setVisible(false);
            this.aColorButton3956.setVisible(false);
        }

        this.repaint();
    }

    private void method2465(String[] var1) {
        int var2 = Integer.parseInt(var1[3]);
        this.aMultiColorList3949.removeAllItems();

        for (int var3 = 0; var3 < var2; ++var3) {
            this.method2467(var1, 4 + var3 * 16, -1);
        }

        this.method2464();
        this.anInt3952 = 0;
        this.repaint();
    }

    private void method2466(String[] var1) {
        this.method2467(var1, 3, this.aMultiColorList3949.getItemCount() == 0 ? Integer.parseInt(var1[3]) : -1);
        this.method2464();
    }

    private void method2467(String[] var1, int var2, int var3) {
        int var4 = Integer.parseInt(var1[var2]);
        String var5 = var1[var2 + 1];
        boolean var6 = var1[var2 + 2].equals("t");
        int var7 = Integer.parseInt(var1[var2 + 3]);
        int var8 = Integer.parseInt(var1[var2 + 4]);
        int var9 = Integer.parseInt(var1[var2 + 5]);
        int var10 = Integer.parseInt(var1[var2 + 6]);
        int var11 = Integer.parseInt(var1[var2 + 7]);
        int var12 = Integer.parseInt(var1[var2 + 8]);
        int var13 = Integer.parseInt(var1[var2 + 9]);
        boolean var14 = var1[var2 + 10].equals("t");
        int var15 = Integer.parseInt(var1[var2 + 11]);
        String var16 = var1[var2 + 12];
        boolean var17 = var1[var2 + 13].equals("t");
        int var18 = Integer.parseInt(var1[var2 + 14]);
        String var19 = var1[var2 + 15];
        String[] var20 = new String[4];
        var20[0] = "";
        byte var21 = 0;
        if (!var17) {
            var21 = 7;
        } else if (var7 == 1 && var6) {
            var20[0] = this.aClientSettings_3932.textManager.method2039("LobbyReal_ListRegOnlyAndPassword");
            var21 = 1;
        } else if (var6) {
            var20[0] = this.aClientSettings_3932.textManager.method2039("LobbyReal_ListPassword");
            var21 = 1;
        } else if (var7 == 1) {
            var20[0] = this.aClientSettings_3932.textManager.method2039("LobbyReal_ListRegOnly");
        }

        var20[1] = var5;
        var20[2] = var17 ? var18 + " / " + var8 : "" + var18;
        var20[3] = "" + var9;
        int[] var22 = new int[]{var4, var6 ? 1 : 0, var7, var10, var11, var12, var13, var14 ? 1 : 0, var15, var17 ? 1 : 0};
        Object[] var23 = new Object[]{var22, var19, var16, var5};
        MultiColorListItem var24 = new MultiColorListItem(var21, false, var20, var23, var4 == var3);
        if (!var17) {
            var24.setOverrideColor(new Color(192, 192, 192));
        }

        this.aMultiColorList3949.addItem(var24);
    }

    private void method2468(String[] var1) {
        int var2 = this.method2471();
        this.method2470(Integer.parseInt(var1[3]));
        this.method2467(var1, 3, var2);
        this.method2464();
    }

    private void method2469(String[] var1) {
        int var2 = this.method2471();
        int var3 = Integer.parseInt(var1[3]);
        this.method2470(var3);
        this.method2464();
        if (var2 == var3) {
            this.anInt3952 = 0;
            this.repaint();
        }

    }

    private void method2470(int var1) {
        MultiColorList var2 = this.aMultiColorList3949;
        synchronized (this.aMultiColorList3949) {
            MultiColorListItem[] var3 = this.aMultiColorList3949.getAllItems();
            if (var3 != null) {
                int var4 = var3.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    Object[] var6 = (Object[]) ((Object[]) var3[var5].getData());
                    int[] var7 = (int[]) ((int[]) var6[0]);
                    if (var7[0] == var1) {
                        this.aMultiColorList3949.removeItem(var3[var5]);
                        return;
                    }
                }

            }
        }
    }

    private int method2471() {
        Object[] var1 = this.method2472();
        if (var1 == null) {
            return -1;
        } else {
            int[] var2 = (int[]) ((int[]) var1[0]);
            return var2[0];
        }
    }

    private Object[] method2472() {
        MultiColorListItem var1 = this.aMultiColorList3949.getSelectedItem();
        return var1 == null ? null : (Object[]) ((Object[]) var1.getData());
    }

    static {
        aStringArray3957[0] = " / ";
        aStringArray3957[1] = "LobbyReal_ListRegOnlyAndPassword";
        aStringArray3957[2] = "LobbyReal_ListRegOnly";
        aStringArray3957[3] = "LobbyReal_ListPassword";
        aStringArray3957[4] = "join\t";
        aStringArray3957[5] = "LobbyReal_NumberOfRounds";
        aStringArray3957[6] = "Increasing";
        aStringArray3957[7] = "LobbyReal_GameName";
        aStringArray3957[8] = "LobbyReal_ThinkTime";
        aStringArray3957[9] = "Random";
        aStringArray3957[10] = "Decreasing";
        aStringArray3957[11] = "LobbyReal_GameStartedNote";
        aStringArray3957[12] = "LobbyReal_PlayerList";
        aStringArray3957[13] = "AlreadyStarted";
        aStringArray3957[14] = "LobbyReal_JoinGameTitle";
        aStringArray3957[15] = "LobbyReal_OnlyFor";
        aStringArray3957[16] = "LobbyReal_Wind";
        aStringArray3957[17] = "Turns";
        aStringArray3957[18] = "Both";
        aStringArray3957[19] = "SameTime";
        aStringArray3957[20] = "Name: ";
        aStringArray3957[21] = "LobbyReal_ThinkTimeUnlimited";
        aStringArray3957[22] = "Constant";
        aStringArray3957[23] = "Info";
        aStringArray3957[24] = "Survive";
        aStringArray3957[25] = "WrongPassword";
        aStringArray3957[26] = "LobbyReal_PlayOrder";
        aStringArray3957[27] = "LobbyReal_JoinError";
        aStringArray3957[28] = "None";
        aStringArray3957[29] = "Creator: ";
        aStringArray3957[30] = "Destroy";
        aStringArray3957[31] = "LobbyReal_Duds";
        aStringArray3957[32] = "LobbyReal_WeaponAdd";
        aStringArray3957[33] = "NotExist";
        aStringArray3957[34] = "LobbyReal_QuickHelpMulti";
        aStringArray3957[35] = "LobbyReal_NumberOfPlayers";
        aStringArray3957[36] = "LobbyReal_DudsYes";
        aStringArray3957[37] = "LobbyReal_Scoring";
        aStringArray3957[38] = "LobbyReal_CreateGameTitle";
        aStringArray3957[39] = "LobbyReal_GamePassword";
        aStringArray3957[40] = "RegOnly";
        aStringArray3957[41] = "create\t";
        aStringArray3957[42] = "changename\t";
        aStringArray3957[43] = "gamelist";
        aStringArray3957[44] = "change";
        aStringArray3957[45] = "remove";
        aStringArray3957[46] = "add";
        aStringArray3957[47] = "full";
        aStringArray3957[48] = "LobbyReal_PlayOrderTurns";
        aStringArray3957[49] = "LobbyReal_ListTitlePlayers";
        aStringArray3957[50] = "LobbyReal_WindNone";
        aStringArray3957[51] = "LobbyReal_WeaponAddIncreasing";
        aStringArray3957[52] = "LobbyReal_SettingsLess";
        aStringArray3957[53] = "LobbyReal_OnlyForReg";
        aStringArray3957[54] = "Change";
        aStringArray3957[55] = "LobbyReal_ScoringBoth";
        aStringArray3957[56] = "LobbyReal_DudsNo";
        aStringArray3957[57] = "LobbyReal_WindRandom";
        aStringArray3957[58] = "LobbyReal_ScoringSurvive";
        aStringArray3957[59] = "LobbyReal_ListTitleRounds";
        aStringArray3957[60] = "LobbyReal_PlayOrderSameTime";
        aStringArray3957[61] = "LobbyReal_SettingsMore";
        aStringArray3957[62] = "LobbyReal_OnlyForAll";
        aStringArray3957[63] = "LobbyReal_WeaponAddDecreasing";
        aStringArray3957[64] = "LobbyReal_ListTitleGame";
        aStringArray3957[65] = "LobbyReal_ScoringDestroy";
        aStringArray3957[66] = "LobbyReal_WeaponAddConstant";
        aStringArray3957[67] = "LobbyReal_JoinGame";
        aStringArray3957[68] = "LobbyReal_ListTitleUserLimit";
        aStringArray3957[69] = "LobbyReal_WindNormal";
        aStringArray3957[70] = "LobbyReal_CreateGame";
        aColor3931 = new Color(255, 255, 0);
    }
}
