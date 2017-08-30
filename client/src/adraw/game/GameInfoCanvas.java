package adraw.game;

import adraw.GameApplet;
import adraw.lobby.LobbyGamePanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

class GameInfoCanvas extends Canvas {

    private GameApplet gameApplet;
    private TextManager textManager;
    private ImageManager imageManager;
    private String gameName;
    private String gamePermsInfo;
    private int numPlayers;
    private int maxPlayers;
    private int roundTime;
    private int wordType;
    private Image image;
    private Graphics graphics;


    protected GameInfoCanvas(GameApplet gameApplet, TextManager textManager, ImageManager imageManager) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.setSize(290, 100);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        if (this.image == null) {
            this.image = this.createImage(290, 100);
            this.graphics = this.image.getGraphics();
        }

        this.graphics.drawImage(this.imageManager.getImage("game-info"), 0, 0, this);
        this.graphics.setColor(Color.gray);
        this.graphics.drawRect(0, 0, 289, 99);
        if (this.gameName != null) {
            this.graphics.setColor(GameApplet.colourForegroundDefault);
            this.graphics.setFont(GameApplet.fontSerif20);
            this.gameApplet.drawText(this.graphics, this.gameName, 285, 22, 1);
            if (this.numPlayers > 0) {
                this.graphics.setFont(GameApplet.fontDialog14b);
                this.gameApplet.drawText(this.graphics, this.textManager.getGame("GameInfo_NumberOfPlayers", this.numPlayers, this.maxPlayers), 285, 41, 1);
            }

            this.graphics.setFont(GameApplet.fontDialog12);
            if (this.gamePermsInfo != null) {
                this.gameApplet.drawText(this.graphics, this.gamePermsInfo, 285, 64, 1);
            }

            this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_RoundTime") + " " + this.textManager.getTime((long) this.roundTime), 285, 78, 1);
            if (this.wordType > 0) {
                this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_WordType") + " " + this.textManager.getGame("LobbyReal_WordType" + LobbyGamePanel.wordTypes[this.wordType]), 285, 92, 1);
            }
        }

        g.drawImage(this.image, 0, 0, this);
    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("gameinfo")) {
            this.gameName = args[2];
            this.maxPlayers = Integer.parseInt(args[4]);
            this.gamePermsInfo = null;
            int var2 = Integer.parseInt(args[3]);
            if (var2 == 1) {
                this.gamePermsInfo = this.textManager.getGame("GameInfo_OnlyForRegistered");
            } else if (var2 == 2) {
                this.gamePermsInfo = this.textManager.getGame("GameInfo_PasswordProtected");
            }

            this.roundTime = Integer.parseInt(args[5]);
            this.wordType = Integer.parseInt(args[6]);
            this.repaint();
            return true;
        } else if (args[1].equals("players")) {
            this.numPlayers = (args.length - 2) / 3;
            this.repaint();
            return true;
        } else if(args[1].equals("join") || args[1].equals("owninfo")) {
            ++this.numPlayers;
            this.repaint();
            return true;
        } else if(args[1].equals("part")) {
            --this.numPlayers;
            this.repaint();
            return true;
        }
        return false;
    }
}
