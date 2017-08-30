package com.playray.tools;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

public class QuickTimer implements Runnable {

    private int delay;
    private Vector listeners;
    private boolean stopped;
    private static final String aString2233 = "QuickTimer.start() called after QuickTimer.stopAll() was called";


    public QuickTimer(int delay) {
        this(delay, (QuickTimerListener) null, false);
    }

    public QuickTimer(int delay, QuickTimerListener listener) {
        this(delay, listener, true);
    }

    private QuickTimer(int delay, QuickTimerListener listener, boolean start) {
        this.delay = delay;
        this.listeners = new Vector();
        if (listener != null) {
            this.addListener(listener);
        }

        this.stopped = false;
        if (start) {
            this.start();
        }

    }

    public void run() {
        Tools.sleep((long) this.delay);
        if (!this.stopped) {
            Enumeration var1 = this.listeners.elements();

            while (var1.hasMoreElements()) {
                QuickTimerListener listener;
                try {
                    listener = (QuickTimerListener) ((QuickTimerListener) var1.nextElement());
                } catch (NoSuchElementException var4) {
                    return;
                }

                if (listener != null) {
                    listener.qtFinished();
                }
            }

        }
    }

    public void addListener(QuickTimerListener listener) {
        this.listeners.addElement(listener);
    }

    public void removeListener(QuickTimerListener listener) {
        this.listeners.removeElement(listener);
    }

    public void start() {
        if (this.stopped) {
            throw new IllegalStateException("QuickTimer.start() called after QuickTimer.stopAll() was called");
        } else {
            Thread var1 = new Thread(this);
            var1.setDaemon(true);
            var1.start();
        }
    }

    public void stopAll() {
        this.stopped = true;
    }

}
