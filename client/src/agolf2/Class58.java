package agolf2;

import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.SoundManager;
import com.aapeli.client.TextManager;
import com.aapeli.credit.ProductHandler;

public abstract class Class58 {

    public AApplet_Sub3 gameApplet;
    public Parameters aParameters1186;
    public TextManager textManager;
    public ImageManager imageManager;
    public SoundManager aSoundManager1189;
    public TileOverlays aTileOverlays_1190;
    public TrackTileOverlays aClass39_Sub1_1191;
    public ProductHandler aProductHandler1192;
    public static int anInt1193;


    public Class58(AApplet_Sub3 var1, Parameters var2) {
        this.gameApplet = var1;
        this.aParameters1186 = var2;
        this.aProductHandler1192 = new ProductHandler();
    }

    protected void method1434(TextManager var1, ImageManager var2, SoundManager var3) {
        this.textManager = var1;
        this.imageManager = var2;
        this.aSoundManager1189 = var3;
        this.aTileOverlays_1190 = new TileOverlays(var2);
    }

    public void method1435(String var1) {
        this.aProductHandler1192 = new ProductHandler(var1);
    }

    protected abstract boolean method1436();
}
