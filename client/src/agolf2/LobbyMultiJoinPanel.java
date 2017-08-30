package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.multiuser.UserList;
import com.aapeli.multiuser.UserListHandler;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class LobbyMultiJoinPanel extends IPanel implements ItemListener, UserListHandler, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2445;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__2446;
    private int anInt2447;
    private int anInt2448;
    private MultiColorList aMultiColorList2449;
    private LobbyGameInfo aLobbyGameInfo_2450;
    private UserList anUserList2451;
    private RoundButton aRoundButton2452;
    private static final String[] aStringArray2453 = new String[11];


    protected LobbyMultiJoinPanel(Class58_Sub1 var1, LobbyMultiContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2445 = var1;
        this.anLobbyMultiContentPanel__2446 = var2;
        this.anInt2447 = var3;
        this.anInt2448 = var4;
        this.setSize(var3, var4);
        this.method560();
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog12b);
        var1.drawString(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_TitleSelectGame"), 11, 23);
        if (this.aLobbyGameInfo_2450 != null) {
            var1.drawString(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_TitlePlayers"), 251, 23);
            var1.drawString(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_TitleSettings"), 356, 23);
            if (!this.aLobbyGameInfo_2450.method1352()) {
                var1.setFont(AApplet_Sub3.fontDialog12);
                int var2 = this.anInt2447 - 10 - 20 - 230 - 10;
                StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_InviteOnlyGame"), this.anInt2447 - 10, this.anInt2448 - 25, 1, var2);
            }
        }

        this.anLobbyMultiContentPanel__2446.method797(this.aLobbyGameInfo_2450, var1, 356, this.anInt2447 - 10, 45, false, false);
    }

    public void itemStateChanged(ItemEvent var1) {
        if (var1.getSource() == this.aMultiColorList2449) {
            this.method561();
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aRoundButton2452 && this.aLobbyGameInfo_2450 != null && this.aLobbyGameInfo_2450.method1352()) {
            if (this.aLobbyGameInfo_2450.getTracksTypeIndex() != IPanel_Sub37.anInt2417) {
                if (this.aClass58_Sub1_2445.anAApplet_Sub3_Sub1_3567.method58() == 0) {
                    this.anLobbyMultiContentPanel__2446.aChatLobby_Sub3_2428.addPlainMessage(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_WormCantJoinNonFreeTrackGame"));
                    return;
                }

                if (!this.anLobbyMultiContentPanel__2446.method789()) {
                    this.anLobbyMultiContentPanel__2446.method788();
                    return;
                }
            }

            this.anLobbyMultiContentPanel__2446.method791("join\t" + this.aLobbyGameInfo_2450.method1350());
        }

    }

    public void openPlayerCard(String var1) {
        this.aClass58_Sub1_2445.aParameters1186.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
    }

    public void adminCommand(String var1, String var2, String var3) {
    }

    protected void method554() {
        this.aMultiColorList2449.removeAllItems();
        this.method561();
    }

    protected void method555(LobbyGameInfo var1) {
        String[] var2 = new String[]{var1.getGameName(), "" + IPanel_Sub37.anIntArray2409[var1.getNumTracksIndex()], var1.method1364() + "/" + IPanel_Sub37.anIntArray2408[var1.getNumPlayersIndex()]};
        MultiColorListItem var3 = new MultiColorListItem(var1.method1352() ? 0 : 7, var2, var1);
        this.aMultiColorList2449.addItem(var3);
    }

    protected void method556(int var1) {
        MultiColorListItem[] var2 = this.aMultiColorList2449.getAllItems();
        if (var2 != null) {
            for (int var3 = 0; var3 < var2.length; ++var3) {
                if (((LobbyGameInfo) ((LobbyGameInfo) var2[var3].getData())).method1350() == var1) {
                    this.aMultiColorList2449.removeItem(var2[var3]);
                }
            }

            this.method561();
        }
    }

    protected LobbyGameInfo method557(int var1) {
        MultiColorListItem[] var2 = this.aMultiColorList2449.getAllItems();
        if (var2 != null) {
            for (int var3 = 0; var3 < var2.length; ++var3) {
                LobbyGameInfo var4 = (LobbyGameInfo) ((LobbyGameInfo) var2[var3].getData());
                if (var4.method1350() == var1) {
                    return var4;
                }
            }
        }

        return null;
    }

    protected int method558() {
        return this.aMultiColorList2449.getItemCount();
    }

    protected void method559(int var1, LobbyGameInfo var2) {
        if (this.aLobbyGameInfo_2450 != null) {
            if (this.aLobbyGameInfo_2450.method1350() == var1) {
                this.method561();
                this.repaint();
            }
        }
    }

    private void method560() {
        this.setLayout((LayoutManager) null);
        String[] var1 = new String[]{this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_ListGameName"), this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_ListTrackCount"), this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_ListPlayerCount")};
        int[] var2 = new int[]{0, 0, 3};
        this.aMultiColorList2449 = new MultiColorList(var1, var2, 0, 230, this.anInt2448 - 10 - 35);
        this.aMultiColorList2449.setEmptyListText(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_ListEmpty"));
        this.aMultiColorList2449.setLocation(10, 35);
        this.aMultiColorList2449.setSelectable(1);
        this.aMultiColorList2449.addItemListener(this);
        this.add(this.aMultiColorList2449);
        this.anUserList2451 = new UserList(this, this.aClass58_Sub1_2445.textManager, this.aClass58_Sub1_2445.imageManager, true, false, false, 95, this.anInt2448 - 85 - 35);
        this.anUserList2451.setLocation(250, 35);
        this.anUserList2451.setVisible(false);
        this.add(this.anUserList2451);
        this.aRoundButton2452 = new RoundButton(this.aClass58_Sub1_2445.textManager.getGame("Lobby2_Join_JoinButton"));
        this.aRoundButton2452.setBounds(this.anInt2447 - 10 - 120, this.anInt2448 - 10 - 25, 120, 25);
        this.aRoundButton2452.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2452.addActionListener(this);
        this.aRoundButton2452.setVisible(false);
        this.add(this.aRoundButton2452);
    }

    private void method561() {
        this.anUserList2451.removeAllUsers();
        MultiColorListItem var1 = this.aMultiColorList2449.getSelectedItem();
        if (var1 == null) {
            this.aLobbyGameInfo_2450 = null;
            this.anUserList2451.setVisible(false);
            this.aRoundButton2452.setVisible(false);
        } else {
            this.aLobbyGameInfo_2450 = (LobbyGameInfo) ((LobbyGameInfo) var1.getData());
            Class49[] var2 = this.aLobbyGameInfo_2450.method1366();

            for (int var3 = 0; var3 < var2.length; ++var3) {
                this.anUserList2451.addUser(var2[var3].method1379(), false);
            }

            this.anUserList2451.setVisible(true);
            this.aRoundButton2452.setVisible(this.aLobbyGameInfo_2450.method1352());
        }

        this.repaint();
    }

    static {
        aStringArray2453[0] = "Lobby2_Join_JoinButton";
        aStringArray2453[1] = "Lobby2_Join_ListGameName";
        aStringArray2453[2] = "Lobby2_Join_ListEmpty";
        aStringArray2453[3] = "Lobby2_Join_ListPlayerCount";
        aStringArray2453[4] = "Lobby2_Join_ListTrackCount";
        aStringArray2453[5] = "join\t";
        aStringArray2453[6] = "Lobby2_Join_WormCantJoinNonFreeTrackGame";
        aStringArray2453[7] = "Lobby2_Join_TitleSettings";
        aStringArray2453[8] = "Lobby2_Join_TitlePlayers";
        aStringArray2453[9] = "Lobby2_Join_InviteOnlyGame";
        aStringArray2453[10] = "Lobby2_Join_TitleSelectGame";
    }
}
