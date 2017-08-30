package adraw.lobby;

import adraw.GameApplet;
import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class LobbyGamePasswordPanel extends Panel implements KeyListener, ActionListener {

    private TextManager textManager;
    private ImageManager imageManager;
    private LobbyGamePanel lobbyGamePanel;
    private String roomName;
    private TextField textFieldPassword;
    private ColorButton buttonOk;
    private ColorButton buttonCancel;
    private boolean shouldClearHintText;


    protected LobbyGamePasswordPanel(TextManager textManager, ImageManager imageManager, LobbyGamePanel lobbyGamePanel, String roomName) {
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.lobbyGamePanel = lobbyGamePanel;
        this.roomName = roomName;
        this.setSize(200, 75);
        this.shouldClearHintText = true;
        this.create();
    }

    public void addNotify() {
        super.addNotify();
        this.textFieldPassword.requestFocus();
        this.repaint();
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public synchronized void update(Graphics g) {
        g.drawImage(this.imageManager.getImage("bg-password"), 0, 0, this);
    }

    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == this.textFieldPassword) {
            if (this.shouldClearHintText) {
                this.shouldClearHintText = false;
                this.textFieldPassword.setText("");
                this.textFieldPassword.setEchoChar('*');
            }

            if (evt.getKeyCode() == 10) {
                this.getText();
            }
        }

    }

    public void keyReleased(KeyEvent var1) {
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.buttonOk) {
            this.getText();
        }

        if (var2 == this.buttonCancel) {
            this.lobbyGamePanel.joinGame(this.roomName, (String) null);
        }

    }

    private void create() {
        this.textFieldPassword = new TextField(this.textManager.getGame("LobbyRealPassword_EnterPassword"));
        this.textFieldPassword.setBounds(25, 24, 150, 20);
        this.textFieldPassword.setBackground(Color.white);
        this.textFieldPassword.setForeground(Color.black);
        this.textFieldPassword.addKeyListener(this);
        this.add(this.textFieldPassword);
        this.buttonOk = new ColorButton(this.textManager.getGame("LobbyRealPassword_Ok"));
        this.buttonOk.setBounds(25, 46, 50, 20);
        this.buttonOk.setBackground(GameApplet.colourButtonGreen);
        this.buttonOk.addActionListener(this);
        this.add(this.buttonOk);
        this.buttonCancel = new ColorButton(this.textManager.getGame("LobbyRealPassword_Cancel"));
        this.buttonCancel.setBounds(125, 46, 50, 20);
        this.buttonCancel.setBackground(GameApplet.colourButtonRed);
        this.buttonCancel.addActionListener(this);
        this.add(this.buttonCancel);
        this.textFieldPassword.selectAll();
    }

    private void getText() {
        String text = this.textFieldPassword.getText().trim();
        if (!this.shouldClearHintText && text.length() != 0) {
            this.lobbyGamePanel.joinGame(this.roomName, text);
        } else {
            this.lobbyGamePanel.joinGame(this.roomName, (String) null);
        }
    }
}
