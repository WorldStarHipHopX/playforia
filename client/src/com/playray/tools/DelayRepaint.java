package com.playray.tools;

import java.awt.Component;

public class DelayRepaint implements QuickTimerListener {

    private Component target;


    public DelayRepaint(Component target) {
        this(target, 500);
    }

    public DelayRepaint(Component target, int delay) {
        this.target = target;
        new QuickTimer(delay, this);
    }

    public void qtFinished() {
        this.target.repaint();
    }
}
