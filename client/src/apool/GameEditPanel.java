package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.colorgui.ColorCheckbox;
import com.playray.colorgui.GlossyButton;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class GameEditPanel extends SPanel implements ItemListener, ActionListener {

    protected Class60 aClass60_3992;
    protected SPanel_Sub20_Sub2 aSPanel_Sub20_Sub2_3993;
    protected int anInt3994;
    protected int anInt3995;
    private GlossyButton aGlossyButton3996;
    private GlossyButton aGlossyButton3997;
    private GlossyButton aGlossyButton3998;
    private ColorCheckbox aColorCheckbox3999;
    private boolean aBoolean4000;
    private boolean aBoolean4001;


    protected GameEditPanel(Class60 var1, SPanel_Sub20_Sub2 var2, int var3, int var4) {
        this.aClass60_3992 = var1;
        this.aSPanel_Sub20_Sub2_3993 = var2;
        this.anInt3994 = var3;
        this.anInt3995 = var4;
        this.setSize(var3, var4);
        this.method2504();
        this.aBoolean4000 = true;
        this.aBoolean4001 = false;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean4000) {
            this.aBoolean4000 = false;
            GameApplet.method2302(var1, this.anInt3994, this.anInt3995, this);
        } else {
            var1.setFont(GameApplet.aFont4816);
            var1.setColor(GameApplet.aColor4808);
            var1.drawString(this.aClass60_3992.textManager.method2039("GameEdit_Title"), 10, 20);
            if (this.aColorCheckbox3999.isEnabled()) {
                var1.setColor(GameApplet.aColor4809);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3992.textManager.method2039("GameEdit_MoveInstructions"), this.anInt3994 / 2 + 1, 45, -1, this.anInt3994 - 10 - this.anInt3994 / 2 - 1);
            } else if (this.aBoolean4001) {
                var1.setColor(GameApplet.aColor4809);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3992.textManager.method2039("GameEdit_EndInstructions"), this.anInt3994 / 2 + 1, 45, -1, this.anInt3994 - 10 - this.anInt3994 / 2 - 1);
            } else if (!this.aClass60_3992.gameApplet.method2309()) {
                var1.setColor(GameApplet.aColor4810);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3992.textManager.method2039("GameEdit_NotWithoutAccount"), this.anInt3994 / 2 + 1, 45, -1, this.anInt3994 - 10 - this.anInt3994 / 2 - 1);
            }

        }
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton3996) {
            this.aClass60_3992.gameApplet.method2326();
        } else if (var2 == this.aGlossyButton3997) {
            boolean var3 = this.aSPanel_Sub20_Sub2_3993.method2566();
            this.aGlossyButton3998.setEnabled(!var3);
            this.aColorCheckbox3999.setEnabled(var3);
            this.aGlossyButton3997.setLabel(this.aClass60_3992.textManager.method2039("GameEdit_Move" + (var3 ? "End" : "Start") + "Button"));
            this.repaint();
        } else if (var2 == this.aGlossyButton3998) {
            this.aSPanel_Sub20_Sub2_3993.method2569();
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        if (var1.getSource() == this.aColorCheckbox3999) {
            this.aSPanel_Sub20_Sub2_3993.method2567(this.aColorCheckbox3999.getState());
        }

    }

    protected void method2500() {
        this.aGlossyButton3997.setEnabled(false);
        this.aGlossyButton3997.setLabel(this.aClass60_3992.textManager.method2039("GameEdit_MoveStartButton"));
        this.aColorCheckbox3999.setEnabled(false);
        this.aGlossyButton3998.setEnabled(false);
        this.aBoolean4001 = false;
        this.repaint();
    }

    protected void method2501() {
        if (this.aClass60_3992.gameApplet.method2309()) {
            this.aGlossyButton3997.setEnabled(true);
            this.aColorCheckbox3999.setEnabled(false);
            this.aGlossyButton3998.setEnabled(true);
        }

    }

    protected void method2502() {
        this.aGlossyButton3997.setEnabled(false);
        this.aColorCheckbox3999.setEnabled(false);
        this.aGlossyButton3998.setEnabled(false);
        this.aBoolean4001 = false;
        this.repaint();
    }

    protected void method2503() {
        this.aBoolean4001 = true;
        this.repaint();
    }

    private void method2504() {
        short var1 = 150;
        this.aGlossyButton3997 = new GlossyButton(this.aClass60_3992.textManager.method2039("GameEdit_MoveStartButton"), 3);
        this.aGlossyButton3997.setBounds(10, 35, var1, 25);
        this.aGlossyButton3997.setEnabled(false);
        this.aGlossyButton3997.addActionListener(this);
        this.add(this.aGlossyButton3997);
        this.aColorCheckbox3999 = new ColorCheckbox(this.aClass60_3992.textManager.method2039("GameEdit_MoveGridCheckBox"));
        this.aColorCheckbox3999.setBounds(10 + var1 + 5, 37, 120, 21);
        this.aColorCheckbox3999.setForeground(GameApplet.aColor4808);
        this.aColorCheckbox3999.setEnabled(false);
        this.aColorCheckbox3999.addItemListener(this);
        this.add(this.aColorCheckbox3999);
        this.aGlossyButton3998 = new GlossyButton(this.aClass60_3992.textManager.method2039("GameEdit_UndoButton"), 3);
        this.aGlossyButton3998.setBounds(10, 65, var1, 25);
        this.aGlossyButton3998.setEnabled(false);
        this.aGlossyButton3998.addActionListener(this);
        this.add(this.aGlossyButton3998);
        if (!this.aClass60_3992.gameApplet.method2309()) {
            this.aGlossyButton3996 = new GlossyButton(this.aClass60_3992.textManager.method2039("GameEdit_CreateAccountButton"), 3);
            this.aGlossyButton3996.setBounds(this.anInt3994 / 2 + 1, this.anInt3995 - 20 - 25, 175, 25);
            this.aGlossyButton3996.addActionListener(this);
            this.add(this.aGlossyButton3996);
        }

    }
}
