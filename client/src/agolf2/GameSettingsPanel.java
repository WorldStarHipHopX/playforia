package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GameSettingsPanel extends IPanel implements ItemListener, ActionListener {

    private Class58 aClass58_3099;
    private GamePersonalSettings aGamePersonalSettings_3100;
    private Frame_Sub2 aFrame_Sub2_3101;
    private ColorCheckbox checkboxGraphicsBlur;
    private ColorCheckbox checkboxGraphicsSpotLight;
    private ColorCheckbox checkboxGraphicsBallHlShadow;
    private ColorCheckbox checkboxSoundEffects;
    private RoundButton buttonOk;


    protected GameSettingsPanel(Class58 var1, GamePersonalSettings var2, Frame_Sub2 var3) {
        this.aClass58_3099 = var1;
        this.aGamePersonalSettings_3100 = var2;
        this.aFrame_Sub2_3101 = var3;
        this.setSize(280, 180);
        this.setBackground(var1.imageManager.getImage("background_settings"));
        this.setBackground(new Color(0xb1e1e9));
    }

    public void itemStateChanged(ItemEvent var1) {
        this.aGamePersonalSettings_3100.smoothGraphics = this.checkboxGraphicsBlur.getState();
        this.aGamePersonalSettings_3100.threedeeLights = this.checkboxGraphicsSpotLight.getState();
        this.aGamePersonalSettings_3100.threedeeBall = this.checkboxGraphicsBallHlShadow.getState();
        this.aGamePersonalSettings_3100.soundEffects = this.checkboxSoundEffects.getState();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.buttonOk) {
            this.aFrame_Sub2_3101.method237();
        }

    }

    protected void create() {
        this.setLayout((LayoutManager) null);
        byte y = 15;
        this.checkboxGraphicsBlur = this.createCheckbox("GraphicsBlur", this.aGamePersonalSettings_3100.smoothGraphics, y);
        this.checkboxGraphicsSpotLight = this.createCheckbox("GraphicsSpotLight", this.aGamePersonalSettings_3100.threedeeLights, y + 20);
        this.checkboxGraphicsBallHlShadow = this.createCheckbox("GraphicsBallHlShadow", this.aGamePersonalSettings_3100.threedeeBall, y + 40);
        this.checkboxSoundEffects = this.createCheckbox("SounfEffects", this.aGamePersonalSettings_3100.soundEffects, y + 64);
        this.buttonOk = new RoundButton(this.aClass58_3099.textManager.getGame("Game_Settings_ButtonOk"));
        this.buttonOk.setBounds(185, 142, 75, 23);
        this.buttonOk.setBackground(AApplet_Sub3.colourButtonGreen);
        this.buttonOk.addActionListener(this);
        this.add(this.buttonOk);
    }

    protected ColorCheckbox createCheckbox(String text, boolean checked, int y) {
        ColorCheckbox cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc = new ColorCheckbox(this.aClass58_3099.textManager.getGame("Game_Settings_" + text), checked);
        cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc.setBounds(25, y, 235, 18);
        cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc.setForeground(Color.BLACK);
        cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc.addItemListener(this);
        this.add(cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc);
        return cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc;
    }
}
