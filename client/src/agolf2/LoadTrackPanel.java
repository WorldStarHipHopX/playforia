package agolf2;

import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;
import com.aapeli.colorgui.RoundButton;

import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class LoadTrackPanel extends IPanel_Sub27 implements ItemListener {

    private MultiColorList aMultiColorList4705;
    private RoundButton aRoundButton4706;
    private static final String[] aStringArray4707 = new String[7];


    protected LoadTrackPanel(Class58_Sub1 var1, EditorPopupFrame var2) {
        super(var1, var2, 400, 250);
        this.method675();
    }

    protected void method669(Graphics var1) {
        String var2 = null;
        if (this.anInt3097 > 0) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_Error", this.anInt3097);
        } else if (this.aBoolean3096) {
            var2 = this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_Wait");
        }

        if (var2 != null) {
            var1.setColor(AApplet_Sub3.aColor3779);
            StringDraw.drawStringWithMaxWidth(var1, var2, 10, 20, -1, 380);
        }

    }

    protected void method670(Object var1) {
        if (var1 == this.aRoundButton4706) {
            MultiColorListItem var2 = this.aMultiColorList4705.getSelectedItem();
            this.method676(var2);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        if (var1.getSource() == this.aMultiColorList4705 && var1.getID() == 2) {
            MultiColorListItem var2 = (MultiColorListItem) ((MultiColorListItem) var1.getItem());
            this.method676(var2);
        }

    }

    private void method675() {
        String[] var1 = new String[]{this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_ListName"), this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_ListState"), this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_ListRating"), this.aClass58_Sub1_3090.textManager.getGame("Editor_PopupLoad_ListVotes")};
        int[] var2 = new int[]{0, 0, 5, 5};
        this.aMultiColorList4705 = new MultiColorList(var1, var2, 0, 380, 200);
        this.aMultiColorList4705.setDecimalSeparator(this.aClass58_Sub1_3090.textManager.getDecimalSeparator());
        this.aMultiColorList4705.setLocation(10, 10);
        this.aMultiColorList4705.addItemListener(this);
        this.add(this.aMultiColorList4705);
        Class42 var3 = this.aJFrame__3091.anIPanel_Sub7_2254.method547();
        var3.method1295(this.aMultiColorList4705);
        this.aMultiColorList4705.setSelectable(1);
        this.aRoundButton4706 = this.method671("PopupLoad_Load", 290, 215, 100, 25, AApplet_Sub3.colourButtonGreen);
    }

    private void method676(MultiColorListItem var1) {
        if (var1 != null) {
            this.method672();
            this.aJFrame__3091.anIPanel_Sub7_2254.method543(var1.getString(0));
        }
    }

    static {
        aStringArray4707[0] = "Editor_PopupLoad_Wait";
        aStringArray4707[1] = "Editor_PopupLoad_Error";
        aStringArray4707[2] = "PopupLoad_Load";
        aStringArray4707[3] = "Editor_PopupLoad_ListState";
        aStringArray4707[4] = "Editor_PopupLoad_ListVotes";
        aStringArray4707[5] = "Editor_PopupLoad_ListRating";
        aStringArray4707[6] = "Editor_PopupLoad_ListName";
    }
}
