package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class LobbyCoinsPanel extends SPanel implements ItemListener {

    private static final Font aFont3968 = new Font("Dialog", Font.PLAIN, 32);
    private Class60 aClass60_3969;
    private SPanel_Sub21 aSPanel_Sub21_3970;
    private LobbyHeaderPanel aSPanel__3971;
    private int height;
    private ColorCheckbox_Sub1 aColorCheckbox_Sub1_3973;
    private GlossyButton_Sub1 aGlossyButton_Sub1_3974;
    private boolean aBoolean3975;


    protected LobbyCoinsPanel(Class60 var1, SPanel_Sub21 var2, LobbyHeaderPanel var3, int height) {
        this.aClass60_3969 = var1;
        this.aSPanel_Sub21_3970 = var2;
        this.aSPanel__3971 = var3;
        this.height = height;
        this.setSize(170, height);
        this.method2489();
        this.method2490();
        this.aBoolean3975 = true;
    }

    public void paintContent(Graphics2D var1) {
        if (this.aBoolean3975) {
            this.aBoolean3975 = false;
            GameApplet.method2302(var1, 170, this.height, this);
        }

        if (this.aClass60_3969.aClass61_1207.aBoolean1217) {
            byte var2 = 25;
            if (!this.aClass60_3969.gameApplet.method2309()) {
                var1.setFont(GameApplet.aFont4817);
                var1.setColor(GameApplet.aColor4810);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3969.textManager.method2039("Lobby_Coins_NoAccount"), 85, var2 + 35, 0, 140);
            } else if (!this.aClass60_3969.gameApplet.method2313()) {
                var1.setFont(GameApplet.aFont4816);
                var1.setColor(GameApplet.aColor4811);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3969.textManager.method2039("Lobby_Coins_YourCoins") + " " + this.aClass60_3969.textManager.getNumber((long) this.aClass60_3969.gameApplet.method2312()), 85, var2 + 30, 0, 164);
                var1.setFont(GameApplet.aFont4817);
                var1.setColor(GameApplet.aColor4810);
                StringDraw.drawStringWithMaxWidth(var1, this.aClass60_3969.textManager.method2039("Lobby_Coins_CoinsNotUsable"), 85, var2 + 53, 0, 140);
            } else {
                var1.drawImage(this.aClass60_3969.imageManager.method1983("lobby_coin-pile"), 10, 45, this);
                var1.setColor(GameApplet.aColor4811);
                var1.setFont(GameApplet.aFont4817);
                StringDraw.drawString(var1, this.aClass60_3969.textManager.method2039("Lobby_Coins_YourCoins"), 85, var2 + 35, -1);
                var1.setFont(aFont3968);
                StringDraw.drawString(var1, this.aClass60_3969.textManager.getNumber((long) this.aClass60_3969.gameApplet.method2312()), 85, var2 + 71, -1);
            }
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        this.aSPanel_Sub21_3970.method2576();
        if (var1.getSource() == this.aColorCheckbox_Sub1_3973) {
            this.aClass60_3969.aClass61_1207.aBoolean1217 = this.aColorCheckbox_Sub1_3973.getState();
            this.method2490();
            this.aSPanel_Sub21_3970.method2584();
            if (this.aClass60_3969.aClass61_1207.aBoolean1217) {
                if (this.aClass60_3969.gameApplet.method2309()) {
                    this.aSPanel_Sub21_3970.method2579(this.aClass60_3969.textManager.method2039("Lobby_Coins_CoinGamesEnabledInfo"));
                } else {
                    this.aSPanel_Sub21_3970.method2579(this.aClass60_3969.textManager.method2039("Lobby_Coins_CoinGamesEnabledWormInfo"));
                    this.aClass60_3969.soundManager.playIllegal();
                }
            } else {
                this.aSPanel_Sub21_3970.method2579(this.aClass60_3969.textManager.method2039("Lobby_Coins_CoinGamesDisabledInfo"));
            }
        }

    }

    private void method2489() {
        this.aColorCheckbox_Sub1_3973 = new ColorCheckbox_Sub1(this.aClass60_3969.textManager.method2039("Lobby_Coins_PlayWithCoinsCheckbox"), this.aClass60_3969.aClass61_1207.aBoolean1217);
        this.aColorCheckbox_Sub1_3973.setBounds(5, 5, 160, 22);
        this.aColorCheckbox_Sub1_3973.setBoxBackground(GameApplet.aColor4811);
        this.aColorCheckbox_Sub1_3973.setForeground(GameApplet.aColor4811);
        this.aColorCheckbox_Sub1_3973.addItemListener(this);
        this.add(this.aColorCheckbox_Sub1_3973);
    }

    private void method2490() {
        if (this.aGlossyButton_Sub1_3974 != null) {
            this.aGlossyButton_Sub1_3974.method2878();
            this.remove(this.aGlossyButton_Sub1_3974);
            this.aGlossyButton_Sub1_3974 = null;
        }

        if (this.aClass60_3969.aClass61_1207.aBoolean1217) {
            if (!this.aClass60_3969.gameApplet.method2309()) {
                this.aGlossyButton_Sub1_3974 = new GlossyButton_Sub1(this.aClass60_3969, this.aClass60_3969.textManager.method2039("Lobby_Coins_CreateAccountButton"), 10, 0, this.height - 5 - 25);
            } else if (this.aClass60_3969.gameApplet.method2312() < this.aSPanel__3971.method2509()) {
                this.aGlossyButton_Sub1_3974 = new GlossyButton_Sub1(this.aClass60_3969, this.aClass60_3969.textManager.method2039("Lobby_Coins_GetMoreCoinsButton"), 10, 1, this.height - 5 - 25);
            } else if (!this.aClass60_3969.gameApplet.method2313()) {
                this.aGlossyButton_Sub1_3974 = new GlossyButton_Sub1(this.aClass60_3969, this.aClass60_3969.textManager.method2039("Lobby_Coins_BuySomeCoinsButton"), 10, 1, this.height - 5 - 25);
            }

            if (this.aGlossyButton_Sub1_3974 != null) {
                this.add(this.aGlossyButton_Sub1_3974);
            }
        }

        this.repaint();
    }
}
