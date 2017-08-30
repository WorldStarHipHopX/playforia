package apool;

import com.playray.client.SPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GameSpinBallPanel extends SPanel implements MouseListener {

    private static final Color aColor4095 = new Color(192, 192, 192);
    private static final Color aColor4096 = new Color(192, 0, 0);
    private Class60 aClass60_4097;
    private SPanel_Sub20 aSPanel_Sub20_4098;
    private int anInt4099;
    private int anInt4100;
    private boolean aBoolean4101;


    protected GameSpinBallPanel(Class60 var1, SPanel_Sub20 var2) {
        this.aClass60_4097 = var1;
        this.aSPanel_Sub20_4098 = var2;
        this.setSize(125, 100);
        this.method2627(false);
        this.setCursor(new Cursor(1));
        this.addMouseListener(this);
    }

    public void paintContent(Graphics2D var1) {
        var1.drawImage(this.aClass60_4097.imageManager.method1983("game_spinball"), 0, 0, this);
        var1.setFont(GameApplet.aFont4816);
        var1.setColor(GameApplet.aColor4808);
        var1.drawString(this.aClass60_4097.textManager.method2039("GameSpinBall_Title"), 5, 15);
        var1.setColor(aColor4095);
        var1.drawLine(43, 55, 81, 55);
        var1.drawLine(62, 36, 62, 74);
        var1.setColor(aColor4096);
        var1.drawLine(62 + this.anInt4099 - 3, 55 + this.anInt4100, 62 + this.anInt4099 + 3, 55 + this.anInt4100);
        var1.drawLine(62 + this.anInt4099, 55 + this.anInt4100 - 3, 62 + this.anInt4099, 55 + this.anInt4100 + 3);
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        if (this.aBoolean4101) {
            int var2 = var1.getX() - 62;
            int var3 = var1.getY() - 55;
            if (Math.sqrt((double) (var2 * var2 + var3 * var3)) <= 37.0D) {
                if (var2 >= -2 && var2 <= 2) {
                    var2 = 0;
                }

                if (var3 >= -2 && var3 <= 2) {
                    var3 = 0;
                }

                this.anInt4099 = var2;
                this.anInt4100 = var3;
                if (!this.aSPanel_Sub20_4098.method2543(2.0D * (double) this.anInt4099 / 79.0D, 2.0D * (double) this.anInt4100 / 79.0D)) {
                    this.anInt4099 = this.anInt4100 = 0;
                }

                this.repaint();
            }
        }
    }

    public void mouseReleased(MouseEvent var1) {
    }

    public void mouseClicked(MouseEvent var1) {
    }

    protected void method2627(boolean var1) {
        this.method2628(var1);
        this.anInt4099 = this.anInt4100 = 0;
        this.repaint();
    }

    protected void method2628(boolean var1) {
        this.aBoolean4101 = var1;
    }
}
