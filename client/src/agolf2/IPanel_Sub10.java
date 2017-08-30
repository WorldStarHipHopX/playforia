package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.multiuser.UserList;
import com.aapeli.multiuser.UserListHandler;
import com.aapeli.multiuser.UserListItem;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub10 extends IPanel implements UserListHandler, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2454;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__2455;
    private int anInt2456;
    private int anInt2457;
    private LobbyGameInfo aLobbyGameInfo_2458;
    private boolean aBoolean2459;
    private UserList anUserList2460;
    private RoundButton aRoundButton2461;
    private RoundButton aRoundButton2462;
    private RoundButton aRoundButton2463;
    private RoundButton aRoundButton2464;
    private boolean aBoolean2465;
    private static final String[] aStringArray2466 = new String[15];


    protected IPanel_Sub10(Class58_Sub1 var1, LobbyMultiContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2454 = var1;
        this.anLobbyMultiContentPanel__2455 = var2;
        this.anInt2456 = var3;
        this.anInt2457 = var4;
        this.setSize(var3, var4);
        this.method574();
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog12b);
        var1.drawString(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_TitleSettings"), 11, 23);
        var1.drawString(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_TitlePlayers"), 221, 23);
        this.anLobbyMultiContentPanel__2455.method797(this.aLobbyGameInfo_2458, var1, 11, 190, 45, true, false);
        String var2 = null;
        if (this.aLobbyGameInfo_2458.method1352()) {
            var2 = this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_WaitingJoiningPlayers");
        } else if (!this.aBoolean2459) {
            var2 = this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_WaitingInvitedPlayers", this.aLobbyGameInfo_2458.method1353());
        }

        if (var2 != null) {
            var1.setFont(AApplet_Sub3.fontDialog12);
            StringDraw.drawStringWithMaxWidth(var1, var2, 10, this.anInt2457 - 35, -1, this.anInt2456 - 10 - 120 - 30 - 10);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton2461 && this.aBoolean2459) {
            this.anLobbyMultiContentPanel__2455.method798(IPanel_Sub37.anIntArray2408[this.aLobbyGameInfo_2458.getNumPlayersIndex()] == 2);
        } else if (var2 == this.aRoundButton2462 && this.aBoolean2459) {
            this.anLobbyMultiContentPanel__2455.method791("waitsetfree");
            this.aRoundButton2461.setVisible(false);
            this.aRoundButton2462.setVisible(false);
        } else if (var2 == this.aRoundButton2463 && !this.aBoolean2465) {
            this.anLobbyMultiContentPanel__2455.method791("waitrts");
            this.aBoolean2465 = true;
            this.aRoundButton2463.setVisible(false);
        } else if (var2 == this.aRoundButton2464) {
            this.anLobbyMultiContentPanel__2455.method791("waitpart");
        }

    }

    public void openPlayerCard(String var1) {
        this.aClass58_Sub1_2454.aParameters1186.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
    }

    public void adminCommand(String var1, String var2, String var3) {
    }

    protected void method572(LobbyGameInfo var1, boolean var2) {
        this.aLobbyGameInfo_2458 = var1;
        this.aRoundButton2461.setLabel(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_" + (IPanel_Sub37.anIntArray2408[var1.getNumPlayersIndex()] == 2 ? "Challenge" : "Invite") + "Button"));
        this.aBoolean2465 = false;
        this.method575();
        this.aBoolean2459 = var2;
        this.aRoundButton2461.setVisible(var2);
        this.aRoundButton2462.setVisible(var2);
        this.repaint();
    }

    protected void method573(int var1, LobbyGameInfo var2) {
        if (this.aLobbyGameInfo_2458 != null) {
            if (this.aLobbyGameInfo_2458.method1350() == var1) {
                this.aLobbyGameInfo_2458 = var2;
                this.method575();
                this.repaint();
            }
        }
    }

    private void method574() {
        this.setLayout((LayoutManager) null);
        this.anUserList2460 = new UserList(this, this.aClass58_Sub1_2454.textManager, this.aClass58_Sub1_2454.imageManager, true, false, false, 200, this.anInt2457 - 85 - 35);
        this.anUserList2460.setLocation(220, 35);
        this.add(this.anUserList2460);
        this.aRoundButton2461 = new RoundButton();
        this.aRoundButton2461.setBounds(10, this.anInt2457 - 10 - 25, 130, 25);
        this.aRoundButton2461.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2461.addActionListener(this);
        this.add(this.aRoundButton2461);
        this.aRoundButton2462 = new RoundButton(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_SetFreeButton"));
        this.aRoundButton2462.setBounds(155, this.anInt2457 - 10 - 25, 145, 25);
        this.aRoundButton2462.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2462.addActionListener(this);
        this.add(this.aRoundButton2462);
        this.aRoundButton2463 = new RoundButton(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_ReadyToStartButton"));
        this.aRoundButton2463.setBounds(this.anInt2456 - 10 - 120, this.anInt2457 - 10 - 20 - 10 - 20, 120, 20);
        this.aRoundButton2463.setBackground(AApplet_Sub3.aColor3784);
        this.aRoundButton2463.addActionListener(this);
        this.add(this.aRoundButton2463);
        this.aRoundButton2464 = new RoundButton(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_PartButton"));
        this.aRoundButton2464.setBounds(this.anInt2456 - 10 - 120, this.anInt2457 - 10 - 20, 120, 20);
        this.aRoundButton2464.setBackground(AApplet_Sub3.aColor3783);
        this.aRoundButton2464.addActionListener(this);
        this.add(this.aRoundButton2464);
    }

    private void method575() {
        int var1 = this.anUserList2460.getUserCount();
        this.anUserList2460.removeAllUsers();
        Class49[] var2 = this.aLobbyGameInfo_2458.method1366();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            UserListItem var4 = this.anUserList2460.addUser(var2[var3].method1379(), false);
            if (var2[var3].method1380()) {
                var4.setAfterNickText(this.aClass58_Sub1_2454.textManager.getGame("Lobby2_Wait_ReadyToStart"));
            }
        }

        if (this.anUserList2460.getUserCount() < var1) {
            this.aBoolean2465 = false;
        }

        this.aRoundButton2463.setVisible(!this.aBoolean2465 && var2.length > 1);
    }

    static {
        aStringArray2466[0] = "Lobby2_Wait_SetFreeButton";
        aStringArray2466[1] = "Lobby2_Wait_ReadyToStartButton";
        aStringArray2466[2] = "Lobby2_Wait_PartButton";
        aStringArray2466[3] = "waitpart";
        aStringArray2466[4] = "waitrts";
        aStringArray2466[5] = "waitsetfree";
        aStringArray2466[6] = "Lobby2_Wait_WaitingInvitedPlayers";
        aStringArray2466[7] = "Lobby2_Wait_TitleSettings";
        aStringArray2466[8] = "Lobby2_Wait_TitlePlayers";
        aStringArray2466[9] = "Lobby2_Wait_WaitingJoiningPlayers";
        aStringArray2466[10] = "Invite";
        aStringArray2466[11] = "Challenge";
        aStringArray2466[12] = "Button";
        aStringArray2466[13] = "Lobby2_Wait_";
        aStringArray2466[14] = "Lobby2_Wait_ReadyToStart";
    }
}
