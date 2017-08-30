package com.aapeli.colorgui;

import com.aapeli.client.IPanel;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.Vector;

public class Choicer extends IPanel implements ComponentListener, ItemListener, ItemSelectable {

    private Choice aChoice3248 = new Choice();
    private ColorSpinner colorSpinner;
    private boolean choiceMode = true;
    private Vector aVector3251;
    private Object anObject3252 = new Object();


    public Choicer() {
        this.aChoice3248.setBackground(Color.white);
        this.aChoice3248.setForeground(Color.black);
        this.aChoice3248.addItemListener(this);
        this.aVector3251 = new Vector();
        this.setLayout((LayoutManager) null);
        this.aChoice3248.setLocation(0, 0);
        this.add(this.aChoice3248);
        this.addComponentListener(this);
    }

    public void componentHidden(ComponentEvent var1) {
    }

    public void componentShown(ComponentEvent var1) {
    }

    public void componentMoved(ComponentEvent var1) {
    }

    public void componentResized(ComponentEvent var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            Dimension var3 = this.getSize();
            if (this.choiceMode) {
                this.aChoice3248.setSize(var3);
            } else {
                this.colorSpinner.setSize(var3);
            }

        }
    }

    public void itemStateChanged(ItemEvent var1) {
        Vector var2 = this.aVector3251;
        synchronized (this.aVector3251) {
            if (!this.aVector3251.isEmpty()) {
                var1 = new ItemEvent(this, var1.getID(), var1.getItem(), var1.getStateChange());
                Enumeration var3 = this.aVector3251.elements();

                while (var3.hasMoreElements()) {
                    ((ItemListener) ((ItemListener) var3.nextElement())).itemStateChanged(var1);
                }

            }
        }
    }

    public Object[] getSelectedObjects() {
        Object var1 = this.anObject3252;
        synchronized (this.anObject3252) {
            return this.choiceMode ? this.aChoice3248.getSelectedObjects() : this.colorSpinner.getSelectedObjects();
        }
    }

    public void setBackground(Color var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            super.setBackground(var1);
            if (this.choiceMode) {
                this.aChoice3248.setBackground(var1);
            } else {
                this.colorSpinner.setBackground(var1);
            }

        }
    }

    public void setForeground(Color var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            super.setForeground(var1);
            if (this.choiceMode) {
                this.aChoice3248.setForeground(var1);
            } else {
                this.colorSpinner.setForeground(var1);
            }

        }
    }

    public void addItem(String var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            if (this.choiceMode) {
                this.method825(var1);
            }

            if (this.choiceMode) {
                this.aChoice3248.addItem(var1);
            } else {
                this.colorSpinner.addItem(var1);
            }

        }
    }

    public void removeItem(int var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            if (this.choiceMode) {
                this.aChoice3248.remove(var1);
            } else {
                this.colorSpinner.removeItem(var1);
            }

        }
    }

    public int getItemCount() {
        Object var1 = this.anObject3252;
        synchronized (this.anObject3252) {
            return this.choiceMode ? this.aChoice3248.getItemCount() : this.colorSpinner.getItemCount();
        }
    }

    public int getSelectedIndex() {
        Object var1 = this.anObject3252;
        synchronized (this.anObject3252) {
            return this.choiceMode ? this.aChoice3248.getSelectedIndex() : this.colorSpinner.getSelectedIndex();
        }
    }

    public void select(int var1) {
        this.setSelectedIndex(var1);
    }

    public void setSelectedIndex(int var1) {
        Object var2 = this.anObject3252;
        synchronized (this.anObject3252) {
            if (this.choiceMode) {
                this.aChoice3248.select(var1);
            } else {
                this.colorSpinner.setSelectedIndex(var1);
            }

        }
    }

    public void addItemListener(ItemListener var1) {
        Vector var2 = this.aVector3251;
        synchronized (this.aVector3251) {
            this.aVector3251.addElement(var1);
        }
    }

    public void removeItemListener(ItemListener var1) {
        Vector var2 = this.aVector3251;
        synchronized (this.aVector3251) {
            this.aVector3251.removeElement(var1);
        }
    }

    public void moveToSpinner() {
        Object var1 = this.anObject3252;
        synchronized (this.anObject3252) {
            if (this.choiceMode) {
                this.colorSpinner = new ColorSpinner();
                this.colorSpinner.setLocation(0, 0);
                this.colorSpinner.setSize(this.getSize());
                this.colorSpinner.setBackground(this.aChoice3248.getBackground());
                this.colorSpinner.setForeground(this.aChoice3248.getForeground());
                int var2 = this.aChoice3248.getItemCount();

                int var3;
                for (var3 = 0; var3 < var2; ++var3) {
                    this.colorSpinner.addItem(this.aChoice3248.getItem(var3));
                }

                var3 = this.aChoice3248.getSelectedIndex();
                if (var3 >= 0) {
                    this.colorSpinner.setSelectedIndex(var3);
                }

                this.aChoice3248.removeItemListener(this);
                this.remove(this.aChoice3248);
                this.add(this.colorSpinner);
                this.colorSpinner.addItemListener(this);
                this.choiceMode = false;
                this.aChoice3248 = null;
            }
        }
    }

    public ColorSpinner getColorSpinner() {
        return this.colorSpinner;
    }

    public boolean isChoiceMode() {
        return this.choiceMode;
    }

    private void method825(String var1) {
        char[] var2 = var1.toCharArray();

        for (int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] > 255) {
                this.moveToSpinner();
                return;
            }
        }

    }
}
