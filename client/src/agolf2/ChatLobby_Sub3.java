package agolf2;

import com.aapeli.multiuser.ChatListener;
import com.aapeli.multiuser.ChatLobby;

public class ChatLobby_Sub3 extends ChatLobby implements ChatListener {

    private static boolean aBoolean3708;
    private Class58_Sub1 aClass58_Sub1_3709;
    private IPanel_Sub37 anIPanel_Sub37_3710;
    private static final String[] aStringArray3711 = new String[12];


    public ChatLobby_Sub3(Class58_Sub1 var1, IPanel_Sub37 var2, int var3, int var4, int var5, int var6) {
        super(var1.aParameters1186, var1.textManager, var1.imageManager, var1.aBadWordFilter3571, var5, var6);
        this.useRoundButtons();
        this.aClass58_Sub1_3709 = var1;
        this.anIPanel_Sub37_3710 = var2;
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setForeground(AApplet_Sub3.aColor3779);
        this.setLocation(var3, var4);
        int var7 = var1.anAApplet_Sub3_Sub1_3567.method59();
        this.enablePopUp(var7 >= 1, var7 >= 2);
        if (var1.anAApplet_Sub3_Sub1_3567.method58() == 0) {
            this.disableChatInput(1);
        } else if (var1.anAApplet_Sub3_Sub1_3567.method61()) {
            this.disableChatInput(2);
        }

        this.addChatListener(this);
    }

    public void localUserSay(String var1) {
        this.anIPanel_Sub37_3710.method791("say\t" + var1);
    }

    public void localUserSayPrivately(String var1, String var2) {
        this.anIPanel_Sub37_3710.method791("say\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2) {
        this.anIPanel_Sub37_3710.method791("command\t" + var1 + "\t" + var2);
    }

    public void localUserAdminCommand(String var1, String var2, String var3) {
        this.anIPanel_Sub37_3710.method791("command\t" + var1 + "\t" + var2 + "\t" + var3);
    }

    protected boolean method910(String[] var1) {
        if (var1[1].equals("users")) {
            int var5 = var1.length - 2;
            String[] var6 = new String[var5];

            for (int var4 = 0; var4 < var5; ++var4) {
                var6[var4] = var1[2 + var4];
            }

            this.setFullUserList(var6);
            return true;
        } else if (var1[1].equals("ownjoin")) {
            this.method912();
            this.localUserJoin(var1[2]);
            return true;
        } else {
            boolean var2 = var1[1].equals("return");
            if (!var1[1].equals("join") && !var2) {
                if (!var1[1].equals("part")) {
                    if (var1[1].equals("say")) {
                        this.userSay(var1[2], var1[3]);
                        return true;
                    } else if (var1[1].equals("sayp")) {
                        this.userSayPrivately(var1[2], var1[3]);
                        return true;
                    } else if (var1[1].equals("sheriffsay")) {
                        this.sheriffSay(var1[2]);
                        return true;
                    } else if (var1[1].equals("serversay")) {
                        this.serverSay(var1[2]);
                        return true;
                    } else if (var1[1].equals("nc")) {
                        this.gui_userlist.setNotAcceptingChallenges(this.gui_userlist.getUser(var1[2]), var1[3].equals("t"));
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    int var3 = Integer.parseInt(var1[3]);
                    if (var3 == 1) {
                        this.userLeft(var1[2], false);
                    }

                    if (var3 == 2) {
                        this.userLeft(var1[2], true);
                    }

                    if (var3 == 3 || var3 == 4) {
                        this.userLeftJoinedGame(var1[2], var1[4]);
                    }

                    if (var3 == 5) {
                        this.userLeftWatchingGame(var1[2], var1[4]);
                    }

                    return true;
                }
            } else {
                this.userJoin(var1[2], var2);
                return true;
            }
        }
    }

    public void method911() {
        this.gui_userlist.setNotAcceptingChallenges(this.gui_userlist.getLocalUser(), this.aClass58_Sub1_3709.aClass59_Sub1_3569.aBoolean3587);
    }

    private void method912() {
        if (aBoolean3708) {
            this.addLine();
            String var1 = this.aClass58_Sub1_3709.anAApplet_Sub3_Sub1_3567.method70();
            if (var1 != null) {
                this.addPlainMessage(var1);
                this.addLine();
            }

            aBoolean3708 = false;
        } else {
            this.clearOutput();
        }

    }

    static {
        aStringArray3711[0] = "say\t";
        aStringArray3711[1] = "command\t";
        aStringArray3711[2] = "users";
        aStringArray3711[3] = "say";
        aStringArray3711[4] = "return";
        aStringArray3711[5] = "serversay";
        aStringArray3711[6] = "part";
        aStringArray3711[7] = "sheriffsay";
        aStringArray3711[8] = "sayp";
        aStringArray3711[9] = "join";
        aStringArray3711[10] = "ownjoin";
        aStringArray3711[11] = "nc";
        aBoolean3708 = true;
    }
}
