package agolf2;


public class Pixel {

    protected static final double[] aDoubleArray1128 = {0.9994D, 0.996D, 0.98D, 0.9998D, 0.85D,
            0.996D, 0.0D, 0.0D, 0.85D, 0.996D, 0.85D, 0.0D, 0.0D, 0.9994D, 0.0D, 0.0D, 0.9994D,
            0.0D, 0.9994D, 0.0D, 0.0D, 0.9994D, 0.0D, 0.0D, 1.0D, 0.0D, 1.0D, 1.0D};
    protected static final double[] aDoubleArray1129 = {0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D,
            0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.95D, 0.0D, 0.0D, 0.95D, 0.0D, 0.95D, 0.0D,
            0.0D, 0.95D, 0.0D, 0.0D, 0.95D, 0.0D, 0.05D, 100.0D};
    private static final double aDouble1130 = Math.sqrt(2.0D) * 0.5D * 2.0E-4D;
    protected static final double[] aDoubleArray1131 = {-aDouble1130, 0.0D, aDouble1130, -2.0E-4D,
            0.0D, 2.0E-4D, -aDouble1130, 0.0D, aDouble1130};
    protected static final double[] aDoubleArray1132 = {-aDouble1130, -2.0E-4D, -aDouble1130, 0.0D,
            0.0D, 0.0D, aDouble1130, 2.0E-4D, aDouble1130};
    private int baseX;
    private int baseY;
    private int element;
    private int slope;
    private int object;


    protected Pixel(int element) {
        this(-1, -1, element, 4, -1);
    }

    protected Pixel(int baseX, int baseY, int element, int slope) {
        this(baseX, baseY, element, slope, -1);
    }

    protected Pixel(int baseX, int baseY, int element, int slope, int object) {
        this.baseX = baseX;
        this.baseY = baseY;
        this.element = element;
        this.slope = slope;
        this.object = object;
    }

    public String toString() {
        return "[Pixel: bx=" + this.baseX + ", by=" + this.baseY + ", element=" + this.element + ", slope=" + this.slope + ", object=" + this.object + "]";
    }

    protected static boolean method1368(int var0) {
        return var0 >= 12;
    }

    protected static boolean method1369(int var0) {
        return var0 >= 4 && var0 <= 11;
    }

    public int getBaseX() {
        return this.baseX;
    }

    public int getBaseY() {
        return this.baseY;
    }

    public int getElement() {
        return this.element;
    }

    public int getSlope() {
        return this.slope;
    }

    public int getObject() {
        return this.object;
    }

    public boolean method1375() {
        return this.method1376(false);
    }

    protected boolean method1376(boolean var1) {
        return method1368(this.element) ? true : (this.object >= 18 && this.object <= 23 ? true : (this.object != 24 && this.object != 25 && this.object != 26 ? (this.object != 42 && this.object != 43 ? var1 && (this.object == 61 || this.object == 79 || this.object == 69 || this.object == 71) : true) : true));
    }

    protected boolean method1377() {
        return this.baseX < 0 || this.baseY < 0;
    }

    public boolean method1378() {
        return this.slope != 4;
    }
}
