package adraw.game;

import adraw.GameApplet;
import com.aapeli.client.CharacterImage;
import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class GamePlayerListPanel extends Panel implements ItemListener, ActionListener {

    private GameApplet gameApplet;
    private TextManager textManager;
    private ImageManager imageManager;
    private GamePanel gamePanel;
    private MultiColorList playerList;
    private String localPlayerName;
    private PopupMenu popupMenu;
    private MenuItem popupMenuItemOpenPlayerCard;
    private MenuItem popupMenuItemKickPlayer;
    private MenuItem popupMenuItemKickBanPlayer;
    private String popupMenuPlayerName;


    protected GamePlayerListPanel(GameApplet gameApplet, TextManager textManager, ImageManager imageManager, GamePanel gamePanel) {
        this.gameApplet = gameApplet;
        this.textManager = textManager;
        this.imageManager = imageManager;
        this.gamePanel = gamePanel;
        this.setSize(290, 155);
        this.create();
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics var1) {
        var1.setColor(this.gameApplet.colourBackground);
        var1.fillRect(0, 0, 290, 155);
    }

    public void itemStateChanged(ItemEvent evt) {
        MultiColorListItem item = (MultiColorListItem) evt.getItem();
        if (item != null) {
            String playerName = item.getString(0);
            int var4 = evt.getID();
            if (var4 == 2) {
                this.showPlayerCard(playerName);
            }

            if (var4 == 1) {
                int[] mouseCoords = this.playerList.getLastClickedMouseXY();
                this.showPopupMenu(playerName, mouseCoords[0], mouseCoords[1]);
            }

        }
    }

    public void actionPerformed(ActionEvent evt) {
        Object evtSource = evt.getSource();
        if (evtSource == this.popupMenuItemOpenPlayerCard) {
            this.showPlayerCard(this.popupMenuPlayerName);
        } else if (evtSource == this.popupMenuItemKickPlayer) {
            this.sendAdminCommand("kick", this.popupMenuPlayerName);
        } else {
            if (evtSource == this.popupMenuItemKickBanPlayer) {
                this.sendAdminCommand("ban", this.popupMenuPlayerName);
            }

        }
    }

    protected boolean handlePacket(String[] args) {
        if(args[1].equals("players")) {
            int var2 = (args.length - 2) / 3;

            for (int var3 = 0; var3 < var2; ++var3) {
                this.addPlayer(args[2 + var3 * 3], args[3 + var3 * 3], args[4 + var3 * 3], false);
            }

            return true;
        } else if (args[1].equals("owninfo")) {
            this.localPlayerName = this.addPlayer(args[2], args[3], args[4], true);
            return true;
        } else if (args[1].equals("join")) {
            this.addPlayer(args[2], args[3], args[4], false);
            return true;
        } else if(args[1].equals("part")) {
            String playerName = args[2];
            this.playerList.removeItem(0, playerName);
            return true;
        } else if(args[1].equals("queue")) {
            this.setQueue(args);
            return true;
        } else if(args[1].equals("score")) {
            String playerName = args[2];
            String score = this.textManager.getNumber((long) Integer.parseInt(args[3]));
            this.setScore(playerName, 2, score, false);
            return true;
        }
        return false;
    }

    protected void setDrawer2(String var1) {
        if (var1 == null) {
            var1 = this.localPlayerName;
        }

        this.setDrawer(var1);
    }

    protected void clearDrawer() {
        this.setDrawer((String) null);
    }

    protected CharacterImage method284(String var1) {
        MultiColorListItem var2 = this.playerList.getItem(0, var1);
        return var2 == null ? null : (CharacterImage) var2.getData();
    }

    protected void showPlayerCard(String playerName) {
        if (playerName != null) {
            this.popupMenuPlayerName = playerName;
            this.gameApplet.showPlayerCard(playerName);
        }
    }

    protected void showPopupMenu(String playerName, int mouseX, int mouseY) {
        if (playerName != null) {
            this.popupMenuPlayerName = playerName;
            if (this.popupMenu != null) {
                this.remove(this.popupMenu);
            }

            this.popupMenu = new PopupMenu();
            this.popupMenuItemOpenPlayerCard = this.addMenuItem(this.popupMenu, this.textManager.getGame("GamePlayers_OpenPlayerCard"));
            this.popupMenuItemOpenPlayerCard.setEnabled(playerName.charAt(0) != '~');
            if (this.gameApplet.getPlayerAccessLevel() >= 1) {
                this.popupMenu.addSeparator();
                Menu sheriffMenu = new Menu("Sheriff");
                this.popupMenuItemKickPlayer = this.addMenuItem(sheriffMenu, "Kick");
                this.popupMenuItemKickBanPlayer = this.addMenuItem(sheriffMenu, "Kick & Ban");
                this.popupMenu.add(sheriffMenu);
            }

            this.add(this.popupMenu);
            this.popupMenu.show(this.playerList, mouseX, mouseY);
        }
    }

    private MenuItem addMenuItem(Menu menu, String text) {
        MenuItem item = new MenuItem(text);
        item.addActionListener(this);
        menu.add(item);
        return item;
    }

    private void sendAdminCommand(String var1, String var2) {
        this.gamePanel.writeGameData("command\t" + var1 + "\t" + var2);
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        String[] colTitles = new String[]{this.textManager.getGame("GamePlayers_TitleNick"), this.textManager.getGame("GamePlayers_TitleDrawQueue"), this.textManager.getGame("GamePlayers_TitleScore")};
        int[] colOrder = new int[]{MultiColorList.ORDER_ABC, MultiColorList.ORDER_123_ALL, MultiColorList.ORDER_321_ALL};
        this.playerList = new MultiColorList(colTitles, colOrder, 2, 290, 155);
        this.playerList.setLocation(0, 0);
        this.playerList.setSelectable(MultiColorList.SELECTABLE_ONE);
        this.playerList.setDecimalSeparator(this.textManager.getDecimalSeparator());
        this.playerList.addItemListener(this);
        this.add(this.playerList);
    }

    private String addPlayer(String playerInfo, String avatarUrl, String var3, boolean isLocalPlayer) {
        String name = GamePanel.getPlayerName(playerInfo);
        String status = GamePanel.getPlayerStatus(playerInfo);
        boolean isRegistered = status.indexOf('r') >= 0;
        boolean isSheriff = status.indexOf('s') >= 0;
        byte colourIndex;
        if (isLocalPlayer) {
            colourIndex = MultiColorListItem.COLOR_BLUE;
        } else if (isSheriff) {
            colourIndex = MultiColorListItem.COLOR_YELLOW;
        } else {
            colourIndex = MultiColorListItem.COLOR_BLACK;
        }

        CharacterImage var10 = new CharacterImage(this.imageManager, avatarUrl, 1);
        String[] var11 = new String[]{name, "", this.textManager.getNumber((long) Integer.parseInt(var3))};
        MultiColorListItem var12 = new MultiColorListItem(colourIndex, isRegistered, var11, var10);
        this.playerList.addItem(var12);
        return name;
    }

    private void setQueue(String[] var1) {
        this.reOrderPlayerListQueues(false);
        int var2 = var1.length - 2;

        for (int var3 = 0; var3 < var2; ++var3) {
            this.setScore(var1[2 + var3], 1, String.valueOf(var3 + 1), false);
        }

    }

    private void setDrawer(String playerName) {
        this.reOrderPlayerListQueues(true);
        if (playerName != null) {
            this.setScore(playerName, 1, this.textManager.getGame("GamePlayers_Drawing" + (this.gamePanel.method275() ? "Only" : "")), true);
        }

    }

    private void reOrderPlayerListQueues(boolean var1) {
        synchronized (playerList) {
            MultiColorListItem[] items = this.playerList.getAllItems();
            int numItems = items.length;

            for (int i = 0; i < numItems; ++i) {
                String[] var6 = items[i].getStrings();
                if (var6[1].length() > 0) {
                    char var7 = var6[1].charAt(0);
                    if (var7 >= '0' && var7 < '9') {
                        if (!var1) {
                            var6[1] = "";
                            items[i].setOverrideColor((Color) null);
                        }
                    } else if (var1) {
                        var6[1] = "";
                        items[i].setOverrideColor((Color) null);
                    }
                }
            }

            this.playerList.reSort();
        }
    }

    private void setScore(String playerName, int var2, String score, boolean isDrawing) {
        synchronized (playerList) {
            MultiColorListItem item = this.playerList.getItem(0, playerName);
            if (item != null) {
                String[] var7 = item.getStrings();
                var7[var2] = score;
                if (isDrawing) {
                    item.setOverrideColor(MultiColorListItem.COLOR_MAGENTA);
                }

                this.playerList.reSort();
                return;
            }
        }
    }
}
