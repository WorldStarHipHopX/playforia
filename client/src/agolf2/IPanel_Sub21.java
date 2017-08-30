package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPanel_Sub21 extends IPanel implements ActionListener {

    private Class58_Sub1 aClass58_Sub1_3043;
    private IPanel_Sub7 anIPanel_Sub7_3044;
    private RoundButton aRoundButton3045;
    private RoundButton aRoundButton3046;
    private RoundButton aRoundButton3047;
    private RoundButton aRoundButton3048;
    private RoundButton aRoundButton3049;
    private static final String[] aStringArray3050 = new String[11];


    public IPanel_Sub21(Class58_Sub1 var1, IPanel_Sub7 var2) {
        this.aClass58_Sub1_3043 = var1;
        this.anIPanel_Sub7_3044 = var2;
        this.setSize(335, 175);
        this.method631();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setFont(AApplet_Sub3.fontDialog12);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.drawString(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_SaveInfo"), 130, 35);
        var1.drawString(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_PublishInfo"), 130, 65);
        var1.drawString(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_LoadInfo"), 130, 95);
        var1.drawString(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_DeleteInfo"), 130, 125);
        var1.drawString(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_BackInfo"), 130, 155);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton3045) {
            this.anIPanel_Sub7_3044.method538();
        } else if (var2 == this.aRoundButton3046) {
            this.anIPanel_Sub7_3044.method540();
        } else if (var2 == this.aRoundButton3047) {
            this.anIPanel_Sub7_3044.method542();
        } else if (var2 == this.aRoundButton3048) {
            this.anIPanel_Sub7_3044.method544();
        } else if (var2 == this.aRoundButton3049) {
            this.anIPanel_Sub7_3044.method546();
        }

    }

    private void method631() {
        this.setLayout((LayoutManager) null);
        this.aRoundButton3045 = this.method632("Save", 20, 20, AApplet_Sub3.aColor3784);
        this.aRoundButton3046 = this.method632("Publish", 20, 50, AApplet_Sub3.aColor3784);
        this.aRoundButton3047 = this.method632("Load", 20, 80, AApplet_Sub3.colourButtonGreen);
        this.aRoundButton3048 = this.method632("Delete", 20, 110, AApplet_Sub3.aColor3783);
        this.aRoundButton3049 = this.method632("Back", 20, 140, AApplet_Sub3.aColor3782);
    }

    private RoundButton method632(String var1, int var2, int var3, Color var4) {
        RoundButton var5 = new RoundButton(this.aClass58_Sub1_3043.textManager.getGame("Editor_File_" + var1));
        var5.setBounds(var2, var3, 100, 20);
        var5.setBackground(var4);
        var5.addActionListener(this);
        this.add(var5);
        return var5;
    }

    static {
        aStringArray3050[0] = "Publish";
        aStringArray3050[1] = "Save";
        aStringArray3050[2] = "Load";
        aStringArray3050[3] = "Delete";
        aStringArray3050[4] = "Back";
        aStringArray3050[5] = "Editor_File_SaveInfo";
        aStringArray3050[6] = "Editor_File_DeleteInfo";
        aStringArray3050[7] = "Editor_File_LoadInfo";
        aStringArray3050[8] = "Editor_File_BackInfo";
        aStringArray3050[9] = "Editor_File_PublishInfo";
        aStringArray3050[10] = "Editor_File_";
    }
}
