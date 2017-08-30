package com.playray.multiuser;

import com.playray.colorgui.ColorCheckbox;

import java.awt.event.MouseEvent;

public class NoChallCheckbox extends ColorCheckbox {

    private long[] aLongArray4944;


    public NoChallCheckbox(String var1) {
        this(var1, false);
    }

    public NoChallCheckbox(String var1, boolean var2) {
        super(var1, var2);
        this.aLongArray4944 = new long[]{0L, 0L, 0L, 0L};
    }

    public void mouseReleased(MouseEvent var1) {
        long var2 = System.currentTimeMillis();
        if (var2 >= this.aLongArray4944[1] + 2000L) {
            if (var2 >= this.aLongArray4944[2] + 5000L) {
                if (var2 >= this.aLongArray4944[3] + 10000L) {
                    this.aLongArray4944[3] = this.aLongArray4944[2];
                    this.aLongArray4944[2] = this.aLongArray4944[1];
                    this.aLongArray4944[1] = this.aLongArray4944[0];
                    this.aLongArray4944[0] = var2;
                    super.mouseReleased(var1);
                }
            }
        }
    }
}
