package apool;

import com.playray.colorgui.GlossyButton;
import com.playray.tools.Tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GlossyButton_Sub1 extends GlossyButton implements Runnable, ActionListener {

    private Class60 aClass60_4949;
    private String aString4950;
    private int anInt4951;
    private int anInt4952;
    private boolean aBoolean4953;
    private static final String aString4954 = " (";


    protected GlossyButton_Sub1(Class60 var1, String var2, int var3, int var4, int var5) {
        this.aClass60_4949 = var1;
        this.aString4950 = var2;
        this.anInt4951 = var3;
        this.anInt4952 = var4;
        this.method2879();
        this.setBounds(10, var5, 150, 25);
        this.setColor(1);
        this.addActionListener(this);
        this.aBoolean4953 = true;
        Thread var6 = new Thread(this);
        var6.setDaemon(true);
        var6.start();
    }

    public void run() {
        do {
            Tools.sleep(1000L);
            if (this.aBoolean4953) {
                --this.anInt4951;
                if (this.anInt4951 >= 0) {
                    this.method2879();
                } else {
                    this.actionPerformed((ActionEvent) null);
                }
            }
        } while (this.aBoolean4953);

    }

    public void actionPerformed(ActionEvent var1) {
        this.aBoolean4953 = false;
        if (this.anInt4952 == 0) {
            this.aClass60_4949.gameApplet.method2326();
        } else if (this.anInt4952 == 1) {
            this.aClass60_4949.gameApplet.method2327();
        }

    }

    protected void method2878() {
        this.aBoolean4953 = false;
    }

    private void method2879() {
        this.setLabel(this.aString4950 + " (" + this.anInt4951 + ")");
    }

}
