package agolf2;

import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.RoundButton;

import java.awt.Graphics;

class DeleteTrackPanel extends IPanel_Sub27 {

    private ColorList aColorList4702;
    private RoundButton aRoundButton4703;
    private static final String[] aStringArray4704 = new String[4];


    protected DeleteTrackPanel(Class58_Sub1 var1, EditorPopupFrame var2) {
        super(var1, var2, 300, 200);
        this.method674();
    }

    protected void method669(Graphics var1) {
        String var2 = null;
        if (this.anInt3097 > 0) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupDelete_Error", this.anInt3097);
        } else if (this.anInt3097 == 0) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupDelete_Deleted");
        } else if (this.aBoolean3096) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupDelete_Wait");
        }

        if (var2 != null) {
            var1.setColor(AApplet_Sub3.aColor3779);
            StringDraw.drawStringWithMaxWidth(var1, var2, 10, 20, -1, 280);
        }

    }

    protected void method670(Object var1) {
        if (var1 == this.aRoundButton4703) {
            ColorListItem var2 = this.aColorList4702.getSelectedItem();
            if (var2 != null) {
                this.method672();
                this.aJFrame__3091.anIPanel_Sub7_2254.method545(var2.getString());
            }
        }

    }

    private void method674() {
        this.aColorList4702 = new ColorList(280, 150);
        this.aColorList4702.setSorting(1);
        this.aColorList4702.setLocation(10, 10);
        this.add(this.aColorList4702);
        Class42 var1 = this.aJFrame__3091.anIPanel_Sub7_2254.method547();
        var1.method1296(this.aColorList4702);
        this.aColorList4702.setSelectable(1);
        this.aRoundButton4703 = this.method671("PopupDelete_Delete", 190, 165, 100, 25, AApplet_Sub3.aColor3783);
    }

    static {
        aStringArray4704[0] = "PopupDelete_Delete";
        aStringArray4704[1] = "Editor_PopupDelete_Deleted";
        aStringArray4704[2] = "Editor_PopupDelete_Error";
        aStringArray4704[3] = "Editor_PopupDelete_Wait";
    }
}
