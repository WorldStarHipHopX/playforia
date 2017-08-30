package agolf2;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame_Sub2 extends Frame implements WindowListener {

    private IPanel_Sub28 anIPanel_Sub28_184;
    private boolean aBoolean185;
    protected Panel panel;


    public Frame_Sub2(IPanel_Sub28 var1) {
        this.anIPanel_Sub28_184 = var1;
        this.aBoolean185 = true;
    }

    public void windowOpened(WindowEvent var1) {
    }

    public void windowClosed(WindowEvent var1) {
    }

    public void windowClosing(WindowEvent var1) {
        this.method237();
    }

    public void windowActivated(WindowEvent var1) {
    }

    public void windowDeactivated(WindowEvent var1) {
    }

    public void windowIconified(WindowEvent var1) {
    }

    public void windowDeiconified(WindowEvent var1) {
    }

    protected void method236(Applet applet) {
        if (this.isVisible()) {
            this.toFront();
        } else {
            this.setVisible(true);
            if (this.aBoolean185) {
                this.aBoolean185 = false;
                this.setBackground(AApplet_Sub3.aColor3778);
                Insets insets = this.getInsets();
                int width = insets.left + 280 + insets.right;
                int height = insets.top + 180 + insets.bottom;
                this.setResizable(false);
                this.setSize(width, height);
                Point location = applet.getLocationOnScreen();
                Dimension dimensions = applet.getSize();
                this.setLocation(location.x + dimensions.width / 2 - width / 2, location.y + dimensions.height / 2 - height / 2);
                this.setLayout((LayoutManager) null);
                this.panel.setLocation(insets.left, insets.top);
                this.add(this.panel);
                this.addWindowListener(this);
            }

            this.requestFocus();
        }
    }

    public void method237() {
        this.setVisible(false);
        this.anIPanel_Sub28_184.method687();
    }
}
