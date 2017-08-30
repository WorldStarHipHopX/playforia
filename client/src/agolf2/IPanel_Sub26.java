package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IPanel_Sub26 extends IPanel implements ActionListener {

    private Class58_Sub1 aClass58_Sub1_3081;
    private int anInt3082;
    private int anInt3083;
    private RoundButton aRoundButton3084;
    private RoundButton aRoundButton3085;
    private RoundButton aRoundButton3086;
    private ColorCheckbox aColorCheckbox3087;
    private ColorButton aColorButton3088;
    private static final String[] aStringArray3089 = new String[12];


    protected IPanel_Sub26(Class58_Sub1 var1, int var2, int var3) {
        this.aClass58_Sub1_3081 = var1;
        this.anInt3082 = var2;
        this.anInt3083 = var3;
        this.setSize(var2, var3);
        this.method666();
        this.setBackground(var1.imageManager.getImage("background_select"));
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog11);
        if (AApplet_Sub3_Sub1.aString4749 != null) {
            StringDraw.drawString(var1, AApplet_Sub3_Sub1.aString4749, this.anInt3082 / 2, this.anInt3083 - 10, 0);
        }

        if (!this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method60()) {
            StringDraw.drawString(var1, this.aClass58_Sub1_3081.textManager.getGame("Select_RegisteredOnly"), this.anInt3082 * 3 / 4 + 25, this.anInt3083 - 38, 0);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.aSynchronizedBool_3777.method1168()) {
            this.aClass58_Sub1_3081.aClass59_Sub1_3569.aBoolean3579 = this.aColorCheckbox3087.getState();
            Object var2 = var1.getSource();
            if (var2 != this.aRoundButton3084 && var2 != this.aRoundButton3085) {
                if (var2 == this.aRoundButton3086) {
                    if (this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method60()) {
                        this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method54(0);
                        this.method668("editor");
                    } else {
                        this.aClass58_Sub1_3081.aSoundManager1189.playIllegal();
                    }
                } else if (var2 == this.aColorButton3088) {
                    this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method54(0);
                    this.method668("ta");
                }
            } else {
                this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method54(0);
                if (var2 == this.aRoundButton3084) {
                    this.method668("single\t" + (this.aClass58_Sub1_3081.aClass59_Sub1_3569.aBoolean3579 ? 't' : 'f'));
                } else {
                    this.method668("multi");
                }
            }

        }
    }

    private void method666() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton3084 = this.method667("SinglePlayer", this.anInt3082 / 4 - 75 - 27, this.anInt3083 - 80, 150, 30, AApplet_Sub3.aColor3784);
        this.aColorCheckbox3087 = new ColorCheckbox(this.aClass58_Sub1_3081.textManager.getGame("Select_NoChat"), this.aClass58_Sub1_3081.aClass59_Sub1_3569.aBoolean3579);
        this.aColorCheckbox3087.setBounds(this.anInt3082 / 4 - 60 - 27, this.anInt3083 - 80 + 30 + 2, 120, 15);
        this.aColorCheckbox3087.setForeground(AApplet_Sub3.aColor3779);
        this.add(this.aColorCheckbox3087);
        this.aRoundButton3085 = this.method667("MultiPlayer", this.anInt3082 / 2 - 75, this.anInt3083 - 80, 150, 30, AApplet_Sub3.aColor3784);
        boolean var1 = this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method60();
        this.aRoundButton3086 = this.method667("Editor", this.anInt3082 * 3 / 4 - 75 + 25, this.anInt3083 - 80, 150, 30, var1 ? AApplet_Sub3.aColor3784 : AApplet_Sub3.aColor3785);
        if (this.aClass58_Sub1_3081.anAApplet_Sub3_Sub1_3567.method59() == 2) {
            this.aColorButton3088 = new ColorButton();
            this.aColorButton3088.setBounds(this.anInt3082 - 4, 0, 4, 4);
            this.aColorButton3088.setBackground(AApplet_Sub3.aColor3784);
            this.aColorButton3088.addActionListener(this);
            this.add(this.aColorButton3088);
        }

    }

    private RoundButton method667(String var1, int var2, int var3, int var4, int var5, Color var6) {
        RoundButton var7 = new RoundButton(this.aClass58_Sub1_3081.textManager.getGame("Select_" + var1));
        var7.setBounds(var2, var3, var4, var5);
        var7.setBackground(var6);
        var7.addActionListener(this);
        this.add(var7);
        return var7;
    }

    private void method668(String var1) {
        this.aClass58_Sub1_3081.aClass36_Sub1_3572.method1179("select\t" + var1);
    }

    static {
        aStringArray3089[0] = "Select_RegisteredOnly";
        aStringArray3089[1] = "MultiPlayer";
        aStringArray3089[2] = "Select_NoChat";
        aStringArray3089[3] = "Editor";
        aStringArray3089[4] = "SinglePlayer";
        aStringArray3089[5] = "multi";
        aStringArray3089[6] = "ta";
        aStringArray3089[7] = "single\t";
        aStringArray3089[8] = "editor";
        aStringArray3089[9] = "background_select";
        aStringArray3089[10] = "Select_";
        aStringArray3089[11] = "select\t";
    }
}
