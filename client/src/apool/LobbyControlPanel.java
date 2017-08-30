package apool;

import com.playray.client.SPanel;
import com.playray.colorgui.ColorCheckbox;
import com.playray.multiuser.NoChallCheckbox;

import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class LobbyControlPanel extends SPanel implements ItemListener {

    private Class60 aClass60_3977;
    private SPanel_Sub21 aSPanel_Sub21_3978;
    private int width;
    private int height;
    private ColorCheckbox checkboxChallengeSound;
    private NoChallCheckbox checkboxNoChallenges;
    private boolean shouldPaint;
    private static final String[] aStringArray3984 = new String[3];


    protected LobbyControlPanel(Class60 var1, SPanel_Sub21 var2, boolean var3, int width, int height) {
        this.aClass60_3977 = var1;
        this.aSPanel_Sub21_3978 = var2;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.create(var3);
        this.shouldPaint = true;
    }

    public void paintContent(Graphics2D var1) {
        if (this.shouldPaint) {
            this.shouldPaint = false;
            GameApplet.method2302(var1, this.width, this.height, this);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        this.aSPanel_Sub21_3978.method2576();
        Object var2 = var1.getSource();
        if (var2 == this.checkboxNoChallenges) {
            this.aClass60_3977.aClass61_1207.aBoolean1226 = this.checkboxNoChallenges.getState();
            this.aSPanel_Sub21_3978.method2583();
            this.checkboxChallengeSound.setEnabled(!this.aClass60_3977.aClass61_1207.aBoolean1226);
        } else if (var2 == this.checkboxChallengeSound) {
            this.aClass60_3977.aClass61_1207.aBoolean1227 = this.checkboxChallengeSound.getState();
        }

    }

    protected void method2491() {
        if (!this.checkboxNoChallenges.getState()) {
            this.checkboxNoChallenges.setState(true);
            this.aClass60_3977.aClass61_1207.aBoolean1226 = true;
            this.aSPanel_Sub21_3978.method2580("nc\tt");
            this.aSPanel_Sub21_3978.method2577(true);
            this.checkboxChallengeSound.setEnabled(false);
        }

    }

    private void create(boolean var1) {
        this.checkboxNoChallenges = new NoChallCheckbox(this.aClass60_3977.textManager.method2039("Lobby_Control_NoChallanges"));
        this.checkboxNoChallenges.setBounds(5, 5, this.width - 5 - 5, 20);
        this.checkboxNoChallenges.setForeground(GameApplet.aColor4808);
        this.checkboxNoChallenges.addItemListener(this);
        if (var1) {
            this.aClass60_3977.aClass61_1207.aBoolean1226 = false;
        }

        this.checkboxNoChallenges.setState(this.aClass60_3977.aClass61_1207.aBoolean1226);
        if (!var1) {
            this.add(this.checkboxNoChallenges);
        }

        this.checkboxChallengeSound = new ColorCheckbox(this.aClass60_3977.textManager.method2039("Lobby_Control_ChallengeSound"));
        this.checkboxChallengeSound.setBounds(5, 30, this.width - 5 - 5, 20);
        this.checkboxChallengeSound.setForeground(GameApplet.aColor4808);
        this.checkboxChallengeSound.addItemListener(this);
        this.checkboxChallengeSound.setState(this.aClass60_3977.aClass61_1207.aBoolean1227);
        if (!this.aClass60_3977.aClass61_1207.aBoolean1226) {
            this.add(this.checkboxChallengeSound);
        }

    }
}
