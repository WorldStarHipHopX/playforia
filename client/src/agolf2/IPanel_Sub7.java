package agolf2;

import com.aapeli.client.IPanel;

import java.awt.LayoutManager;
import java.util.Vector;

public class IPanel_Sub7 extends IPanel implements Interface4 {

    private Class58_Sub1 aClass58_Sub1_2307;
    private int anInt2308;
    private int anInt2309;
    private Class42 aClass42_2310;
    private IPanel_Sub9 anIPanel_Sub9_2311;
    private Class52 aClass52_2312;
    private Canvas_Sub6_Sub1 aCanvas_Sub6_Sub1_2313;
    private int anInt2314;
    private int anInt2315;
    private int anInt2316;
    private int anInt2317;
    private Vector aVector2318;
    private EditorPopupFrame aJFrame__2319;
    protected String aString2320;
    private SynchronizedBool aSynchronizedBool_2321;
    private SynchronizedBool aSynchronizedBool_2322;
    public static int anInt2323;
    private static final String[] aStringArray2324 = new String[10];


    public IPanel_Sub7(Class58_Sub1 var1, int var2, int var3) {
        this.aClass58_Sub1_2307 = var1;
        this.anInt2308 = var2;
        this.anInt2309 = var3;
        this.setSize(var2, var3);
        this.aClass42_2310 = new Class42(var1);
        this.method549();
        this.setBackground(var1.imageManager.getImage("background"));
        this.aVector2318 = new Vector(20);
        this.anIPanel_Sub9_2311.method566(false);
        this.aString2320 = "";
        this.aSynchronizedBool_2321 = new SynchronizedBool(false);
        this.aSynchronizedBool_2322 = new SynchronizedBool(false);
    }

    public void method5(int var1, int var2, int var3, int var4) {
        Class38 var5 = this.anIPanel_Sub9_2311.method564();
        if (var5 != null) {
            int var6 = var5.method1223();
            if (var6 == 3) {
                this.aCanvas_Sub6_Sub1_2313.method195(var3, var4, var5.method1226(), var5.method1227());
            }

        }
    }

    public void method6(int var1, int var2, int var3, int var4, boolean var5) {
        this.method550();
        Class38 var6 = this.anIPanel_Sub9_2311.method563(var5);
        if (var6 != null) {
            int var7 = var6.method1223();
            if (var7 == 0) {
                if (this.aClass52_2312.method1398(var3, var4, var6.method1225())) {
                    this.aCanvas_Sub6_Sub1_2313.method171(var3, var4);
                }
            } else if (var7 == 1) {
                if (this.aClass52_2312.method1400(var3, var4, var6.method1225())) {
                    this.aCanvas_Sub6_Sub1_2313.method170();
                }
            } else if (var7 == 2) {
                this.anInt2314 = this.anInt2316 = var3;
                this.anInt2315 = this.anInt2317 = var4;
                this.aCanvas_Sub6_Sub1_2313.method193(this.anInt2314, this.anInt2315, this.anInt2316, this.anInt2317);
            } else if (var7 == 3) {
                this.aClass52_2312.method1399(var3, var4, var6.method1226(), var6.method1227());
                this.aCanvas_Sub6_Sub1_2313.method170();
            }

        }
    }

    public void method7(int var1, int var2, int var3, int var4, boolean var5) {
        Class38 var6 = this.anIPanel_Sub9_2311.method563(var5);
        if (var6 != null) {
            int var7 = var6.method1223();
            if (var7 == 0) {
                if (this.aClass52_2312.method1398(var3, var4, var6.method1225())) {
                    this.aCanvas_Sub6_Sub1_2313.method171(var3, var4);
                }
            } else if (var7 == 2) {
                this.anInt2316 = var3;
                this.anInt2317 = var4;
                this.aCanvas_Sub6_Sub1_2313.method193(this.anInt2314, this.anInt2315, this.anInt2316, this.anInt2317);
            }

        }
    }

    public void method8(int var1, int var2, int var3, int var4, boolean var5) {
        Class38 var6 = this.anIPanel_Sub9_2311.method563(var5);
        if (var6 != null) {
            int var7 = var6.method1223();
            if (var7 == 2) {
                this.aCanvas_Sub6_Sub1_2313.method194();
                Block[] var8 = this.aClass52_2312.method1397(this.anInt2314, this.anInt2315, var3, var4);
                this.anIPanel_Sub9_2311.method565(var8, Math.abs(this.anInt2314 - var3) + 1);
            }

        }
    }

    public void method9(int var1, boolean var2) {
        if (var2 && var1 == 90 || !var2 && var1 == 85) {
            this.method534();
        }

    }

    public int method10() {
        return this.anIPanel_Sub9_2311.method562();
    }

    public void method526() {
        this.aSynchronizedBool_2321.method1167(true);
    }

    public void method527(String var1) {
    }

    public void method528(String[] var1) {
        if (!var1[1].equals("tracks")) {
            if (var1[1].equals("track")) {
                this.method548();
                this.method550();
                this.anIPanel_Sub9_2311.method569(var1[2], var1[4]);
                this.aClass52_2312.method1405(var1[3]);
                this.aCanvas_Sub6_Sub1_2313.method170();
            } else {
                if (var1[1].equals("reply") && this.aJFrame__2319 != null) {
                    this.aJFrame__2319.method2340(Integer.parseInt(var1[2]));
                }

            }
        } else {
            this.aClass42_2310.clear();
            int var2 = var1.length - 2;

            for (int var3 = 0; var3 < var2; ++var3) {
                this.aClass42_2310.add(new EditorListState(var1[2 + var3]));
            }

        }
    }

    public void method529() {
        this.method550();
        this.aClass52_2312.method1401();
        this.aCanvas_Sub6_Sub1_2313.method170();
    }

    public void method530() {
        this.method550();
        this.aClass52_2312.method1402();
        this.aCanvas_Sub6_Sub1_2313.method170();
    }

    public void method531(int var1, int var2) {
        this.method550();
        this.aClass52_2312.method1403(var1, var2);
        this.aCanvas_Sub6_Sub1_2313.method170();
    }

    public void method532() {
        this.aClass58_Sub1_2307.anAApplet_Sub3_Sub1_3567.method71(this.aClass52_2312.method1404());
    }

    public void method533() {
        this.aSynchronizedBool_2322.method1167(true);
    }

    public void method534() {
        this.method551();
        this.aCanvas_Sub6_Sub1_2313.method170();
    }

    public void method535() {
        this.method550();
        this.aClass52_2312.method1392();
        this.aCanvas_Sub6_Sub1_2313.method170();
        this.aString2320 = "";
    }

    public void method536(boolean var1) {
        this.aCanvas_Sub6_Sub1_2313.method196(var1);
    }

    public void method537(boolean var1) {
        this.aCanvas_Sub6_Sub1_2313.method197(var1);
    }

    public void method538() {
        this.method548();
        this.aJFrame__2319 = new EditorPopupFrame(this.aClass58_Sub1_2307, this, 0);
    }

    public void method539(String var1) {
        this.aString2320 = var1;
        this.method553("save\t" + var1 + "\t" + this.aClass52_2312.method1404() + "\t" + this.anIPanel_Sub9_2311.method568());
    }

    public void method540() {
        this.method548();
        this.aJFrame__2319 = new EditorPopupFrame(this.aClass58_Sub1_2307, this, 1, !this.aSynchronizedBool_2321.method1168() ? 1 : (!this.aSynchronizedBool_2322.method1168() ? 2 : 0));
    }

    public void method541(String var1, boolean var2) {
        this.aString2320 = var1;
        this.method553("publish\t" + var1 + "\t" + (var2 ? "t" : "f") + "\t" + this.aClass52_2312.method1404() + "\t" + this.anIPanel_Sub9_2311.method568());
    }

    public void method542() {
        this.method548();
        this.aJFrame__2319 = new EditorPopupFrame(this.aClass58_Sub1_2307, this, 2);
    }

    public void method543(String var1) {
        this.method553("load\t" + var1);
        this.aString2320 = var1;
    }

    public void method544() {
        this.method548();
        this.aJFrame__2319 = new EditorPopupFrame(this.aClass58_Sub1_2307, this, 3);
    }

    public void method545(String var1) {
        this.method553("delete\t" + var1);
    }

    public void method546() {
        this.method548();
        this.aClass58_Sub1_2307.anAApplet_Sub3_Sub1_3567.method54(0);
        this.method553("back");
    }

    protected Class42 method547() {
        return this.aClass42_2310;
    }

    protected void method548() {
        if (this.aJFrame__2319 != null) {
            this.aJFrame__2319.dispose();
            this.aJFrame__2319 = null;
        }

    }

    private void method549() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub9_2311 = new IPanel_Sub9(this.aClass58_Sub1_2307, this, this.anInt2308 - 10, this.anInt2309 - 5 - 420 - 10 - 5);
        this.anIPanel_Sub9_2311.setLocation(5, 5);
        this.add(this.anIPanel_Sub9_2311);
        this.aClass52_2312 = new Class52(this.aClass58_Sub1_2307.aClass39_Sub1_1191);
        this.aCanvas_Sub6_Sub1_2313 = new Canvas_Sub6_Sub1(this.aClass52_2312, this);
        this.aCanvas_Sub6_Sub1_2313.setLocation(40, this.anInt2309 - 5 - 420);
        this.add(this.aCanvas_Sub6_Sub1_2313);
    }

    private void method550() {
        Vector var1 = this.aVector2318;
        synchronized (this.aVector2318) {
            if (this.aVector2318.size() == 20) {
                this.aVector2318.removeElementAt(19);
            }

            this.aVector2318.insertElementAt(this.aClass52_2312.method1404(), 0);
            this.anIPanel_Sub9_2311.method566(true);
        }

        this.aSynchronizedBool_2322.method1167(false);
        this.method552();
    }

    private void method551() {
        Vector var1 = this.aVector2318;
        synchronized (this.aVector2318) {
            if (this.aVector2318.isEmpty()) {
                return;
            }

            this.aClass52_2312.method1405((String) this.aVector2318.elementAt(0));
            this.aVector2318.removeElementAt(0);
            this.anIPanel_Sub9_2311.method566(!this.aVector2318.isEmpty());
        }

        this.aSynchronizedBool_2322.method1167(false);
        this.method552();
    }

    private void method552() {
        if (this.aJFrame__2319 != null && this.aJFrame__2319.method2339() == 1) {
            this.aJFrame__2319.dispose();
            this.aJFrame__2319 = null;
        }

    }

    private void method553(String var1) {
        this.aClass58_Sub1_2307.aClass36_Sub1_3572.method1179("editor\t" + var1);
    }

    static {
        aStringArray2324[0] = "background";
        aStringArray2324[1] = "load\t";
        aStringArray2324[2] = "publish\t";
        aStringArray2324[3] = "save\t";
        aStringArray2324[4] = "back";
        aStringArray2324[5] = "delete\t";
        aStringArray2324[6] = "editor\t";
        aStringArray2324[7] = "tracks";
        aStringArray2324[8] = "reply";
        aStringArray2324[9] = "track";
    }
}
