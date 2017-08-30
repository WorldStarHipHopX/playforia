package agolf2;

import com.aapeli.client.FilterTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.RoundButton;
import com.aapeli.credit.Product;

import java.awt.Graphics;

class PublishTrackPanel extends IPanel_Sub27 {

    private Product aProduct4708;
    private int anInt4709;
    private FilterTextField aFilterTextField4710;
    private ColorCheckbox aColorCheckbox4711;
    private RoundButton aRoundButton4712;
    private static final String[] aStringArray4713 = new String[14];


    protected PublishTrackPanel(Class58_Sub1 var1, EditorPopupFrame var2, int var3) {
        super(var1, var2, 300, 350);
        this.anInt4709 = var3;
        this.aProduct4708 = var1.aProductHandler1192.getProduct("trackpublish");
        this.method677();
    }

    protected void method669(Graphics var1) {
        String var2;
        if (this.anInt4709 == 1) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_NoBoughtCredits");
        } else if (this.anInt4709 == 2) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_TrackNotTested");
        } else if (this.anInt3097 == 1) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_InvalidName");
        } else if (this.anInt3097 == 2) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_CantOverwritePublic");
        } else if (this.anInt3097 == 3) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_TooManyTracks");
        } else if (this.anInt3097 == 4) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_NoCredits");
        } else if (this.anInt3097 == 5) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_Error");
        } else if (this.anInt3097 == 0) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_Published");
        } else if (this.aBoolean3096) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_Wait");
        } else {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_Info", this.aProduct4708.getProductPrice(), this.aClass58_Sub1_3090.anAApplet_Sub3_Sub1_3567.method62());
            var2 = var2 + " " + this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_InfoAdd");
        }

        var1.setColor(AApplet_Sub3.aColor3779);
        StringDraw.drawStringWithMaxWidth(var1, var2, 10, 20, -1, 280);
    }

    protected void method670(Object var1) {
        if (var1 == this.aRoundButton4712) {
            this.method672();
            this.aJFrame__3091.anIPanel_Sub7_2254.method541(this.aFilterTextField4710.getInputText(), this.aColorCheckbox4711.getState());
        }

    }

    protected void method673(int var1) {
        if (var1 == 0 || var1 == 4 || var1 == 5) {
            this.aClass58_Sub1_3090.anAApplet_Sub3_Sub1_3567.callJavaScriptJsonBuyStarted(this.aProduct4708);
            this.aClass58_Sub1_3090.anAApplet_Sub3_Sub1_3567.callJavaScriptJsonBuyFinished(this.aProduct4708, var1 == 0 ? 1 : (var1 == 4 ? 0 : -1));
        }

        super.method673(var1);
    }

    private void method677() {
        if (this.anInt4709 <= 0) {
            this.aFilterTextField4710 = new FilterTextField(this.aClass58_Sub1_3090.textManager, this.aJFrame__3091.anIPanel_Sub7_2254.aString2320, 20);
            this.aFilterTextField4710.noClearOnFirstFocus();
            this.aFilterTextField4710.setBounds(10, 220, 280, 25);
            this.add(this.aFilterTextField4710);
            this.aColorCheckbox4711 = new ColorCheckbox(this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupPublish_SinglePlayerOnly"), false);
            this.aColorCheckbox4711.setBounds(10, 250, 280, 20);
            this.aColorCheckbox4711.setBackground(AApplet_Sub3.aColor3778);
            this.aColorCheckbox4711.setForeground(AApplet_Sub3.aColor3779);
            this.add(this.aColorCheckbox4711);
            this.aRoundButton4712 = this.method671("PopupPublish_Publish", 190, 315, 100, 25, AApplet_Sub3.aColor3784);
        }
    }

    static {
        aStringArray4713[0] = "trackpublish";
        aStringArray4713[1] = "Editor_PopupPublish_SinglePlayerOnly";
        aStringArray4713[2] = "PopupPublish_Publish";
        aStringArray4713[3] = "Editor_PopupPublish_InfoAdd";
        aStringArray4713[4] = "Editor_PopupPublish_Wait";
        aStringArray4713[5] = "Editor_PopupPublish_CantOverwritePublic";
        aStringArray4713[6] = "Editor_PopupPublish_Info";
        aStringArray4713[7] = "Editor_PopupPublish_Published";
        aStringArray4713[8] = "Editor_PopupPublish_InvalidName";
        aStringArray4713[9] = "Editor_PopupPublish_NoCredits";
        aStringArray4713[10] = "Editor_PopupPublish_TrackNotTested";
        aStringArray4713[11] = "Editor_PopupPublish_Error";
        aStringArray4713[12] = "Editor_PopupPublish_NoBoughtCredits";
        aStringArray4713[13] = "Editor_PopupPublish_TooManyTracks";
    }
}
