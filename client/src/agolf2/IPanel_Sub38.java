package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.settingsgui.*;
import com.aapeli.settingsgui.LobbyRoomSettingsPanel;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub38 extends IPanel implements GuiListener, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2508;
    private LobbyMultiContentPanel lobbyMultiContentPanel;
    private int width;
    private int height;
    private LobbyRoomSettingsPanel anLobbyRoomSettingsPanel__2512;
    private LobbyRoomSettingsPanel anLobbyRoomSettingsPanel__2513;
    private UnitChoice anUnitChoice2514;
    private RoundButton aRoundButton2515;
    private RoundButton aRoundButton2516;
    private UnitChoice anUnitChoice2517;
    private UnitChoice anUnitChoice2518;
    private UnitChoice anUnitChoice2519;
    private UnitChoice anUnitChoice2520;
    private static final String[] aStringArray2521 = new String[19];


    protected IPanel_Sub38(Class58_Sub1 var1, LobbyMultiContentPanel var2, int width, int height) {
        this.aClass58_Sub1_2508 = var1;
        this.lobbyMultiContentPanel = var2;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.create();
        this.method817();
    }

    public void unitValueChanged() {
        if (this.anUnitChoice2514.getItemState() != IPanel_Sub37.anInt2417 && !this.lobbyMultiContentPanel.method789()) {
            this.anUnitChoice2514.setItemState(IPanel_Sub37.anInt2417);
            if (this.aClass58_Sub1_2508.anAApplet_Sub3_Sub1_3567.method60()) {
                this.lobbyMultiContentPanel.method788();
            }

        } else {
            if (this.aClass58_Sub1_2508.aClass59_Sub1_3569.aBoolean3584) {
                this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3586 = this.anLobbyRoomSettingsPanel__2512.getSaveableData();
            } else {
                this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3585 = this.anLobbyRoomSettingsPanel__2513.getSaveableData();
            }

        }
    }

    public void unitButtonClicked() {
        if (this.aClass58_Sub1_2508.aClass59_Sub1_3569.aBoolean3584) {
            this.lobbyMultiContentPanel.method791("create\tc\t" + this.anLobbyRoomSettingsPanel__2512.getSaveableData());
        } else {
            this.lobbyMultiContentPanel.method791("create\ts\t" + this.anLobbyRoomSettingsPanel__2513.getSaveableData());
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton2515) {
            this.method816(true);
        } else if (var2 == this.aRoundButton2516) {
            this.method816(false);
        }

    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.anLobbyRoomSettingsPanel__2512 = this.method813(true);
        this.anLobbyRoomSettingsPanel__2513 = this.method813(false);
        this.aRoundButton2515 = this.method815("MoreSettings", this.anLobbyRoomSettingsPanel__2513);
        this.aRoundButton2516 = this.method815("LessSettings", this.anLobbyRoomSettingsPanel__2512);
    }

    private LobbyRoomSettingsPanel method813(boolean var1) {
        LobbyRoomSettingsPanel var2 = new LobbyRoomSettingsPanel();
        byte var3;
        byte var4;
        if (var1) {
            var3 = 40;
            var4 = 5;
            var2.setSize(this.width - var3 - var3, this.height - 3 - 20 - 5 - 5);
        } else {
            var3 = 75;
            var4 = 40;
            var2.setSize(this.width - var3 - var3, this.height - 3 - 20 - 40 - 170);
        }

        var2.setLocation(var3, var4);
        var2.setBackground(AApplet_Sub3.aColor3778);
        var2.setForeground(AApplet_Sub3.aColor3779);
        this.method814(var2, var1);
        UnitButton var5 = new UnitButton(this.aClass58_Sub1_2508.textManager.getGame("Lobby2_Create_CreateGame"), AApplet_Sub3.colourButtonGreen, true);
        var2.addUnit(var5);
        var2.ready();

        try {
            var2.setSaveableData(var1 ? this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3586 : this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3585);
        } catch (Exception var9) {
            if (var1) {
                this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3586 = "2^9^-^1^1^3^3^1^0^1";
            } else {
                this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3585 = "2^9";
            }

            try {
                var2.setSaveableData(var1 ? this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3586 : this.aClass58_Sub1_2508.aClass59_Sub1_3569.aString3585);
            } catch (Exception var8) {
                ;
            }
        }

        var2.addGuiListener(this);
        return var2;
    }

    private void method814(LobbyRoomSettingsPanel var1, boolean var2) {
        UnitChoice var3 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_PlayerCount"));
        var3.setRelativeWidth(0.5D);

        for (int var4 = 0; var4 < IPanel_Sub37.anIntArray2408.length; ++var4) {
            var3.addItem("" + IPanel_Sub37.anIntArray2408[var4]);
        }

        var1.addUnit(var3);
        UnitChoice var13 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_TrackCount"));
        var13.setRelativeWidth(0.5D);

        for (int var5 = 0; var5 < IPanel_Sub37.anIntArray2409.length; ++var5) {
            var13.addItem("" + IPanel_Sub37.anIntArray2409[var5]);
        }

        var1.addUnit(var13);
        if (!var2) {
            this.anUnitChoice2517 = var3;
            this.anUnitChoice2518 = var13;
        } else {
            this.anUnitChoice2519 = var3;
            this.anUnitChoice2520 = var13;
            if (this.aClass58_Sub1_2508.anAApplet_Sub3_Sub1_3567.method58() >= 1) {
                UnitTextField var15 = new UnitTextField(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_GameName"), this.aClass58_Sub1_2508.textManager, 20);
                var1.addUnit(var15);
            } else {
                UnitData var14 = new UnitData();
                var1.addUnit(var14);
            }

            this.anUnitChoice2514 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_TrackTypes"));

            for (int var6 = 0; var6 < IPanel_Sub37.anIntArray2410.length; ++var6) {
                if (IPanel_Sub37.anIntArray2410[var6] != IPanel_Sub37.anInt2418) {
                    String var17 = this.lobbyMultiContentPanel.method790(var6);
                    if (IPanel_Sub37.anIntArray2410[var6] != IPanel_Sub37.anInt2417 && !this.aClass58_Sub1_2508.anAApplet_Sub3_Sub1_3567.method60()) {
                        var17 = var17 + " " + this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_RegisteredOnly");
                    }

                    this.anUnitChoice2514.addItem(var17);
                } else {
                    this.anUnitChoice2514.addInvisibleItem();
                }
            }

            var1.addUnit(this.anUnitChoice2514);
            UnitChoice var16 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_PlayOrder"));

            for (int var7 = 0; var7 < IPanel_Sub37.anIntArray2411.length; ++var7) {
                var16.addItem(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_PlayOrder" + IPanel_Sub37.aStringArray2420[var7]));
            }

            var1.addUnit(var16);
            UnitChoice var18 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_MaxStrikesPerTrack"));
            var18.setRelativeWidth(0.5D);

            for (int var8 = 0; var8 < IPanel_Sub37.anIntArray2412.length; ++var8) {
                var18.addItem("" + IPanel_Sub37.anIntArray2412[var8]);
            }

            var1.addUnit(var18);
            UnitChoice var19 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_TurnTimeLimit"));
            var19.setRelativeWidth(0.5D);

            for (int var9 = 0; var9 < IPanel_Sub37.anIntArray2413.length; ++var9) {
                var19.addItem(this.aClass58_Sub1_2508.textManager.getTime((long) IPanel_Sub37.anIntArray2413[var9]));
            }

            var1.addUnit(var19);
            UnitCheckboxGroup var20 = new UnitCheckboxGroup(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_BallCollision"));
            var20.setRelativeWidth(0.75D);

            for (int var10 = 0; var10 < IPanel_Sub37.anIntArray2414.length; ++var10) {
                var20.addItem(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_BallCollision" + IPanel_Sub37.aStringArray2421[var10]));
            }

            var1.addUnit(var20);
            UnitChoice var21 = new UnitChoice(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_Scoring"));

            for (int var11 = 0; var11 < IPanel_Sub37.anIntArray2415.length; ++var11) {
                var21.addItem(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_Scoring" + IPanel_Sub37.aStringArray2422[var11]));
            }

            var1.addUnit(var21);
            UnitCheckboxGroup var22 = new UnitCheckboxGroup(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_AllowSpectators"));
            var22.setRelativeWidth(0.75D);

            for (int var12 = 0; var12 < IPanel_Sub37.anIntArray2416.length; ++var12) {
                var22.addItem(this.aClass58_Sub1_2508.textManager.getGame("Lobby_Settings_AllowSpectators" + IPanel_Sub37.aStringArray2423[var12]));
            }

            var1.addUnit(var22);
        }
    }

    private RoundButton method815(String var1, LobbyRoomSettingsPanel var2) {
        Point var3 = var2.getLocation();
        Dimension var4 = var2.getSize();
        RoundButton var5 = new RoundButton(this.aClass58_Sub1_2508.textManager.getGame("Lobby2_Create_" + var1));
        var5.setBounds(var3.x + var4.width - 100 - 5, var3.y + var4.height + 10 - 5, 100, 20);
        var5.setBackground(AApplet_Sub3.aColor3784);
        var5.addActionListener(this);
        return var5;
    }

    private void method816(boolean var1) {
        if (var1 != this.aClass58_Sub1_2508.aClass59_Sub1_3569.aBoolean3584) {
            this.aClass58_Sub1_2508.aClass59_Sub1_3569.aBoolean3584 = var1;
            this.method817();
        }
    }

    private void method817() {
        if (this.aClass58_Sub1_2508.aClass59_Sub1_3569.aBoolean3584) {
            this.remove(this.anLobbyRoomSettingsPanel__2513);
            this.remove(this.aRoundButton2515);
            this.anUnitChoice2519.setItemState(this.anUnitChoice2517.getItemState());
            this.anUnitChoice2520.setItemState(this.anUnitChoice2518.getItemState());
            this.add(this.anLobbyRoomSettingsPanel__2512);
            this.add(this.aRoundButton2516);
        } else {
            this.remove(this.anLobbyRoomSettingsPanel__2512);
            this.remove(this.aRoundButton2516);
            this.anUnitChoice2517.setItemState(this.anUnitChoice2519.getItemState());
            this.anUnitChoice2518.setItemState(this.anUnitChoice2520.getItemState());
            this.add(this.anLobbyRoomSettingsPanel__2513);
            this.add(this.aRoundButton2515);
        }

    }

    static {
        aStringArray2521[0] = "Lobby2_Create_";
        aStringArray2521[1] = "Lobby2_Create_CreateGame";
        aStringArray2521[2] = "2^9^-^1^1^3^3^1^0^1";
        aStringArray2521[3] = "2^9";
        aStringArray2521[4] = "create\tc\t";
        aStringArray2521[5] = "create\ts\t";
        aStringArray2521[6] = "Lobby_Settings_MaxStrikesPerTrack";
        aStringArray2521[7] = "Lobby_Settings_TrackTypes";
        aStringArray2521[8] = "Lobby_Settings_Scoring";
        aStringArray2521[9] = "Lobby_Settings_TurnTimeLimit";
        aStringArray2521[10] = "Lobby_Settings_PlayerCount";
        aStringArray2521[11] = "Lobby_Settings_GameName";
        aStringArray2521[12] = "Lobby_Settings_RegisteredOnly";
        aStringArray2521[13] = "Lobby_Settings_PlayOrder";
        aStringArray2521[14] = "Lobby_Settings_TrackCount";
        aStringArray2521[15] = "Lobby_Settings_BallCollision";
        aStringArray2521[16] = "Lobby_Settings_AllowSpectators";
        aStringArray2521[17] = "MoreSettings";
        aStringArray2521[18] = "LessSettings";
    }
}
