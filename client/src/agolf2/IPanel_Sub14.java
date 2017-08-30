package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.ColorCheckbox;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;
import com.aapeli.colorgui.RoundButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

class IPanel_Sub14 extends IPanel implements ItemListener, ActionListener {

    private static final String[] aStringArray2989;
    private static final int[] anIntArray2990;
    private Class58_Sub1 aClass58_Sub1_2991;
    private LobbySingleContentPanel anLobbySingleContentPanel__2992;
    private IPanel_Sub18 anIPanel_Sub18_2993;
    private int anInt2994;
    private int anInt2995;
    private MultiColorList aMultiColorList2996;
    private ColorCheckbox aColorCheckbox2997;
    private RoundButton aRoundButton2998;
    private boolean aBoolean2999;
    private static final String[] aStringArray3000 = new String[7];


    protected IPanel_Sub14(Class58_Sub1 var1, LobbySingleContentPanel var2, IPanel_Sub18 var3, int var4, int var5) {
        this.aClass58_Sub1_2991 = var1;
        this.anLobbySingleContentPanel__2992 = var2;
        this.anIPanel_Sub18_2993 = var3;
        this.anInt2994 = var4;
        this.anInt2995 = var5;
        this.setSize(var4, var5);
        this.method597();
        this.aBoolean2999 = false;
    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        if (this.aBoolean2999) {
            var1.setColor(AApplet_Sub3.aColor3779);
            var1.setFont(AApplet_Sub3.fontDialog12);
            StringDraw.drawString(var1, this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_RegisteredOnly"), this.anInt2994 / 2 + 150 - 1, this.anInt2995 - 20 - 1, 1);
        }

    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aMultiColorList2996) {
            this.method599(false);
            MultiColorListItem var3 = this.aMultiColorList2996.getSelectedItem();
            if (var3 == null) {
                this.aClass58_Sub1_2991.aClass59_Sub1_3569.aString3582 = "";
            } else {
                Object[] var4 = (Object[]) ((Object[]) var3.getData());
                this.aClass58_Sub1_2991.aClass59_Sub1_3569.aString3582 = (String) ((String) var4[0]);
            }
        } else if (var2 == this.aColorCheckbox2997) {
            this.aClass58_Sub1_2991.aClass59_Sub1_3569.aBoolean3583 = this.aColorCheckbox2997.getState();
        }

    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.aRoundButton2998) {
            this.method600(this.aClass58_Sub1_2991.aClass59_Sub1_3569.aBoolean3583);
        }

    }

    protected void method594(String[] var1) {
        this.aMultiColorList2996.removeAllItems();

        for (int var2 = 2; var2 < var1.length; var2 += 2) {
            this.method598(var1[var2], var1[var2 + 1]);
        }

        if (this.aClass58_Sub1_2991.aClass59_Sub1_3569.aString3582.length() > 0) {
            this.method599(true);
        }

    }

    protected void method595() {
        MultiColorListItem[] var1 = this.aMultiColorList2996.getAllItems();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2].setOverrideColor((Color) null);
        }

        this.aMultiColorList2996.repaint();
        this.aRoundButton2998.setVisible(true);
        if (this.aClass58_Sub1_2991.aTournament3568 != null) {
            this.method600(true);
        }

    }

    protected void method596() {
        MultiColorListItem[] var1 = this.aMultiColorList2996.getAllItems();
        this.aMultiColorList2996.unselectAll();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            Object[] var3 = (Object[]) ((Object[]) var1[var2].getData());
            String var4 = (String) ((String) var3[0]);
            if (var4.equalsIgnoreCase(this.aClass58_Sub1_2991.aTournament3568.getSubGame())) {
                var1[var2].setSelected(true);
            }
        }

        if (!this.method599(false)) {
            this.method600(true);
        }

    }

    private void method597() {
        this.setLayout((LayoutManager) null);
        String[] var1 = new String[]{this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_ListName"), this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_ListDifficulty"), this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_ListTrackCount")};
        int[] var2 = new int[]{0, 0, 3};
        this.aMultiColorList2996 = new MultiColorList(var1, var2, 1, 300, this.anInt2995 - 45 - 25 - 10 - 45);
        this.aMultiColorList2996.setLocation(this.anInt2994 / 2 - 150, 45);
        this.aMultiColorList2996.setSelectable(1);
        this.aMultiColorList2996.addItemListener(this);
        this.add(this.aMultiColorList2996);
        this.aColorCheckbox2997 = new ColorCheckbox(this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_AllowSpectators"), this.aClass58_Sub1_2991.aClass59_Sub1_3569.aBoolean3583);
        int var3 = this.anInt2994 / 2 - 150;
        int var4 = this.anInt2995 - 45 - 20;
        this.aColorCheckbox2997.setBounds(var3, var4, 170, 18);
        this.aColorCheckbox2997.setForeground(AApplet_Sub3.aColor3779);
        this.aColorCheckbox2997.addItemListener(this);
        this.add(this.aColorCheckbox2997);
        this.aRoundButton2998 = new RoundButton(this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_StartButton"));
        this.aRoundButton2998.setBounds(this.anInt2994 / 2 + 150 - 120, this.anInt2995 - 45 - 25, 120, 25);
        this.aRoundButton2998.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton2998.addActionListener(this);
        this.aRoundButton2998.setVisible(false);
        this.add(this.aRoundButton2998);
    }

    private void method598(String var1, String var2) {
        StringTokenizer var3 = new StringTokenizer(var1, ";");
        String var4 = var3.nextToken();
        int var5 = Integer.parseInt(var3.nextToken());
        boolean var6 = var3.nextToken().equals("t");
        int var7 = Integer.parseInt(var3.nextToken());
        String[] var8 = new String[]{var4, this.aClass58_Sub1_2991.textManager.getGame("Lobby1_Championship_ListDifficulty" + aStringArray2989[var5]), "" + var7};
        Object[] var9 = new Object[]{var4, new Boolean(var6), new Class53(this.aClass58_Sub1_2991, var4, var2)};
        MultiColorListItem var10 = new MultiColorListItem(anIntArray2990[var5], var8, var9);
        if (!var6 && !this.anLobbySingleContentPanel__2992.method789()) {
            var10.setOverrideColor(7);
        }

        if (var4.equals(this.aClass58_Sub1_2991.aClass59_Sub1_3569.aString3582)) {
            var10.setSelected(true);
        }

        this.aMultiColorList2996.addItem(var10);
    }

    private boolean method599(boolean var1) {
        this.aBoolean2999 = false;
        MultiColorListItem var2 = this.aMultiColorList2996.getSelectedItem();
        if (var2 != null) {
            Object[] var3 = (Object[]) ((Object[]) var2.getData());
            this.anIPanel_Sub18_2993.method614((Class53) ((Class53) var3[2]));
        } else {
            this.anIPanel_Sub18_2993.method614((Class53) null);
        }

        MultiColorListItem var4 = this.method601();
        if (var4 == null) {
            this.aRoundButton2998.setVisible(false);
            if (var2 != null) {
                if (this.aClass58_Sub1_2991.anAApplet_Sub3_Sub1_3567.method60()) {
                    if (!var1) {
                        this.anLobbySingleContentPanel__2992.method788();
                        return true;
                    }
                } else {
                    this.aBoolean2999 = true;
                }
            }
        } else {
            this.aRoundButton2998.setVisible(true);
        }

        this.repaint();
        return false;
    }

    private void method600(boolean var1) {
        MultiColorListItem var2 = this.method601();
        if (var2 != null) {
            Object[] var3 = (Object[]) ((Object[]) var2.getData());
            this.anLobbySingleContentPanel__2992.method791("start\tc\t" + (String) ((String) var3[0]) + "\t" + (var1 ? "t" : "f"));
        }
    }

    private MultiColorListItem method601() {
        MultiColorListItem var1 = this.aMultiColorList2996.getSelectedItem();
        if (var1 == null) {
            return null;
        } else {
            Object[] var2 = (Object[]) ((Object[]) var1.getData());
            return !((Boolean) ((Boolean) var2[1])).booleanValue() && !this.anLobbySingleContentPanel__2992.method789() ? null : var1;
        }
    }

    static {
        aStringArray3000[0] = "start\tc\t";
        aStringArray3000[1] = "Lobby1_Championship_RegisteredOnly";
        aStringArray3000[2] = "Lobby1_Championship_ListDifficulty";
        aStringArray3000[3] = "Lobby1_Championship_AllowSpectators";
        aStringArray3000[4] = "Lobby1_Championship_StartButton";
        aStringArray3000[5] = "Lobby1_Championship_ListTrackCount";
        aStringArray3000[6] = "Lobby1_Championship_ListName";
        aStringArray2989 = new String[4];
        aStringArray2989[0] = "Undefined";
        aStringArray2989[1] = "Easy";
        aStringArray2989[2] = "Medium";
        aStringArray2989[3] = "Hard";
        anIntArray2990 = new int[]{0, 2, 4, 1};
    }
}
