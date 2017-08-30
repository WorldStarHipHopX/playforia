package agolf2;

import com.aapeli.client.InputTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.RoundButton;

import java.awt.Graphics;

class SaveTrackPanel extends IPanel_Sub27 {

    private InputTextField anInputTextField4714;
    private RoundButton aRoundButton4715;
    private static final String[] aStringArray4716 = new String[8];


    protected SaveTrackPanel(Class58_Sub1 var1, EditorPopupFrame var2) {
        super(var1, var2, 300, 200);
        this.method678();
    }

    protected void method669(Graphics var1) {
        String var2;
        if (this.anInt3097 == 1) {
            var2 = "InvalidName";
        } else if (this.anInt3097 == 2) {
            var2 = "CantOverwritePublic";
        } else if (this.anInt3097 == 3) {
            var2 = "TooManyTracks";
        } else if (this.anInt3097 == 0) {
            var2 = "Saved";
        } else if (this.aBoolean3096) {
            var2 = "Wait";
        } else {
            var2 = "Info";
        }

        var1.setColor(AApplet_Sub3.aColor3779);
        StringDraw.drawStringWithMaxWidth(var1, this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupSave_" + var2), 10, 20, -1, 280);
    }

    protected void method670(Object var1) {
        if (var1 == this.aRoundButton4715 || var1 == this.anInputTextField4714) {
            this.method672();
            this.aJFrame__3091.anIPanel_Sub7_2254.method539(this.anInputTextField4714.getInputText());
        }

    }

    private void method678() {
        this.anInputTextField4714 = new InputTextField(this.aJFrame__3091.anIPanel_Sub7_2254.aString2320, 20);
        this.anInputTextField4714.noClearOnFirstFocus();
        this.anInputTextField4714.setBounds(10, 100, 280, 25);
        this.anInputTextField4714.addActionListener(this);
        this.add(this.anInputTextField4714);
        this.aRoundButton4715 = this.method671("PopupSave_Save", 190, 165, 100, 25, AApplet_Sub3.aColor3784);
    }

    static {
        aStringArray4716[0] = "PopupSave_Save";
        aStringArray4716[1] = "TooManyTracks";
        aStringArray4716[2] = "Saved";
        aStringArray4716[3] = "Wait";
        aStringArray4716[4] = "CantOverwritePublic";
        aStringArray4716[5] = "Info";
        aStringArray4716[6] = "Editor_PopupSave_";
        aStringArray4716[7] = "InvalidName";
    }
}
