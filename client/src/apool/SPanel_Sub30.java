package apool;

import com.playray.client.SPanel;

class SPanel_Sub30 extends SPanel {

    private SynchronizedInt aSynchronizedInt_4109;
    private boolean aBoolean4110;
    private int anInt4111;
    private int anInt4112;
    private int anInt4113;
    private SPanel_Sub34_Sub2[] aSPanel_Sub34_Sub2Array4114;
    private SPanel_Sub33 aSPanel_Sub33_4115;


    protected SPanel_Sub30(Class60 var1, SPanel_Sub20 var2, int var3, int var4, boolean var5, int var6, int var7) {
        super(false);
        this.setSize(var6, var7);
        this.aSynchronizedInt_4109 = new SynchronizedInt(var4);
        this.aBoolean4110 = var5;
        this.anInt4112 = this.anInt4113 = -1;
        this.anInt4111 = -2;
        int var8 = (var6 - 150) / 2;
        this.aSPanel_Sub34_Sub2Array4114 = new SPanel_Sub34_Sub2[2];
        this.aSPanel_Sub34_Sub2Array4114[0] = new SPanel_Sub34_Sub2(var1, this, 0, var8, var7);
        this.aSPanel_Sub34_Sub2Array4114[0].setLocation(0, 0);
        this.add(this.aSPanel_Sub34_Sub2Array4114[0]);
        this.aSPanel_Sub34_Sub2Array4114[1] = new SPanel_Sub34_Sub2(var1, this, 1, var8, var7);
        this.aSPanel_Sub34_Sub2Array4114[1].setLocation(var6 - var8, 0);
        this.add(this.aSPanel_Sub34_Sub2Array4114[1]);
        this.aSPanel_Sub33_4115 = new SPanel_Sub33(var1, var2, this, var3);
        this.aSPanel_Sub33_4115.setLocation(var8, var7 - 68);
        this.add(this.aSPanel_Sub33_4115);
    }

    protected int method2630() {
        return this.aSynchronizedInt_4109.method1467();
    }

    protected boolean method2631() {
        return this.aBoolean4110;
    }

    protected int method2632() {
        return this.anInt4111;
    }

    protected int method2633() {
        return this.anInt4112;
    }

    protected int method2634() {
        return this.anInt4113;
    }

    protected void method2635(String var1, String var2, String var3, String var4, int var5) {
        this.anInt4111 = var5;
        this.aSPanel_Sub34_Sub2Array4114[0].method2749(var1, var3);
        this.aSPanel_Sub34_Sub2Array4114[1].method2749(var2, var4);
    }

    protected void method2636() {
        this.anInt4113 = -1;
        this.aSPanel_Sub34_Sub2Array4114[0].method2750();
        this.aSPanel_Sub34_Sub2Array4114[1].method2750();
    }

    protected void method2637() {
        this.aSPanel_Sub34_Sub2Array4114[0].method2751();
        this.aSPanel_Sub34_Sub2Array4114[1].method2751();
    }

    protected void method2638(int var1) {
        this.anInt4112 = var1;
        this.aSPanel_Sub33_4115.method2732();
        this.aSPanel_Sub34_Sub2Array4114[0].repaint();
        this.aSPanel_Sub34_Sub2Array4114[1].repaint();
    }

    protected void method2639(int[] var1) {
        this.aSPanel_Sub34_Sub2Array4114[0].method2752(var1[0]);
        this.aSPanel_Sub34_Sub2Array4114[1].method2752(var1[1]);
    }

    protected void method2640(int var1, int var2) {
        this.aSPanel_Sub34_Sub2Array4114[var1].method2753(var2);
    }

    protected void method2641(int var1, int var2) {
        this.aSPanel_Sub34_Sub2Array4114[var1].method2754(var2);
    }

    protected int method2642(int var1) {
        return this.aSPanel_Sub34_Sub2Array4114[var1].method2755();
    }

    protected void method2643(int var1) {
        this.anInt4113 = var1;
        this.anInt4112 = -1;
        this.aSPanel_Sub34_Sub2Array4114[0].repaint();
        this.aSPanel_Sub34_Sub2Array4114[1].repaint();
        this.aSPanel_Sub33_4115.repaint();
    }

    protected String method2644(int var1) {
        String var2 = this.aSPanel_Sub34_Sub2Array4114[0].method2756(var1);
        String var3 = this.aSPanel_Sub34_Sub2Array4114[1].method2756(var1);
        return var2 + "," + var3;
    }

    protected void method2645(int var1, String var2) {
        int var3 = var2.indexOf(44);
        this.aSPanel_Sub34_Sub2Array4114[0].method2757(var1, var2.substring(0, var3));
        this.aSPanel_Sub34_Sub2Array4114[1].method2757(var1, var2.substring(var3 + 1));
    }

    protected void method2646(int var1) {
        this.aSPanel_Sub34_Sub2Array4114[var1].method2758();
    }

    protected void method2647() {
        this.aSPanel_Sub33_4115.method2733();
    }

    protected boolean[][] method2648() {
        boolean[][] var1 = new boolean[][]{this.aSPanel_Sub34_Sub2Array4114[0].method2759(), this.aSPanel_Sub34_Sub2Array4114[1].method2759()};
        return var1;
    }
}
