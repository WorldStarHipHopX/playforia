package agolf2;

import com.aapeli.client.IPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

public class IPanel_Sub17 extends IPanel implements Interface2, Interface1 {

    private Class58_Sub1 aClass58_Sub1_2284;
    private IPanel_Sub9 anIPanel_Sub9_2285;
    private IPanel_Sub11 anIPanel_Sub11_2286;
    private IPanel_Sub19 anIPanel_Sub19_2287;


    public IPanel_Sub17(Class58_Sub1 var1, IPanel_Sub9 var2) {
        this.aClass58_Sub1_2284 = var1;
        this.anIPanel_Sub9_2285 = var2;
        this.method612();
        BlockBasic var3 = new BlockBasic(var1.aClass39_Sub1_1191, 1, 24, 0, 4, 4);
        BlockBasic var4 = new BlockBasic(var1.aClass39_Sub1_1191, 0, 24, 0, 4, 4);
        this.anIPanel_Sub11_2286.method577(var4);
        this.anIPanel_Sub11_2286.method576(var3);
        this.method611(var3);
        this.anIPanel_Sub19_2287.method618(var4);
        this.anIPanel_Sub19_2287.method618(var3);
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        Dimension var2 = this.getSize();
        var1.setColor(IPanel_Sub9.aColor2970);
        var1.drawRect(0, 0, var2.width - 1, var2.height - 1);
        var1.drawRect(1, 1, var2.width - 3, var2.height - 3);
    }

    public void method2(Block var1, boolean var2) {
        if (!var2) {
            this.anIPanel_Sub11_2286.method576(var1);
        } else {
            this.anIPanel_Sub11_2286.method577(var1);
        }

        this.method611(var1);
    }

    public void method1(Block var1) {
        this.method611(var1);
    }

    public IPanel_Sub11 method609() {
        return this.anIPanel_Sub11_2286;
    }

    public Block method610(boolean var1) {
        Block var2 = this.anIPanel_Sub11_2286.method579(var1);
        this.anIPanel_Sub19_2287.method618(var2);
        return var2;
    }

    protected void method611(Block var1) {
        this.anIPanel_Sub9_2285.method567(var1, true);
    }

    private void method612() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub11_2286 = new IPanel_Sub11(this.aClass58_Sub1_2284, this);
        this.anIPanel_Sub11_2286.setLocation(10, 88);
        this.add(this.anIPanel_Sub11_2286);
        this.anIPanel_Sub19_2287 = new IPanel_Sub19(3, 9, this);
        this.anIPanel_Sub19_2287.setLocation(105, 13);
        this.add(this.anIPanel_Sub19_2287);
    }
}
