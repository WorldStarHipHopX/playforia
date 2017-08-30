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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class IPanel_Sub24 extends IPanel implements ItemListener, UserListHandler, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2477;
    private LobbySingleContentPanel anLobbySingleContentPanel__2478;
    private int anInt2479;
    private int anInt2480;
    private MultiColorList aMultiColorList2481;
    private Class51 aClass51_2482;
    private UserList anUserList2483;
    private RoundButton aRoundButton2484;
    private static final String[] aStringArray2485 = new String[11];


    protected IPanel_Sub24(Class58_Sub1 var1, LobbySingleContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2477 = var1;
        this.anLobbySingleContentPanel__2478 = var2;
        this.anInt2479 = var3;
        this.anInt2480 = var4;
        this.setSize(var3, var4);
        this.method653();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        Point var2 = this.getLocation();
        var1.drawImage(this.aClass58_Sub1_2477.imageManager.getImage("background"), -var2.x, -var2.y, this);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog12b);
        var1.drawString(this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_TitleSelectGame"), 11, 23);
        if (this.aClass51_2482 != null) {
            if (this.method655()) {
                var1.drawString(this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_TitleSpectators"), 341, 23);
            } else {
                var1.setFont(AApplet_Sub3.fontDialog12);
                int var3 = this.anInt2479 - 10 - 20 - 320 - 10;
                StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_NoSpectatorsGame"), this.anInt2479 - 10, this.anInt2480 - 25, 1, var3);
            }
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        if (var1.getSource() == this.aMultiColorList2481) {
            this.method654();
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aRoundButton2484 && this.method655()) {
            this.anLobbySingleContentPanel__2478.method791("watch\t" + this.aClass51_2482.method1386());
        }

    }

    public void openPlayerCard(String var1) {
        this.aClass58_Sub1_2477.aParameters1186.showPlayerCard(var1);
    }

    public void adminCommand(String var1, String var2) {
    }

    public void adminCommand(String var1, String var2, String var3) {
    }

    protected void method649() {
        this.aMultiColorList2481.removeAllItems();
        this.method654();
    }

    protected void method650(Class51 var1) {
        boolean var2 = var1.method1389();
        String var3 = var1.method1388();
        if (var3 == null) {
            var3 = this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_ListTrackSetNone");
        }

        String[] var4 = new String[]{var1.method1387(), var3, var2 ? "" + var1.method1390() : "-"};
        MultiColorListItem var5 = new MultiColorListItem(var2 ? 0 : 7, var4, var1);
        this.aMultiColorList2481.addItem(var5);
    }

    protected void method651(int var1) {
        MultiColorListItem[] var2 = this.aMultiColorList2481.getAllItems();
        if (var2 != null) {
            for (int var3 = 0; var3 < var2.length; ++var3) {
                if (((Class51) ((Class51) var2[var3].getData())).method1386() == var1) {
                    this.aMultiColorList2481.removeItem(var2[var3]);
                }
            }

            this.method654();
        }
    }

    protected int method652() {
        return this.aMultiColorList2481.getItemCount();
    }

    private void method653() {
        this.setLayout((LayoutManager) null);
        String[] var1 = new String[]{this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_ListPlayerNick"), this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_ListTrackSet"), this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_ListSpectatorCount")};
        int[] var2 = new int[]{0, 0, 3};
        this.aMultiColorList2481 = new MultiColorList(var1, var2, 1, 320, this.anInt2480 - 10 - 35);
        this.aMultiColorList2481.setEmptyListText(this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_ListEmpty"));
        this.aMultiColorList2481.setLocation(10, 35);
        this.aMultiColorList2481.setSelectable(1);
        this.aMultiColorList2481.addItemListener(this);
        this.add(this.aMultiColorList2481);
        this.anUserList2483 = new UserList(this, this.aClass58_Sub1_2477.textManager, this.aClass58_Sub1_2477.imageManager, true, false, false, 150, this.anInt2480 - 10 - 25 - 5 - 40 - 35);
        this.anUserList2483.setLocation(340, 35);
        this.anUserList2483.setVisible(false);
        this.add(this.anUserList2483);
        this.aRoundButton2484 = new RoundButton(this.aClass58_Sub1_2477.textManager.getGame("Lobby1_Watch_WatchButton"));
        this.aRoundButton2484.setBounds(this.anInt2479 - 10 - 120, this.anInt2480 - 10 - 25, 120, 25);
        this.aRoundButton2484.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2484.addActionListener(this);
        this.aRoundButton2484.setVisible(false);
        this.add(this.aRoundButton2484);
    }

    private void method654() {
        this.anUserList2483.removeAllUsers();
        MultiColorListItem var1 = this.aMultiColorList2481.getSelectedItem();
        if (var1 == null) {
            this.aClass51_2482 = null;
            this.anUserList2483.setVisible(false);
            this.aRoundButton2484.setVisible(false);
        } else {
            this.aClass51_2482 = (Class51) ((Class51) var1.getData());
            if (this.method655()) {
                String[] var2 = this.aClass51_2482.method1391();

                for (int var3 = 0; var3 < var2.length; ++var3) {
                    this.anUserList2483.addUser(var2[var3], false);
                }

                this.anUserList2483.setVisible(true);
                this.aRoundButton2484.setVisible(true);
            } else {
                this.anUserList2483.setVisible(false);
                this.aRoundButton2484.setVisible(false);
            }
        }

        this.repaint();
    }

    private boolean method655() {
        return this.aClass51_2482 == null ? false : this.aClass51_2482.method1389();
    }

    static {
        aStringArray2485[0] = "watch\t";
        aStringArray2485[1] = "background";
        aStringArray2485[2] = "Lobby1_Watch_TitleSelectGame";
        aStringArray2485[3] = "Lobby1_Watch_NoSpectatorsGame";
        aStringArray2485[4] = "Lobby1_Watch_TitleSpectators";
        aStringArray2485[5] = "Lobby1_Watch_ListPlayerNick";
        aStringArray2485[6] = "Lobby1_Watch_WatchButton";
        aStringArray2485[7] = "Lobby1_Watch_ListSpectatorCount";
        aStringArray2485[8] = "Lobby1_Watch_ListTrackSet";
        aStringArray2485[9] = "Lobby1_Watch_ListEmpty";
        aStringArray2485[10] = "Lobby1_Watch_ListTrackSetNone";
    }
}
