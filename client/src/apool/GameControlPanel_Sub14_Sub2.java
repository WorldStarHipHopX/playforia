package apool;

import com.playray.colorgui.GlossyButton;

import java.awt.event.ActionEvent;

class GameControlPanel_Sub14_Sub2 extends GameControlPanel {

    private static final String[] aStringArray4833 = new String[2];


    protected GameControlPanel_Sub14_Sub2(Class60 var1, SPanel_Sub20 var2, int var3, int var4) {
        super(var1, var2, var3, var4);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == super.aGlossyButton3965) {
            super.aSPanel_Sub20_3959.method2546();
        } else {
            super.actionPerformed(var1);
        }

    }

    protected void method2476() {
        super.aGlossyButton3964 = new GlossyButton(super.aClass60_3958.textManager.method2039("GameControl_NewGame"), 1);
        super.aGlossyButton3964.setBounds(4, super.height - 3 - 20 - 5 - 20 - 5 - 25, super.width - 8, 25);
        super.aGlossyButton3964.addActionListener(this);
        super.aGlossyButton3964.setEnabled(false);
        this.add(super.aGlossyButton3964);
        super.aGlossyButton3965 = new GlossyButton(super.aClass60_3958.textManager.method2039("GameControl_Quit"), 4);
        super.aGlossyButton3965.setBounds(4, super.height - 3 - 20, super.width - 8, 20);
        super.aGlossyButton3965.addActionListener(this);
        this.add(super.aGlossyButton3965);
    }

    protected void method2488(boolean var1) {
        super.aGlossyButton3964.setEnabled(var1);
    }

    static {
        aStringArray4833[0] = "GameControl_Quit";
        aStringArray4833[1] = "GameControl_NewGame";
    }
}
