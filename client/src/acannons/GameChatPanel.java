package acannons;

import com.playray.client.InputTextField;
import com.playray.client.SPanel;
import com.playray.client.UrlLabel;
import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.ChatBase;
import com.playray.multiuser.ChatTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameChatPanel extends SPanel implements KeyListener, ActionListener {

    private ClientSettings aClientSettings_3849;
    private GamePanel aSPanel__3850;
    private int anInt3851;
    private int anInt3852;
    private String aString3853;
    private boolean aBoolean3854;
    private ChatTextArea aChatTextArea3855;
    private InputTextField anInputTextField3856;
    private GlossyButton aGlossyButton3857;
    private GlossyButton aGlossyButton3858;
    private static final String[] aStringArray3859 = new String[45];


    protected GameChatPanel(ClientSettings var1, GamePanel var2, int var3, int var4) {
        super(false);
        this.aClientSettings_3849 = var1;
        this.aSPanel__3850 = var2;
        this.anInt3851 = var3;
        this.anInt3852 = var4;
        this.setSize(var3, var4);
        this.setBackground(GameApplet.aColor4781);
        this.setForeground(GameApplet.aColor4782);
        this.aBoolean3854 = true;
        this.method2410();
        this.method2411();
    }

    public void keyPressed(KeyEvent var1) {
        if (var1.getSource() == this.anInputTextField3856 && var1.getKeyCode() == 10) {
            this.method2412();
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 != this.anInputTextField3856.getTextField() && var2 != this.aGlossyButton3857) {
            if (this.aString3853 != null && var2 == this.aGlossyButton3858) {
                String var3 = this.anInputTextField3856.getInputText();
                if (var3.length() > 0) {
                    this.aSPanel__3850.method2424("shout\t" + var3);
                    this.aSPanel__3850.method2427(var3);
                }
            }
        } else {
            this.method2412();
        }

    }

    protected boolean handlePacket(String[] var1) {
        String var12;
        if (var1[1].equals("gameinfo")) {
            var12 = var1[4];
            boolean var13 = var1[5].equals("t");
            int var14 = Integer.parseInt(var1[6]);
            int var5 = Integer.parseInt(var1[7]);
            int var6 = Integer.parseInt(var1[8]);
            int var7 = Integer.parseInt(var1[9]);
            int var8 = Integer.parseInt(var1[10]);
            int var9 = Integer.parseInt(var1[12]);
            boolean var10 = var1[11].equals("t");
            String var11 = "";
            if (var13) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("GameChat_GameSettingsPasswordNeeded") + ", ";
            }

            if (var14 > 0) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("GameChat_GameSettingsRegisteredOnly") + ", ";
            }

            var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WeaponAdd") + " ";
            if (var5 == 1) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WeaponAddIncreasing");
            } else if (var5 == 0) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WeaponAddConstant");
            } else if (var5 == -1) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WeaponAddDecreasing");
            }

            var11 = var11 + ", " + this.aClientSettings_3849.textManager.method2039("LobbyReal_PlayOrder") + " ";
            if (var6 == 0) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_PlayOrderTurns");
            } else if (var6 == 1) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_PlayOrderSameTime");
            }

            if (var7 > 0) {
                var11 = var11 + ", " + this.aClientSettings_3849.textManager.method2039("LobbyReal_ThinkTime") + " " + var7;
            }

            var11 = var11 + ", " + this.aClientSettings_3849.textManager.method2039("LobbyReal_Wind") + " ";
            if (var8 == 0) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WindNone");
            } else if (var8 == 1) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WindNormal");
            } else if (var8 == 2) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_WindRandom");
            }

            if (var10) {
                var11 = var11 + ", " + this.aClientSettings_3849.textManager.method2039("LobbyReal_Duds") + " " + this.aClientSettings_3849.textManager.method2039("LobbyReal_DudsYes");
            }

            var11 = var11 + ", " + this.aClientSettings_3849.textManager.method2039("LobbyReal_Scoring") + " ";
            if (var9 == 0) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_ScoringSurvive");
            } else if (var9 == 1) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_ScoringDestroy");
            } else if (var9 == 2) {
                var11 = var11 + this.aClientSettings_3849.textManager.method2039("LobbyReal_ScoringBoth");
            }

            this.method2413(this.aClientSettings_3849.textManager.method2040("GameChat_GameName", var12));
            this.method2413(this.aClientSettings_3849.textManager.method2040("GameChat_GameSettings", var11));
            return true;
        } else if (var1[1].equals("owninfo")) {
            this.aString3853 = var1[3];
            return true;
        } else if (var1[1].equals("join")) {
            if (var1[4].length() <= 1) {
                this.method2413(this.aClientSettings_3849.textManager.method2040("GameChat_PlayerJoin", var1[3]));
            } else {
                this.method2413(this.aClientSettings_3849.textManager.method2041("GameChat_PlayerJoinClan", var1[3], var1[4]));
            }

            return true;
        } else if (var1[1].equals("part")) {
            this.method2413(this.aClientSettings_3849.textManager.method2040("GameChat_PlayerLeft" + (Integer.parseInt(var1[3]) == 2 ? "ConnectionProblem" : ""), this.aSPanel__3850.method2422(Integer.parseInt(var1[2]))));
            return true;
        } else if (var1[1].equals("say")) {
            var12 = var1[3];
            if (this.aClientSettings_3849.badWordFilter != null) {
                var12 = this.aClientSettings_3849.badWordFilter.filter(var12);
            }

            this.aChatTextArea3855.addSay(var1[2], var12);
            return true;
        } else if (var1[1].equals("startgame")) {
            if (this.aBoolean3854) {
                this.aBoolean3854 = false;
            } else {
                this.method2414(this.aClientSettings_3849.textManager.method2039("GameChat_NewGameStarted"));
            }

            return true;
        } else if (var1[1].equals("endround") && var1.length > 2) {
            int var2 = Integer.parseInt(var1[2]) + 1;
            int var3 = Integer.parseInt(var1[3]);
            String var4;
            if (var3 == -1) {
                var4 = this.aClientSettings_3849.textManager.method2045("GameChat_RoundNoWinner", var2);
            } else {
                var4 = this.aClientSettings_3849.textManager.method2041("GameChat_RoundWinner", this.aSPanel__3850.method2422(var3), "" + var2);
            }

            this.method2414(var4);
            return true;
        } else if (var1[1].equals("endgame")) {
            this.method2414(this.aClientSettings_3849.textManager.method2039("GameChat_GameOver"));
            return true;
        } else {
            return false;
        }
    }

    protected void broadcastMessage(String var1) {
        this.aChatTextArea3855.addBroadcastMessage(var1);
    }

    private void method2410() {
        boolean var1 = false;
        var1 = this.aClientSettings_3849.gameApplet.method2282();
        this.aChatTextArea3855 = new ChatTextArea(this.aClientSettings_3849.textManager, this.anInt3851, this.anInt3852 - 22 - 2);
        this.aChatTextArea3855.setLocation(0, 0);
        this.add(this.aChatTextArea3855);
        this.anInputTextField3856 = new InputTextField(this.aClientSettings_3849.textManager.method2039("GameChat_InputHelp"), 200, true);
        this.anInputTextField3856.setBounds(0, this.anInt3852 - 22, this.anInt3851 - 70 - 1 - (var1 ? 71 : 0), 22);
        this.anInputTextField3856.getTextField().addActionListener(this);
        this.add(this.anInputTextField3856);
        this.aGlossyButton3857 = new GlossyButton(this.aClientSettings_3849.textManager.method2039("GameChat_SayButton"), 3);
        this.aGlossyButton3857.setBounds(this.anInt3851 - 70 - (var1 ? 71 : 0), this.anInt3852 - 22, 70, 22);
        this.aGlossyButton3857.addActionListener(this);
        this.add(this.aGlossyButton3857);
        this.aGlossyButton3858 = new GlossyButton(this.aClientSettings_3849.textManager.method2039("GameChat_ShoutButton") + "", 4);
        if (var1) {
            this.aGlossyButton3858.setBounds(this.anInt3851 - 70, this.anInt3852 - 22, 70, 22);
            this.aGlossyButton3858.addActionListener(this);
            this.add(this.aGlossyButton3858);
        }

    }

    private void method2411() {
        byte var1 = 0;
        if (!this.aClientSettings_3849.gameApplet.method2282()) {
            var1 = 1;
        } else if (this.aClientSettings_3849.gameApplet.method2284()) {
            var1 = 2;
        }

        if (var1 != 0) {
            ChatBase.setInputByCIDR(var1, this, this.anInputTextField3856, this.aGlossyButton3857, (UrlLabel) null, this.aClientSettings_3849.textManager, this.aClientSettings_3849.params);
        }

    }

    private void method2412() {
        if (this.aString3853 != null) {
            String var1 = this.anInputTextField3856.getInputText();
            if (var1.length() > 0) {
                this.aSPanel__3850.method2424("say\t" + var1);
                this.aChatTextArea3855.addOwnSay(this.aString3853, var1);
            }

        }
    }

    private void method2413(String var1) {
        this.aChatTextArea3855.addMessage(var1);
    }

    private void method2414(String var1) {
        this.aChatTextArea3855.addPlainMessage(this.aClientSettings_3849.textManager.method2040("GameChat_GameMessage", var1));
    }

    static {
        aStringArray3859[0] = "shout\t";
        aStringArray3859[1] = "say\t";
        aStringArray3859[2] = "GameChat_GameMessage";
        aStringArray3859[3] = "GameChat_GameOver";
        aStringArray3859[4] = "LobbyReal_ScoringSurvive";
        aStringArray3859[5] = "LobbyReal_WeaponAddConstant";
        aStringArray3859[6] = "LobbyReal_ScoringBoth";
        aStringArray3859[7] = "GameChat_NewGameStarted";
        aStringArray3859[8] = "LobbyReal_WindRandom";
        aStringArray3859[9] = "LobbyReal_ThinkTime";
        aStringArray3859[10] = "LobbyReal_WeaponAdd";
        aStringArray3859[11] = "endround";
        aStringArray3859[12] = "GameChat_GameSettings";
        aStringArray3859[13] = "GameChat_PlayerJoinClan";
        aStringArray3859[14] = "owninfo";
        aStringArray3859[15] = "startgame";
        aStringArray3859[16] = "part";
        aStringArray3859[17] = "LobbyReal_PlayOrder";
        aStringArray3859[18] = "gameinfo";
        aStringArray3859[19] = "LobbyReal_PlayOrderSameTime";
        aStringArray3859[20] = "LobbyReal_DudsYes";
        aStringArray3859[21] = "endgame";
        aStringArray3859[22] = "LobbyReal_Duds";
        aStringArray3859[23] = "LobbyReal_Wind";
        aStringArray3859[24] = "GameChat_RoundNoWinner";
        aStringArray3859[25] = "GameChat_PlayerLeft";
        aStringArray3859[26] = "say";
        aStringArray3859[27] = "GameChat_GameName";
        aStringArray3859[28] = "LobbyReal_Scoring";
        aStringArray3859[29] = "LobbyReal_WeaponAddDecreasing";
        aStringArray3859[30] = "join";
        aStringArray3859[31] = "LobbyReal_ScoringDestroy";
        aStringArray3859[32] = "LobbyReal_PlayOrderTurns";
        aStringArray3859[33] = "ConnectionProblem";
        aStringArray3859[34] = "GameChat_GameSettingsPasswordNeeded";
        aStringArray3859[35] = "LobbyReal_WindNormal";
        aStringArray3859[36] = "LobbyReal_WindNone";
        aStringArray3859[37] = "LobbyReal_WeaponAddIncreasing";
        aStringArray3859[38] = "GameChat_GameSettingsRegisteredOnly";
        aStringArray3859[39] = ", ";
        aStringArray3859[40] = "GameChat_PlayerJoin";
        aStringArray3859[41] = "GameChat_RoundWinner";
        aStringArray3859[42] = "GameChat_SayButton";
        aStringArray3859[43] = "GameChat_ShoutButton";
        aStringArray3859[44] = "GameChat_InputHelp";
    }
}
