package apool;

import com.playray.client.SPanel;
import com.playray.colorgui.ColorList;
import com.playray.colorgui.ColorListItem;
import com.playray.colorgui.GlossyButton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class LobbyGameListPanel extends SPanel implements ActionListener, ItemListener {

    private Class60 aClass60_3985;
    private SPanel_Sub21 aSPanel_Sub21_3986;
    private int anInt3987;
    private int anInt3988;
    private ColorList listGameTitles;
    private GlossyButton buttonWatch;


    protected LobbyGameListPanel(Class60 var1, SPanel_Sub21 var2, int var3, int var4) {
        super(false);
        this.aClass60_3985 = var1;
        this.aSPanel_Sub21_3986 = var2;
        this.anInt3987 = var3;
        this.anInt3988 = var4;
        this.setSize(var3, var4);
        this.create();
    }

    public void actionPerformed(ActionEvent var1) {
        this.aSPanel_Sub21_3986.method2576();
        if (var1.getSource() == this.buttonWatch) {
            ColorListItem var2 = this.listGameTitles.getSelectedItem();
            this.method2499(var2);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        this.aSPanel_Sub21_3986.method2576();
        if (var1.getSource() == this.listGameTitles && var1.getID() == 2) {
            ColorListItem var2 = (ColorListItem) ((ColorListItem) var1.getItem());
            this.method2499(var2);
        }

    }

    protected static String method2493(String var0, String var1) {
        return var0 + " - " + var1;
    }

    protected boolean method2494(String[] var1) {
        if (var1[1].equals("gamelist")) {
            if (var1[2].equals("list")) {
                int var2 = (var1.length - 3) / 4;

                for (int var3 = 0; var3 < var2; ++var3) {
                    this.method2495(var1[3 + var3 * 4], var1[4 + var3 * 4], var1[5 + var3 * 4], var1[6 + var3 * 4]);
                }

                return true;
            }

            if (var1[2].equals("add")) {
                this.method2495(var1[3], var1[4], var1[5], var1[6]);
                return true;
            }

            if (var1[2].equals("change")) {
                this.method2496(var1[3], var1[4]);
                return true;
            }

            if (var1[2].equals("remove")) {
                this.method2497(var1[3], var1[4]);
                return true;
            }
        }

        return false;
    }

    private void method2495(String var1, String var2, String var3, String var4) {
        int var5 = var4.equals("t") ? 0 : 7;
        String[] var6 = new String[]{var1, var2, var3, var4};
        ColorListItem var7 = new ColorListItem((Image) null, var5, false, method2493(var2, var3), var6, false);
        var7.setIcon(var1.equals("t") ? this.aClass60_3985.imageManager.method1983("coin-icon") : this.aClass60_3985.anImage1213);
        this.listGameTitles.addItem(var7);
    }

    private void method2496(String var1, String var2) {
        String[] var3 = this.method2497(var1, var2);
        this.method2495(var3[0], var1, var2, "t");
    }

    private String[] method2497(String var1, String var2) {
        ColorListItem var3 = this.listGameTitles.removeItem(method2493(var1, var2));
        return var3 != null ? (String[]) ((String[]) var3.getData()) : null;
    }

    private void create() {
        this.listGameTitles = new ColorList(this.anInt3987, this.anInt3988 - 25 - 2);
        this.listGameTitles.setLocation(0, 0);
        this.listGameTitles.setSelectable(1);
        this.listGameTitles.setSorting(1);
        this.listGameTitles.setTitle(this.aClass60_3985.textManager.method2039("Lobby_GameList_Title"));
        this.listGameTitles.addItemListener(this);
        this.listGameTitles.setAlpha(208);
        this.add(this.listGameTitles);
        this.buttonWatch = new GlossyButton(this.aClass60_3985.textManager.method2039("Lobby_GameList_Watch"), 1);
        this.buttonWatch.setBounds(0, this.anInt3988 - 25, this.anInt3987, 25);
        this.buttonWatch.addActionListener(this);
        this.add(this.buttonWatch);
    }

    private void method2499(ColorListItem var1) {
        if (var1 != null) {
            String[] var2 = (String[]) ((String[]) var1.getData());
            if (!var2[3].equals("t")) {
                this.aSPanel_Sub21_3986.method2579(this.aClass60_3985.textManager.method2039("Lobby_GameList_NoSpectatorsAllowed"));
            } else {
                this.aSPanel_Sub21_3986.method2580("watch\t" + var2[1] + "\t" + var2[2]);
            }
        }
    }
}
