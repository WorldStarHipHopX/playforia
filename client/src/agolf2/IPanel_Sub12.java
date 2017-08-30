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

class IPanel_Sub12 extends IPanel implements ItemListener, UserListHandler, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2467;
    private LobbyMultiContentPanel anLobbyMultiContentPanel__2468;
    private int anInt2469;
    private int anInt2470;
    private MultiColorList aMultiColorList2471;
    private LobbyGameInfo aLobbyGameInfo_2472;
    private UserList anUserList2473;
    private UserList anUserList2474;
    private RoundButton aRoundButton2475;
    private static final String[] aStringArray2476 = new String[10];


    protected IPanel_Sub12(Class58_Sub1 var1, LobbyMultiContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2467 = var1;
        this.anLobbyMultiContentPanel__2468 = var2;
        this.anInt2469 = var3;
        this.anInt2470 = var4;
        this.setSize(var3, var4);
        this.method587();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog12b);
        var1.drawString(this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_TitleSelectGame"), 11, 23);
        if (this.aLobbyGameInfo_2472 != null) {
            var1.drawString(this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_TitlePlayers"), 321, 23);
            var1.drawString(this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_TitleSpectators"), 436, 23);
            if (!this.method589()) {
                var1.setFont(AApplet_Sub3.fontDialog12);
                int var2 = this.anInt2469 - 10 - 20 - 300 - 10;
                StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_NoSpectatorsGame"), this.anInt2469 - 10, this.anInt2470 - 25, 1, var2);
            }
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        if (var1.getSource() == this.aMultiColorList2471) {
            this.method588();
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aRoundButton2475 && this.method589()) {
            this.anLobbyMultiContentPanel__2468.method791("watch\t" + this.aLobbyGameInfo_2472.method1350());
        }

    }

    public void openPlayerCard(String var1) {
        this.aClass58_Sub1_2467.aParameters1186.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
    }

    public void adminCommand(String var1, String var2, String var3) {
    }

    protected void method583() {
        this.aMultiColorList2471.removeAllItems();
        this.method588();
    }

    protected void method584(LobbyGameInfo var1) {
        boolean var2 = this.method590(var1);
        String[] var3 = new String[]{var1.getGameName(), var1.method1364() + "/" + IPanel_Sub37.anIntArray2408[var1.getNumPlayersIndex()], var2 ? "" + var1.method1365() : "-"};
        MultiColorListItem var4 = new MultiColorListItem(var2 ? 0 : 7, var3, var1);
        this.aMultiColorList2471.addItem(var4);
    }

    protected void method585(int var1) {
        MultiColorListItem[] var2 = this.aMultiColorList2471.getAllItems();
        if (var2 != null) {
            for (int var3 = 0; var3 < var2.length; ++var3) {
                if (((LobbyGameInfo) ((LobbyGameInfo) var2[var3].getData())).method1350() == var1) {
                    this.aMultiColorList2471.removeItem(var2[var3]);
                }
            }

            this.method588();
        }
    }

    protected int method586() {
        return this.aMultiColorList2471.getItemCount();
    }

    private void method587() {
        this.setLayout((LayoutManager) null);
        String[] var1 = new String[]{this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_ListGameName"), this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_ListPlayerCount"), this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_ListSpectatorCount")};
        int[] var2 = new int[]{0, 3, 3};
        this.aMultiColorList2471 = new MultiColorList(var1, var2, 2, 300, this.anInt2470 - 10 - 35);
        this.aMultiColorList2471.setEmptyListText(this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_ListEmpty"));
        this.aMultiColorList2471.setLocation(10, 35);
        this.aMultiColorList2471.setSelectable(1);
        this.aMultiColorList2471.addItemListener(this);
        this.add(this.aMultiColorList2471);
        this.anUserList2473 = new UserList(this, this.aClass58_Sub1_2467.textManager, this.aClass58_Sub1_2467.imageManager, true, false, false, 105, this.anInt2470 - 10 - 25 - 5 - 40 - 35);
        this.anUserList2473.setLocation(320, 35);
        this.anUserList2473.setVisible(false);
        this.add(this.anUserList2473);
        this.anUserList2474 = new UserList(this, this.aClass58_Sub1_2467.textManager, this.aClass58_Sub1_2467.imageManager, true, false, false, this.anInt2469 - 10 - 435, this.anInt2470 - 10 - 25 - 5 - 40 - 35);
        this.anUserList2474.setLocation(435, 35);
        this.anUserList2474.setVisible(false);
        this.add(this.anUserList2474);
        this.aRoundButton2475 = new RoundButton(this.aClass58_Sub1_2467.textManager.getGame("Lobby2_Watch_WatchButton"));
        this.aRoundButton2475.setBounds(this.anInt2469 - 10 - 120, this.anInt2470 - 10 - 25, 120, 25);
        this.aRoundButton2475.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2475.addActionListener(this);
        this.add(this.aRoundButton2475);
    }

    private void method588() {
        this.anUserList2473.removeAllUsers();
        this.anUserList2474.removeAllUsers();
        MultiColorListItem var1 = this.aMultiColorList2471.getSelectedItem();
        if (var1 == null) {
            this.aLobbyGameInfo_2472 = null;
            this.anUserList2473.setVisible(false);
            this.anUserList2474.setVisible(false);
            this.aRoundButton2475.setVisible(false);
        } else {
            this.aLobbyGameInfo_2472 = (LobbyGameInfo) ((LobbyGameInfo) var1.getData());
            Class49[] var2 = this.aLobbyGameInfo_2472.method1366();

            for (int var3 = 0; var3 < var2.length; ++var3) {
                this.anUserList2473.addUser(var2[var3].method1379(), false);
            }

            this.anUserList2473.setVisible(true);
            if (this.method589()) {
                String[] var5 = this.aLobbyGameInfo_2472.method1367();

                for (int var4 = 0; var4 < var5.length; ++var4) {
                    this.anUserList2474.addUser(var5[var4], false);
                }

                this.anUserList2474.setVisible(true);
                this.aRoundButton2475.setVisible(true);
            } else {
                this.anUserList2474.setVisible(false);
                this.aRoundButton2475.setVisible(false);
            }
        }

        this.repaint();
    }

    private boolean method589() {
        return this.aLobbyGameInfo_2472 == null ? false : this.method590(this.aLobbyGameInfo_2472);
    }

    private boolean method590(LobbyGameInfo var1) {
        return IPanel_Sub37.anIntArray2416[var1.getAudienceIndex()] == 1;
    }

    static {
        aStringArray2476[0] = "watch\t";
        aStringArray2476[1] = "Lobby2_Watch_ListGameName";
        aStringArray2476[2] = "Lobby2_Watch_WatchButton";
        aStringArray2476[3] = "Lobby2_Watch_ListEmpty";
        aStringArray2476[4] = "Lobby2_Watch_ListSpectatorCount";
        aStringArray2476[5] = "Lobby2_Watch_ListPlayerCount";
        aStringArray2476[6] = "Lobby2_Watch_TitleSelectGame";
        aStringArray2476[7] = "Lobby2_Watch_TitlePlayers";
        aStringArray2476[8] = "Lobby2_Watch_TitleSpectators";
        aStringArray2476[9] = "Lobby2_Watch_NoSpectatorsGame";
    }
}
