package agolf2;

import java.awt.event.WindowListener;

class GameSettingsFrame extends Frame_Sub2 implements WindowListener {



    protected GameSettingsFrame(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2) {
        super(var2);
        this.setTitle(var1.textManager.getGame("Game_Settings_Title"));
        this.panel = new GameSettingsBeepPanel(var1, this);
    }

}
