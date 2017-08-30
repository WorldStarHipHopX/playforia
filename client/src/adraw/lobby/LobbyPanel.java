package adraw.lobby;

import adraw.Connection;
import adraw.GameApplet;
import com.aapeli.client.BadWordFilter;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.Parameters;
import com.aapeli.client.TextManager;

import java.awt.LayoutManager;

public class LobbyPanel extends IPanel {

    private GameApplet gameApplet;
    private TextManager textManager;
    private ImageManager imageManager;
    private BadWordFilter badwordFilter;
    private Connection connection;
    private int width;
    private int height;
    private LobbyGamePanel lobbyGamePanel;
    private LobbyChatPanel lobbyChatPanel;
    private LobbyControlPanel lobbyControlPanel;
    public static boolean aBoolean2913;
    private static final String[] aStringArray2914 = new String[2];


    public LobbyPanel(GameApplet gameApplet, Parameters params, TextManager textManager, ImageManager imageManager, BadWordFilter badwordFilter, Connection connection, int width, int height) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.badwordFilter = badwordFilter;
        this.connection = connection;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.setBackground(imageManager.getImage("background"));
        this.create(params);
    }

    public void method486(int var1) {
        this.lobbyGamePanel.method491(var1);
    }

    protected void writeLobbyCommand(String var1) {
        this.connection.writeData("lobby\t" + var1);
    }

    public void handlePacket(String[] args) {
        boolean handled = false;
        if (this.lobbyGamePanel.handlePacket(args)) {
            handled = true;
        }

        if (this.lobbyChatPanel.handlePacket(args)) {
            handled = true;
        }

    }

    public void broadcastMessage(String message) {
        this.lobbyChatPanel.broadcastMessage(message);
    }

    private void create(Parameters params) {
        this.setLayout((LayoutManager) null);
        this.lobbyGamePanel = new LobbyGamePanel(this.gameApplet, this.textManager, this.imageManager, this, this.width - 10, this.height - 170 - 10 - 3);
        this.lobbyGamePanel.setLocation(5, 3);
        this.add(this.lobbyGamePanel);
        this.lobbyChatPanel = new LobbyChatPanel(this.gameApplet, params, this.textManager, this.imageManager, this.badwordFilter, this, this.width - 100 - 10, 170);
        this.lobbyChatPanel.setLocation(5, this.height - 170 - 5);
        this.add(this.lobbyChatPanel);
        this.lobbyControlPanel = new LobbyControlPanel(this.gameApplet, this.textManager, this, 90, 170);
        this.lobbyControlPanel.setLocation(this.width - 90 - 5, this.height - 170 - 5);
        this.add(this.lobbyControlPanel);
    }
}
