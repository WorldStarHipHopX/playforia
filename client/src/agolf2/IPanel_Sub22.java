package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.settingsgui.*;
import com.aapeli.settingsgui.LobbyRoomSettingsPanel;

import java.awt.LayoutManager;
import java.util.StringTokenizer;

class IPanel_Sub22 extends IPanel implements GuiListenerExt {

    private Class58_Sub1 aClass58_Sub1_2522;
    private LobbySingleContentPanel anLobbySingleContentPanel__2523;
    private int anInt2524;
    private int anInt2525;
    private LobbyRoomSettingsPanel anLobbyRoomSettingsPanel__2526;
    private UnitChoice anUnitChoice2527;
    private UnitButton anUnitButton2528;
    private UnitButton anUnitButton2529;
    private TrackSelectFrame aJFrame__2530;
    private static final String[] aStringArray2531 = new String[8];


    protected IPanel_Sub22(Class58_Sub1 var1, LobbySingleContentPanel var2, int var3, int var4) {
        this.aClass58_Sub1_2522 = var1;
        this.anLobbySingleContentPanel__2523 = var2;
        this.anInt2524 = var3;
        this.anInt2525 = var4;
        this.setSize(var3, var4);
        this.method635();
    }

    public void unitValueChanged(Unit var1) {
        this.method634();
        if (this.method636()) {
            if (this.aClass58_Sub1_2522.anAApplet_Sub3_Sub1_3567.method60()) {
                this.anLobbySingleContentPanel__2523.method788();
            }

        } else {
            this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3580 = this.anLobbyRoomSettingsPanel__2526.getSaveableData();
        }
    }

    public void unitButtonClicked(Unit var1) {
        this.method634();
        if (var1 == this.anUnitButton2528) {
            this.method637();
        } else if (var1 == this.anUnitButton2529) {
            String var2 = "start\tt\t" + this.anLobbyRoomSettingsPanel__2526.getSaveableData() + "\t";
            if (this.anUnitChoice2527.getItemState() == IPanel_Sub37.anInt2418) {
                if (this.method639() == 0) {
                    return;
                }

                var2 = var2 + this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3581;
            } else {
                var2 = var2 + "-";
            }

            this.anLobbySingleContentPanel__2523.method791(var2);
        }

    }

    protected void method633(String[] var1) {
        if (this.aJFrame__2530 != null) {
            this.aJFrame__2530.method2341(var1);
        }

    }

    protected void method634() {
        if (this.aJFrame__2530 != null) {
            this.aJFrame__2530.dispose();
            this.aJFrame__2530 = null;
            this.method638();
        }

    }

    private void method635() {
        this.setLayout((LayoutManager) null);
        this.anLobbyRoomSettingsPanel__2526 = new LobbyRoomSettingsPanel();
        this.anLobbyRoomSettingsPanel__2526.setBounds(30, 30, this.anInt2524 - 40 - 40, this.anInt2525 - 30 - 30 - 30);
        this.anLobbyRoomSettingsPanel__2526.setBackground(AApplet_Sub3.aColor3778);
        this.anLobbyRoomSettingsPanel__2526.setForeground(AApplet_Sub3.aColor3779);
        UnitChoice var1 = new UnitChoice(this.aClass58_Sub1_2522.textManager.getGame("Lobby_Settings_TrackCount"));
        var1.setRelativeWidth(0.5D);

        for (int var2 = 0; var2 < IPanel_Sub37.anIntArray2409.length; ++var2) {
            var1.addItem("" + IPanel_Sub37.anIntArray2409[var2]);
        }

        this.anLobbyRoomSettingsPanel__2526.addUnit(var1);
        this.anUnitChoice2527 = new UnitChoice(this.aClass58_Sub1_2522.textManager.getGame("Lobby_Settings_TrackTypes"));
        this.anUnitChoice2527.setRelativeWidth(0.9D);

        for (int var3 = 0; var3 < IPanel_Sub37.anIntArray2410.length; ++var3) {
            String var8 = this.anLobbySingleContentPanel__2523.method790(var3);
            if (var3 != IPanel_Sub37.anInt2417 && !this.aClass58_Sub1_2522.anAApplet_Sub3_Sub1_3567.method60()) {
                var8 = var8 + " " + this.aClass58_Sub1_2522.textManager.getGame("Lobby_Settings_RegisteredOnly");
            }

            this.anUnitChoice2527.addItem(var8);
        }

        this.anLobbyRoomSettingsPanel__2526.addUnit(this.anUnitChoice2527);
        this.anUnitButton2528 = new UnitButton("", AApplet_Sub3.aColor3784, true);
        this.anUnitButton2528.setRelativeWidth(0.9D);
        this.method638();
        this.anLobbyRoomSettingsPanel__2526.addUnit(this.anUnitButton2528);
        UnitCheckboxGroup var9 = new UnitCheckboxGroup(this.aClass58_Sub1_2522.textManager.getGame("Lobby_Settings_AllowSpectators"));
        var9.setRelativeWidth(0.75D);

        int var4;
        for (var4 = 0; var4 < IPanel_Sub37.anIntArray2416.length; ++var4) {
            var9.addItem(this.aClass58_Sub1_2522.textManager.getGame("Lobby_Settings_AllowSpectators" + IPanel_Sub37.aStringArray2423[var4]));
        }

        this.anLobbyRoomSettingsPanel__2526.addUnit(var9);
        this.anUnitButton2529 = new UnitButton(this.aClass58_Sub1_2522.textManager.getGame("Lobby1_Training_StartButton"), AApplet_Sub3.colourButtonGreen, true);
        this.anLobbyRoomSettingsPanel__2526.addUnit(this.anUnitButton2529);

        for (var4 = 0; var4 < IPanel_Sub37.anIntArray2410.length; ++var4) {
            this.anLobbyRoomSettingsPanel__2526.addRule(new Rule(this.anUnitChoice2527, var4, var1, var4 != IPanel_Sub37.anInt2418));
            this.anLobbyRoomSettingsPanel__2526.addRule(new Rule(this.anUnitChoice2527, var4, this.anUnitButton2528, var4 == IPanel_Sub37.anInt2418));
        }

        this.anLobbyRoomSettingsPanel__2526.ready();

        try {
            this.anLobbyRoomSettingsPanel__2526.setSaveableData(this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3580);
        } catch (Exception var7) {
            this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3580 = "9^1^1";

            try {
                this.anLobbyRoomSettingsPanel__2526.setSaveableData(this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3580);
            } catch (Exception var6) {
                ;
            }
        }

        this.method636();
        this.anLobbyRoomSettingsPanel__2526.addGuiListenerExt(this);
        this.add(this.anLobbyRoomSettingsPanel__2526);
    }

    private boolean method636() {
        if (this.anUnitChoice2527.getItemState() != IPanel_Sub37.anInt2417 && !this.anLobbySingleContentPanel__2523.method789()) {
            this.anUnitChoice2527.setItemState(IPanel_Sub37.anInt2417);
            this.anLobbyRoomSettingsPanel__2526.checkAllRules();
            return true;
        } else {
            return false;
        }
    }

    private void method637() {
        this.method634();
        this.aJFrame__2530 = new TrackSelectFrame(this.aClass58_Sub1_2522, this.anLobbySingleContentPanel__2523, this);
    }

    private void method638() {
        this.anUnitButton2528.setButtonLabel(this.aClass58_Sub1_2522.textManager.getGame("Lobby1_Training_FreeChoiceButton", this.method639()));
    }

    private int method639() {
        String var1 = this.aClass58_Sub1_2522.aClass59_Sub1_3569.aString3581;
        if (var1.length() == 0) {
            return 0;
        } else {
            StringTokenizer var2 = new StringTokenizer(var1, ";");
            return var2.countTokens();
        }
    }

    static {
        aStringArray2531[0] = "Lobby1_Training_FreeChoiceButton";
        aStringArray2531[1] = "Lobby_Settings_AllowSpectators";
        aStringArray2531[2] = "Lobby1_Training_StartButton";
        aStringArray2531[3] = "Lobby_Settings_RegisteredOnly";
        aStringArray2531[4] = "9^1^1";
        aStringArray2531[5] = "Lobby_Settings_TrackTypes";
        aStringArray2531[6] = "Lobby_Settings_TrackCount";
        aStringArray2531[7] = "start\tt\t";
    }
}
