package apool;

import com.playray.colorgui.ColorCheckbox;

import java.awt.event.MouseEvent;

public class ColorCheckbox_Sub1 extends ColorCheckbox {

    private long[] aLongArray4943 = new long[]{0L, 0L, 0L, 0L};


    public ColorCheckbox_Sub1(String var1, boolean var2) {
        super(var1, var2);
    }

    public void mouseReleased(MouseEvent var1) {
        long var2 = System.currentTimeMillis();
        if (var2 >= this.aLongArray4943[1] + 2000L) {
            if (var2 >= this.aLongArray4943[2] + 5000L) {
                if (var2 >= this.aLongArray4943[3] + 10000L) {
                    this.aLongArray4943[3] = this.aLongArray4943[2];
                    this.aLongArray4943[2] = this.aLongArray4943[1];
                    this.aLongArray4943[1] = this.aLongArray4943[0];
                    this.aLongArray4943[0] = var2;
                    super.mouseReleased(var1);
                }
            }
        }
    }
}
