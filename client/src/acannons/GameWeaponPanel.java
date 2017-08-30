package acannons;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;
import com.playray.credit.Product;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class GameWeaponPanel extends SPanel implements MouseMotionListener, MouseListener, Runnable {

    private static final int[] anIntArray3837 = {10, 70, 130, 190, 260, 320, 380, 453, 515, 575, 10, 70, 130, 190, 260, 320, 453, 515};
    private static final int[] anIntArray3838 = {14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 93, 93, 93, 93, 93, 93, 93, 93};
    private ClientSettings aClientSettings_3839;
    private GamePanel aSPanel__3840;
    private GameAreaPanel aSPanel__3841;
    private int anInt3842;
    private Thread aThread3843;
    private int anInt3844;
    private String aString3845;
    private String aString3846;
    private Object anObject3847;


    protected GameWeaponPanel(ClientSettings var1, GamePanel var2, GameAreaPanel var3) {
        this.aClientSettings_3839 = var1;
        this.aSPanel__3840 = var2;
        this.aSPanel__3841 = var3;
        this.anObject3847 = new Object();
        this.setSize(630, 240);
        this.setBackground(var1.imageManager.method1983("bg-weaponmenu"));
        this.anInt3842 = -1;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void paintContent(Graphics2D var1) {
        String var2 = this.aThread3843 != null ? (this.aString3845 == null ? this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_InProgress") : this.aString3845) : null;
        int var3 = var2 == null ? this.anInt3842 : -1;
        var1.setFont(GameApplet.fontDialog11);

        int var5;
        for (int var4 = 0; var4 < 18; ++var4) {
            var1.setColor(var4 == var3 ? Color.white : Color.gray);
            var5 = this.aSPanel__3841.method2375(var4);
            String var6;
            if (var5 == 0) {
                if ((var4 == 16 || var4 == 17) && this.aClientSettings_3839.gameApplet.method2282()) {
                    var6 = this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buyable");
                } else {
                    var6 = this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_None");
                }
            } else if (var5 == -1) {
                var6 = this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Unlimited");
            } else if (var5 == -2) {
                var6 = this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_NoMoreDuringRound");
            } else {
                var6 = "" + var5;
            }

            StringDraw.drawString(var1, var6, anIntArray3837[var4] + 24, anIntArray3838[var4] + 48 + 12, 0);
        }

        int var7;
        if (var3 >= 0) {
            var1.setColor(Color.white);
            var1.setFont(GameApplet.fontDialog14);
            var1.drawString(this.aClientSettings_3839.textManager.method2039("GameReal_WeaponName_" + var3), 10, 185);
            String var9 = this.aClientSettings_3839.textManager.method2039("GameReal_WeaponDesc_" + var3);
            if (var3 == 16 || var3 == 17) {
                if (!this.aClientSettings_3839.gameApplet.method2282()) {
                    var9 = var9 + " " + this.aClientSettings_3839.textManager.method2039("GameReal_WeaponDesc_Worm");
                } else if (this.aClientSettings_3839.productHandler.getProduct("shield") == null) {
                    var9 = var9 + " " + this.aClientSettings_3839.textManager.method2039("GameReal_WeaponDesc_Error");
                } else {
                    var5 = this.aSPanel__3841.method2375(var3);
                    if (var5 == 0) {
                        Product var12 = this.method2405(var3);
                        if (var12 != null) {
                            var7 = var12.getProductPrice();
                            var9 = var9 + " " + this.aClientSettings_3839.textManager.getWithQuantity("GameReal_WeaponDesc_BuyableWithPrice", new String[]{"" + var7}, var7);
                        }
                    } else if (var5 == -2) {
                        var9 = var9 + " " + this.aClientSettings_3839.textManager.method2039("GameReal_WeaponDesc_NoMoreDuringRound");
                    }
                }
            }

            var1.setColor(Color.black);
            var1.setFont(GameApplet.fontDialog12);
            StringDraw.drawStringWithMaxWidth(var1, var9, 10, 210, -1, 600);
        }

        if (var2 != null) {
            short var11 = 200;
            byte var10 = 125;
            int var13 = 315 - var11 / 2;
            var7 = 120 - var10 / 2;
            var1.setColor(new Color(0, 0, 0, 32));

            for (int var8 = 1; var8 < 10; ++var8) {
                var1.fillRoundRect(var13 - var8 / 2, var7 - var8 / 2, var11 + var8 + var8 / 2, var10 + var8 + var8 / 2, 20, 20);
            }

            var1.setColor(GameApplet.aColor4781);
            var1.fillRoundRect(var13, var7, var11, var10, 20, 20);
            var1.setFont(GameApplet.fontDialog14);
            var1.setColor(GameApplet.aColor4782);
            var1.drawRoundRect(var13, var7, var11, var10, 20, 20);
            StringDraw.drawStringWithMaxWidth(var1, var2, 315, 100, 0, var11 - 10 - 10);
        }

    }

    public void mouseMoved(MouseEvent var1) {
        int var2 = this.anInt3842;
        this.anInt3842 = var1 != null ? this.method2404(var1.getX(), var1.getY()) : -1;
        if (this.anInt3842 != var2) {
            this.repaint();
        }

    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void mouseEntered(MouseEvent var1) {
        this.mouseMoved(var1);
    }

    public void mouseExited(MouseEvent var1) {
        this.mouseMoved((MouseEvent) null);
    }

    public void mousePressed(MouseEvent var1) {
        if (var1.isMetaDown()) {
            this.aSPanel__3841.method2361(-1);
        } else {
            int var2 = this.method2404(var1.getX(), var1.getY());
            if (var2 != -1) {
                int var3 = this.aSPanel__3841.method2375(var2);
                if (var3 == -2) {
                    if (this.aClientSettings_3839.aPlayerInfo_764.aBoolean780) {
                        this.aClientSettings_3839.soundManager.playIllegal();
                    }

                } else if (var3 != 0) {
                    this.aSPanel__3841.method2361(var2);
                } else {
                    if (var2 == 16 || var2 == 17) {
                        this.method2406(var2);
                    }

                }
            }
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void run() {
        Product var1 = this.method2405(this.anInt3844);
        if (this.aClientSettings_3839.gameApplet.method2294() < var1.getProductPrice()) {
            this.method2407(this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_NoCredits"), 2);
        } else {
            this.aString3846 = null;
            this.aSPanel__3840.method2424("buy\t" + var1.getProductName());
            int var2 = 0;

            do {
                Tools.sleep(100L);
                ++var2;
            } while (this.aString3846 == null && var2 < 500);

            String var3 = this.aString3846;
            if (var3 == null) {
                this.method2407(this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_Failed"), 3);
            } else if (var3.equals("nobalance")) {
                this.method2407(this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_NoCredits"), 2);
            } else if (!var3.equals("ok")) {
                this.method2407(this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_Failed"), 3);
            } else {
                var1.userBoughtProduct();
                this.method2407(this.aClientSettings_3839.textManager.method2039("GameRealWeaponMenu_Buy_Success"), 1);
                this.aSPanel__3841.method2361(this.anInt3844);
            }
        }
    }

    protected boolean method2403(String[] var1) {
        if (var1[1].equals("buy")) {
            if (var1[2].equals("ok")) {
                this.aClientSettings_3839.gameApplet.method2295(Integer.parseInt(var1[3]));
                int var2 = Integer.parseInt(var1[5]);
                if (var1[4].equals(Const.SHIELD)) {
                    this.aSPanel__3841.method2376(16, var2);
                } else {
                    this.aSPanel__3841.method2376(17, var2);
                }
            }

            this.aString3846 = var1[2];
            return true;
        } else {
            return false;
        }
    }

    private int method2404(int var1, int var2) {
        for (int var3 = 0; var3 < 18; ++var3) {
            if (var1 >= anIntArray3837[var3] && var1 < anIntArray3837[var3] + 48 && var2 >= anIntArray3838[var3] && var2 < anIntArray3838[var3] + 48 + 15) {
                return var3;
            }
        }

        return -1;
    }

    private Product method2405(int var1) {
        return this.aClientSettings_3839.productHandler.getProduct(var1 == 16 ? Const.SHIELD : Const.TELEPORT);
    }

    private void method2406(int var1) {
        Object var2 = this.anObject3847;
        synchronized (this.anObject3847) {
            if (this.aThread3843 == null) {
                this.anInt3844 = var1;
                this.aString3845 = null;
                this.aThread3843 = new Thread(this);
                this.aThread3843.setDaemon(true);
                this.aThread3843.start();
            }
        }
    }

    private void method2407(String var1, int var2) {
        this.aString3845 = var1;
        this.repaint();
        Tools.sleep((long) (var2 * 1000));
        this.aThread3843 = null;
        this.repaint();
    }
}
