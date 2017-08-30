package agolf2;

import com.aapeli.multiuser.ChatGame;
import com.aapeli.multiuser.ChatGameListener;
import com.aapeli.multiuser.ChatListener;

class ChatGame_Sub1 extends ChatGame implements ChatListener, ChatGameListener {

    private Class58_Sub1 aClass58_Sub1_3701;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_3702;
    private static final String[] aStringArray3703 = new String[17];


    protected ChatGame_Sub1(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, boolean var3) {
        super(var1.aParameters1186, var1.textManager, var1.imageManager, var1.aBadWordFilter3571, false, var3, 480, 100);
        this.setMessageMaximumLength(150);
        this.useRoundButtons();
        this.aClass58_Sub1_3701 = var1;
        this.anIPanel_Sub28_Sub1_3702 = var2;
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setForeground(AApplet_Sub3.aColor3779);
        if (var1.anAApplet_Sub3_Sub1_3567.method58() == 0) {
            this.disableChatInput(1);
        } else if (var1.anAApplet_Sub3_Sub1_3567.method61()) {
            this.disableChatInput(2);
        }

        this.addChatListener(this);
        this.addChatGameListener(this);
    }

    public void localUserSay(String var1) {
        this.anIPanel_Sub28_Sub1_3702.method695("say\t" + var1);
    }

    public void localUserSayPrivately(String var1, String var2) {
        this.anIPanel_Sub28_Sub1_3702.method695("say\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2) {
        this.anIPanel_Sub28_Sub1_3702.method695("command\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2, String var3) {
        this.anIPanel_Sub28_Sub1_3702.method695("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    public void localUserKick(String var1) {
        this.anIPanel_Sub28_Sub1_3702.method695("kick\t" + var1);
    }

    public void localUserBan(String var1) {
        this.anIPanel_Sub28_Sub1_3702.method695("ban\t" + var1);
    }

    protected void method900(String var1) {
        this.addPlainMessage(this.aClass58_Sub1_3701.textManager.getGame("Game_Chat_FirstGameStart", var1));
    }

    protected void method901() {
        this.addPlainMessage(this.aClass58_Sub1_3701.textManager.getGame("Game_Chat_GameStart"));
    }

    protected void method902() {
        this.addPlainMessage(this.aClass58_Sub1_3701.textManager.getGame("Game_Chat_GameEnd"));
    }

    protected void method903(int var1, String[] var2, String[] var3, int var4) {
        this.setFullUserList(var2, var4);

        for (int var5 = 0; var5 < var1; ++var5) {
            this.changeToPlayer(var3[var5]);
        }

    }

    protected boolean method904(String[] var1) {
        int var2;
        if (var1[1].equals("users")) {
            var2 = var1.length - 2;
            String[] var6 = new String[var2];

            for (int var4 = 0; var4 < var2; ++var4) {
                var6[var4] = var1[2 + var4];
            }

            this.setFullUserList(var6);
            return true;
        } else if (var1[1].equals("ojoin")) {
            this.localUserJoin(var1[2]);
            return true;
        } else if (var1[1].equals("sjoin")) {
            this.spectatorJoin(var1[2]);
            return true;
        } else if (!var1[1].equals("spart")) {
            if (var1[1].equals("part")) {
                String var5 = this.anIPanel_Sub28_Sub1_3702.anIPanel_Sub31_3643.method744(Integer.parseInt(var1[2])).method1327();
                int var3 = Integer.parseInt(var1[3]);
                if (var3 == 6) {
                    this.addPlainMessage(this.aClass58_Sub1_3701.textManager.getGame("Game_Chat_PlayerTimedOut", var5));
                }

                this.playerLeft(var5, var3 == 2);
                return true;
            } else if (var1[1].equals("say")) {
                this.userSay(var1[2], var1[3]);
                return true;
            } else if (var1[1].equals("sayp")) {
                this.localUserSayPrivately(var1[2], var1[3]);
                return true;
            } else if (var1[1].equals("sheriffsay")) {
                this.sheriffSay(var1[2]);
                return true;
            } else if (var1[1].equals("serversay")) {
                this.serverSay(var1[2]);
                return true;
            } else {
                return false;
            }
        } else {
            var2 = Integer.parseInt(var1[3]);
            this.spectatorLeft(var1[2], var2 == 7 || var2 == 8);
            return true;
        }
    }

    static {
        aStringArray3703[0] = "Game_Chat_GameStart";
        aStringArray3703[1] = "say\t";
        aStringArray3703[2] = "Game_Chat_GameEnd";
        aStringArray3703[3] = "kick\t";
        aStringArray3703[4] = "serversay";
        aStringArray3703[5] = "say";
        aStringArray3703[6] = "ojoin";
        aStringArray3703[7] = "users";
        aStringArray3703[8] = "sjoin";
        aStringArray3703[9] = "spart";
        aStringArray3703[10] = "sayp";
        aStringArray3703[11] = "part";
        aStringArray3703[12] = "Game_Chat_PlayerTimedOut";
        aStringArray3703[13] = "sheriffsay";
        aStringArray3703[14] = "ban\t";
        aStringArray3703[15] = "command\t";
        aStringArray3703[16] = "Game_Chat_FirstGameStart";
    }
}
