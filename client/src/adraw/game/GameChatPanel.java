package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.BadWordFilter;
import com.aapeli.client.InputTextField;
import com.aapeli.client.SoundManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.ColorTextArea;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameChatPanel extends Panel implements KeyListener, ActionListener {

    private GameApplet gameApplet;
    private TextManager textManager;
    private SoundManager soundManager;
    private BadWordFilter badwordFilter;
    private GamePanel gamePanel;
    private GameFloodProtection gameFloodProtection;
    private String ownInfo;
    private ColorTextArea textArea;
    private InputTextField textFieldInput;
    private ColorButton buttonChat;
    private ColorCheckbox checkboxBeep;
    private ColorCheckbox checkboxClear;
    private boolean isNotDrawing;


    protected GameChatPanel(GameApplet gameApplet, TextManager textManager, SoundManager soundManager, BadWordFilter badWordFilter, GamePanel gamePanel) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.soundManager = soundManager;
        this.badwordFilter = badWordFilter;
        this.gamePanel = gamePanel;
        this.setSize(465, 180);
        this.gameFloodProtection = new GameFloodProtection();
        this.create();
        this.isNotDrawing = true;
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
        g.fillRect(0, 0, 465, 180);
        if (!this.isNotDrawing) {
            g.setFont(GameApplet.fontDialog12);
            g.setColor(this.gameApplet.colourForeground);
            g.drawString(this.textManager.getGame("GameChat_CantChatOrGuess"), 1, 148);
        }

    }

    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == this.textFieldInput && evt.getKeyCode() == 10) {
            this.sendChatInput();
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.buttonChat) {
            this.sendChatInput();
        }

    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("owninfo")) {
            this.ownInfo = GamePanel.getPlayerName(args[2]);
            return true;
        } else if (args[1].equals("join")) {
            this.addChatMessage(this.textManager.getGame("GameChat_PlayerJoined", GamePanel.getPlayerName(args[2])));
            return true;
        } else if (args[1].equals("part")) {
            this.addChatMessage(this.textManager.getGame("GameChat_" + (args[2].equals("t") ? "Drawer" : "Player") + "Left", args[2]));
            return true;
        } else if (args[1].equals("vkd")) {
            this.addChatMessage(this.textManager.getGame("GameChat_RemovingDrawerByVotes"));
            return true;
        } else if (args[1].equals("say")) {
            boolean isLocalPlayer = args[2].equals(this.ownInfo);
            this.addPlayerMessage(isLocalPlayer ? 3 : 0, args[2], args[3], isLocalPlayer);
            return true;
        } else if (args[1].equals("noplayers")) {
            this.addChatMessage(this.textManager.getGame("GameChat_NotEnoughPlayers", args[2]));
            return true;
        } else if (args[1].equals("nodrawer")) {
            this.addChatMessage(this.textManager.getGame("GameChat_NoDrawer"));
            return true;
        } else if (args[1].equals("gpart")) {
            String var2;
            if (args[2].equals(this.ownInfo)) {
                var2 = this.textManager.getGame("GameChat_YouGuessedPartially");
            } else {
                var2 = this.textManager.getGame("GameChat_OtherGuessedPartially", args[2]);
            }

            this.addChatMessage(var2);
            return true;
        } else {
            return false;
        }
    }

    protected void addRoundStartMessage(boolean var1, String var2, String var3) {
        if (this.checkboxClear.getState()) {
            this.textArea.clear();
        } else {
            this.textArea.addLine();
        }

        String var4;
        if (var1) {
            if (this.gamePanel.method275()) {
                var4 = this.textManager.getGame("GameChat_NewRound");
            } else {
                var4 = this.textManager.getGame("GameChat_NewRoundYouDraw", var3);
            }

            this.setNotDrawing(false);
        } else {
            var4 = this.textManager.getGame("GameChat_NewRoundOtherDraw", var2);
            this.buttonChat.setLabel(this.textManager.getGame("GameChat_GuessButton"));
        }

        String var5 = this.textManager.getShared("Chat_Message", var4);
        this.textArea.addLine(5, var5, false);
        if (this.checkboxBeep.getState()) {
            this.soundManager.playNotify();
        }

    }

    protected void addRoundRunningMessage(String var1) {
        String var2 = this.textManager.getGame("GameChat_RunningRound", var1);
        String var3 = this.textManager.getShared("Chat_Message", var2);
        this.textArea.addLine(5, var3, false);
    }

    protected void addRoundEndMessage(String word, String playerInfo) {
        String var3;
        if (playerInfo != null) {
            if (playerInfo.equals(this.ownInfo)) {
                var3 = this.textManager.getGame("GameChat_RoundEndYouGuessed", word);
            } else {
                var3 = this.textManager.getGame("GameChat_RoundEndOtherGuessed", word, playerInfo);
            }
        } else {
            var3 = this.textManager.getGame("GameChat_RoundEndNoneGuessed", word);
        }

        String var4 = this.textManager.getShared("Chat_Message", var3);
        this.textArea.addLine(5, var4, false);
        this.buttonChat.setLabel(this.textManager.getGame("GameChat_SayButton"));
        this.setNotDrawing(true);
    }

    protected void getFocus() {
        if (this.isNotDrawing) {
            this.textFieldInput.requestFocus();
        }

    }

    protected void addServerMessage(String var1) {
        String var2 = this.textManager.getGame("MessageFromServer", var1);
        this.textArea.addLine(6, var2, false);
    }

    protected void addChatMessage(String var1) {
        String var2 = this.textManager.getShared("Chat_Message", var1);
        this.textArea.addLine(7, var2, false);
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.textArea = new ColorTextArea(465, 128);
        this.textArea.setLocation(0, 0);
        this.add(this.textArea);
        this.textFieldInput = new InputTextField(this.textManager.getGame("GameChat_InputHelp"), 200, true);
        this.textFieldInput.setBounds(0, 130, 360, 25);
        this.textFieldInput.addKeyListener(this);
        this.add(this.textFieldInput);
        this.buttonChat = new ColorButton(this.textManager.getGame("GameChat_SayButton"));
        this.buttonChat.setBounds(361, 130, 104, 25);
        this.buttonChat.setBackground(GameApplet.aColor3733);
        this.buttonChat.addActionListener(this);
        this.add(this.buttonChat);
        this.checkboxBeep = new ColorCheckbox(this.textManager.getGame("GameChat_BeepOnRoundStart"));
        this.checkboxBeep.setBounds(0, 160, 227, 20);
        this.checkboxBeep.setBackground(this.gameApplet.colourBackground);
        this.checkboxBeep.setForeground(this.gameApplet.colourForeground);
        this.add(this.checkboxBeep);
        this.checkboxClear = new ColorCheckbox(this.textManager.getGame("GameChat_ClearOnRoundStart"));
        this.checkboxClear.setBounds(232, 160, 232, 20);
        this.checkboxClear.setBackground(this.gameApplet.colourBackground);
        this.checkboxClear.setForeground(this.gameApplet.colourForeground);
        this.add(this.checkboxClear);
    }

    private void setNotDrawing(boolean notDrawing) {
        if (notDrawing != this.isNotDrawing) {
            this.isNotDrawing = notDrawing;
            this.setVisible(false);
            if (notDrawing) {
                this.textFieldInput.setText("");
                this.textFieldInput.addKeyListener(this);
                this.add(this.textFieldInput);
                this.add(this.buttonChat);
            } else {
                this.textFieldInput.removeKeyListener(this);
                this.remove(this.textFieldInput);
                this.remove(this.buttonChat);
            }

            this.setVisible(true);
        }
    }

    private void sendChatInput() {
        if (this.gameApplet.isValidSite && this.ownInfo != null) {
            String text = this.textFieldInput.getText().trim();
            if (text.length() != 0) {
                if (this.gameFloodProtection.canSend()) {
                    text = this.textFieldInput.getInputText();
                    if (text.length() > 0) {
                        this.gamePanel.writeGameData("say\t" + text);
                    }

                }
            }
        }
    }

    private void addPlayerMessage(int var1, String playerName, String message, boolean isLocalPlayer) {
        if (this.badwordFilter != null && !isLocalPlayer) {
            message = this.badwordFilter.filter(message);
        }

        String var5;
        if (message.length() > 4 && message.toLowerCase().startsWith("/me ")) {
            var5 = this.textManager.getShared("Chat_UserAction", playerName, message.substring(4));
            this.textArea.addLine(var1, var5, isLocalPlayer);
        } else {
            var5 = this.textManager.getShared("Chat_UserSay", playerName, message);
            this.textArea.addLine(var1, var5, isLocalPlayer);
        }
    }
}
