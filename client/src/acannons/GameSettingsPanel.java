package acannons;

import com.playray.client.SPanel;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.GlossyButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

class GameSettingsPanel extends SPanel implements ItemListener, ActionListener {

    private ClientSettings aClientSettings_3892;
    private GameSettingsFrame aJFrame__3893;
    private GameAreaPanel aSPanel__3894;
    private ColorCheckbox aColorCheckbox3895;
    private ColorCheckbox aColorCheckbox3896;
    private ColorCheckbox aColorCheckbox3897;
    private ColorCheckbox aColorCheckbox3898;
    private ColorCheckbox aColorCheckbox3899;
    private JComboBox aJComboBox3900;
    private ColorCheckbox aColorCheckbox3901;
    private ColorCheckbox aColorCheckbox3902;
    private GlossyButton aGlossyButton3903;
    private static final String[] aStringArray3904 = new String[13];


    protected GameSettingsPanel(ClientSettings var1, GameSettingsFrame var2, GameAreaPanel var3) {
        this.aClientSettings_3892 = var1;
        this.aJFrame__3893 = var2;
        this.aSPanel__3894 = var3;
        this.setSize(300, 305);
        this.setBackground(var1.imageManager.method1983("bg-game"), -30, -30);
        this.method2447();
    }

    public Dimension getPreferredSize() {
        return this.getMinimumSize();
    }

    public Dimension getMinimumSize() {
        return new Dimension(300, 305);
    }

    public void paintContent(Graphics2D var1) {
        var1.setColor(GameApplet.aColor4782);
        var1.drawString(this.aClientSettings_3892.textManager.method2039("GameSettings_UserFaces"), 20, 155);
    }

    public void itemStateChanged(ItemEvent var1) {
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean780 = this.aColorCheckbox3895.getState();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean781 = this.aColorCheckbox3896.getState();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean782 = this.aColorCheckbox3897.getState();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean783 = this.aColorCheckbox3898.getState();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean784 = this.aColorCheckbox3899.getState();
        this.aClientSettings_3892.aPlayerInfo_764.anInt785 = this.aJComboBox3900.getSelectedIndex();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean786 = this.aColorCheckbox3901.getState();
        this.aClientSettings_3892.aPlayerInfo_764.aBoolean787 = this.aColorCheckbox3902.getState();
        this.aSPanel__3894.repaint();
    }

    public void actionPerformed(ActionEvent var1) {
        this.aJFrame__3893.hideFrame();
    }

    private void method2447() {
        this.aColorCheckbox3895 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_Sounds"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean780);
        this.aColorCheckbox3895.setBounds(20, 20, 260, 20);
        this.aColorCheckbox3895.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3895.addItemListener(this);
        this.add(this.aColorCheckbox3895);
        this.aColorCheckbox3896 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_BeepGameStart"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean781);
        this.aColorCheckbox3896.setBounds(20, 50, 260, 20);
        this.aColorCheckbox3896.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3896.addItemListener(this);
        this.add(this.aColorCheckbox3896);
        this.aColorCheckbox3897 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_BeepRoundStart"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean782);
        this.aColorCheckbox3897.setBounds(20, 70, 260, 20);
        this.aColorCheckbox3897.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3897.addItemListener(this);
        this.add(this.aColorCheckbox3897);
        this.aColorCheckbox3898 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_BeepOwnTurnStart"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean783);
        this.aColorCheckbox3898.setBounds(20, 90, 260, 20);
        this.aColorCheckbox3898.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3898.addItemListener(this);
        this.add(this.aColorCheckbox3898);
        this.aColorCheckbox3899 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_BeepWhenTimeIsLow"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean784);
        this.aColorCheckbox3899.setBounds(20, 110, 260, 20);
        this.aColorCheckbox3899.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3899.addItemListener(this);
        this.add(this.aColorCheckbox3899);
        this.aJComboBox3900 = new JComboBox();
        this.aJComboBox3900.addItem(this.aClientSettings_3892.textManager.method2039("GameSettings_UserFacesNo"));
        this.aJComboBox3900.addItem(this.aClientSettings_3892.textManager.method2039("GameSettings_UserFacesUp"));
        this.aJComboBox3900.addItem(this.aClientSettings_3892.textManager.method2039("GameSettings_UserFacesDown"));
        this.aJComboBox3900.setSelectedIndex(this.aClientSettings_3892.aPlayerInfo_764.anInt785);
        this.aJComboBox3900.setBounds(20, 161, 260, 22);
        this.aJComboBox3900.setBackground(Color.white);
        this.aJComboBox3900.setForeground(Color.black);
        this.aJComboBox3900.addItemListener(this);
        this.add(this.aJComboBox3900);
        this.aColorCheckbox3901 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_DrawAimArrow"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean786);
        this.aColorCheckbox3901.setBounds(20, 200, 260, 20);
        this.aColorCheckbox3901.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3901.addItemListener(this);
        this.add(this.aColorCheckbox3901);
        this.aColorCheckbox3902 = new ColorCheckbox(this.aClientSettings_3892.textManager.method2039("GameSettings_ScoreOverCannon"), this.aClientSettings_3892.aPlayerInfo_764.aBoolean787);
        this.aColorCheckbox3902.setBounds(20, 225, 260, 20);
        this.aColorCheckbox3902.setForeground(GameApplet.aColor4782);
        this.aColorCheckbox3902.addItemListener(this);
        this.add(this.aColorCheckbox3902);
        this.aGlossyButton3903 = new GlossyButton(this.aClientSettings_3892.textManager.method2039("GameSettings_CloseButton"), 3);
        this.aGlossyButton3903.setBounds(205, 265, 75, 23);
        this.aGlossyButton3903.addActionListener(this);
        this.add(this.aGlossyButton3903);
    }

    static {
        aStringArray3904[0] = "bg-game";
        aStringArray3904[1] = "GameSettings_UserFaces";
        aStringArray3904[2] = "GameSettings_BeepGameStart";
        aStringArray3904[3] = "GameSettings_ScoreOverCannon";
        aStringArray3904[4] = "GameSettings_Sounds";
        aStringArray3904[5] = "GameSettings_UserFacesUp";
        aStringArray3904[6] = "GameSettings_BeepWhenTimeIsLow";
        aStringArray3904[7] = "GameSettings_UserFacesNo";
        aStringArray3904[8] = "GameSettings_CloseButton";
        aStringArray3904[9] = "GameSettings_UserFacesDown";
        aStringArray3904[10] = "GameSettings_DrawAimArrow";
        aStringArray3904[11] = "GameSettings_BeepRoundStart";
        aStringArray3904[12] = "GameSettings_BeepOwnTurnStart";
    }
}
