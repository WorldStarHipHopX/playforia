package apool;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.SoundManager;
import com.playray.client.TextManager;
import com.playray.multiuser.Languages;

import java.awt.Image;

public class Class60 {

    public GameApplet gameApplet;
    public Parameters params;
    public int anInt1201;
    public int anInt1202;
    public String aString1203;
    public String aString1204;
    public boolean aBoolean1205;
    public boolean aBoolean1206;
    public Class61 aClass61_1207;
    public BadWordFilter badWordFilter;
    public TextManager textManager;
    public ImageManager imageManager;
    public SoundManager soundManager;
    public Conn connection;
    public Image anImage1213;
    public Languages language;
    public static int anInt1215;


    public Class60(GameApplet var1, Parameters var2) {
        this.gameApplet = var1;
        this.params = var2;
        this.anInt1201 = var1.anInt2601;
        this.anInt1202 = var1.anInt2602;
        this.method1453();
        this.aClass61_1207 = new Class61();
        this.badWordFilter = null;
    }

    protected void method1449() {
        this.badWordFilter = new BadWordFilter(this.textManager);
    }

    protected boolean method1450() {
        this.connection = new Conn(this);
        return this.connection.method1470();
    }

    protected void method1451() {
        this.connection.method1471();
    }

    protected void method1452() {
        if (this.connection != null) {
            this.connection.method1476();
            this.connection = null;
        }

    }

    private void method1453() {
        this.aBoolean1205 = this.params.getParameter("disablegameselect") != null;
        if (!this.aBoolean1205) {
            this.aBoolean1205 = this.params.getParameter("disableroomselect") != null;
        }

        this.aBoolean1206 = this.params.getParameter("disablespgames") != null;
        this.aString1203 = this.params.getParameter("lobby");
        if (this.aString1203 == null) {
            this.aString1203 = this.params.getParameter("game");
        }

        if (this.aString1203 == null) {
            this.aString1203 = this.params.getParameter("room");
        }

        this.aString1204 = this.params.getParameter("replay");
    }
}
