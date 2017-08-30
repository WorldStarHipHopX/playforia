package agolf2;

public class Class43_Sub1 extends Class43 {

    private Canvas_Sub6_Sub2 aCanvas_Sub6_Sub2_3566;


    public Class43_Sub1(TrackOverlays var1, Class52 var2, int var3, boolean var4, boolean var5) {
        super(var1, var2, var3, var4, var5);
    }

    public void method1323(Canvas_Sub6_Sub2 var1) {
        this.aCanvas_Sub6_Sub2_3566 = var1;
    }

    protected void method1303(int var1) {
        this.aGameBallArray1087 = new GameBall_Sub1[this.anInt1085];

        for (int var2 = 0; var2 < this.anInt1085; ++var2) {
            this.aGameBallArray1087[var2] = new GameBall_Sub1(this, var2, var1, this.aTrackOverlays_1083);
        }

    }

    public void method1324() {
        int[] var1 = this.aCanvas_Sub6_Sub2_3566.method173();

        for (int var2 = 0; var2 < this.anInt1085; ++var2) {
            ((GameBall_Sub1) ((GameBall_Sub1) this.aGameBallArray1087[var2])).method1280(var1[0], var1[1]);
        }

    }

    public GameBall_Sub1[] method1325() {
        return (GameBall_Sub1[]) ((GameBall_Sub1[]) this.aGameBallArray1087);
    }

    public void method1302() {
        super.method1302();
        this.aCanvas_Sub6_Sub2_3566 = null;
    }

    protected boolean method1309(int var1, int var2) {
        if (super.method1309(var1, var2)) {
            if (this.aCanvas_Sub6_Sub2_3566 != null) {
                this.aCanvas_Sub6_Sub2_3566.method206(var1, var2);
            }

            return true;
        } else {
            return false;
        }
    }

    protected boolean method1310(int var1, int var2, int var3) {
        if (super.method1310(var1, var2, var3)) {
            if (this.aCanvas_Sub6_Sub2_3566 != null) {
                this.aCanvas_Sub6_Sub2_3566.method206(var1, var2);
            }

            return true;
        } else {
            return false;
        }
    }

    protected boolean method1311(int var1, int var2, int var3) {
        if (super.method1311(var1, var2, var3)) {
            if (this.aCanvas_Sub6_Sub2_3566 != null) {
                this.aCanvas_Sub6_Sub2_3566.method206(var1, var2);
            }

            return true;
        } else {
            return false;
        }
    }

    protected boolean method1312(BlockSpecial var1, int var2, int var3, int var4, int var5) {
        if (super.method1312(var1, var2, var3, var4, var5)) {
            int var6 = var2 + var4;
            int var7 = var3 + var5;
            if (this.aCanvas_Sub6_Sub2_3566 != null) {
                this.aCanvas_Sub6_Sub2_3566.method206(var2, var3);
                this.aCanvas_Sub6_Sub2_3566.method206(var6, var7);
            }

            return true;
        } else {
            return false;
        }
    }
}
