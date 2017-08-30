package adraw.game;

import adraw.Connection;
import adraw.GameApplet;
import com.aapeli.client.BadWordFilter;
import com.aapeli.client.ImageManager;
import com.aapeli.client.SoundManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.tools.Tools;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends Panel implements ActionListener {

    private static final int[] anIntArray253 = new int[]{5000, 8000};
    private GameApplet gameApplet;
    private TextManager textManager;
    private ImageManager imageManager;
    private SoundManager soundManager;
    private Connection connection;
    private int width;
    private int height;
    private GameInfoCanvas gameInfoCanvas;
    private GameDrawingToolsPanel gameDrawingToolsPanel;
    private GameDrawerInfoPanel gameDrawerInfoPanel;
    private GamePlayerListPanel gamePlayerListPanel;
    private ColorButton buttonBack;
    private ColorButton buttonEnterDrawQueue;
    private ColorButton buttonVoteKickDrawer;
    private GameDrawingCanvas gameDrawingCanvas;
    private GameWordPanel gameWordPanel;
    private GameChatPanel gameChatPanel;
    private boolean aBoolean271;
    private boolean isInDrawingQueue;
    private long canceledQueueTime;
    private int anInt274;
    private boolean aBoolean275;
    public static int anInt276;


    public GamePanel(GameApplet gameApplet, TextManager textManager, ImageManager imageManager, SoundManager soundManager, BadWordFilter badWordFilter, Connection connection, int width, int height) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.soundManager = soundManager;
        this.connection = connection;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.aBoolean271 = this.isInDrawingQueue = this.aBoolean275 = false;
        this.canceledQueueTime = 0L;
        this.anInt274 = -1;
        this.create(badWordFilter);
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        g.setColor(this.gameApplet.colourBackground);
        g.fillRect(0, 0, this.width, this.height);
    }

    public void actionPerformed(ActionEvent evt) {
        Object evtSource = evt.getSource();
        if (this.anInt274 < 1 && evtSource == this.buttonEnterDrawQueue) {
            if (this.isInDrawingQueue) {
                this.writeGameData("queue\tcancel");
                this.canceledQueueTime = System.currentTimeMillis();
                this.isInDrawingQueue = false;
                this.buttonEnterDrawQueue.setLabel(this.textManager.getGame("Game_EnterDrawQueue"));
                this.gameChatPanel.addChatMessage(this.textManager.getGame("Game_CancelledDrawQueue"));
            } else if (System.currentTimeMillis() > this.canceledQueueTime + 10000L) {
                this.writeGameData("queue\tenter");
                this.isInDrawingQueue = true;
                this.buttonEnterDrawQueue.setLabel(this.textManager.getGame("Game_CancelDrawQueue"));
                this.gameChatPanel.addChatMessage(this.textManager.getGame("Game_EnteredDrawQueue"));
            } else {
                this.gameChatPanel.addChatMessage(this.textManager.getGame("Game_CantEnterDrawQueue"));
            }
        } else {
            if (this.anInt274 == 0 && evtSource == this.buttonVoteKickDrawer) {
                this.setVisible(false);
                this.remove(this.buttonVoteKickDrawer);
                this.buttonVoteKickDrawer.removeActionListener(this);
                this.setVisible(true);
                this.gameChatPanel.addChatMessage(this.textManager.getGame("GameChat_VoteKickDrawerSent"));
                this.writeGameData("vkd");
            }

            if (evtSource == this.buttonBack) {
                this.aBoolean275 = true;
                this.gameApplet.setGameState(0);
                this.method278();
                this.writeGameData("quit");
                this.gameApplet.removePlayerList();
            }

        }
    }

    protected static String getPlayerName(String playerInfo) {
        int colon = playerInfo.indexOf(':');
        int triangle = playerInfo.indexOf('^', colon + 1);
        return Tools.changeFromSaveable(playerInfo.substring(colon + 1, triangle));
    }

    protected static String getPlayerStatus(String playerInfo) {// rsv.. etc
        int firstTriangle = playerInfo.indexOf('^');
        int secondTriangle = playerInfo.indexOf('^', firstTriangle + 1);
        return playerInfo.substring(firstTriangle + 1, secondTriangle);
    }

    public void handlePacket(String[] args) {
        boolean handled = false;
        if (this.gameInfoCanvas.handlePacket(args)) {
            handled = true;
        }

        if (this.gamePlayerListPanel.handlePacket(args)) {
            handled = true;
        }

        if (this.gameDrawingCanvas.handlePacket(args)) {
            handled = true;
        }

        if (this.gameWordPanel.handlePacket(args)) {
            handled = true;
        }

        if (this.gameChatPanel.handlePacket(args)) {
            handled = true;
        }

        if (args[1].equals("gameinfo")) {
            this.aBoolean271 = args[7].equals("t");
            if (!this.aBoolean271) {
                this.buttonEnterDrawQueue.addActionListener(this);
                this.add(this.buttonEnterDrawQueue);
            }

        } else if (args[1].equals("part")) {
            if (args[4].equals("t")) {
                this.aBoolean271 = false;
                if (this.anInt274 == -1) {
                    this.buttonEnterDrawQueue.addActionListener(this);
                    this.add(this.buttonEnterDrawQueue);
                }
            }

        } else if(args[1].equals("roundstart")) {
            boolean var3 = args.length == 6;
            if (var3) {
                this.gameDrawingToolsPanel.setVisible(false);
                this.gameDrawingToolsPanel.method296(true);
                this.gameDrawerInfoPanel.setVisible(false);
                this.gameDrawingToolsPanel.setVisible(true);
                this.gameDrawerInfoPanel.setDrawer(args[3], this.gamePlayerListPanel.method284(args[3]));
            } else {
                this.gameDrawerInfoPanel.setDrawer(args[3], this.gamePlayerListPanel.method284(args[3]));
                this.gameDrawingToolsPanel.setVisible(false);
                this.gameDrawerInfoPanel.setVisible(true);
                this.gameDrawingToolsPanel.method296(false);
            }

            this.gamePlayerListPanel.setDrawer2(var3 ? null : args[3]);
            this.gameWordPanel.method307(var3, args);
            this.gameChatPanel.addRoundStartMessage(var3, args[3], var3 ? args[4] : null);
            this.method280(var3 ? 1 : 0);
            this.gameDrawingCanvas.method74(var3, args[3], var3 ? args[4] : null);
            this.gameChatPanel.getFocus();
            Tools.sleep((long) anIntArray253[this.aBoolean271 ? 1 : 0]);
            if (!this.aBoolean275) {
                this.gameDrawingCanvas.method75(var3);
                this.gameWordPanel.method308();
                this.gameChatPanel.getFocus();
            }
        } else if(args[1].equals("roundrun")) {
            this.gameDrawerInfoPanel.setDrawer(args[3], this.gamePlayerListPanel.method284(args[3]));
            this.gameDrawingToolsPanel.setVisible(false);
            this.gameDrawerInfoPanel.setVisible(true);
            this.gameDrawingToolsPanel.method296(false);
            this.gamePlayerListPanel.setDrawer2(args[3]);
            this.gameWordPanel.method307(false, args);
            this.gameWordPanel.method308();
            this.gameChatPanel.addRoundRunningMessage(args[3]);
            this.method280(0);
            this.gameDrawingCanvas.method75(false);
            this.gameChatPanel.getFocus();
        } else if(args[1].equals("roundend")) {
            boolean var3 = args.length == 4;
            if (var3) {
                this.gameDrawerInfoPanel.setGuesser(args[3], this.gamePlayerListPanel.method284(args[3]));
            }

            this.gameDrawingToolsPanel.setVisible(false);
            this.gameDrawerInfoPanel.setVisible(true);
            this.gameDrawingToolsPanel.setNotDrawing();
            this.gamePlayerListPanel.clearDrawer();
            this.gameDrawingCanvas.method76(args[2]);
            this.gameWordPanel.method309(args[2]);
            this.gameChatPanel.addRoundEndMessage(args[2], var3 ? args[3] : null);
            this.method280(-1);
            this.gameChatPanel.getFocus();
        } if(handled) {
            ;// ??????????????????????
        }
    }

    protected boolean method275() {
        return this.aBoolean271;
    }

    public void addServerMessage(String var1) {
        this.gameChatPanel.addServerMessage(var1);
    }

    protected void writeGameData(String var1) {
        this.connection.writeData("game\t" + var1);
    }

    public void method278() {
        this.gameDrawingCanvas.stop();
        this.gameWordPanel.stop();
    }

    private void create(BadWordFilter badwordFilter) {
        this.setLayout((LayoutManager) null);
        this.gameInfoCanvas = new GameInfoCanvas(this.gameApplet, this.textManager, this.imageManager);
        this.gameInfoCanvas.setLocation(5, 5);
        this.add(this.gameInfoCanvas);
        this.gameDrawingToolsPanel = new GameDrawingToolsPanel(this.textManager, this.imageManager);
        this.gameDrawingToolsPanel.setLocation(5, 110);
        this.gameDrawingToolsPanel.setVisible(false);
        this.add(this.gameDrawingToolsPanel);
        this.gameDrawerInfoPanel = new GameDrawerInfoPanel(this.textManager, this.imageManager);
        this.gameDrawerInfoPanel.setLocation(5, 110);
        this.gameDrawerInfoPanel.setVisible(false);
        this.add(this.gameDrawerInfoPanel);
        this.gamePlayerListPanel = new GamePlayerListPanel(this.gameApplet, this.textManager, this.imageManager, this);
        this.gamePlayerListPanel.setLocation(5, 270);
        this.add(this.gamePlayerListPanel);
        this.buttonBack = new ColorButton(this.textManager.getGame("Game_Back"));
        this.buttonBack.setBounds(5, this.height - 5 - 20, 100, 20);
        this.buttonBack.setBackground(GameApplet.colourButtonYellow);
        this.buttonBack.addActionListener(this);
        this.add(this.buttonBack);
        this.buttonEnterDrawQueue = new ColorButton(this.textManager.getGame("Game_EnterDrawQueue"));
        this.buttonEnterDrawQueue.setBounds(120, this.height - 5 - 20 - 5 - 25, 175, 25);
        this.buttonEnterDrawQueue.setBackground(GameApplet.aColor3733);
        this.buttonVoteKickDrawer = new ColorButton(this.textManager.getGame("Game_VoteKickDrawer"));
        this.buttonVoteKickDrawer.setBounds(120, this.height - 5 - 20, 175, 20);
        this.buttonVoteKickDrawer.setBackground(GameApplet.colourButtonRed);
        this.gameDrawingCanvas = new GameDrawingCanvas(this.gameApplet, this.textManager, this, this.gameDrawingToolsPanel);
        this.gameDrawingCanvas.setLocation(300, 5);
        this.add(this.gameDrawingCanvas);
        this.gameWordPanel = new GameWordPanel(this.gameApplet, this.textManager);
        this.gameWordPanel.setLocation(300, 266);
        this.add(this.gameWordPanel);
        this.gameChatPanel = new GameChatPanel(this.gameApplet, this.textManager, this.soundManager, badwordFilter, this);
        this.gameChatPanel.setLocation(300, 300);
        this.add(this.gameChatPanel);
        this.gameDrawingToolsPanel.setDrawingCanvas(this.gameDrawingCanvas);
    }

    private void method280(int var1) {
        if (var1 != this.anInt274) {
            this.anInt274 = var1;
            this.setVisible(false);
            this.remove(this.buttonEnterDrawQueue);
            this.buttonEnterDrawQueue.removeActionListener(this);
            this.remove(this.buttonVoteKickDrawer);
            this.buttonVoteKickDrawer.removeActionListener(this);
            if (var1 == 1) {
                this.buttonBack.setBackground(GameApplet.colourButtonRed);
            } else {
                if (!this.aBoolean271) {
                    this.buttonEnterDrawQueue.addActionListener(this);
                    this.add(this.buttonEnterDrawQueue);
                    if (var1 == 0) {
                        this.buttonVoteKickDrawer.addActionListener(this);
                        this.add(this.buttonVoteKickDrawer);
                    }
                }

                this.buttonBack.setBackground(GameApplet.colourButtonYellow);
            }

            this.setVisible(true);
        }
    }
}
