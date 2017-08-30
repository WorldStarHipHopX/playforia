package adraw;

import adraw.game.GamePanel;
import adraw.lobby.LobbyPanel;
import com.aapeli.applet.AApplet;
import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.SoundManager;
import com.aapeli.client.StringDraw;
import com.aapeli.tools.Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameApplet extends AApplet {

    public boolean isValidSite = false;
    public static final Color colourBackgroundDefault = new Color(0xeeeeee);
    public static final Color colourForegroundDefault = new Color(0);
    public static final Color colourJoinErrorDefault = new Color(160, 0, 0);
    public static final Color colourButtonGreen = new Color(144, 224, 144);
    public static final Color colourButtonYellow = new Color(224, 224, 144);
    public static final Color colourButtonRed = new Color(224, 144, 144);
    public static final Color aColor3733 = new Color(144, 144, 224);
    public Color colourBackground;
    public Color colourForeground;
    public Color colourJoinError;
    public static final Font fontSerif20 = new Font("Serif", Font.PLAIN, 20);
    public static final Font fontDialog14b = new Font("Dialog", Font.BOLD, 14);
    public static final Font fontDialog12b = new Font("Dialog", Font.BOLD, 12);
    public static final Font fontDialog12 = new Font("Dialog", Font.PLAIN, 12);
    public static final Font fontDialog11 = new Font("Dialog", Font.PLAIN, 11);
    private boolean aBoolean3742;
    private int playerAccessLevel;
    private boolean aBoolean3744;
    private int gameState;
    private BadWordFilter badWordFilter;
    private boolean shouldRemoveSession;
    private Connection connection;
    private LobbyPanel lobbyPanel;
    public static int anInt3750;


    public void initApplet(Parameters params) {
        this.isValidSite = this.isValidSite();
        this.colourBackground = Tools.getColor(params.getParameter("bgcolor"), colourBackgroundDefault);
        this.colourForeground = Tools.getColor(params.getParameter("fgcolor"), colourForegroundDefault);
        this.colourJoinError = this.colourForeground.equals(colourForegroundDefault) ? colourJoinErrorDefault : this.colourForeground;
        this.setBackground(this.colourBackground);
        this.setForeground(this.colourForeground);
    }

    public void defineSounds(SoundManager soundManager) {
    }

    public void defineImages(ImageManager imageManager, String stfu) {
        imageManager.defineImage("background.gif");
        imageManager.defineImage("bg-password.gif");
        imageManager.defineImage("game-info.gif");
        imageManager.defineImage("game-tools-on.gif");
        imageManager.defineImage("game-tools-off.gif");
    }

    public void createImages() {
    }

    public void connectToServer() {
        this.connection = new Connection(this, super.param.getServerIp(), super.param.getServerPort());
        this.connection.connectAndRead();
    }

    public void appletReady() {
        this.setBackground("background");
        this.setGameSettings(false, 0, true, true);
        this.shouldRemoveSession = false;
        this.connection.method1125();
    }

    public void destroyApplet() {
    }

    public boolean isDebug() {
        return false;
    }

    protected int getGameState() {
        return this.gameState;
    }

    public void setGameState(int newState) {
        this.setGameState(newState, 0);
    }

    protected void setGameState(int newState, int var2) {
        if (newState != this.gameState && this.isValidSite) {
            this.gameState = newState;
            if (this.connection != null) {
                this.connection.setLobbyPanel((LobbyPanel) null);
                this.connection.setGamePanel((GamePanel) null);
            }

            this.clearContent();
            if (newState == 1) {
                if (this.shouldRemoveSession) {
                    super.param.removeSession();
                } else {
                    this.shouldRemoveSession = true;
                }

                if (this.hasSession()) {
                    super.param.noGuestAutoLogin();
                    this.connection.writeData("reglogin\t" + super.param.getSession());
                    this.gameState = 0;
                } else {
                    this.connection.writeData("autologin");
                    this.gameState = 0;
                }
            }

            if (newState == 2) {
                if (this.lobbyPanel == null) {
                    this.lobbyPanel = new LobbyPanel(this, super.param, super.textManager, super.imageManager, this.badWordFilter, this.connection, super.appletWidth, super.appletHeight);
                    this.lobbyPanel.setLocation(0, 0);
                }

                this.lobbyPanel.method486(var2);
                this.connection.setLobbyPanel(this.lobbyPanel);
                this.addToContent(this.lobbyPanel);
            }

            if (newState == 3) {
                GamePanel var3 = new GamePanel(this, super.textManager, super.imageManager, super.soundManager, this.badWordFilter, this.connection, super.appletWidth, super.appletHeight);
                this.connection.setGamePanel(var3);
                var3.setLocation(0, 0);
                this.addToContent(var3);
            }

            if (newState == 4) {
                this.setEndState(AApplet.END_QUIT);
                super.param.showQuitPage();
            } else {
                this.contentReady();
            }
        }
    }

    protected void setGameSettings(boolean var1, int var2, boolean var3, boolean var4) {
        this.aBoolean3742 = var1;
        this.playerAccessLevel = var2;
        this.badWordFilter = var3 ? new BadWordFilter(super.textManager) : null;
        this.aBoolean3744 = var4;
    }

    public boolean playerIsRegistered() {
        return this.aBoolean3742;
    }

    public int getPlayerAccessLevel() {
        return this.playerAccessLevel;
    }

    public boolean method24() {
        return this.aBoolean3744;
    }

    public int drawText(Graphics graphics, String text, int x, int y, int align) {
        byte alignment = StringDraw.ALIGN_LEFT;
        if (align == StringDraw.ALIGN_CENTER) {
            alignment = StringDraw.ALIGN_CENTER;
        }

        if (align == StringDraw.ALIGN_RIGHT) {
            alignment = StringDraw.ALIGN_RIGHT;
        }

        return StringDraw.drawString(graphics, text, x, y, alignment);
    }

    public String getWelcomeMessage() {
        String var1 = super.param.getWelcomeMessage();
        super.param.removeWelcomeMessage();
        return var1;
    }

    protected boolean hasSession() {
        return super.param.getSession() != null;
    }

    public boolean showPlayerCard(String var1) {
        return super.param.showPlayerCard(var1);
    }

    public void removePlayerList() {
        super.param.removePlayerList();
    }

    private boolean isValidSite() {
        if(true)// best override java
            return true;
        String[] var1 = new String[]{"com", "net", "fi"};
        String[] var2 = new String[]{"com", "net", "org", "fi", "de", "se", "co.uk", "dk", "be", "nl", "ru", "ch", "at", "es", "no", "fr", "it", "ee", "co.ee", "jp", "be", "co.nz", "pl", "pt", "com.pt", "cz", "gr", "hu", "co.hu", "li", "lt", "lu", "md", "mobi", "ro", "sk", "li", "am", "by", "gs", "lv", "ie", "cl", "com.br", "com.ve", "co.ve", "com.tr", "web.tr", "com.co", "com.ar", "com.mx"};
        String[] var3 = new String[]{"com", "net"};
        String var4 = this.getCodeBase().getHost().toLowerCase();
        String var5 = this.getDocumentBase().getHost().toLowerCase();
        boolean var6 = this.containsDomain(var4, "aapeli", var1) || this.containsDomain(var4, "playray", var2) || this.containsDomain(var4, "playforia", var3);
        boolean var7 = this.containsDomain(var5, "aapeli", var1) || this.containsDomain(var5, "playray", var2) || this.containsDomain(var5, "playforia", var3);
        return var6 && var7;
    }

    private boolean containsDomain(String host, String domain, String[] tld) {
        for (int var4 = 0; var4 < tld.length; ++var4) {
            if (host.equals(domain + "." + tld[var4])) {
                return true;
            }

            if (host.endsWith("." + domain + "." + tld[var4])) {
                return true;
            }
        }

        return false;
    }
}
