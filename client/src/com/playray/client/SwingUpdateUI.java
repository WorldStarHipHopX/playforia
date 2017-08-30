package com.playray.client;

import com.playray.client.Class120;
import com.playray.client.Class121;
import com.playray.client.SwingUpdateTarget;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;

public class SwingUpdateUI {

    public static void callUpdateUI(SwingUpdateTarget var0, Object var1) {
        callUpdateUI(var0, var1, false);
    }

    public static void callUpdateUI(SwingUpdateTarget var0, Object var1, boolean var2) {
        if (EventQueue.isDispatchThread()) {
            var0.updateUI(var1);
        } else if (var2) {
            try {
                SwingUtilities.invokeLater(new Class120(var0, var1));
            } catch (Exception var5) {
                ;
            }
        } else {
            try {
                SwingUtilities.invokeAndWait(new Class121(var0, var1));
            } catch (Exception var4) {
                ;
            }
        }

    }
}
