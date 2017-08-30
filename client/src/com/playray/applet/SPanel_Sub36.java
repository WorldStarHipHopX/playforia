package com.playray.applet;

import com.playray.applet.AApplet;
import com.playray.client.SPanel;

final class SPanel_Sub36 extends SPanel {

    protected SPanel_Sub36() {
        super(false);
    }

    protected SPanel_Sub36(AApplet var1) {
        this.setBackground(var1.getBackground());
        this.setForeground(var1.getForeground());
    }

    protected void method2782() {
        this.setVisible(false);
        this.removeAll();
    }

    protected boolean method2783() {
        if (this.getComponentCount() > 0) {
            this.setVisible(true);
            return true;
        } else {
            return false;
        }
    }
}
