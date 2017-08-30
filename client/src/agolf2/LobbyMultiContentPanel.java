package agolf2;

import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.TabBar;
import com.aapeli.colorgui.TabBarListener;
import com.aapeli.multiuser.UserList;

import java.awt.Graphics;

public class LobbyMultiContentPanel extends IPanel_Sub37 implements TabBarListener {

    private static int anInt3672;
    private IPanel_Sub5 anIPanel_Sub5_3673;
    private TabBar aTabBar3674;
    private TabBar aTabBar3675;
    private IPanel_Sub38 anIPanel_Sub38_3676;
    private LobbyMultiJoinPanel anLobbyMultiJoinPanel__3677;
    private IPanel_Sub12 anIPanel_Sub12_3678;
    private IPanel_Sub10 anIPanel_Sub10_3679;
    private LobbyMultiInvitePanel anLobbyMultiInvitePanel__3680;
    public static boolean aBoolean3681;
    private static final String[] aStringArray3682 = new String[43];


    public LobbyMultiContentPanel(Class58_Sub1 var1, int var2, int var3) {
        super(var1, var2, var3, "lobby2");
        this.method800();
    }

    public void selectedTabChanged(int var1) {
        anInt3672 = var1;
    }

    public boolean method782(String[] var1) {
        if (var1[1].equals("gamelist")) {
            if (var1[2].equals("full")) {
                this.method801(var1);
                return true;
            }

            if (var1[2].equals("add")) {
                this.method802(var1, 3, true);
                return true;
            }

            if (var1[2].equals("remove")) {
                this.method803(var1);
                return true;
            }

            if (var1[2].equals("change")) {
                this.method804(var1);
                return true;
            }
        }

        if (var1[1].equals("gotowait")) {
            int var10 = Integer.parseInt(var1[2]);
            boolean var8 = var1[3].equals("t");
            LobbyGameInfo var9 = this.anLobbyMultiJoinPanel__3677.method557(var10);
            this.anIPanel_Sub10_3679.method572(var9, var8);
            this.remove(this.aTabBar3674);
            this.add(this.aTabBar3675);
            this.anLobbyMultiInvitePanel__3680.method519(true);
            return true;
        } else {
            String var2;
            if (var1[1].equals("waitinvite")) {
                var2 = null;
                LobbyMultiInvitePanel var3 = this.anLobbyMultiInvitePanel__3680;
                synchronized (this.anLobbyMultiInvitePanel__3680) {
                    if (this.aClass58_Sub1_2424.aClass59_Sub1_3569.aBoolean3587) {
                        var2 = "noinv";
                    }

                    if (this.anLobbyMultiInvitePanel__3680.method520()) {
                        var2 = "agame";
                    }

                    if (this.anLobbyMultiInvitePanel__3680.method517()) {
                        var2 = "ainv";
                    }

                    if (this.aChatLobby_Sub3_2428.isUserIgnored(var1[2])) {
                        var2 = "ignored";
                    }

                    if (var2 != null) {
                        this.method791("waitifail\t" + var1[2] + "\t" + var2);
                        return true;
                    }

                    int var4 = Integer.parseInt(var1[3]);
                    LobbyGameInfo var5 = this.anLobbyMultiJoinPanel__3677.method557(var4);
                    this.anLobbyMultiInvitePanel__3680.method516(var1[2], var5);
                }

                if (this.aClass58_Sub1_2424.aClass59_Sub1_3569.aBoolean3588) {
                    this.aClass58_Sub1_2424.aSoundManager1189.playChallenge();
                }

                return true;
            } else if (var1[1].equals("waitifail")) {
                var2 = null;
                if (var1[3].equals("noinv")) {
                    var2 = "UserTakesNoInvites";
                } else if (var1[3].equals("agame")) {
                    var2 = "UserJoinedAnotherGame";
                } else if (var1[3].equals("ainv")) {
                    var2 = "UserHaveAnotherInvite";
                } else if (var1[3].equals("ignored")) {
                    var2 = "UserHasIgnoredYou";
                } else if (var1[3].equals("reject")) {
                    var2 = "UserRejectedInvite";
                }

                this.aChatLobby_Sub3_2428.addPlainMessage(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Wait_" + var2, var1[2]));
                return true;
            } else if (var1[1].equals("partwait")) {
                this.remove(this.aTabBar3675);
                this.add(this.aTabBar3674);
                this.anLobbyMultiInvitePanel__3680.method519(false);
                return true;
            } else {
                return false;
            }
        }
    }

    protected void method783() {
    }

    protected void method797(LobbyGameInfo var1, Graphics var2, int var3, int var4, int var5, boolean var6, boolean var7) {
        if (var1 != null) {
            var2.setFont(AApplet_Sub3.fontDialog11);
            var2.setColor(AApplet_Sub3.aColor3779);
            byte var8 = 15;
            byte var9 = 0;
            if (var6) {
                StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_PlayerCount"), var3, var5, -1);
                StringDraw.drawString(var2, "" + IPanel_Sub37.anIntArray2408[var1.getNumPlayersIndex()], var4, var5 + var9, 1);
                StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_TrackCount"), var3, var5 + var8, -1);
                StringDraw.drawString(var2, "" + IPanel_Sub37.anIntArray2409[var1.getNumTracksIndex()], var4, var5 + var8 + var9, 1);
                var5 += var8 * 2;
            }

            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_GameName"), var3, var5, -1);
            StringDraw.drawString(var2, var1.getGameName(), var4, var5 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_TrackTypes"), var3, var5 + var8, -1);
            StringDraw.drawString(var2, this.method790(var1.getTracksTypeIndex()), var4, var5 + var8 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_PlayOrder"), var3, var5 + var8 * 2, -1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_PlayOrder" + IPanel_Sub37.aStringArray2420[var1.getPlayingOrderIndex()]), var4, var5 + var8 * 2 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_MaxStrikesPerTrack"), var3, var5 + var8 * 3, -1);
            StringDraw.drawString(var2, "" + IPanel_Sub37.anIntArray2412[var1.getMaxStrokesIndex()], var4, var5 + var8 * 3 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_TurnTimeLimit"), var3, var5 + var8 * 4, -1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getTime((long) IPanel_Sub37.anIntArray2413[var1.getTimeLimitIndex()]), var4, var5 + var8 * 4 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_BallCollision"), var3, var5 + var8 * 5, -1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_BallCollision" + IPanel_Sub37.aStringArray2421[var1.getCollisionIndex()]), var4, var5 + var8 * 5 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_Scoring"), var3, var5 + var8 * 6, -1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_Scoring" + IPanel_Sub37.aStringArray2422[var1.getScoringIndex()]), var4, var5 + var8 * 6 + var9, 1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_AllowSpectators"), var3, var5 + var8 * 7, -1);
            StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_AllowSpectators" + IPanel_Sub37.aStringArray2423[var1.getAudienceIndex()]), var4, var5 + var8 * 7 + var9, 1);
            if (var7) {
                Class49[] var10 = var1.method1366();
                String var11 = "";

                for (int var12 = 0; var12 < var10.length; ++var12) {
                    if (var12 > 0) {
                        var11 = var11 + ", ";
                    }

                    var11 = UserList.getNickFromUserInfo(var10[var12].method1379());
                }

                StringDraw.drawString(var2, this.aClass58_Sub1_2424.textManager.getGame("Lobby_Settings_Players"), var3, var5 + var8 * 8, -1);
                StringDraw.drawString(var2, var11, var4, var5 + var8 * 8 + var9, 1);
            }

        }
    }

    protected void method798(boolean var1) {
        String var2 = this.aChatLobby_Sub3_2428.getSelectedNickForChallenge();
        if (var2 != null) {
            this.method791("waitinvite\t" + var2);
            this.aChatLobby_Sub3_2428.addPlainMessage(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Wait_User" + (var1 ? "Challenged" : "Invited"), var2));
        }
    }

    protected void method799() {
        this.method791("nc\t" + (this.aClass58_Sub1_2424.aClass59_Sub1_3569.aBoolean3587 ? 't' : 'f'));
        this.aChatLobby_Sub3_2428.method911();
    }

    private void method800() {
        byte var1 = 25;
        this.anIPanel_Sub5_3673 = new IPanel_Sub5(this.aClass58_Sub1_2424, this, this.anInt2426 - 10, var1);
        this.anIPanel_Sub5_3673.setLocation(5, 5);
        this.add(this.anIPanel_Sub5_3673);
        this.aTabBar3674 = this.method786(550, 330, var1);
        this.aTabBar3675 = this.method786(550, 330, var1);
        this.anIPanel_Sub38_3676 = new IPanel_Sub38(this.aClass58_Sub1_2424, this, 550, 330);
        this.aTabBar3674.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Create_Title"), this.anIPanel_Sub38_3676);
        this.anLobbyMultiJoinPanel__3677 = new LobbyMultiJoinPanel(this.aClass58_Sub1_2424, this, 550, 330);
        this.aTabBar3674.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Join_Title", "-"), this.anLobbyMultiJoinPanel__3677);
        this.anIPanel_Sub12_3678 = new IPanel_Sub12(this.aClass58_Sub1_2424, this, 550, 330);
        this.aTabBar3674.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Watch_Title", "-"), this.anIPanel_Sub12_3678);
        this.anIPanel_Sub10_3679 = new IPanel_Sub10(this.aClass58_Sub1_2424, this, 550, 330);
        this.aTabBar3675.addTab(this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Wait_Title"), this.anIPanel_Sub10_3679);
        this.aTabBar3674.setSelectedIndex(anInt3672 >= 0 ? anInt3672 : 0);
        this.aTabBar3674.addTabBarListener(this);
        this.add(this.aTabBar3674);
        this.anLobbyMultiInvitePanel__3680 = new LobbyMultiInvitePanel(this.aClass58_Sub1_2424, this, this.anInt2426 - 5 - 570, 337);
        this.anLobbyMultiInvitePanel__3680.setLocation(570, 5 + var1 + 5 + 28);
        this.add(this.anLobbyMultiInvitePanel__3680);
        int var2 = this.anInt2427 - 5 - 5 - 365 - 5 - var1 - 5;
        this.method787(var2, true);
    }

    private void method801(String[] var1) {
        this.anLobbyMultiJoinPanel__3677.method554();
        this.anIPanel_Sub12_3678.method583();
        int var2 = Integer.parseInt(var1[3]);

        for (int var3 = 0; var3 < var2; ++var3) {
            this.method802(var1, 6 * var3 + 4, false);
        }

        this.method805();
        if (anInt3672 == -1) {
            anInt3672 = var2 > 0 ? 1 : 0;
            this.aTabBar3674.setSelectedIndex(anInt3672);
        }

    }

    private LobbyGameInfo method802(String[] var1, int var2, boolean var3) {
        int var4 = Integer.parseInt(var1[var2]);
        char var5 = var1[var2 + 1].charAt(0);
        String var6 = var1[var2 + 2];
        String var7 = var1[var2 + 3];
        String var8 = var1[var2 + 4];
        String var9 = var1[var2 + 5];
        LobbyGameInfo var10 = new LobbyGameInfo(var4, var5, var6, var7, var8, var9);
        if (!var10.method1351()) {
            this.anLobbyMultiJoinPanel__3677.method555(var10);
        } else {
            this.anIPanel_Sub12_3678.method584(var10);
        }

        if (var3) {
            this.method805();
        }

        return var10;
    }

    private int method803(String[] var1) {
        int var2 = Integer.parseInt(var1[3]);
        this.anLobbyMultiJoinPanel__3677.method556(var2);
        this.anIPanel_Sub12_3678.method585(var2);
        this.method805();
        return var2;
    }

    private void method804(String[] var1) {
        int var2 = this.method803(var1);
        LobbyGameInfo var3 = this.method802(var1, 3, true);
        this.anLobbyMultiJoinPanel__3677.method559(var2, var3);
        this.anIPanel_Sub10_3679.method573(var2, var3);
        this.anLobbyMultiInvitePanel__3680.method518(var2, var3);
    }

    private void method805() {
        this.aTabBar3674.setTabTitle(1, this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Join_Title", this.anLobbyMultiJoinPanel__3677.method558()));
        this.aTabBar3674.setTabTitle(2, this.aClass58_Sub1_2424.textManager.getGame("Lobby2_Watch_Title", this.anIPanel_Sub12_3678.method586()));
    }

    static {
        aStringArray3682[0] = "Lobby2_Watch_Title";
        aStringArray3682[1] = "Lobby2_Join_Title";
        aStringArray3682[2] = "Challenged";
        aStringArray3682[3] = "Lobby2_Wait_User";
        aStringArray3682[4] = "Invited";
        aStringArray3682[5] = "waitinvite\t";
        aStringArray3682[6] = "UserHaveAnotherInvite";
        aStringArray3682[7] = "reject";
        aStringArray3682[8] = "UserTakesNoInvites";
        aStringArray3682[9] = "change";
        aStringArray3682[10] = "add";
        aStringArray3682[11] = "UserHasIgnoredYou";
        aStringArray3682[12] = "waitifail";
        aStringArray3682[13] = "Lobby2_Wait_";
        aStringArray3682[14] = "ignored";
        aStringArray3682[15] = "gotowait";
        aStringArray3682[16] = "remove";
        aStringArray3682[17] = "gamelist";
        aStringArray3682[18] = "partwait";
        aStringArray3682[19] = "noinv";
        aStringArray3682[20] = "agame";
        aStringArray3682[21] = "ainv";
        aStringArray3682[22] = "full";
        aStringArray3682[23] = "UserRejectedInvite";
        aStringArray3682[24] = "waitinvite";
        aStringArray3682[25] = "UserJoinedAnotherGame";
        aStringArray3682[26] = "waitifail\t";
        aStringArray3682[27] = "Lobby2_Wait_Title";
        aStringArray3682[28] = "Lobby2_Create_Title";
        aStringArray3682[29] = "nc\t";
        aStringArray3682[30] = "Lobby_Settings_TrackTypes";
        aStringArray3682[31] = ", ";
        aStringArray3682[32] = "Lobby_Settings_GameName";
        aStringArray3682[33] = "Lobby_Settings_TrackCount";
        aStringArray3682[34] = "Lobby_Settings_Players";
        aStringArray3682[35] = "Lobby_Settings_PlayerCount";
        aStringArray3682[36] = "Lobby_Settings_AllowSpectators";
        aStringArray3682[37] = "Lobby_Settings_PlayOrder";
        aStringArray3682[38] = "Lobby_Settings_BallCollision";
        aStringArray3682[39] = "Lobby_Settings_Scoring";
        aStringArray3682[40] = "Lobby_Settings_MaxStrikesPerTrack";
        aStringArray3682[41] = "Lobby_Settings_TurnTimeLimit";
        aStringArray3682[42] = "lobby2";
        anInt3672 = -1;
    }
}
