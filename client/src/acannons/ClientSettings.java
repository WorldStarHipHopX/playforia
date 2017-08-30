package acannons;

import com.playray.client.BadWordFilter;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.TextManager;
import com.playray.credit.ProductHandler;

public class ClientSettings {

    public GameApplet gameApplet;
    public Parameters params;
    public int useWinterGraphics;
    public PlayerInfo aPlayerInfo_764;
    public BadWordFilter badWordFilter;
    public ProductHandler productHandler;
    public TextManager textManager;
    public ImageManager imageManager;
    public com.playray.client.SoundManager soundManager;
    public SoundManager aSoundManager_770;
    public GameSpriteManager aGameSpriteManager_771;
    public Connection aConnection_772;
    public LobbyPanel lobbyPanel;
    public int anInt774;
    public int anInt775;
    public static int anInt776;


    protected ClientSettings(GameApplet gameApplet, Parameters params) {
        this.gameApplet = gameApplet;
        this.params = params;
        this.useWinterGraphics = 0;
        String grafix = gameApplet.getParameter("graphics");
        if (grafix != null && grafix.equalsIgnoreCase("winter")) {
            this.useWinterGraphics = 1;
        }

        this.aPlayerInfo_764 = new PlayerInfo();
        this.badWordFilter = null;
        this.productHandler = new ProductHandler();
    }

    protected void initBadWordFilter() {
        this.badWordFilter = new BadWordFilter(this.textManager);
    }

    protected boolean method995() {
        this.aConnection_772 = new Connection(this);
        return this.aConnection_772.connect();
    }

    protected void method996() {
        this.aConnection_772.sendVersion();
    }

    protected void initProductHandler(String var1) {
        this.productHandler = new ProductHandler(var1);
    }

    protected void method998() {
        if (this.aConnection_772 != null) {
            this.aConnection_772.disconnect();
            this.aConnection_772 = null;
        }

    }
}
