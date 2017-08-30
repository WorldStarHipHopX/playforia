package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IPanel_Sub23 extends IPanel implements ActionListener, ItemListener {

    private Class58_Sub1 aClass58_Sub1_3051;
    private IPanel_Sub7 anIPanel_Sub7_3052;
    private IPanel_Sub35 anIPanel_Sub35_3053;
    private IPanel_Sub35 anIPanel_Sub35_3054;
    private IPanel_Sub35 anIPanel_Sub35_3055;
    private IPanel_Sub35 anIPanel_Sub35_3056;
    private IPanel_Sub35 anIPanel_Sub35_3057;
    private IPanel_Sub35 anIPanel_Sub35_3058;
    private IPanel_Sub35 anIPanel_Sub35_3059;
    private IPanel_Sub35 anIPanel_Sub35_3060;
    private IPanel_Sub35 anIPanel_Sub35_3061;
    private RoundButton aRoundButton3062;
    private RoundButton aRoundButton3063;
    private RoundButton aRoundButton3064;
    private ColorCheckbox aColorCheckbox3065;
    private ColorCheckbox aColorCheckbox3066;
    private Class38 aClass38_3067;
    private static final String[] aStringArray3068 = new String[22];


    public IPanel_Sub23(Class58_Sub1 var1, IPanel_Sub7 var2) {
        this.aClass58_Sub1_3051 = var1;
        this.anIPanel_Sub7_3052 = var2;
        this.setSize(335, 175);
        this.method644();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setFont(AApplet_Sub3.fontDialog12);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.drawString(this.aClass58_Sub1_3051.textManager.getGame("Editor_Tools_Paint"), 10, 25);
        var1.drawString(this.aClass58_Sub1_3051.textManager.getGame("Editor_Tools_Mirror"), 65, 25);
        var1.drawString(this.aClass58_Sub1_3051.textManager.getGame("Editor_Tools_Move"), 123, 25);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.anIPanel_Sub35_3053) {
            this.aClass38_3067 = null;
            this.anIPanel_Sub35_3054.method764(false);
            this.anIPanel_Sub35_3055.method764(false);
        } else if (var2 == this.anIPanel_Sub35_3054) {
            this.aClass38_3067 = null;
            this.anIPanel_Sub35_3053.method764(false);
            this.anIPanel_Sub35_3055.method764(false);
        } else if (var2 == this.anIPanel_Sub35_3055) {
            this.aClass38_3067 = null;
            this.anIPanel_Sub35_3053.method764(false);
            this.anIPanel_Sub35_3054.method764(false);
        } else if (var2 == this.anIPanel_Sub35_3056) {
            this.anIPanel_Sub7_3052.method529();
        } else if (var2 == this.anIPanel_Sub35_3057) {
            this.anIPanel_Sub7_3052.method530();
        } else if (var2 == this.anIPanel_Sub35_3058) {
            this.anIPanel_Sub7_3052.method531(0, -1);
        } else if (var2 == this.anIPanel_Sub35_3059) {
            this.anIPanel_Sub7_3052.method531(0, 1);
        } else if (var2 == this.anIPanel_Sub35_3060) {
            this.anIPanel_Sub7_3052.method531(-1, 0);
        } else if (var2 == this.anIPanel_Sub35_3061) {
            this.anIPanel_Sub7_3052.method531(1, 0);
        } else if (var2 == this.aRoundButton3062) {
            this.anIPanel_Sub7_3052.method532();
        } else if (var2 == this.aRoundButton3063) {
            this.anIPanel_Sub7_3052.method534();
        } else if (var2 == this.aRoundButton3064) {
            this.anIPanel_Sub7_3052.method535();
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorCheckbox3065) {
            this.anIPanel_Sub7_3052.method536(this.aColorCheckbox3065.getState());
        } else if (var2 == this.aColorCheckbox3066) {
            this.anIPanel_Sub7_3052.method537(this.aColorCheckbox3066.getState());
        }

    }

    public int method640() {
        return this.anIPanel_Sub35_3053.method765() ? 0 : (this.anIPanel_Sub35_3054.method765() ? 1 : 2);
    }

    public Class38 method641() {
        return this.anIPanel_Sub35_3053.method765() ? new Class38(0) : (this.anIPanel_Sub35_3054.method765() ? new Class38(1) : (this.aClass38_3067 == null ? new Class38(2) : this.aClass38_3067));
    }

    public void method642(Block[] var1, int var2) {
        this.aClass38_3067 = new Class38(var1, var2);
    }

    public void method643(boolean var1) {
        this.aRoundButton3063.setBackground(var1 ? AApplet_Sub3.aColor3784 : AApplet_Sub3.aColor3785);
    }

    private void method644() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub35_3053 = this.method646("paint_pencil", "paint_pencil_active", 10, 45);
        this.anIPanel_Sub35_3054 = this.method646("paint_fill", "paint_fill_active", 10, 80);
        this.anIPanel_Sub35_3055 = this.method646("paint_stamp", "paint_stamp_active", 10, 115);
        this.anIPanel_Sub35_3053.method764(true);
        this.anIPanel_Sub35_3056 = this.method645("mirror_hor", 65, 60);
        this.anIPanel_Sub35_3057 = this.method645("mirror_ver", 74, 90);
        this.anIPanel_Sub35_3058 = this.method645("move_up", 145, 50);
        this.anIPanel_Sub35_3059 = this.method645("move_down", 145, 115);
        this.anIPanel_Sub35_3060 = this.method645("move_left", 123, 72);
        this.anIPanel_Sub35_3061 = this.method645("move_right", 188, 72);
        this.aRoundButton3062 = this.method647("Test", 230, 15, AApplet_Sub3.colourButtonGreen);
        this.aRoundButton3063 = this.method647("Undo", 230, 47, AApplet_Sub3.aColor3784);
        this.aRoundButton3064 = this.method647("Clear", 230, 134, AApplet_Sub3.aColor3783);
        this.aColorCheckbox3065 = this.method648("Grid", 230, 77);
        this.aColorCheckbox3066 = this.method648("Crosshair", 230, 102);
    }

    private IPanel_Sub35 method645(String var1, int var2, int var3) {
        IPanel_Sub35 var4 = new IPanel_Sub35(this.aClass58_Sub1_3051.imageManager.getImage("editor_" + var1));
        var4.setLocation(var2, var3);
        var4.method763(this);
        this.add(var4);
        return var4;
    }

    private IPanel_Sub35 method646(String var1, String var2, int var3, int var4) {
        IPanel_Sub35 var5 = new IPanel_Sub35(this.aClass58_Sub1_3051.imageManager.getImage("editor_" + var1), this.aClass58_Sub1_3051.imageManager.getImage("editor_" + var2));
        var5.setLocation(var3, var4);
        var5.method763(this);
        this.add(var5);
        return var5;
    }

    private RoundButton method647(String var1, int var2, int var3, Color var4) {
        RoundButton var5 = new RoundButton(this.aClass58_Sub1_3051.textManager.getGame("Editor_Tools_" + var1));
        var5.setBounds(var2, var3, 100, 20);
        var5.setBackground(var4);
        var5.addActionListener(this);
        this.add(var5);
        return var5;
    }

    private ColorCheckbox method648(String var1, int var2, int var3) {
        ColorCheckbox var4 = new ColorCheckbox(this.aClass58_Sub1_3051.textManager.getGame("Editor_Tools_" + var1));
        var4.setBackground(IPanel_Sub9.aColor2969);
        var4.setForeground(AApplet_Sub3.aColor3779);
        var4.setBounds(var2, var3, 100, 20);
        var4.addItemListener(this);
        this.add(var4);
        return var4;
    }

    static {
        aStringArray3068[0] = "Editor_Tools_Paint";
        aStringArray3068[1] = "Editor_Tools_Move";
        aStringArray3068[2] = "Editor_Tools_Mirror";
        aStringArray3068[3] = "Editor_Tools_";
        aStringArray3068[4] = "editor_";
        aStringArray3068[5] = "mirror_ver";
        aStringArray3068[6] = "paint_fill";
        aStringArray3068[7] = "Crosshair";
        aStringArray3068[8] = "move_down";
        aStringArray3068[9] = "paint_pencil_active";
        aStringArray3068[10] = "paint_stamp";
        aStringArray3068[11] = "paint_fill_active";
        aStringArray3068[12] = "Undo";
        aStringArray3068[13] = "Grid";
        aStringArray3068[14] = "paint_stamp_active";
        aStringArray3068[15] = "Clear";
        aStringArray3068[16] = "mirror_hor";
        aStringArray3068[17] = "Test";
        aStringArray3068[18] = "move_left";
        aStringArray3068[19] = "move_up";
        aStringArray3068[20] = "move_right";
        aStringArray3068[21] = "paint_pencil";
    }
}
