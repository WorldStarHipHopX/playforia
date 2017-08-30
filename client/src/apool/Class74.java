package apool;

class Class74 {

    private int anInt1293;
    private boolean[] aBooleanArray1294;
    private double[] aDoubleArray1295;
    private double[] aDoubleArray1296;
    private SynchronizedInt aSynchronizedInt_1297;
    private SynchronizedInt aSynchronizedInt_1298;
    private boolean[] aBooleanArray1299;


    protected Class74(SPanel_Sub32 var1, SPanel_Sub34_Sub1 var2) {
        this.anInt1293 = var1.method2684();
        if (this.anInt1293 < 1) {
            this.anInt1293 = 1;
        } else if (this.anInt1293 > 3) {
            this.anInt1293 = 3;
        }

        Class65[] var3 = var1.method2688();
        this.aBooleanArray1294 = new boolean[var3.length];
        this.aDoubleArray1295 = new double[var3.length];
        this.aDoubleArray1296 = new double[var3.length];

        for (int var4 = 0; var4 < var3.length; ++var4) {
            this.aBooleanArray1294[var4] = var3[var4].method1482();
            this.aDoubleArray1295[var4] = var3[var4].method1483();
            this.aDoubleArray1296[var4] = var3[var4].method1484();
        }

        this.aSynchronizedInt_1297 = new SynchronizedInt(var2.method2743());
        this.aSynchronizedInt_1298 = new SynchronizedInt(var2.method2744());
        this.aBooleanArray1299 = var2.method2747();
    }

    protected void method1545(SPanel_Sub32 var1, SPanel_Sub34_Sub1 var2) {
        var1.method2685(this.anInt1293);
        Class65[] var3 = var1.method2688();

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4].method1492(this.aBooleanArray1294[var4]);
            var3[var4].method1493(this.aDoubleArray1295[var4], this.aDoubleArray1296[var4]);
        }

        var1.repaint();
        var2.method2748(this.aSynchronizedInt_1297, this.aSynchronizedInt_1298, this.aBooleanArray1299);
    }
}
