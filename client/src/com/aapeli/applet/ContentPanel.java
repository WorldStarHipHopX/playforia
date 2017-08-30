package com.aapeli.applet;

import com.aapeli.applet.AApplet;
import com.aapeli.client.IPanel;

import java.awt.LayoutManager;

class ContentPanel extends IPanel {

    protected ContentPanel(AApplet var1) {
        this.setBackground(var1.getBackground());
        this.setForeground(var1.getForeground());
        this.setLayout((LayoutManager) null);
    }

    protected void dispose() {
        this.setVisible(false);
        this.removeAll();
    }

    protected void makeVisible() {
        if (this.getComponentCount() > 0) {
            this.setVisible(true);
        }

    }
}
