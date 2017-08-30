package agolf2;

import com.aapeli.client.IPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Enumeration;
import java.util.Vector;

public class IPanel_Sub35 extends IPanel implements MouseMotionListener, MouseListener {

    private Image anImage3182;
    private Image anImage3183;
    private int anInt3184;
    private int anInt3185;
    private Vector aVector3186;
    private boolean aBoolean3187;
    private boolean aBoolean3188;


    public IPanel_Sub35(Image var1) {
        this.anImage3182 = var1;
        this.anInt3184 = var1.getWidth(this);
        this.anInt3185 = var1.getHeight(this);
        this.setSize(this.anInt3184, this.anInt3185);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.aVector3186 = new Vector();
        this.aBoolean3187 = false;
    }

    public IPanel_Sub35(Image var1, Image var2) {
        this(var1);
        this.anImage3183 = var2;
        this.aBoolean3188 = false;
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        Image var2 = this.anImage3182;
        if ((this.aBoolean3187 || this.aBoolean3188) && this.anImage3183 != null) {
            var2 = this.anImage3183;
        }

        var1.drawImage(var2, 0, 0, this);
    }

    public void mouseEntered(MouseEvent var1) {
    }

    public void mouseExited(MouseEvent var1) {
    }

    public void mousePressed(MouseEvent var1) {
        this.aBoolean3187 = true;
        this.repaint();
    }

    public void mouseReleased(MouseEvent var1) {
        boolean var2 = this.aBoolean3187;
        this.aBoolean3187 = false;
        if (this.anImage3183 != null) {
            this.aBoolean3188 = true;
        }

        this.repaint();
        if (var2) {
            this.method766();
        }

    }

    public void mouseClicked(MouseEvent var1) {
    }

    public void mouseMoved(MouseEvent var1) {
    }

    public void mouseDragged(MouseEvent var1) {
    }

    public void method763(ActionListener var1) {
        Vector var2 = this.aVector3186;
        synchronized (this.aVector3186) {
            this.aVector3186.addElement(var1);
        }
    }

    public void method764(boolean var1) {
        this.aBoolean3188 = var1;
        this.repaint();
    }

    public boolean method765() {
        return this.aBoolean3188;
    }

    private void method766() {
        Vector var1 = this.aVector3186;
        synchronized (this.aVector3186) {
            if (!this.aVector3186.isEmpty()) {
                ActionEvent var2 = new ActionEvent(this, 1001, (String) null);
                Enumeration var3 = this.aVector3186.elements();

                while (var3.hasMoreElements()) {
                    ((ActionListener) var3.nextElement()).actionPerformed(var2);
                }

            }
        }
    }
}
