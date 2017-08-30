package agolf2;

import com.aapeli.client.IPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class IPanel_Sub11 extends IPanel implements MouseListener, ActionListener {

    private Class58_Sub1 aClass58_Sub1_2981;
    private Interface1 anInterface1_2982;
    private Block aBlock_2983;
    private Block aBlock_2984;
    private boolean aBoolean2985;
    private IPanel_Sub35 anIPanel_Sub35_2986;
    public static boolean aBoolean2987;


    protected IPanel_Sub11(Class58_Sub1 var1, Interface1 var2) {
        this.aClass58_Sub1_2981 = var1;
        this.anInterface1_2982 = var2;
        this.setSize(74, 68);
        this.create();
        this.aBoolean2985 = false;
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        this.update(g);
    }

    public void update(Graphics g) {
        this.drawBackground(g);
        g.drawImage(this.aBlock_2983.method1207(), 1, 1, 30, 30, this);
        g.drawImage(this.aBlock_2984.method1207(), 43, 1, 30, 30, this);
        g.setColor(Color.RED);
        g.drawRect(this.aBoolean2985 ? 42 : 0, 0, 31, 31);
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mousePressed(MouseEvent evt) {
        if (evt.getY() <= 32) {
            int var2 = evt.getX();
            if (var2 < 32) {
                this.aBoolean2985 = false;
                this.anInterface1_2982.method1(this.aBlock_2983);
            } else if (var2 >= 43) {
                this.aBoolean2985 = true;
                this.anInterface1_2982.method1(this.aBlock_2984);
            }

            this.repaint();
        }
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void actionPerformed(ActionEvent evt) {
        Block var2 = this.aBlock_2983;
        this.aBlock_2983 = this.aBlock_2984;
        this.aBlock_2984 = var2;
        this.aBoolean2985 = !this.aBoolean2985;
        this.repaint();
    }

    protected void method576(Block var1) {
        this.aBlock_2983 = var1;
        this.aBoolean2985 = false;
        this.repaint();
    }

    protected void method577(Block var1) {
        this.aBlock_2984 = var1;
        this.aBoolean2985 = true;
        this.repaint();
    }

    protected void method578(Block var1) {
        if (!this.aBoolean2985) {
            this.aBlock_2983 = var1;
        } else {
            this.aBlock_2984 = var1;
        }

        this.repaint();
    }

    public Block method579(boolean var1) {
        return var1 ? this.aBlock_2984 : this.aBlock_2983;
    }

    protected boolean method580() {
        return this.aBoolean2985;
    }

    protected void method581(boolean var1) {
        this.aBoolean2985 = var1;
        this.repaint();
    }

    private void create() {
        this.setLayout((LayoutManager) null);
        this.anIPanel_Sub35_2986 = new IPanel_Sub35(this.aClass58_Sub1_2981.imageManager.getImage("editor_swap"));
        Dimension var1 = this.anIPanel_Sub35_2986.getSize();
        this.anIPanel_Sub35_2986.setLocation(37 - var1.width / 2, 68 - var1.height);
        this.anIPanel_Sub35_2986.method763(this);
        this.add(this.anIPanel_Sub35_2986);
    }

}
