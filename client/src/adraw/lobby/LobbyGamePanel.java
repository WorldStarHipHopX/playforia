package adraw.lobby;

import adraw.GameApplet;
import com.aapeli.client.IPanel;
import com.aapeli.client.ImageManager;
import com.aapeli.client.InputTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.ColorButton;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;
import com.aapeli.settingsgui.*;
import com.aapeli.settingsgui.LobbyRoomSettingsPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

public class LobbyGamePanel extends IPanel implements GuiListener, ItemListener, ActionListener {

    public static String[] wordTypes = {"All", "Noun", "Verb", "Adjective"};
    private static final int numWordTypes = wordTypes.length;
    private static final int[] roundTimes = {60, 90, 120, 150, 180, 240, 300};
    private GameApplet gameApplet;
    private TextManager textManager;
    private ImageManager imageManager;
    private LobbyPanel lobbyPanel;
    private int width;
    private int height;
    private LobbyRoomSettingsPanel lobbyRoomSettingsPanel;
    private MultiColorList gameList;
    private ColorList gamePlayersList;
    private ColorButton buttonJoinGame;
    private boolean onlyCreatorDraws;
    private int joinError;
    private LobbyGamePasswordPanel lobbyGamePasswordPanel;
    private Image image;
    private Graphics graphics;
    private String additionalGameInfo;
    private InputTextField textFieldGameName;
    private ColorButton buttonChangeGameName;


    protected LobbyGamePanel(GameApplet gameApplet, TextManager textManager, ImageManager imageManager, LobbyPanel lobbyPanel, int width, int height) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.lobbyPanel = lobbyPanel;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.onlyCreatorDraws = false;
        this.additionalGameInfo = null;
        this.create();
    }

    public void update(Graphics g) {
        if (this.image == null) {
            this.image = this.createImage(this.width, this.height);
            this.graphics = this.image.getGraphics();
        }

        this.drawBackground(this.graphics);
        this.graphics.setColor(this.gameApplet.colourForeground);
        this.graphics.setFont(GameApplet.fontSerif20);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_CreateGameTitle"), this.width / 4 + 20, 65, StringDraw.ALIGN_CENTER);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_JoinGameTitle"), this.width * 3 / 4 - 40, 65, StringDraw.ALIGN_CENTER);
        this.graphics.setFont(GameApplet.fontDialog12);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_GameName"), this.width / 2 - 185 + -60, 101, StringDraw.ALIGN_RIGHT);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_GamePassword"), this.width / 2 - 185 + -60, 126, StringDraw.ALIGN_RIGHT);
        if (this.gameApplet.playerIsRegistered()) {
            this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_OnlyFor"), this.width / 2 - 185 + -60, 151, StringDraw.ALIGN_RIGHT);
        }

        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_MaxPlayers"), this.width / 2 - 185 + -60, 176, StringDraw.ALIGN_RIGHT);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_RoundTime"), this.width / 2 - 185 + -60, 201, StringDraw.ALIGN_RIGHT);
        this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_WordType"), this.width / 2 - 185 + -60, 226, StringDraw.ALIGN_RIGHT);
        if (this.onlyCreatorDraws) {
            this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_OnlyCreatorDrawNote"), this.width * 3 / 4 - 40, this.height - 60, StringDraw.ALIGN_CENTER);
        }

        if (this.joinError > 0) {
            String reason = null;
            if (this.joinError == 1) {
                reason = "NotExist";
            } else if (this.joinError == 2) {
                reason = "WrongPassword";
            } else if (this.joinError == 3) {
                reason = "GameFull";
            } else if (this.joinError == 4) {
                reason = "RegOnly";
            } else if (this.joinError == 6) {
                reason = "Banned";
            } else if (this.joinError == 7) {
                reason = "DuplicateAccess";
            }

            this.graphics.setColor(this.gameApplet.colourJoinError);
            this.gameApplet.drawText(this.graphics, this.textManager.getGame("LobbyReal_JoinError" + reason), this.width * 3 / 4 - 40, this.height - 12, StringDraw.ALIGN_CENTER);
        }

        if (this.additionalGameInfo != null) {
            this.graphics.setColor(new Color(255, 176, 176));
            this.graphics.fillRect(360, this.height - 19, this.width - 20 - 360, 19);
            this.graphics.setColor(Color.black);
            this.graphics.setFont(GameApplet.fontDialog11);
            StringDraw.drawString(this.graphics, "Creator: " + this.additionalGameInfo, 365, this.height - 5, StringDraw.ALIGN_LEFT);
            StringDraw.drawString(this.graphics, "Name:", this.width - 20 - 5 - 70 - 130 - 5, this.height - 5, StringDraw.ALIGN_RIGHT);
        }

        g.drawImage(this.image, 0, 0, this);
    }

    public void unitValueChanged() {
    }

    public void unitButtonClicked() {
        if (this.lobbyGamePasswordPanel == null && this.gameApplet.isValidSite) {
            this.gameApplet.setGameState(0);
            this.lobbyPanel.writeLobbyCommand("create\t" + this.lobbyRoomSettingsPanel.getSaveableData());
        }
    }

    public void itemStateChanged(ItemEvent evt) {
        if (evt.getSource() == this.gameList && evt.getID() == MultiColorList.ID_DOUBLECLICKED) {
            MultiColorListItem item = (MultiColorListItem) evt.getItem();
            this.joinGame(item);
        } else {
            this.method504();
        }
    }

    public void actionPerformed(ActionEvent evt) {
        if (this.lobbyGamePasswordPanel == null && this.gameApplet.isValidSite) {
            Object evtSource = evt.getSource();
            if (evtSource == this.buttonChangeGameName) {
                String[] var6 = this.getSelectedGameInfo();
                if (var6 != null) {
                    int var4 = Integer.parseInt(var6[0]);
                    String var5 = this.textFieldGameName.getInputText(false);
                    if (var5.length() != 0) {
                        if (!var5.equals(var6[5])) {
                            this.lobbyPanel.writeLobbyCommand("changename\t" + var4 + "\t" + var5);
                        }
                    }
                }
            } else {
                if (evtSource == this.buttonJoinGame) {
                    this.joinError = 0;
                    this.repaint();
                    MultiColorListItem var3 = this.gameList.getSelectedItem();
                    this.joinGame(var3);
                }

            }
        }
    }

    protected void method491(int var1) {
        this.joinError = var1;
        this.repaint();
    }

    protected void joinGame(String gameName, String password) {
        this.setVisible(false);
        this.remove(this.lobbyGamePasswordPanel);
        this.lobbyGamePasswordPanel = null;
        this.add(this.gameList);
        this.add(this.gamePlayersList);
        this.add(this.buttonJoinGame);
        this.setVisible(true);
        if (password != null) {
            this.gameApplet.setGameState(0);
            this.lobbyPanel.writeLobbyCommand("join\t" + gameName + "\t" + password);
        }
    }

    protected boolean handlePacket(String[] args) {
        if (args[1].equals("gamelist")) {
            if (args[2].equals("full")) {
                this.addGames(args);
                this.method504();
                return true;
            }

            if (args[2].equals("add")) {
                if (args.length == 12) {
                    this.addGame(args, 3, this.gameList.getItemCount() == 0 ? Integer.parseInt(args[3]) : -1);
                } else {
                    this.removeGame(args[3], args[4], true);
                }

                this.method504();
                return true;
            }

            if (args[2].equals("remove")) {
                this.removeGame(args[3], args[4], false);
                this.method504();
                return true;
            }

            if (args[2].equals("namechange")) {
                this.changeGameName(args[3], args[4]);
                this.method504();
                return true;
            }
        }

        return false;
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.lobbyRoomSettingsPanel = new LobbyRoomSettingsPanel();
        this.lobbyRoomSettingsPanel.setBounds(5, 83, 315, 205);
        this.lobbyRoomSettingsPanel.setBackground(this.gameApplet.colourBackground);
        this.lobbyRoomSettingsPanel.setForeground(this.gameApplet.colourForeground);
        if (this.gameApplet.playerIsRegistered()) {
            UnitTextField unit = new UnitTextField(this.textManager.getGame("LobbyReal_GameName"), this.textManager, 15);
            this.lobbyRoomSettingsPanel.addUnit(unit);
        } else {
            UnitData unit = new UnitData();
            this.lobbyRoomSettingsPanel.addUnit(unit);
        }

        UnitChoice choicePerms = new UnitChoice(this.textManager.getGame("LobbyReal_OnlyFor"));
        choicePerms.addItem(this.textManager.getGame("LobbyReal_ForAll"));
        choicePerms.addItem(this.textManager.getGame("LobbyReal_OnlyForReg"));
        choicePerms.addItem(this.textManager.getGame("LobbyReal_OnlyPassword"));
        if (this.gameApplet.playerIsRegistered()) {
            choicePerms.setItemState(1);// SO EVIL
        }

        this.lobbyRoomSettingsPanel.addUnit(choicePerms);
        UnitTextField textFieldGamePassword = new UnitTextField(this.textManager.getGame("LobbyReal_GamePassword"), this.textManager, 15);
        this.lobbyRoomSettingsPanel.addUnit(textFieldGamePassword);
        UnitChoice choiceMaxPlayers = new UnitChoice(this.textManager.getGame("LobbyReal_MaxPlayers"));

        for (int i = 4; i <= 10; ++i) {
            choiceMaxPlayers.addItem(String.valueOf(i));
        }

        choiceMaxPlayers.setItemState(4);
        this.lobbyRoomSettingsPanel.addUnit(choiceMaxPlayers);
        UnitChoice choiceRoundTime = new UnitChoice(this.textManager.getGame("LobbyReal_RoundTime"));

        for (int i = 0; i < roundTimes.length; ++i) {
            choiceRoundTime.addItem(this.textManager.getTime((long) roundTimes[i]));
        }

        choiceRoundTime.setItemState(2);
        this.lobbyRoomSettingsPanel.addUnit(choiceRoundTime);
        UnitChoice choiceWordType = new UnitChoice(this.textManager.getGame("LobbyReal_WordType"));

        for (int i = 0; i < numWordTypes; ++i) {
            choiceWordType.addItem(this.textManager.getGame("LobbyReal_WordType" + wordTypes[i]));
        }

        choiceWordType.setItemState(0);
        this.lobbyRoomSettingsPanel.addUnit(choiceWordType);
        UnitChoice choiceOnlyCreatorDraws = new UnitChoice(this.textManager.getGame("LobbyReal_OnlyCreatorDraw"));
        choiceOnlyCreatorDraws.addItem(this.textManager.getGame("LobbyReal_OnlyCreatorDrawNo"));
        choiceOnlyCreatorDraws.addItem(this.textManager.getGame("LobbyReal_OnlyCreatorDrawYes"));
        choiceOnlyCreatorDraws.setItemState(0);
        this.lobbyRoomSettingsPanel.addUnit(choiceOnlyCreatorDraws);
        UnitButton buttonCreateRoom = new UnitButton(this.textManager.getGame("LobbyReal_CreateGame"), GameApplet.colourButtonGreen);
        this.lobbyRoomSettingsPanel.addUnit(buttonCreateRoom);
        if (!this.gameApplet.playerIsRegistered()) {
            this.lobbyRoomSettingsPanel.addRule(new Rule(choicePerms, 1, choicePerms, 0));
            this.lobbyRoomSettingsPanel.addRule(new Rule(choicePerms, 2, choicePerms, 0));
        }

        for (int var11 = 0; var11 < 3; ++var11) {
            this.lobbyRoomSettingsPanel.addRule(new Rule(choicePerms, var11, textFieldGamePassword, var11 == 2));
        }

        this.lobbyRoomSettingsPanel.ready();
        this.lobbyRoomSettingsPanel.checkAllRules();
        this.lobbyRoomSettingsPanel.addGuiListener(this);
        this.add(this.lobbyRoomSettingsPanel);
        String[] listTitles = new String[]{this.textManager.getGame("LobbyReal_GameListTitleProtection"), this.textManager.getGame("LobbyReal_GameListTitleGameName"), this.textManager.getGame("LobbyReal_GameListTitlePlayers"), this.textManager.getGame("LobbyReal_GameListTitleRoundTime"), this.textManager.getGame("LobbyReal_GameListTitleWordType"), this.textManager.getGame("LobbyReal_GameListTitleHosted")};
        int[] var13 = new int[]{0, 0, 2, 5, 0, 0};
        this.gameList = new MultiColorList(listTitles, var13, 1, this.width / 2 - 100 + 15, 145);
        this.gameList.setLocation(this.width / 2 - 30, 85);
        this.gameList.setSelectable(1);
        this.gameList.addItemListener(this);
        this.add(this.gameList);
        this.gamePlayersList = new ColorList(100, 145);
        this.gamePlayersList.setLocation(this.width - 20 - 100 + 10, 85);
        this.gamePlayersList.setTitle(this.textManager.getGame("LobbyReal_PlayerListTitle"), new Color(192, 192, 192));
        this.gamePlayersList.setSorting(1);
        this.add(this.gamePlayersList);
        this.buttonJoinGame = new ColorButton(this.textManager.getGame("LobbyReal_JoinGame"));
        this.buttonJoinGame.setBackground(GameApplet.colourButtonGreen);
        this.buttonJoinGame.setBounds(this.width * 3 / 4 - 40 - 60, this.height - 30 - 23, 120, 23);
        this.buttonJoinGame.addActionListener(this);
        this.add(this.buttonJoinGame);
        if (this.gameApplet.getPlayerAccessLevel() >= 1) {
            this.textFieldGameName = new InputTextField(15);
            this.textFieldGameName.setBounds(this.width - 20 - 5 - 70 - 130, this.height - 1 - 17, 130, 17);
            this.textFieldGameName.setVisible(false);
            this.add(this.textFieldGameName);
            this.buttonChangeGameName = new ColorButton("Change");
            this.buttonChangeGameName.setBounds(this.width - 20 - 5 - 70, this.height - 1 - 17, 70, 17);
            this.buttonChangeGameName.setBackground(GameApplet.colourButtonYellow);
            this.buttonChangeGameName.addActionListener(this);
            this.buttonChangeGameName.setVisible(false);
            this.add(this.buttonChangeGameName);
        }

    }

    private void joinGame(MultiColorListItem var1) {
        if (var1 != null) {
            String[] var2 = (String[]) var1.getData();
            int var3 = Integer.parseInt(var2[1]);
            if (var3 == 2) {
                this.displayPasswordPanel(var2[0]);
            } else if (var3 == 1 && !this.gameApplet.playerIsRegistered()) {
                this.joinError = 4;
                this.repaint();
            } else {
                this.gameApplet.setGameState(0);
                this.lobbyPanel.writeLobbyCommand("join\t" + var2[0]);
            }
        }
    }

    private void displayPasswordPanel(String var1) {
        this.setVisible(false);
        this.remove(this.gameList);
        this.remove(this.gamePlayersList);
        this.remove(this.buttonJoinGame);
        this.lobbyGamePasswordPanel = new LobbyGamePasswordPanel(this.textManager, this.imageManager, this, var1);
        this.lobbyGamePasswordPanel.setLocation(this.width / 2 + 40, 120);
        this.add(this.lobbyGamePasswordPanel);
        this.setVisible(true);
    }

    private void addGames(String[] var1) {
        int var2 = Integer.parseInt(var1[3]);
        int var3 = var2 > 0 ? Integer.parseInt(var1[4]) : -1;
        this.gameList.removeAllItems();

        for (int var4 = 0; var4 < var2; ++var4) {
            this.addGame(var1, 4 + var4 * 9, var3);
        }

        this.joinError = 0;
        this.repaint();
    }

    private void addGame(String[] var1, int var2, int var3) {
        int var4 = Integer.parseInt(var1[var2]);
        int var5 = Integer.parseInt(var1[var2 + 2]);
        int var6 = Integer.parseInt(var1[var2 + 3]);
        int var7 = (new StringTokenizer(var1[var2 + 8], ",")).countTokens();
        String[] var8 = new String[6];
        byte var9 = 0;
        boolean var10 = false;
        var8[0] = "";
        if (var5 == 1) {
            var8[0] = this.textManager.getGame("LobbyReal_ListRegOnly");
            var10 = true;
        }

        if (var5 == 2) {
            var8[0] = this.textManager.getGame("LobbyReal_ListPassword");
            var9 = 1;
        }

        var8[1] = var1[var2 + 1];
        var8[2] = var7 + "/" + var6;
        var8[3] = this.textManager.getTime((long) Integer.parseInt(var1[var2 + 4]));
        var8[4] = this.textManager.getGame("LobbyReal_ListWordType" + wordTypes[Integer.parseInt(var1[var2 + 5])]);
        var8[5] = this.textManager.getGame("LobbyReal_ListHosted" + (var1[var2 + 7].equals("t") ? "Yes" : "No"));
        String[] var11 = new String[]{var1[var2], var1[var2 + 2], var1[var2 + 8], var1[var2 + 7], var1[var2 + 6], var1[var2 + 1]};
        MultiColorListItem var12 = new MultiColorListItem(var9, var10, var8, var11, var4 == var3);
        this.gameList.addItem(var12);
    }

    private void removeGame(String var1, String var2, boolean var3) {
        boolean var4 = this.method500(var1, var2, var3);
        if (var4) {
            this.method504();
        }

    }

    private boolean method500(String var1, String var2, boolean var3) {
        MultiColorListItem var4 = this.method502(var1);
        if (var4 != null) {
            synchronized (gameList) {
                String[] var6 = (String[]) var4.getData();
                String[] var7 = var4.getStrings();
                int var8 = var7[2].indexOf(47);
                int var9 = Integer.parseInt(var7[2].substring(0, var8));
                if (var3) {
                    var6[2] = var6[2] + "," + var2;
                    var7[2] = var9 + 1 + var7[2].substring(var8);
                } else {
                    var6[2] = this.method503(var6[2], var2);
                    if (var6[2] == null) {
                        this.gameList.removeItem(var4);
                    } else {
                        var7[2] = var9 - 1 + var7[2].substring(var8);
                    }
                }

                this.gameList.repaint();
                return var4.isSelected();
            }
        } else {
            return false;
        }
    }

    private void changeGameName(String var1, String var2) {
        MultiColorListItem var3 = this.method502(var1);
        if (var3 != null) {
            synchronized (gameList) {
                String[] var5 = (String[]) var3.getData();
                String[] var6 = var3.getStrings();
                var6[1] = var5[5] = var2;
                this.gameList.repaint();
            }
        }
    }

    private MultiColorListItem method502(String var1) {
        synchronized (gameList) {
            MultiColorListItem[] var3 = this.gameList.getAllItems();
            if (var3 == null) {
                return null;
            } else {
                int var4 = var3.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    String[] var6 = (String[]) var3[var5].getData();
                    if (var6[0].equals(var1)) {
                        MultiColorListItem var7 = var3[var5];
                        return var7;
                    }
                }

                return null;
            }
        }
    }

    private String method503(String var1, String var2) {
        StringTokenizer var3 = new StringTokenizer(var1, ",");
        String var4 = null;

        while (var3.hasMoreTokens()) {
            String var5 = var3.nextToken();
            if (!var5.equals(var2)) {
                if (var4 == null) {
                    var4 = var5;
                } else {
                    var4 = var4 + "," + var5;
                }
            }
        }

        return var4;
    }

    private void method504() {
        this.gamePlayersList.removeAllItems();
        String[] var1 = this.getSelectedGameInfo();
        if (var1 != null) {
            StringTokenizer var2 = new StringTokenizer(var1[2], ",");

            while (var2.hasMoreTokens()) {
                ColorListItem var3 = new ColorListItem(var2.nextToken());
                this.gamePlayersList.addItem(var3);
            }

            this.onlyCreatorDraws = var1[3].equals("t");
            if (this.gameApplet.getPlayerAccessLevel() >= 1) {
                this.additionalGameInfo = var1[4];
                this.textFieldGameName.setText(var1[5]);
                this.textFieldGameName.setVisible(true);
                this.buttonChangeGameName.setVisible(true);
            }
        } else {
            this.onlyCreatorDraws = false;
            if (this.additionalGameInfo != null) {
                this.additionalGameInfo = null;
                this.textFieldGameName.setVisible(false);
                this.buttonChangeGameName.setVisible(false);
            }
        }

        this.repaint();
    }

    private String[] getSelectedGameInfo() {
        MultiColorListItem var1 = this.gameList.getSelectedItem();
        return var1 != null ? (String[]) var1.getData() : null;
    }
}
