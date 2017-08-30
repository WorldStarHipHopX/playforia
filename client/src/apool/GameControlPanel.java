package apool;

import com.playray.client.SPanel;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.GlossyButton;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

abstract class GameControlPanel extends SPanel implements ItemListener, ActionListener {

    protected Class60 aClass60_3958;
    protected SPanel_Sub20 aSPanel_Sub20_3959;
    protected int width;
    protected int height;
    private ColorCheckbox checkboxSound;
    private ColorCheckbox checkboxShadow;
    protected GlossyButton aGlossyButton3964;
    protected GlossyButton aGlossyButton3965;
    private boolean aBoolean3966;


    protected GameControlPanel(Class60 var1, SPanel_Sub20 var2, int width, int height) {
        this.aClass60_3958 = var1;
        this.aSPanel_Sub20_3959 = var2;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.create();
        this.aBoolean3966 = true;
    }

    public void paintContent(Graphics2D g2d) {
        if (this.aBoolean3966) {
            this.aBoolean3966 = false;
            GameApplet.method2302(g2d, this.width, this.height, this);
        }

    }

    public void itemStateChanged(ItemEvent evt) {
        this.aClass60_3958.aClass61_1207.playSounds = this.checkboxSound.getState();
        this.aClass60_3958.aClass61_1207.showShadows = this.checkboxShadow.getState();
        if (evt.getSource() == this.checkboxShadow) {
            this.aSPanel_Sub20_3959.method2544();
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aGlossyButton3964) {
            this.aSPanel_Sub20_3959.method2545();
        }

    }

    protected abstract void method2476();

    private void create() {
        this.checkboxSound = new ColorCheckbox(this.aClass60_3958.textManager.method2039("GameControl_Sound"), this.aClass60_3958.aClass61_1207.playSounds);
        this.checkboxSound.setBounds(4, 3, this.width - 8, 17);
        this.checkboxSound.setForeground(GameApplet.aColor4808);
        this.checkboxSound.addItemListener(this);
        this.add(this.checkboxSound);
        this.checkboxShadow = new ColorCheckbox(this.aClass60_3958.textManager.method2039("GameControl_Shadow"), this.aClass60_3958.aClass61_1207.showShadows);
        this.checkboxShadow.setBounds(4, 22, this.width - 8, 17);
        this.checkboxShadow.setForeground(GameApplet.aColor4808);
        this.checkboxShadow.addItemListener(this);
        this.add(this.checkboxShadow);
        this.method2476();
    }
}
