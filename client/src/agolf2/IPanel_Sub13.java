package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPanel_Sub13 extends IPanel implements Interface3, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2288;
    private IPanel_Sub11 anIPanel_Sub11_2289;
    private IPanel_Sub25 anIPanel_Sub25_2290;
    private IPanel_Sub25 anIPanel_Sub25_2291;
    private IPanel_Sub25 anIPanel_Sub25_2292;
    private IPanel_Sub35 anIPanel_Sub35_2293;
    private String aString2294;
    private Image anImage2295;
    private Graphics aGraphics2296;
    private static final String[] aStringArray2297 = new String[7];


    public IPanel_Sub13(Class58_Sub1 var1) {
        this.aClass58_Sub1_2288 = var1;
        this.setSize(320, 175);
        this.method593();
    }

    public void update(Graphics var1) {
        if (this.anImage2295 == null || this.aGraphics2296 == null) {
            this.anImage2295 = this.createImage(320, 175);
            this.aGraphics2296 = this.anImage2295.getGraphics();
        }

        this.drawBackground(this.aGraphics2296);
        if (this.aString2294 != null) {
            this.aGraphics2296.setFont(AApplet_Sub3.fontDialog11);
            this.aGraphics2296.setColor(AApplet_Sub3.aColor3779);
            StringDraw.drawStringWithMaxWidth(this.aGraphics2296, this.aString2294, 6, 156, -1, 308);
        }

        var1.drawImage(this.anImage2295, 0, 0, this);
    }

    public void method3(IPanel_Sub25 var1, int var2) {
        if (var1 == this.anIPanel_Sub25_2290 && var2 >= 0) {
            this.aString2294 = this.aClass58_Sub1_2288.textManager.getGame("Editor_ShapeInfo");
        } else if (var1 == this.anIPanel_Sub25_2291 && var2 >= 0) {
            this.aString2294 = this.aClass58_Sub1_2288.textManager.getGame("Editor_ElementInfo_" + var2);
        } else if (var1 == this.anIPanel_Sub25_2292 && var2 >= 0) {
            this.aString2294 = this.aClass58_Sub1_2288.textManager.getGame("Editor_SlopeInfo_" + var2);
        } else {
            this.aString2294 = null;
        }

        this.repaint();
    }

    public void method4(IPanel_Sub25 var1, int var2, boolean var3) {
        int var4 = this.anIPanel_Sub25_2290.method657();
        if (var1 == this.anIPanel_Sub25_2290 && this.anIPanel_Sub11_2289.method580() != var3) {
            Block var5 = this.anIPanel_Sub11_2289.method579(var3);
            if (var5 instanceof BlockBasic) {
                this.method592((BlockBasic) ((BlockBasic) var5), false);
            }

            this.anIPanel_Sub11_2289.method581(var3);
            var4 = var2;
        }

        int var9 = this.anIPanel_Sub25_2291.method658();
        int var6 = this.anIPanel_Sub25_2291.method659();
        int var7 = this.anIPanel_Sub25_2292.method658();
        int var8 = this.anIPanel_Sub25_2292.method659();
        this.anIPanel_Sub11_2289.method578(new BlockBasic(this.aClass58_Sub1_2288.aClass39_Sub1_1191, var4, var9, var6, var7, var8));
    }

    public void actionPerformed(ActionEvent var1) {
        int var2 = this.anIPanel_Sub25_2290.method657();
        int var3 = this.anIPanel_Sub25_2291.method658();
        int var4 = this.anIPanel_Sub25_2291.method659();
        int var5 = this.anIPanel_Sub25_2292.method658();
        int var6 = this.anIPanel_Sub25_2292.method659();
        BlockBasic var7 = new BlockBasic(this.aClass58_Sub1_2288.aClass39_Sub1_1191, var2, var4, var3, var6, var5);
        this.anIPanel_Sub11_2289.method578(var7);
        this.method592(var7, false);
    }

    public void method591(IPanel_Sub11 var1) {
        this.anIPanel_Sub11_2289 = var1;
    }

    public void method592(BlockBasic var1, boolean var2) {
        if (var2) {
            this.anIPanel_Sub25_2290.method660(var1.method1206());
        }

        this.anIPanel_Sub25_2291.method661(var1.getElements1(), var1.getElements2());
        this.anIPanel_Sub25_2292.method661(var1.getSlopes1(), var1.getSlopes2());
    }

    private void method593() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub25_2290 = new IPanel_Sub25(this.aClass58_Sub1_2288.imageManager.getImage("track_shapes"), 9, 8, this, false);
        this.anIPanel_Sub25_2290.method656(new int[]{2, 9, 10, 11, 21, 23, 24, 26, 39, 41, 42, 44, 48, 50, 51, 53, 66, 68, 69, 71});
        this.anIPanel_Sub25_2290.setLocation(5, 8);
        this.add(this.anIPanel_Sub25_2290);
        this.anIPanel_Sub25_2291 = new IPanel_Sub25(this.aClass58_Sub1_2288.imageManager.getImage("track_elements"), 4, 7, this, true);
        this.anIPanel_Sub25_2291.method656(new int[]{6, 7, 11, 12, 14, 15, 17, 19, 20, 22, 23, 25});
        this.anIPanel_Sub25_2291.setLocation(175, 8);
        this.add(this.anIPanel_Sub25_2291);
        this.anIPanel_Sub25_2292 = new IPanel_Sub25(this.aClass58_Sub1_2288.imageManager.getImage("track_slopes"), 3, 3, this, true);
        this.anIPanel_Sub25_2292.setLocation(260, 8);
        this.add(this.anIPanel_Sub25_2292);
        this.anIPanel_Sub35_2293 = new IPanel_Sub35(this.aClass58_Sub1_2288.imageManager.getImage("editor_mouse"));
        this.anIPanel_Sub35_2293.setLocation(255, 75);
        this.anIPanel_Sub35_2293.method763(this);
        this.add(this.anIPanel_Sub35_2293);
    }

    static {
        aStringArray2297[0] = "track_slopes";
        aStringArray2297[1] = "editor_mouse";
        aStringArray2297[2] = "track_shapes";
        aStringArray2297[3] = "track_elements";
        aStringArray2297[4] = "Editor_ShapeInfo";
        aStringArray2297[5] = "Editor_SlopeInfo_";
        aStringArray2297[6] = "Editor_ElementInfo_";
    }
}
