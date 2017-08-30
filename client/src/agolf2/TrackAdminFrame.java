package agolf2;

import com.aapeli.tools.QuickTimer;
import com.aapeli.tools.QuickTimerListener;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class TrackAdminFrame extends Frame implements WindowListener, QuickTimerListener {

    private IPanel_Sub28_Sub1 anIPanel_Sub28_Sub1_2532;
    private Panel aPanel2533;
    private boolean aBoolean2534;


    public TrackAdminFrame(Class58_Sub1 var1, IPanel_Sub28_Sub1 var2, String var3, String var4, Image var5, double var6, boolean var8, int var9) {
        this.anIPanel_Sub28_Sub1_2532 = var2;
        this.setTitle("Track Admin - Super Minigolf");
        this.aPanel2533 = new Panel_Sub20(var1, var2, this, var3, var4, var5, var6, var8, var9);
        this.aBoolean2534 = true;
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.destroy();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    public void qtFinished() {
        this.requestFocus();
    }

    protected void create(Applet var1) {
        if (this.isVisible()) {
            this.toFront();
        } else {
            this.setVisible(true);
            if (this.aBoolean2534) {
                this.aBoolean2534 = true;
                this.setBackground(AApplet_Sub3.aColor3778);
                Insets var2 = this.getInsets();
                int var3 = var2.left + 200 + var2.right;
                int var4 = var2.top + 280 + var2.bottom;
                this.setResizable(false);
                this.setSize(var3, var4);
                Point var5 = var1.getLocationOnScreen();
                Dimension var6 = var1.getSize();
                this.setLocation(var5.x + var6.width / 2 - var3 / 2, var5.y + var6.height / 2 - var4 / 2);
                this.setLayout((LayoutManager) null);
                this.aPanel2533.setLocation(var2.left, var2.top);
                this.add(this.aPanel2533);
                this.addWindowListener(this);
            }

            this.requestFocus();
            new QuickTimer(125, this);
        }
    }

    protected void destroy() {
        this.setVisible(false);
        this.anIPanel_Sub28_Sub1_2532.method687();
    }

}
