package agolf2;

import com.aapeli.colorgui.ColorCheckbox;

import java.awt.event.ItemEvent;

class GameSettingsBeepPanel extends GameSettingsPanel {

    private ColorCheckbox checkboxBeep;
    private Class58_Sub1 aClass58_Sub1_4718;


    protected GameSettingsBeepPanel(Class58_Sub1 var1, GameSettingsFrame var2) {
        super(var1, var1.aClass59_Sub1_3569, var2);
        this.aClass58_Sub1_4718 = var1;
        this.create();
    }

    public void itemStateChanged(ItemEvent evt) {
        super.itemStateChanged(evt);
        this.aClass58_Sub1_4718.aClass59_Sub1_3569.beepOnTurn = this.checkboxBeep.getState();
    }

    protected void create() {
        super.create();
        byte y = 15;
        this.checkboxBeep = this.createCheckbox("BeepOwnTurnStart", this.aClass58_Sub1_4718.aClass59_Sub1_3569.beepOnTurn, y + 84);
    }

}
