package com.aapeli.tools;

import java.awt.Component;

public class DelayRepaint implements QuickTimerListener {

    private Component component;


    public DelayRepaint(Component cmp) {
        this(cmp, 500);
    }

    public DelayRepaint(Component cmp, int delay) {
        this.component = cmp;
        new QuickTimer(delay, this);
    }

    public void qtFinished() {
        this.component.repaint();
    }
}
