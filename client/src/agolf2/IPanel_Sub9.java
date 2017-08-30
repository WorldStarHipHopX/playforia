package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.colorgui.TabBar;

import java.awt.Color;
import java.awt.LayoutManager;

public class IPanel_Sub9 extends IPanel {

    public static final Color aColor2969;
    public static final Color aColor2970;
    private Class58_Sub1 aClass58_Sub1_2971;
    private IPanel_Sub7 anIPanel_Sub7_2972;
    private TabBar aTabBar2973;
    private TabBar aTabBar2974;
    private IPanel_Sub13 anIPanel_Sub13_2975;
    private IPanel_Sub15 anIPanel_Sub15_2976;
    private IPanel_Sub17 anIPanel_Sub17_2977;
    private IPanel_Sub23 anIPanel_Sub23_2978;
    private IPanel_Sub21 anIPanel_Sub21_2979;
    private static final String[] aStringArray2980 = new String[4];


    protected IPanel_Sub9(Class58_Sub1 var1, IPanel_Sub7 var2, int var3, int var4) {
        this.aClass58_Sub1_2971 = var1;
        this.anIPanel_Sub7_2972 = var2;
        this.setSize(var3, var4);
        this.method570();
    }

    protected int method562() {
        return this.anIPanel_Sub23_2978.method640();
    }

    protected Class38 method563(boolean var1) {
        Class38 var2 = this.anIPanel_Sub23_2978.method641();
        int var3 = var2.method1223();
        if (var3 == 0 || var3 == 1) {
            Block var4 = this.anIPanel_Sub17_2977.method610(var1);
            var2.method1224(var4);
        }

        return var2;
    }

    protected Class38 method564() {
        Class38 var1 = this.anIPanel_Sub23_2978.method641();
        return var1.method1223() == 3 ? var1 : null;
    }

    protected void method565(Block[] var1, int var2) {
        this.anIPanel_Sub23_2978.method642(var1, var2);
    }

    protected void method566(boolean var1) {
        this.anIPanel_Sub23_2978.method643(var1);
    }

    public void method567(Block var1, boolean var2) {
        if (var1 instanceof BlockBasic) {
            this.anIPanel_Sub13_2975.method592((BlockBasic) ((BlockBasic) var1), var2);
        } else {
            this.anIPanel_Sub15_2976.method605((BlockSpecial) ((BlockSpecial) var1), var2);
        }

    }

    protected String method568() {
        return "-";
    }

    protected void method569(String var1, String var2) {
    }

    private void method570() {
        this.setLayout((LayoutManager) null);
        this.aTabBar2973 = this.method571(0, 0, 325, 200);
        this.aTabBar2974 = this.method571(510, 0, 340, 200);
        this.anIPanel_Sub13_2975 = new IPanel_Sub13(this.aClass58_Sub1_2971);
        this.aTabBar2973.addTab(this.aClass58_Sub1_2971.textManager.getGame("Editor_Basic"), this.anIPanel_Sub13_2975);
        this.anIPanel_Sub15_2976 = new IPanel_Sub15(this.aClass58_Sub1_2971);
        this.aTabBar2973.addTab(this.aClass58_Sub1_2971.textManager.getGame("Editor_Special"), this.anIPanel_Sub15_2976);
        this.anIPanel_Sub23_2978 = new IPanel_Sub23(this.aClass58_Sub1_2971, this.anIPanel_Sub7_2972);
        this.aTabBar2974.addTab(this.aClass58_Sub1_2971.textManager.getGame("Editor_Tools"), this.anIPanel_Sub23_2978);
        this.anIPanel_Sub21_2979 = new IPanel_Sub21(this.aClass58_Sub1_2971, this.anIPanel_Sub7_2972);
        this.aTabBar2974.addTab(this.aClass58_Sub1_2971.textManager.getGame("Editor_File"), this.anIPanel_Sub21_2979);
        this.add(this.aTabBar2973);
        this.add(this.aTabBar2974);
        this.anIPanel_Sub17_2977 = new IPanel_Sub17(this.aClass58_Sub1_2971, this);
        this.anIPanel_Sub17_2977.setBounds(335, 21, 165, 179);
        this.add(this.anIPanel_Sub17_2977);
        IPanel_Sub11 var1 = this.anIPanel_Sub17_2977.method609();
        this.anIPanel_Sub13_2975.method591(var1);
        this.anIPanel_Sub15_2976.method604(var1);
    }

    private TabBar method571(int var1, int var2, int var3, int var4) {
        TabBar var5 = new TabBar(var3, var4);
        var5.setBackground(AApplet_Sub3.aColor3778);
        var5.setBorderColor(aColor2970);
        var5.setButtonBackground(aColor2969);
        var5.setButtonForeground(AApplet_Sub3.aColor3779);
        var5.setLocation(var1, var2);
        return var5;
    }

    static {
        aStringArray2980[0] = "Editor_Basic";
        aStringArray2980[1] = "Editor_Tools";
        aStringArray2980[2] = "Editor_File";
        aStringArray2980[3] = "Editor_Special";
        aColor2969 = new Color(0, 160, 32);
        aColor2970 = new Color(224, 224, 255);
    }
}
