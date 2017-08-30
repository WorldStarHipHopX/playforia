package agolf2;

import com.aapeli.applet.AApplet;
import com.aapeli.bigtext.BigText;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.SoundManager;

import java.awt.Color;
import java.awt.Font;

public abstract class AApplet_Sub3 extends AApplet {

    public SynchronizedBool aSynchronizedBool_3777;
    public static final Color aColor3778 = new Color(0, 168, 0);
    public static final Color aColor3779 = Color.WHITE;
    public static final Color aColor3780 = new Color(160, 255, 160);
    public static final Color colourButtonGreen = new Color(144, 224, 144);
    public static final Color aColor3782 = new Color(224, 224, 144);
    public static final Color aColor3783 = new Color(224, 144, 144);
    public static final Color aColor3784 = new Color(144, 144, 224);
    public static final Color aColor3785 = new Color(192, 192, 192);
    public static final Font fontDialog24 = new Font("Dialog", Font.PLAIN, 24);
    public static final Font fontDialog16b = new Font("Dialog", Font.BOLD, 16);
    public static final Font fontDialog14 = new Font("Dialog", Font.PLAIN, 14);
    public static final Font fontDialog12b = new Font("Dialog", Font.BOLD, 12);
    public static final Font fontDialog12 = new Font("Dialog", Font.PLAIN, 12);
    public static final Font fontDialog11 = new Font("Dialog", Font.PLAIN, 11);
    protected int anInt3792;
    private String username;
    private SynchronizedInteger aSynchronizedInteger_3794;
    private SynchronizedInteger aSynchronizedInteger_3795;
    private SynchronizedInteger aSynchronizedInteger_3796;
    private boolean aBoolean3797;
    protected boolean aBoolean3798;
    public static boolean aBoolean3799;
    private static final String[] aStringArray3800 = new String[70];


    public void method51(Parameters var1, boolean var2) {
        this.aSynchronizedBool_3777 = new SynchronizedBool(var2 || this.isValidSite());
        this.setBackground(aColor3778);
        this.setForeground(aColor3779);
    }

    public void defineSounds(SoundManager var1) {
        var1.defineSound("player_strike.au");
        var1.defineSound("ball_hole.au");
        var1.defineSound("ball_bouncer.au");
        var1.defineSound("ball_mine.au");
        var1.defineSound("ball_teleport.au");
        var1.defineSound("ball_water.au");
        var1.defineSound("ball_swamp.au");
        var1.defineSound("ball_acid.au");
        var1.defineSound("ball_sacid.au");
        var1.defineSound("ball_sizechange.au");
    }

    public void defineImages(ImageManager var1, String var2) {
        var1.defineImage("background.jpg");
        var1.defineImage(TileOverlays.filenameShapes);
        var1.defineImage(TileOverlays.filenameElements);
        var1.defineImage(TileOverlays.filenameObjects);
        var1.defineImage(TileOverlays.filenameSlopes);
    }

    public void method52(Class58 var1) {
        var1.method1434(this.textManager, this.imageManager, this.soundManager);
        BigText.initialize(var1.imageManager);
        var1.aTileOverlays_1190.load();
    }

    public void defineSecImages(ImageManager var1, String var2) {
        var1.defineImage("background_settings.png");
    }

    public void appletReady() {
        this.setBackground("background");
        this.aBoolean3798 = false;
        this.anInt3792 = 0;
    }

    public int method53() {
        return this.anInt3792;
    }

    public void method54(int var1) {
        this.method55(var1, 0);
    }

    protected abstract void method55(int var1, int var2);

    public void setGameSettings(String var1, int var2, int var3, int var4, boolean var5) {
        System.out.println(var1);
        this.username = var1;
        this.aSynchronizedInteger_3794 = new SynchronizedInteger(var2);
        this.aSynchronizedInteger_3795 = new SynchronizedInteger(var3);
        this.aSynchronizedInteger_3796 = new SynchronizedInteger(var4);
        this.aBoolean3797 = var5;
    }

    public String getUsername() {
        return this.username;
    }

    public int method58() {
        return this.aSynchronizedInteger_3794.method1174();
    }

    public int method59() {
        return this.aSynchronizedInteger_3795.method1174();
    }

    public boolean method60() {
        return this.method58() >= 1;
    }

    public boolean method61() {
        return this.aBoolean3797;
    }

    public int method62() {
        return this.aSynchronizedInteger_3796.method1174();
    }

    public void method63(int var1) {
        this.aSynchronizedInteger_3796.set(var1);
        this.param.updateWebPageInfoBox(var1, -1, -1);
    }

    public abstract void method64(boolean var1);

    private boolean isValidSite() {
        String var1 = "aapeli";
        String var2 = "playray";
        String var3 = "playforia";
        String[] var4 = new String[]{"com", "net", "fi"};
        String[] var5 = new String[]{"com", "net", "org", "fi", "de", "se", "co.uk", "dk", "be", "nl", "ru", "ch", "at", "es", "no", "fr", "it", "ee", "co.ee", "jp", "be", "co.nz", "pl", "pt", "com.pt", "cz", "gr", "hu", "co.hu", "li", "lt", "lu", "md", "mobi", "ro", "sk", "li", "am", "by", "gs", "lv", "ie", "cl", "com.br", "com.ve", "co.ve", "com.tr", "web.tr", "com.co", "com.ar", "com.mx"};
        String[] var6 = new String[]{"com", "net"};
        String var7 = this.getCodeBase().getHost().toLowerCase();
        String var8 = this.getDocumentBase().getHost().toLowerCase();
        boolean var9 = this.containsDomain(var7, var1, var4) || this.containsDomain(var7, var2, var5) || this.containsDomain(var7, var3, var6);
        boolean var10 = this.containsDomain(var8, var1, var4) || this.containsDomain(var8, var2, var5) || this.containsDomain(var8, var3, var6);
        return var9 && var10;
    }

    private boolean containsDomain(String var1, String var2, String[] var3) {
        for (int var4 = 0; var4 < var3.length; ++var4) {
            if (var1.equals(var2 + "." + var3[var4])) {
                return true;
            }

            if (var1.endsWith("." + var2 + "." + var3[var4])) {
                return true;
            }
        }

        return false;
    }
}
