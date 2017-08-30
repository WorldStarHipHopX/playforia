package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameRatePanel extends IPanel implements ActionListener {

    private Class58_Sub1 aClass58_Sub1_3125;
    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_3126;
    private int width;
    private int height;
    private String aString3129;
    private String aString3130;
    private Image anImage3131;
    private int anInt3132;
    private int anInt3133;
    private SynchronizedInteger aSynchronizedInteger_3134;
    private SynchronizedInteger aSynchronizedInteger_3135;
    private boolean aBoolean3136;
    private int anInt3137;
    private Image[] imageThumbs;
    private boolean aBoolean3139;
    private IPanel_Sub35 panelThumbUp;
    private IPanel_Sub35 panelThumbDown;
    private ColorButton aColorButton3142;
    private Image anImage3143;
    private Graphics aGraphics3144;
    private static final String[] aStringArray3145 = new String[6];


    protected GameRatePanel(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, int width, int height) {
        this.aClass58_Sub1_3125 = var1;
        this.anIPanel_Sub28_Sub1_3126 = var2;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.imageThumbs = var1.imageManager.separateImages("game_thumbs", 2);
        this.create();
        this.aBoolean3139 = false;
        this.aString3130 = null;
        this.anImage3131 = null;
    }

    public void update(Graphics var1) {
        if (this.anImage3143 == null || this.aGraphics3144 == null) {
            if (this.anImage3143 == null) {
                this.anImage3143 = this.aClass58_Sub1_3125.anAApplet_Sub3_Sub1_3567.createImage(this.width, this.height);
            }

            this.aGraphics3144 = this.anImage3143.getGraphics();
        }

        boolean var2 = this.aString3130 != null && this.anImage3131 != null;
        if (var2) {
            this.drawBackground(this.aGraphics3144);
        } else {
            this.aGraphics3144.drawImage(this.aClass58_Sub1_3125.imageManager.getImage("background_prevtrack"), 0, 0, this);
        }

        if (var2) {
            this.aGraphics3144.setFont(AApplet_Sub3.fontDialog12);
            this.aGraphics3144.setColor(AApplet_Sub3.aColor3779);
            StringDraw.drawString(this.aGraphics3144, this.aClass58_Sub1_3125.textManager.getGame("Game_PrevTrackInfo_TrackWas", this.aString3130), this.width / 2, 20, 0);
            if (this.aBoolean3139) {
                StringDraw.drawString(this.aGraphics3144, this.aClass58_Sub1_3125.textManager.getGame("Game_PrevTrackInfo_RateTrack"), 5 + this.anInt3132 + 5 + (this.width - 5 - 5 - this.anInt3132 - 5) / 2, 50, 0);
            } else {
                StringDraw.drawString(this.aGraphics3144, this.aClass58_Sub1_3125.textManager.getGame("Game_PrevTrackInfo_Rating"), 5 + this.anInt3132 + 5 + (this.width - 5 - 5 - this.anInt3132 - 5) / 2, 50, 0);
                this.aGraphics3144.setFont(AApplet_Sub3.fontDialog24);
                double var3 = 1.0D * (double) (this.aSynchronizedInteger_3134.method1174() - this.aSynchronizedInteger_3135.method1174()) / (double) (this.aSynchronizedInteger_3134.method1174() + this.aSynchronizedInteger_3135.method1174());
                StringDraw.drawString(this.aGraphics3144, this.aClass58_Sub1_3125.textManager.getNumber(var3, 1), 5 + this.anInt3132 + 5 + (this.width - 5 - 5 - this.anInt3132 - 5) / 2, 80, 0);
            }

            this.aGraphics3144.drawImage(this.anImage3131, 5, 28, this);
        }

        var1.drawImage(this.anImage3143, 0, 0, this);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aColorButton3142 && this.aClass58_Sub1_3125.anAApplet_Sub3_Sub1_3567.method69()) {
            double var3 = 1.0D * (double) (this.aSynchronizedInteger_3134.method1174() - this.aSynchronizedInteger_3135.method1174()) / (double) (this.aSynchronizedInteger_3134.method1174() + this.aSynchronizedInteger_3135.method1174());
            TrackAdminFrame var5 = new TrackAdminFrame(this.aClass58_Sub1_3125, this.anIPanel_Sub28_Sub1_3126, this.aString3130, this.aString3129, this.anImage3131, var3, this.aBoolean3136, this.anInt3137);
            var5.create(this.aClass58_Sub1_3125.anAApplet_Sub3_Sub1_3567);
            this.aColorButton3142.setVisible(false);
        } else {
            byte var6 = 0;
            if (var2 == this.panelThumbUp) {
                var6 = 1;
            } else if (var2 == this.panelThumbDown) {
                var6 = -1;
            }

            if (var6 != 0) {
                this.anIPanel_Sub28_Sub1_3126.method695("rate\t" + this.aString3129 + "\t" + this.aString3130 + "\t" + var6);
                this.panelThumbUp.setVisible(false);
                this.panelThumbDown.setVisible(false);
                this.aBoolean3139 = false;
                if (var6 == 1) {
                    this.aSynchronizedInteger_3134.method1172();
                } else {
                    this.aSynchronizedInteger_3135.method1172();
                }

                this.repaint();
            }

        }
    }

    protected void method751(String var1, String var2, Image var3, int var4, int var5, boolean var6, boolean var7, int var8) {
        this.aString3129 = var1;
        this.aString3130 = var2;
        this.aSynchronizedInteger_3134 = new SynchronizedInteger(var4);
        this.aSynchronizedInteger_3135 = new SynchronizedInteger(var5);
        this.aBoolean3136 = var7;
        this.anInt3137 = var8;
        this.anInt3133 = this.height - 5 - 28;
        this.anInt3132 = this.anInt3133 * 780 / 420;
        this.anImage3131 = var3.getScaledInstance(this.anInt3132, this.anInt3133, 16);
        this.aBoolean3139 = var6;
        this.repaint();
        this.panelThumbUp.setVisible(this.aBoolean3139);
        this.panelThumbDown.setVisible(this.aBoolean3139);
        if (this.aClass58_Sub1_3125.anAApplet_Sub3_Sub1_3567.method69()) {
            this.aColorButton3142.setVisible(true);
        }

    }

    protected void method752() {
        this.aString3129 = this.aString3130 = null;
        this.anImage3131 = null;
        this.panelThumbUp.setVisible(false);
        this.panelThumbDown.setVisible(false);
        this.aBoolean3139 = false;
        this.aColorButton3142.setVisible(false);
        this.repaint();
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.panelThumbUp = new IPanel_Sub35(this.imageThumbs[0]);
        this.panelThumbUp.setLocation(this.width - 20 - 31 - 5 - 31, this.height - 10 - 31);
        this.panelThumbUp.method763(this);
        this.panelThumbUp.setVisible(false);
        this.add(this.panelThumbUp);
        this.panelThumbDown = new IPanel_Sub35(this.imageThumbs[1]);
        this.panelThumbDown.setLocation(this.width - 20 - 31, this.height - 10 - 31);
        this.panelThumbDown.method763(this);
        this.panelThumbDown.setVisible(false);
        this.add(this.panelThumbDown);
        this.aColorButton3142 = new ColorButton("A");
        this.aColorButton3142.setBounds(0, 0, 10, 10);
        this.aColorButton3142.setBackground(AApplet_Sub3.aColor3783);
        this.aColorButton3142.addActionListener(this);
        this.aColorButton3142.setVisible(false);
        this.add(this.aColorButton3142);
    }

    static {
        aStringArray3145[0] = "Game_PrevTrackInfo_RateTrack";
        aStringArray3145[1] = "Game_PrevTrackInfo_TrackWas";
        aStringArray3145[2] = "Game_PrevTrackInfo_Rating";
        aStringArray3145[3] = "background_prevtrack";
        aStringArray3145[4] = "rate\t";
        aStringArray3145[5] = "game_thumbs";
    }
}
