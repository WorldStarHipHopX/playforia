package apool;

import com.playray.client.SPanel;
import com.playray.client.StringDraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

class SPanel_Sub29 extends SPanel {

    private static final Font aFont4103;
    private Class60 aClass60_4104;
    private int anInt4105;
    private String[][] aStringArrayArray4106;
    private int[][] anIntArrayArray4107;
    private static final String[] aStringArray4108 = new String[3];


    protected SPanel_Sub29(Class60 var1, int var2, int var3) {
        this.aClass60_4104 = var1;
        this.anInt4105 = var2;
        this.setSize(var2, var3);
    }

    public void paintContent(Graphics2D var1) {
        if (this.aStringArrayArray4106 != null) {
            var1.drawImage(this.aClass60_4104.imageManager.method1983("game_bg-score"), 0, 0, this);
            var1.setFont(aFont4103);

            for (int var2 = 0; var2 < 4; ++var2) {
                int var3 = 3 + var2 * (this.anInt4105 / 4) + 10;
                int var4 = 3 + (var2 + 1) * (this.anInt4105 / 4) - 20;
                var1.setColor(Color.black);
                var1.drawString(this.aClass60_4104.textManager.method2039("GameTopList_Title" + var2), var3, 17);
                var1.setColor(Color.white);

                for (int var5 = 0; var5 < 5; ++var5) {
                    var1.drawString(this.aStringArrayArray4106[var2][var5], var3, 44 + var5 * 16);
                    StringDraw.drawString(var1, "" + this.anIntArrayArray4107[var2][var5], var4, 44 + var5 * 16, 1);
                }
            }

        }
    }

    protected void method2629(String[] var1) {
        this.aStringArrayArray4106 = new String[4][5];
        this.anIntArrayArray4107 = new int[4][5];

        for (int var2 = 0; var2 < 4; ++var2) {
            for (int var3 = 0; var3 < 5; ++var3) {
                this.aStringArrayArray4106[var2][var3] = var1[2 + var2 * 5 * 2 + var3 * 2];
                this.anIntArrayArray4107[var2][var3] = Integer.parseInt(var1[2 + var2 * 5 * 2 + var3 * 2 + 1]);
            }
        }

        this.repaint();
    }

    static {
        aStringArray4108[0] = "game_bg-score";
        aStringArray4108[1] = "GameTopList_Title";
        aStringArray4108[2] = "Dialog";
        aFont4103 = new Font("Dialog", 1, 11);
    }
}
