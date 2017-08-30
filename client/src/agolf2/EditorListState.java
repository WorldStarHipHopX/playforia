package agolf2;

import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;

import java.util.StringTokenizer;

class EditorListState {

    private static final String[] aStringArray1073 = new String[4];
    private String aString1074;
    private int anInt1075;
    private int anInt1076;
    private int anInt1077;


    protected EditorListState(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ";");
        this.aString1074 = var2.nextToken();
        this.anInt1075 = Integer.parseInt(var2.nextToken());
        this.anInt1076 = Integer.parseInt(var2.nextToken());
        this.anInt1077 = Integer.parseInt(var2.nextToken());
    }

    protected String method1288() {
        return this.aString1074;
    }

    protected void method1289(Class58_Sub1 var1, MultiColorList var2) {
        double var3 = 0.0D;
        int var5 = this.anInt1076 + this.anInt1077;
        if (var5 > 0) {
            var3 = 1.0D * (double) (this.anInt1076 - this.anInt1077) / (double) var5;
        }

        String[] var6 = new String[]{this.aString1074, var1.textManager.getGame("Editor_PopupLoad_ListState" + aStringArray1073[this.anInt1075]), var1.textManager.getNumber(var3, 2), var1.textManager.getNumber((long) var5)};
        MultiColorListItem var7 = new MultiColorListItem(AApplet_Sub3_Sub1.anIntArray4752[this.anInt1075], var6, (Object) null);
        var2.addItem(var7);
    }

    protected void method1290(ColorList var1) {
        if (this.anInt1075 == 0) {
            ColorListItem var2 = new ColorListItem(this.aString1074);
            var1.addItem(var2);
        }

    }

    static {
        aStringArray1073[0] = "Private";
        aStringArray1073[1] = "Public";
        aStringArray1073[2] = "Official";
        aStringArray1073[3] = "Free";
    }
}
