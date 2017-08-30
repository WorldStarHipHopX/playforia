package agolf2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

class EditorPopupFrame extends JFrame implements WindowListener {

    private int anInt2253;
    protected IPanel_Sub7 anIPanel_Sub7_2254;
    private IPanel_Sub27 activePanel;
    private static final String[] aStringArray2256 = new String[4];


    protected EditorPopupFrame(Class58_Sub1 var1, IPanel_Sub7 var2, int var3) {
        this(var1, var2, var3, 0);
    }

    protected EditorPopupFrame(Class58_Sub1 var1, IPanel_Sub7 var2, int var3, int var4) {
        this.anIPanel_Sub7_2254 = var2;
        this.anInt2253 = var3;
        Container container = this.getContentPane();
        container.setLayout((LayoutManager) null);
        if (var3 == 0) {
            this.setTitle(var1.textManager.getGame("Editor_PopupSave_Title"));
            this.activePanel = new SaveTrackPanel(var1, this);
        } else if (var3 == 1) {
            this.setTitle(var1.textManager.getGame("Editor_PopupPublish_Title"));
            this.activePanel = new PublishTrackPanel(var1, this, var4);
        } else if (var3 == 2) {
            this.setTitle(var1.textManager.getGame("Editor_PopupLoad_Title"));
            this.activePanel = new LoadTrackPanel(var1, this);
        } else if (var3 == 3) {
            this.setTitle(var1.textManager.getGame("Editor_PopupDelete_Title"));
            this.activePanel = new DeleteTrackPanel(var1, this);
        }

        this.activePanel.setLocation(0, 0);
        container.add(this.activePanel);
        Dimension var6 = this.activePanel.getSize();
        container.setSize(var6);
        Point var7 = var1.anAApplet_Sub3_Sub1_3567.getLocationOnScreen();
        Dimension var8 = var1.anAApplet_Sub3_Sub1_3567.getSize();
        this.setLocation(var7.x + var8.width / 2 - var6.width / 2, var7.y + var8.height / 2 - var6.height / 2);
        this.setResizable(false);
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setForeground(AApplet_Sub3.aColor3779);
        this.addWindowListener(this);
        this.setDefaultCloseOperation(0);
        this.setVisible(true);
        Insets var9 = this.getInsets();
        this.setSize(var9.left + var6.width + var9.right, var9.top + var6.height + var9.bottom);
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.anIPanel_Sub7_2254.method548();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected int method2339() {
        return this.anInt2253;
    }

    protected void method2340(int var1) {
        this.activePanel.method673(var1);
    }

    static {
        aStringArray2256[0] = "Editor_PopupLoad_Title";
        aStringArray2256[1] = "Editor_PopupPublish_Title";
        aStringArray2256[2] = "Editor_PopupSave_Title";
        aStringArray2256[3] = "Editor_PopupDelete_Title";
    }
}
