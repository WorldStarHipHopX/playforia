package apool;

import com.playray.colorgui.GlossyButton;
import com.playray.multiuser.QuitConfirm;
import com.playray.multiuser.QuitHandler;

import java.awt.event.ActionEvent;

class GameControlPanel_Sub14_Sub1 extends GameControlPanel implements QuitHandler {

    private GlossyButton aGlossyButton4698;
    private boolean aBoolean4699 = false;
    private QuitConfirm aQuitConfirm4700;
    private static final String[] aStringArray4701 = new String[3];


    protected GameControlPanel_Sub14_Sub1(Class60 var1, SPanel_Sub20 var2, int var3, int var4) {
        super(var1, var2, var3, var4);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aGlossyButton4698) {
            ((SPanel_Sub20_Sub1) ((SPanel_Sub20_Sub1) super.aSPanel_Sub20_3959)).method2555();
        } else if (var2 == super.aGlossyButton3965) {
            if (this.aBoolean4699) {
                this.method2486();
            } else {
                super.aSPanel_Sub20_3959.method2546();
            }
        } else {
            super.actionPerformed(var1);
        }

    }

    public void userQuit() {
        this.method2487();
        super.aSPanel_Sub20_3959.method2546();
    }

    public void userCancel() {
        this.method2487();
    }

    protected void method2476() {
        super.aGlossyButton3964 = new GlossyButton(super.aClass60_3958.textManager.method2039("GameControl_NewGame"), 1);
        super.aGlossyButton3964.setBounds(4, super.height - 3 - 20 - 5 - 20 - 5 - 25, super.width - 8, 25);
        super.aGlossyButton3964.addActionListener(this);
        super.aGlossyButton3964.setVisible(false);
        this.add(super.aGlossyButton3964);
        this.aGlossyButton4698 = new GlossyButton(super.aClass60_3958.textManager.method2039("GameControl_Concede"), 4);
        this.aGlossyButton4698.setBounds(4, super.height - 3 - 20 - 5 - 20, super.width - 8, 20);
        this.aGlossyButton4698.addActionListener(this);
        this.aGlossyButton4698.setEnabled(false);
        super.aGlossyButton3965 = new GlossyButton(super.aClass60_3958.textManager.method2039("GameControl_Quit"), 2);
        super.aGlossyButton3965.setBounds(4, super.height - 3 - 20, super.width - 8, 20);
        super.aGlossyButton3965.addActionListener(this);
        this.add(super.aGlossyButton3965);
    }

    protected void method2478(boolean var1) {
        if (var1) {
            this.add(this.aGlossyButton4698);
        } else {
            super.aGlossyButton3965.setColor(4);
        }

    }

    protected void method2479() {
        super.aGlossyButton3965.setColor(2);
        this.aBoolean4699 = true;
    }

    protected void method2480() {
        this.aGlossyButton4698.setEnabled(true);
        this.aGlossyButton4698.setVisible(true);
    }

    protected void method2481() {
        this.aGlossyButton4698.setEnabled(false);
    }

    protected void method2482() {
        this.aGlossyButton4698.setVisible(false);
    }

    protected void method2483() {
        super.aGlossyButton3965.setColor(4);
        this.aBoolean4699 = false;
        this.method2487();
    }

    protected void method2484() {
        this.method2483();
        super.aGlossyButton3964.setVisible(true);
    }

    protected void method2485(boolean var1) {
        if (var1) {
            super.aGlossyButton3965.setColor(4);
            this.aBoolean4699 = false;
            this.method2487();
            super.aGlossyButton3964.setEnabled(false);
        } else {
            super.aGlossyButton3964.setVisible(false);
        }

    }

    private void method2486() {
        this.method2487();
        this.aQuitConfirm4700 = new QuitConfirm(super.aClass60_3958.textManager, super.aClass60_3958.imageManager, this);
        this.aQuitConfirm4700.open(super.aClass60_3958.gameApplet);
    }

    private void method2487() {
        if (this.aQuitConfirm4700 != null) {
            this.aQuitConfirm4700.close();
            this.aQuitConfirm4700 = null;
            super.aClass60_3958.gameApplet.requestFocus();
        }
    }

    static {
        aStringArray4701[0] = "GameControl_Quit";
        aStringArray4701[1] = "GameControl_Concede";
        aStringArray4701[2] = "GameControl_NewGame";
    }
}
