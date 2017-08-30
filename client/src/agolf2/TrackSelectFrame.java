package agolf2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class TrackSelectFrame extends JFrame implements WindowListener {

    private IPanel_Sub22 anIPanel_Sub22_2257;
    private IPanel_Sub20 anIPanel_Sub20_2258;
    private static final String aString2259 = "Lobby_TrackSelect_Title";


    protected TrackSelectFrame(Class58_Sub1 var1, LobbySingleContentPanel var2, IPanel_Sub22 var3) {
        this.anIPanel_Sub22_2257 = var3;
        Container var4 = this.getContentPane();
        var4.setLayout((LayoutManager) null);
        this.setTitle(var1.textManager.getGame("Lobby_TrackSelect_Title"));
        this.anIPanel_Sub20_2258 = new IPanel_Sub20(var1, var2, var3);
        this.anIPanel_Sub20_2258.setLocation(0, 0);
        var4.add(this.anIPanel_Sub20_2258);
        Dimension var5 = this.anIPanel_Sub20_2258.getSize();
        var4.setSize(var5);
        Point var6 = var1.anAApplet_Sub3_Sub1_3567.getLocationOnScreen();
        Dimension var7 = var1.anAApplet_Sub3_Sub1_3567.getSize();
        this.setLocation(var6.x + var7.width / 2 - var5.width / 2, var6.y + var7.height / 2 - var5.height / 2);
        this.setResizable(false);
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setForeground(AApplet_Sub3.aColor3779);
        this.addWindowListener(this);
        this.setDefaultCloseOperation(0);
        this.setVisible(true);
        Insets var8 = this.getInsets();
        this.setSize(var8.left + var5.width + var8.right, var8.top + var5.height + var8.bottom);
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.anIPanel_Sub22_2257.method634();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected void method2341(String[] var1) {
        this.anIPanel_Sub20_2258.method619(var1);
    }

}
