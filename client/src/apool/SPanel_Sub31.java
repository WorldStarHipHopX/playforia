package apool;

import com.playray.client.SPanel;

import java.awt.Graphics2D;

class SPanel_Sub31 extends SPanel {

    private Class60 aClass60_4116;
    private static final String aString4117 = "game_snooker-values";


    protected SPanel_Sub31(Class60 var1) {
        this.aClass60_4116 = var1;
        this.setSize(125, 20);
    }

    public void paintContent(Graphics2D var1) {
        var1.drawImage(this.aClass60_4116.imageManager.method1983("game_snooker-values"), 0, 0, this);
    }

}
