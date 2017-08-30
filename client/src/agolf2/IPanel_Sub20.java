package agolf2;

import com.aapeli.client.IPanel;
import com.aapeli.client.InputTextField;
import com.aapeli.client.StringDraw;
import com.aapeli.colorgui.Choicer;
import com.aapeli.colorgui.ColorList;
import com.aapeli.colorgui.ColorListItem;
import com.aapeli.colorgui.ColorSpinner;
import com.aapeli.colorgui.MultiColorList;
import com.aapeli.colorgui.MultiColorListItem;
import com.aapeli.colorgui.RoundButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.StringTokenizer;

class IPanel_Sub20 extends IPanel implements ItemListener, ActionListener {

    private static final String[] aStringArray3023 = new String[10];
    private static final String[] aStringArray3024 = new String[10];
    private static final int[] anIntArray3025;
    private static final int anInt3026;
    private static int anInt3027;
    private static String aString3028;
    private Class58_Sub1 aClass58_Sub1_3029;
    private LobbySingleContentPanel anLobbySingleContentPanel__3030;
    private IPanel_Sub22 anIPanel_Sub22_3031;
    private Choicer aChoicer3032;
    private InputTextField anInputTextField3033;
    private RoundButton aRoundButton3034;
    private MultiColorList aMultiColorList3035;
    private RoundButton aRoundButton3036;
    private RoundButton aRoundButton3037;
    private ColorList aColorList3038;
    private RoundButton aRoundButton3039;
    private RoundButton aRoundButton3040;
    private boolean aBoolean3041;


    protected IPanel_Sub20(Class58_Sub1 var1, LobbySingleContentPanel var2, IPanel_Sub22 var3) {
        this.aClass58_Sub1_3029 = var1;
        this.anLobbySingleContentPanel__3030 = var2;
        this.anIPanel_Sub22_3031 = var3;
        this.setSize(700, 500);
        this.setBackground(AApplet_Sub3.aColor3778);
        this.setBackground(var1.imageManager.getImage("background"));
        this.aBoolean3041 = false;
        this.method620();
        if (anInt3027 >= 0 && aString3028 != null) {
            this.aChoicer3032.setSelectedIndex(anInt3027);
            this.method623(anInt3027, aString3028);
        }

    }

    public void update(Graphics var1) {
        this.drawBackground(var1);
        var1.setColor(AApplet_Sub3.aColor3779);
        var1.setFont(AApplet_Sub3.fontDialog12);
        Point var2;
        if (!this.aBoolean3041) {
            var2 = this.aChoicer3032.getLocation();
            Point var3 = this.anInputTextField3033.getLocation();
            Dimension var4 = this.aChoicer3032.getSize();
            var1.drawString(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ChoiceTitle"), var2.x, var2.y - 7);
            StringDraw.drawString(var1, this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ChoiceOrSearch"), (var2.x + var4.width + var3.x) / 2, var2.y + var4.height - 5, 0);
        }

        var2 = this.aMultiColorList3035.getLocation();
        var1.drawString(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsTitle"), var2.x, var2.y - 7);
        var2 = this.aColorList3038.getLocation();
        var1.drawString(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_SelectedTitle"), var2.x, var2.y - 7);
    }

    public void itemStateChanged(ItemEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aChoicer3032 && !this.aBoolean3041) {
            int var6 = this.aChoicer3032.getSelectedIndex();
            if (var6 > 0) {
                this.method624();
                String var4 = this.aClass58_Sub1_3029.aClass56_3570.method1426(var6);
                if (var4 == null) {
                    this.anLobbySingleContentPanel__3030.method791("trackreq\t" + var6);
                } else {
                    this.method622(var6, var4);
                }
            }
        } else if (var1.getID() == 2) {
            if (var2 == this.aMultiColorList3035 && !this.aBoolean3041) {
                if (this.aColorList3038.getItemCount() >= 20) {
                    return;
                }

                MultiColorListItem var5 = (MultiColorListItem) ((MultiColorListItem) var1.getItem());
                this.aColorList3038.removeAllSelections();
                this.method628(var5);
                this.aMultiColorList3035.repaint();
            } else if (var2 == this.aColorList3038) {
                ColorListItem var3 = (ColorListItem) ((ColorListItem) var1.getItem());
                this.aColorList3038.removeItem(var3);
            }
        }

    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.aRoundButton3036) {
            this.method627(true);
        } else if (var2 == this.aRoundButton3037) {
            ColorListItem[] var3 = this.aColorList3038.getSelectedItems();
            if (var3 == null) {
                return;
            }

            for (int var4 = 0; var4 < var3.length; ++var4) {
                this.aColorList3038.removeItem(var3[var4]);
            }
        } else if ((var2 == this.anInputTextField3033 || var2 == this.aRoundButton3034) && !this.aBoolean3041) {
            String var5 = this.anInputTextField3033.getInputText(false);
            if (var5.length() < 3) {
                return;
            }

            var5 = var5.toLowerCase();
            this.anInputTextField3033.clear();
            if (var5.equals("\\\\\\")) {
                this.aClass58_Sub1_3029.aClass56_3570.method1428();
                return;
            }

            this.method624();
            this.aChoicer3032.setSelectedIndex(0);
            String var6 = this.aClass58_Sub1_3029.aClass56_3570.method1427(var5);
            if (var6 == null) {
                this.anLobbySingleContentPanel__3030.method791("trackreq\t0\t" + var5);
            } else {
                this.method622(0, var6);
            }
        } else if (var2 == this.aRoundButton3039) {
            this.aColorList3038.removeAllItems();
        } else if (var2 == this.aRoundButton3040) {
            this.method626();
        }

    }

    protected void method619(String[] var1) {
        int var2 = Integer.parseInt(var1[2]);
        String var3;
        if (var2 == 0) {
            var3 = var1.length > 4 ? var1[4] : "";
            this.aClass58_Sub1_3029.aClass56_3570.method1425(var1[3], var3);
        } else {
            var3 = var1.length > 3 ? var1[3] : "";
            this.aClass58_Sub1_3029.aClass56_3570.method1424(var2, var3);
        }

        this.method622(var2, var3);
    }

    private void method620() {
        this.setLayout((LayoutManager) null);
        byte var1 = 50;
        byte var2 = 20;
        byte var3 = 30;
        byte var4 = 25;
        byte var5 = 23;
        byte var6 = 25;
        byte var7 = 45;
        byte var8 = 15;
        int var9 = 500 - var1 - var2 - var7 - var8 - var6 - var5;
        short var10 = 400;
        byte var11 = 10;
        byte var12 = 22;
        int var13 = 700 - var3 - var4 - var11 * 2 - var12 - var10;
        this.aChoicer3032 = new Choicer();

        for (int var14 = 0; var14 < anInt3026; ++var14) {
            this.aChoicer3032.addItem(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_Choice" + (aStringArray3023[var14] != null ? aStringArray3023[var14] : "")));
        }

        ColorSpinner var17 = this.aChoicer3032.getColorSpinner();
        if (var17 != null) {
            var17.setItemEventProcessDelay(1000);
        }

        this.aChoicer3032.setBounds(var3, var1, 160, var5);
        this.aChoicer3032.addItemListener(this);
        this.add(this.aChoicer3032);
        this.anInputTextField3033 = new InputTextField(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_SearchField", 3), 15);
        this.anInputTextField3033.setBounds(var3 + 210, var1, 160, var5);
        this.anInputTextField3033.addActionListener(this);
        this.add(this.anInputTextField3033);
        this.aRoundButton3034 = new RoundButton(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_SearchButton"));
        this.aRoundButton3034.setBounds(var3 + 210 + 160 + 5, var1, 60, var5);
        this.aRoundButton3034.setBackground(AApplet_Sub3.aColor3784);
        this.aRoundButton3034.addActionListener(this);
        this.add(this.aRoundButton3034);
        String[] var15 = new String[]{this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsTrack"), this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsAuthor"), ""};
        int[] var16 = new int[]{0, 0, 0};
        this.aMultiColorList3035 = new MultiColorList(var15, var16, -1, var10, var9);
        this.aMultiColorList3035.setDecimalSeparator(this.aClass58_Sub1_3029.textManager.getDecimalSeparator());
        this.aMultiColorList3035.setLocation(var3, var1 + var5 + var7);
        this.aMultiColorList3035.setSelectable(2);
        this.aMultiColorList3035.setEmptyListText(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsEmptyInit"));
        this.aMultiColorList3035.addItemListener(this);
        this.add(this.aMultiColorList3035);
        this.aRoundButton3036 = new RoundButton("->");
        this.aRoundButton3036.setBounds(var3 + var10 + var11, 230, var12, var12);
        this.aRoundButton3036.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton3036.addActionListener(this);
        this.add(this.aRoundButton3036);
        this.aRoundButton3037 = new RoundButton("<-");
        this.aRoundButton3037.setBounds(var3 + var10 + var11, 230 + var12 + var11, var12, var12);
        this.aRoundButton3037.setBackground(AApplet_Sub3.aColor3783);
        this.aRoundButton3037.addActionListener(this);
        this.add(this.aRoundButton3037);
        this.aColorList3038 = new ColorList(var13, var9);
        this.aColorList3038.setLocation(700 - var4 - var13, var1 + var5 + var7);
        this.aColorList3038.setSelectable(2);
        this.method621();
        this.aColorList3038.addItemListener(this);
        this.add(this.aColorList3038);
        this.aRoundButton3040 = new RoundButton(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_OkButton"));
        this.aRoundButton3040.setBounds(700 - var4 - 70, 500 - var2 - var6, 70, var6);
        this.aRoundButton3040.setBackground(AApplet_Sub3.colourButtonGreen);
        this.aRoundButton3040.addActionListener(this);
        this.add(this.aRoundButton3040);
        this.aRoundButton3039 = new RoundButton(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ClearButton"));
        this.aRoundButton3039.setBounds(700 - var4 - var13, 500 - var2 - var6, 70, var6);
        this.aRoundButton3039.setBackground(AApplet_Sub3.aColor3782);
        this.aRoundButton3039.addActionListener(this);
        this.add(this.aRoundButton3039);
    }

    private void method621() {
        String var1 = this.aClass58_Sub1_3029.aClass59_Sub1_3569.aString3581;
        if (var1.length() > 1) {
            StringTokenizer var2 = new StringTokenizer(var1, ";");
            int var3 = var2.countTokens();
            if (var3 != 0) {
                for (int var4 = 0; var4 < var3; ++var4) {
                    String var5 = var2.nextToken();
                    int var6 = var5.indexOf(58);
                    String var7 = var5.substring(0, var6);
                    String var8 = var5.substring(var6 + 1);
                    ColorListItem var9 = new ColorListItem(0, false, var8 + " (" + var7 + ")", new String[]{var7, var8}, false);
                    this.aColorList3038.addItem(var9);
                }

            }
        }
    }

    private void method622(int var1, String var2) {
        anInt3027 = var1;
        aString3028 = var2;
        this.method623(var1, var2);
    }

    private void method623(int var1, String var2) {
        if (var2.length() == 0) {
            this.aMultiColorList3035.setEmptyListText(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsEmptyNone"));
            this.method625();
        } else {
            this.aMultiColorList3035.setTitle(var1 > 0 ? this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_Results" + aStringArray3024[var1]) : "", 2);
            this.aMultiColorList3035.setSortOrder(anIntArray3025[var1], 2);
            this.aMultiColorList3035.setSortColumnIndex(var1 == 0 ? 0 : -1);
            String var3 = null;
            StringTokenizer var4 = new StringTokenizer(var2, ";");
            if (var1 == 0) {
                var3 = "";
            }

            while (var4.hasMoreTokens()) {
                String var5 = var4.nextToken();
                String var6 = var4.nextToken();
                if (var1 > 0) {
                    var3 = var4.nextToken();
                    if (var1 == 1) {
                        long var7 = Long.parseLong(var3);
                        var3 = this.aClass58_Sub1_3029.textManager.getDateWithTodayYesterday(var7) + ", " + this.aClass58_Sub1_3029.textManager.getClock(var7, true);
                    } else if (var1 != 2 && var1 != 3) {
                        if (var1 != 4 && var1 != 5) {
                            if (var1 == 6) {
                                var3 = this.aClass58_Sub1_3029.textManager.getNumber(Double.parseDouble(var3) * 100.0D, false, 0) + " %";
                            } else if (var1 == 7) {
                                var3 = this.aClass58_Sub1_3029.textManager.getNumber(Double.parseDouble(var3) * 100.0D, false, 1) + " %";
                            } else if (var1 == 8) {
                                var3 = this.aClass58_Sub1_3029.textManager.getNumber(Double.parseDouble(var3), false, 2);
                            } else if (var1 == 9) {
                                var3 = this.aClass58_Sub1_3029.textManager.getNumber(Double.parseDouble(var3), false, 1);
                            }
                        } else {
                            var3 = this.aClass58_Sub1_3029.textManager.getNumber((long) Integer.parseInt(var3));
                        }
                    } else {
                        var3 = this.aClass58_Sub1_3029.textManager.getNumber(Double.parseDouble(var3), false, 2);
                    }
                }

                MultiColorListItem var9 = new MultiColorListItem(0, false, new String[]{var5, var6, var3}, new String[]{var6, var5});
                this.aMultiColorList3035.addItem(var9);
            }

            this.method625();
        }
    }

    private void method624() {
        this.aChoicer3032.setVisible(false);
        this.anInputTextField3033.setVisible(false);
        this.aRoundButton3034.setVisible(false);
        this.aMultiColorList3035.setEmptyListText(this.aClass58_Sub1_3029.textManager.getGame("Lobby_TrackSelect_ResultsEmptyWait"));
        this.aMultiColorList3035.removeAllItems();
        this.aBoolean3041 = true;
        this.repaint();
    }

    private void method625() {
        this.aChoicer3032.setVisible(true);
        this.anInputTextField3033.setVisible(true);
        this.aRoundButton3034.setVisible(true);
        this.aBoolean3041 = false;
        this.repaint();
    }

    private void method626() {
        if (this.aColorList3038.getItemCount() == 0) {
            this.method627(false);
        }

        ColorListItem[] var1 = this.aColorList3038.getAllItems();
        StringBuffer var2 = new StringBuffer(100);
        if (var1 != null) {
            for (int var3 = 0; var3 < var1.length; ++var3) {
                String[] var4 = (String[]) ((String[]) var1[var3].getData());
                if (var3 > 0) {
                    var2.append(';');
                }

                var2.append(var4[0]).append(':').append(var4[1]);
            }
        }

        this.aClass58_Sub1_3029.aClass59_Sub1_3569.aString3581 = var2.toString();
        this.anIPanel_Sub22_3031.method634();
    }

    private void method627(boolean var1) {
        if (!this.aBoolean3041) {
            if (this.aColorList3038.getItemCount() < 20) {
                if (var1 && this.aMultiColorList3035.getSelectedItemCount() == 0) {
                    this.aMultiColorList3035.selectAll();
                }

                MultiColorListItem[] var2 = this.aMultiColorList3035.getSelectedItems();
                if (var2 != null) {
                    this.aColorList3038.removeAllSelections();

                    for (int var3 = 0; var3 < var2.length && this.aColorList3038.getItemCount() < 20; ++var3) {
                        this.method628(var2[var3]);
                    }

                    this.aMultiColorList3035.repaint();
                }
            }
        }
    }

    private void method628(MultiColorListItem var1) {
        String[] var2 = (String[]) ((String[]) var1.getData());
        ColorListItem var3 = new ColorListItem(0, false, var2[1] + " (" + var2[0] + ")", var2, true);
        this.aColorList3038.addItem(var3);
        var1.setSelected(false);
    }

    static {
        aStringArray3023[0] = null;
        aStringArray3023[1] = "Newest";
        aStringArray3023[2] = "BestRating";
        aStringArray3023[3] = "WorstRating";
        aStringArray3023[4] = "MostPlayed";
        aStringArray3023[5] = "LeastPlayed";
        aStringArray3023[6] = "Easiest";
        aStringArray3023[7] = "Hardest";
        aStringArray3023[8] = "Shortest";
        aStringArray3023[9] = "Longest";

        aStringArray3024[0] = null;
        aStringArray3024[1] = "Date";
        aStringArray3024[2] = "Rating";
        aStringArray3024[3] = "Rating";
        aStringArray3024[4] = "Played";
        aStringArray3024[5] = "Played";
        aStringArray3024[6] = "Finished";
        aStringArray3024[7] = "Finished";
        aStringArray3024[8] = "Average";
        aStringArray3024[9] = "Average";

        anIntArray3025 = new int[]{-1, 5, 5, 4, 5, 4, 5, 4, 4, 5};
        anInt3026 = aStringArray3023.length;
        anInt3027 = -1;
        aString3028 = null;
    }
}
