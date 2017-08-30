package agolf2;

import java.awt.Image;

public abstract class TrackTileOverlays extends TrackOverlays {

    protected Class58 aClass58_3549;


    protected TrackTileOverlays(Class58 var1) {
        this.aClass58_3549 = var1;
    }

    protected int[] method1228(int var1) {
        return this.aClass58_3549.aTileOverlays_1190.getElement(var1);
    }

    protected int[] method1229(int var1) {
        return this.aClass58_3549.aTileOverlays_1190.getObject(var1);
    }

    protected int[] method1230(int var1) {
        return this.aClass58_3549.aTileOverlays_1190.getSlope(var1);
    }

    public int[] method1231(Image var1, int var2, int var3) {
        return this.aClass58_3549.imageManager.getPixels(var1, var2, var3);
    }

    public Image method1232(int[] var1, int var2, int var3) {
        return this.aClass58_3549.imageManager.createImage(var1, var2, var3);
    }

    public abstract Image[] getImagesBalls(int var1);

    public void method1234(String var1) {
        if (this.aClass58_3549.method1436()) {
            this.aClass58_3549.aSoundManager1189.play(var1);
        }

    }
}
