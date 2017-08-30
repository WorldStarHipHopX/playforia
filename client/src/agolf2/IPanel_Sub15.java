package agolf2;

import com.aapeli.client.IPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

public class IPanel_Sub15 extends IPanel implements Interface3 {

    private Class58_Sub1 aClass58_Sub1_2298;
    private IPanel_Sub11 anIPanel_Sub11_2299;
    private IPanel_Sub25 anIPanel_Sub25_2300;
    private IPanel_Sub25 anIPanel_Sub25_2301;
    private IPanel_Sub25 anIPanel_Sub25_2302;
    private String aString2303;
    private Image anImage2304;
    private Graphics aGraphics2305;
    private static final String[] aStringArray2306 = new String[6];


    public IPanel_Sub15(Class58_Sub1 var1) {
        this.aClass58_Sub1_2298 = var1;
        this.setSize(320, 175);
        this.method606();
        this.anIPanel_Sub25_2300.method660(0);
        this.anIPanel_Sub25_2301.method660(0);
        this.anIPanel_Sub25_2302.method660(4);
    }

    public void update(Graphics var1) {
        if (this.anImage2304 == null || this.aGraphics2305 == null) {
            this.anImage2304 = this.createImage(320, 175);
            this.aGraphics2305 = this.anImage2304.getGraphics();
        }

        this.drawBackground(this.aGraphics2305);
        if (this.aString2303 != null) {
            this.aGraphics2305.setFont(AApplet_Sub3.fontDialog11);
            this.aGraphics2305.setColor(AApplet_Sub3.aColor3779);
            this.aGraphics2305.drawString(this.aString2303, 6, 168);
        }

        var1.drawImage(this.anImage2304, 0, 0, this);
    }

    public void method3(IPanel_Sub25 var1, int var2) {
        if (var1 == this.anIPanel_Sub25_2300 && var2 >= 0) {
            this.aString2303 = this.aClass58_Sub1_2298.textManager.getGame("Editor_ObjectInfo_" + var2);
        } else if (var1 == this.anIPanel_Sub25_2301 && var2 >= 0) {
            this.aString2303 = this.aClass58_Sub1_2298.textManager.getGame("Editor_ElementInfo_" + var2);
        } else if (var1 == this.anIPanel_Sub25_2302 && var2 >= 0) {
            this.aString2303 = this.aClass58_Sub1_2298.textManager.getGame("Editor_SlopeInfo_" + var2);
        } else {
            this.aString2303 = null;
        }

        this.repaint();
    }

    public void method4(IPanel_Sub25 var1, int var2, boolean var3) {
        int var4 = this.anIPanel_Sub25_2300.method657();
        if (var1 == this.anIPanel_Sub25_2300 && this.anIPanel_Sub11_2299.method580() != var3) {
            Block var5 = this.anIPanel_Sub11_2299.method579(var3);
            if (var5 instanceof BlockSpecial) {
                this.method605((BlockSpecial) ((BlockSpecial) var5), false);
            }

            this.anIPanel_Sub11_2299.method581(var3);
            var4 = var2;
        }

        int var7 = this.anIPanel_Sub25_2301.method657();
        int var6 = this.anIPanel_Sub25_2302.method657();
        this.anIPanel_Sub11_2299.method578(new BlockSpecial(this.aClass58_Sub1_2298.aClass39_Sub1_1191, var4, var7, var6));
    }

    public void method604(IPanel_Sub11 var1) {
        this.anIPanel_Sub11_2299 = var1;
    }

    public void method605(BlockSpecial var1, boolean var2) {
        if (var2) {
            this.anIPanel_Sub25_2300.method660(var1.method1206());
        }

        this.anIPanel_Sub25_2301.method660(var1.getElement());
        this.anIPanel_Sub25_2302.method660(var1.getSlope());
    }

    private void method606() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub25_2300 = new IPanel_Sub25(this.aClass58_Sub1_2298.imageManager.getImage("track_objects"), 9, 9, this, false);
        this.anIPanel_Sub25_2300.method656(new int[]{2, 3, 4, 5, 7, 8, 15, 16, 17, 33, 34, 35, 40, 41, 51, 52, 53, 60, 62, 70, 78, 80});
        this.anIPanel_Sub25_2300.setLocation(5, 8);
        this.add(this.anIPanel_Sub25_2300);
        this.anIPanel_Sub25_2301 = new IPanel_Sub25(this.aClass58_Sub1_2298.imageManager.getImage("track_elements"), 4, 7, this, false);
        this.anIPanel_Sub25_2301.method656(new int[]{6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27});
        this.anIPanel_Sub25_2301.setLocation(175, 8);
        this.add(this.anIPanel_Sub25_2301);
        this.anIPanel_Sub25_2302 = new IPanel_Sub25(this.aClass58_Sub1_2298.imageManager.getImage("track_slopes"), 3, 3, this, false);
        this.anIPanel_Sub25_2302.setLocation(260, 8);
        this.add(this.anIPanel_Sub25_2302);
    }

    static {
        aStringArray2306[0] = "Editor_ElementInfo_";
        aStringArray2306[1] = "Editor_SlopeInfo_";
        aStringArray2306[2] = "Editor_ObjectInfo_";
        aStringArray2306[3] = "track_slopes";
        aStringArray2306[4] = "track_objects";
        aStringArray2306[5] = "track_elements";
    }
}
