package com.playray.colorgui;

import com.playray.client.SPanel;

public class Progress extends SPanel {

    private double aDouble4506;


    public Progress() {
        this(0.0D);
    }

    public Progress(double var1) {
        this.setProgress(var1);
    }

    public void setProgress(double var1) {
        if (var1 < 1.0E-4D) {
            var1 = 0.0D;
        } else if (var1 > 0.9999D) {
            var1 = 1.0D;
        }

        this.aDouble4506 = var1;
        this.repaint();
    }

    public double getProgress() {
        return this.aDouble4506;
    }

    public int getProgressPercent() {
        int var1 = (int) (this.aDouble4506 * 100.0D + 0.5D);
        if (var1 == 0 && this.aDouble4506 > 0.0D) {
            var1 = 1;
        } else if (var1 == 100 && this.aDouble4506 < 1.0D) {
            var1 = 99;
        }

        return var1;
    }

    public boolean isCompleted() {
        return this.getProgressPercent() == 100;
    }
}
