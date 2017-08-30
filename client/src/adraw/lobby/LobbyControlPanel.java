package adraw.lobby;

import adraw.GameApplet;
import com.aapeli.applet.AApplet;
import com.aapeli.client.IPanel;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LobbyControlPanel extends IPanel implements ActionListener {

    private GameApplet gameApplet;
    private TextManager textManager;
    private LobbyPanel lobbyPanel;
    private int width;
    private int height;
    private ColorButton buttonQuit;
    private static final String[] aStringArray2902 = new String[2];


    protected LobbyControlPanel(GameApplet gameApplet, TextManager textManager, LobbyPanel lobbyPanel, int width, int height) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.lobbyPanel = lobbyPanel;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.create();
    }

    public void actionPerformed(ActionEvent var1) {
        this.gameApplet.setEndState(AApplet.END_QUIT);
        this.lobbyPanel.writeLobbyCommand("quit");
        this.gameApplet.setGameState(4);
    }

    protected void create() {
        this.setLayout((LayoutManager) null);
        this.buttonQuit = new ColorButton(this.textManager.getGame("LobbyControl_Quit"));
        this.buttonQuit.setBackground(GameApplet.colourButtonRed);
        this.buttonQuit.setBounds(0, this.height - 20, this.width, 20);
        this.buttonQuit.addActionListener(this);
        this.add(this.buttonQuit);
    }
}
