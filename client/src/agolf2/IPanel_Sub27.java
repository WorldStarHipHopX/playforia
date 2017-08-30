package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class IPanel_Sub27 extends IPanel implements ActionListener {

    protected Class58_Sub1 aClass58_Sub1_3090;
    protected EditorPopupFrame aJFrame__3091;
    private int anInt3092;
    private int anInt3093;
    private RoundButton aRoundButton3094;
    private RoundButton aRoundButton3095;
    protected boolean aBoolean3096;
    protected int anInt3097;
    private static final String[] aStringArray3098 = new String[4];


    protected IPanel_Sub27(Class58_Sub1 var1, EditorPopupFrame var2, int var3, int var4) {
        this.aClass58_Sub1_3090 = var1;
        this.aJFrame__3091 = var2;
        this.anInt3092 = var3;
        this.anInt3093 = var4;
        this.setBounds(0, 0, var3, var4);
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setForeground(AApplet_Sub3.aColor3779);
        this.setLayout((LayoutManager) null);
        this.aRoundButton3094 = this.method671("Popup_Cancel", 10, var4 - 10 - 20, 100, 20, AApplet_Sub3.aColor3785);
        this.setBackground(var1.imageManager.getImage("background"));
        this.aBoolean3096 = false;
        this.anInt3097 = -1;
    }

    public void update(Graphics var1) {
        super.update(var1);
        this.method669(var1);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 != this.aRoundButton3094 && var2 != this.aRoundButton3095) {
            this.method670(var2);
        } else {
            this.aJFrame__3091.anIPanel_Sub7_2254.method548();
        }
    }

    protected abstract void method669(Graphics var1);

    protected abstract void method670(Object var1);

    protected RoundButton method671(String var1, int var2, int var3, int var4, int var5, Color var6) {
        RoundButton var7 = new RoundButton(this.aClass58_Sub1_3090.textManager.getGame("Editor_" + var1));
        var7.setBounds(var2, var3, var4, var5);
        var7.setBackground(var6);
        var7.addActionListener(this);
        this.add(var7);
        return var7;
    }

    protected void method672() {
        this.aBoolean3096 = true;
        this.removeAll();
        this.repaint();
    }

    protected void method673(int var1) {
        this.anInt3097 = var1;
        this.aRoundButton3095 = this.method671("Popup_Ok", this.anInt3092 - 10 - 100, this.anInt3093 - 10 - 25, 100, 25, AApplet_Sub3.aColor3784);
        this.repaint();
    }

    static {
        aStringArray3098[0] = "Editor_";
        aStringArray3098[1] = "Popup_Ok";
        aStringArray3098[2] = "background";
        aStringArray3098[3] = "Popup_Cancel";
    }
}
