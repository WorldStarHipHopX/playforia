package com.playray.applet;

import com.playray.applet.Class107;
import com.playray.applet.Class108;
import com.playray.applet.SPanel_Sub35;
import com.playray.applet.SPanel_Sub36;
import com.playray.applet.SPanel_Sub37;
import com.playray.applet.SPanel_Sub38;
import com.playray.applet.UIApplet;
import com.playray.client.ImageManager;
import com.playray.client.Parameters;
import com.playray.client.SoundManager;
import com.playray.client.TextManager;
import com.playray.connection.Connection;
import com.playray.credit.Product;
import com.playray.tools.Tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class AApplet extends UIApplet implements Runnable {

    public static final int TEXT_CENTER = 0;
    public static final int TEXT_LOWERLEFT = 1;
    public static final int TEXT_LOWERMIDDLE = 2;
    public static final int END_ERROR_MATCH = 1;
    public static final int END_ERROR_CONNECTION = 2;
    public static final int END_ERROR_VERSION = 3;
    public static final int END_ERROR_SERVERFULL = 4;
    public static final int END_QUIT = 5;
    public static final int END_MESSAGE = 6;
    public static final int END_QUIT_REGISTER = 7;
    public static final int END_QUIT_BUYCOINS = 8;
    public static final int END_ERROR_KICK_NOW = 9;
    public static final int END_ERROR_KICKBAN_NOW = 10;
    public static final int END_ERROR_BAN_INIT = 11;
    public static final int END_ERROR_REGLOGIN_FAILED = 12;
    public static final int END_ERROR_TOOMANYIP_INIT = 13;
    public static final int END_THROWABLE = 14;
    public Parameters param;
    public TextManager aTextManager3821;
    public ImageManager anImageManager3822;
    public SoundManager aSoundManager3823;
    private JPanel aJPanel3824;
    private SPanel_Sub37 aSPanel_Sub37_3825;
    private SPanel_Sub38 aSPanel_Sub38_3826;
    private SPanel_Sub36 aSPanel_Sub36_3827;
    private String aString3828;
    private int anInt3829;
    private int anInt3830;
    private int anInt3831;
    private boolean aBoolean3832;
    private boolean aBoolean3833;
    private Class108 aClass108_3834;
    private Connection aConnection3835;
    private static final String[] aStringArray3836 = new String[45];


    public void init() {
        System.out.println("\n" + this.getAppletInfo() + "\n");
        Dimension var1 = this.getSize();
        this.anInt2601 = var1.width;
        this.anInt2602 = var1.height;
        this.aString3828 = null;
        this.anInt3829 = this.anInt3830 = 0;
        this.anInt3831 = 0;
        this.method2273(0);
        this.aBoolean3832 = true;
        this.aBoolean3833 = false;
    }

    public void start() {
        if (this.aBoolean3832 && !this.aBoolean3833) {
            this.aBoolean3832 = false;
            Thread var1 = new Thread(this);
            var1.start();
        }

    }

    public void stop() {
    }

    public void destroy() {
        this.aBoolean3833 = true;
        this.method2274();
        this.setEndState(5);

        try {
            this.destroyApplet();
        } catch (Exception var2) {
            ;
        }

        if (this.aSPanel_Sub36_3827 != null) {
            this.aSPanel_Sub36_3827.method2782();
            this.aSPanel_Sub36_3827 = null;
        }

        if (this.aSoundManager3823 != null) {
            this.aSoundManager3823.destroy();
        }

        if (this.anImageManager3822 != null) {
            this.anImageManager3822.destroy();
        }

        if (this.aTextManager3821 != null) {
            this.aTextManager3821.destroy();
        }

        if (this.param != null) {
            this.param.destroy();
        }

        this.aSoundManager3823 = null;
        this.anImageManager3822 = null;
        this.aTextManager3821 = null;
        this.param = null;
        this.aString3828 = null;
    }

    public String getAppletInfo() {
        return "-= Playforia Applet =-\nCopyright (c) Playforia (www.playforia.info)\nProgramming: Pasi Laaksonen";
    }

    public void run() {
        long var1 = System.currentTimeMillis();
        this.method2273(1);
        this.aSPanel_Sub37_3825.method2784();
        this.method2273(2);
        this.param = new Parameters(this, this.isDebug());
        this.initApplet(this.param);
        this.aSPanel_Sub37_3825.setBackground(this.getBackground());
        this.aSPanel_Sub37_3825.setForeground(this.getForeground());
        this.aSPanel_Sub38_3826.setMainBackgroundColor(this.getBackground());
        this.aSPanel_Sub38_3826.setBackground(this.getBackground());
        this.aSPanel_Sub38_3826.setForeground(this.getForeground());
        String var3 = this.param.getParameter("initmessage");
        if (var3 != null) {
            this.aSPanel_Sub37_3825.method2785(var3);
        }

        this.callJavaScriptJSON("{\"loading\":\"started\"}");
        if (this.anInt3831 == 0 && !this.aBoolean3833) {
            int var4 = (int) (System.currentTimeMillis() - var1);
            SPanel_Sub35 var5 = SPanel_Sub35.method2775(this, this.param);
            if (var5 != null) {
                this.aSPanel_Sub37_3825.method2788(0.25D);
                var5.method2776();

                while (!var5.method2777()) {
                    Tools.sleep(50L);
                    if (this.aBoolean3833) {
                        var5.method2781();
                        return;
                    }
                }

                this.aSPanel_Sub37_3825.method2787(var5, Tools.getBoolean(this.param.getParameter("ad_clicktocontinue")));
            }

            int var6 = (int) (System.currentTimeMillis() - var1);
            this.aSPanel_Sub37_3825.method2788(0.5D);
            this.aTextManager3821 = new TextManager(this.param, true, this.isDebug());
            this.aTextManager3821.waitLoadingFinished();
            this.textsLoadedNotify(this.aTextManager3821);
            if (!this.aBoolean3833) {
                String var7 = null;
                if (var5 != null && var5.method2780()) {
                    var7 = " " + this.aTextManager3821.getShared("Loader_AdClickNote");
                }

                int var8 = (int) (System.currentTimeMillis() - var1);
                if (System.currentTimeMillis() < var1 + 3000L) {
                    this.aSPanel_Sub37_3825.method2789(2.0D);
                }

                this.callJavaScriptJSON("{\"loading\":\"inprogress\"}");
                this.aSPanel_Sub37_3825.method2785(this.aTextManager3821.getShared("Loader_LoadingGfxSfx") + (var7 != null ? var7 : ""));
                this.aSoundManager3823 = new SoundManager(this, false, this.isDebug());
                this.aSPanel_Sub37_3825.method2786(0.15D);
                this.defineSounds(this.aSoundManager3823);
                if (!this.aBoolean3833) {
                    int var9 = (int) (System.currentTimeMillis() - var1);
                    this.anImageManager3822 = new ImageManager(this, this.isDebug());
                    this.anImageManager3822.setImageAliases(this.param.getImageAliases());
                    this.aSPanel_Sub37_3825.method2786(0.05D);
                    this.defineImages(this.anImageManager3822, this.param.getSiteName());
                    if (!this.aBoolean3833) {
                        this.anImageManager3822.startLoadingImages();

                        while (!this.anImageManager3822.isLoadingFinished()) {
                            Tools.sleep(50L);
                            if (this.aBoolean3833) {
                                return;
                            }

                            this.aSPanel_Sub37_3825.method2788(0.7D + this.anImageManager3822.getImageLoadProgress() * 0.15D);
                        }

                        int var10 = (int) (System.currentTimeMillis() - var1);
                        this.aSPanel_Sub37_3825.method2786(0.05D);
                        this.createImages();
                        this.defineSecImages(this.anImageManager3822, this.param.getSiteName());
                        if (!this.aBoolean3833) {
                            this.anImageManager3822.startLoadingImages();
                            this.aSoundManager3823.startLoading();
                            if (System.currentTimeMillis() < var1 + 7000L) {
                                this.aSPanel_Sub37_3825.method2789(2.0D);
                            }

                            if (!this.aBoolean3833) {
                                int var11 = (int) (System.currentTimeMillis() - var1);
                                this.aSPanel_Sub37_3825.method2785(this.aTextManager3821.getShared("Message_Connecting") + (var7 != null ? var7 : ""));
                                this.aSPanel_Sub37_3825.method2788(1.0D);
                                this.connectToServer();
                                if (this.anInt3831 == 0) {
                                    int var12 = (int) (System.currentTimeMillis() - var1);
                                    this.aSPanel_Sub38_3826.method2798();
                                    this.callJavaScriptJSON("{\"loading\":\"finished\"}");
                                    this.aSPanel_Sub37_3825.method2789(5.0D);
                                    this.aSPanel_Sub37_3825.method2790();

                                    SPanel_Sub37 var13;
                                    do {
                                        var13 = this.aSPanel_Sub37_3825;
                                        if (this.aBoolean3833 || var13 == null) {
                                            return;
                                        }

                                        Tools.sleep(50L);
                                    } while (!var13.method2791());

                                    int var14 = (int) (System.currentTimeMillis() - var1);
                                    this.method2275(var12, var14, var4, var6, var8, var9, var10, var11);
                                    this.writeThriftDebug("clientconnect", "loadtime:i:" + var12 + "^loadertime:i:" + var14);
                                    this.aSPanel_Sub37_3825.method2792();
                                    if (this.anInt3831 == 0 && !this.aBoolean3833) {
                                        if (!this.aBoolean3833) {
                                            this.method2273(3);
                                            this.aSPanel_Sub37_3825 = null;
                                            this.appletReady();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void setBackground(String var1) {
        this.setBackground(var1, 0, 0);
    }

    public void setBackground(String var1, int var2, int var3) {
        this.aString3828 = var1;
        this.anInt3829 = var2;
        this.anInt3830 = var3;
        if (this.aSPanel_Sub36_3827 != null) {
            this.aSPanel_Sub36_3827.setBackground(this.anImageManager3822, var1, var2, var3);
        }

        if (this.aSPanel_Sub38_3826 != null) {
            this.aSPanel_Sub38_3826.setBackground(this.anImageManager3822, var1, this.anInt3829, this.anInt3830);
        }

    }

    public void setTextLocation(int var1) {
        this.aSPanel_Sub38_3826.method2797(var1);
    }

    public void setTextOutline(boolean var1) {
        this.aSPanel_Sub38_3826.setTextOutline(var1);
    }

    public void setEndState(int var1) {
        if (this.anInt3831 == 0) {
            this.anInt3831 = var1;
            this.method2273(4);
        }
    }

    public void setEndState(String var1) {
        this.aSPanel_Sub38_3826.method2799(var1);
        this.setEndState(6);
    }

    public void setEndState(Throwable var1) {
        this.aSPanel_Sub38_3826.method2800(var1);
        this.setEndState(14);
    }

    public void clearContent() {
        if (this.anInt3831 == 0) {
            this.aSPanel_Sub36_3827.method2782();
        }

        this.aSPanel_Sub38_3826.setVisible(true);
    }

    public void addToContent(Component var1) {
        if (this.anInt3831 == 0) {
            this.aSPanel_Sub36_3827.add(var1);
        }

    }

    public void contentReady() {
        if (this.anInt3831 == 0 && this.aSPanel_Sub36_3827.method2783()) {
            this.aSPanel_Sub38_3826.setVisible(false);
        }

    }

    public abstract void initApplet(Parameters var1);

    public void textsLoadedNotify(TextManager var1) {
    }

    public abstract void defineSounds(SoundManager var1);

    public abstract void defineImages(ImageManager var1, String var2);

    public abstract void createImages();

    public void defineSecImages(ImageManager var1, String var2) {
    }

    public abstract void connectToServer();

    public abstract void appletReady();

    public abstract void destroyApplet();

    public abstract boolean isDebug();

    public void showSplash(Image var1) {
        this.aSPanel_Sub38_3826.method2801(var1);
    }

    public void waitAndRemoveSplash(int var1, boolean var2) {
        this.aSPanel_Sub38_3826.method2802(var1, var2);
    }

    public boolean callJavaScriptJSON(String var1) {
        Parameters var2 = this.param;
        return var2 == null ? false : var2.callJavaScriptJSON(var1);
    }

    public void blockExternalPopups() {
        this.method2277();
        this.callJavaScriptJSON("{\"block\":\"true\"}");
    }

    public void blockExternalPopups(int var1) {
        this.blockExternalPopups();
        this.aClass108_3834 = new Class108(this, this, var1);
    }

    public void allowExternalPopups() {
        this.method2277();
        this.callJavaScriptJSON("{\"block\":\"false\"}");
    }

    public void callJavaScriptJsonBuyConfirmNeeded(Product var1) {
        String var2 = "{\"buy\":{\"status\":\"cneeded\",\"product\":\"";
        var2 = var2 + var1.getProductName();
        var2 = var2 + "}}";
        this.callJavaScriptJSON(var2);
    }

    public void callJavaScriptJsonBuyConfirmAnswer(Product var1, boolean var2) {
        String var3 = "{\"buy\":{\"status\":\"canswer\",\"product\":\"";
        var3 = var3 + var1.getProductName();
        var3 = var3 + "\",\"answer\":\"";
        var3 = var3 + (var2 ? "yes" : "no");
        var3 = var3 + "\"}}";
        this.callJavaScriptJSON(var3);
    }

    public void callJavaScriptJsonBuyStarted(Product var1) {
        this.callJavaScriptJsonBuyStarted(var1.getProductName());
    }

    public void callJavaScriptJsonBuyStarted(String var1) {
        String var2 = "{\"buy\":{\"status\":\"started\",\"product\":\"";
        var2 = var2 + var1;
        var2 = var2 + "\"}}";
        this.callJavaScriptJSON(var2);
    }

    public void callJavaScriptJsonBuyFinished(Product var1, int var2) {
        this.callJavaScriptJsonBuyFinished(var1.getProductName(), var2);
    }

    public void callJavaScriptJsonBuyFinished(String var1, int var2) {
        String var3 = "{\"buy\":{\"status\":\"finished\",\"product\":\"";
        var3 = var3 + var1;
        var3 = var3 + "\",\"result\":\"";
        if (var2 == 1) {
            var3 = var3 + "ok";
        } else if (var2 == 0) {
            var3 = var3 + "nobalance";
        } else if (var2 == -1) {
            var3 = var3 + "error";
        }

        var3 = var3 + "\"}}";
        this.callJavaScriptJSON(var3);
    }

    public void setConnectionReference(Connection var1) {
        this.aConnection3835 = var1;
    }

    public void writeThriftLog(String var1, String var2) {
        if (this.aConnection3835 != null) {
            this.aConnection3835.writeThriftLog(0, var1, var2);
        }

    }

    public void writeThriftDebug(String var1, String var2) {
        if (this.aConnection3835 != null) {
            this.aConnection3835.writeThriftLog(1, var1, var2);
        }

    }

    public int getEndState() {
        return this.anInt3831;
    }

    public boolean isDestroy() {
        return this.aBoolean3833;
    }

    private void method2273(int var1) {
        if (EventQueue.isDispatchThread()) {
            this.internalChangeUIsync(var1);
        } else {
            try {
                SwingUtilities.invokeAndWait(new Class107(this, var1));
            } catch (Exception var3) {
                ;
            }
        }

    }

    public void internalChangeUIsync(int var1) {
        if (var1 == 0) {
            this.aJPanel3824 = new JPanel((LayoutManager) null, false);
            this.aJPanel3824.setOpaque(true);
            this.aJPanel3824.setBackground(Color.white);
            this.aJPanel3824.setSize(this.getContentPane().getSize());
            this.setContentPane(this.aJPanel3824);
        } else if (var1 == 1) {
            this.aSPanel_Sub37_3825 = new SPanel_Sub37(this);
            this.aSPanel_Sub37_3825.setBounds(0, 0, this.anInt2601, this.anInt2602);
            this.aJPanel3824.add(this.aSPanel_Sub37_3825);
        } else if (var1 == 2) {
            this.aSPanel_Sub38_3826 = new SPanel_Sub38(this);
            this.aSPanel_Sub38_3826.setBounds(0, 0, this.anInt2601, this.anInt2602);
            this.aSPanel_Sub38_3826.setMainBackgroundColor(this.getBackground());
            this.aSPanel_Sub38_3826.setVisible(false);
            this.aJPanel3824.add(this.aSPanel_Sub38_3826);
        } else if (var1 == 3) {
            this.aJPanel3824.remove(this.aSPanel_Sub37_3825);
            this.aSPanel_Sub37_3825.method2793();
            this.aSPanel_Sub36_3827 = new SPanel_Sub36(this);
            this.aSPanel_Sub36_3827.setBounds(0, 0, this.anInt2601, this.anInt2602);
            this.aSPanel_Sub36_3827.setMainBackgroundColor(this.getBackground());
            if (this.aString3828 != null) {
                this.aSPanel_Sub36_3827.setBackground(this.anImageManager3822, this.aString3828, this.anInt3829, this.anInt3830);
                this.aSPanel_Sub38_3826.setBackground(this.anImageManager3822, this.aString3828, this.anInt3829, this.anInt3830);
            }

            this.aSPanel_Sub36_3827.setVisible(false);
            this.aJPanel3824.add(this.aSPanel_Sub36_3827);
        } else if (var1 == 4) {
            this.method2274();
            if (this.aSPanel_Sub38_3826 != null) {
                this.aSPanel_Sub38_3826.method2803();
                this.aSPanel_Sub38_3826.setVisible(true);
            }

            if (this.aSPanel_Sub36_3827 != null) {
                this.aSPanel_Sub36_3827.method2782();
            }

            if (this.anInt3831 == 2) {
                this.aSPanel_Sub38_3826.method2804("Message_CE_RetryButton", 40);
            } else if (this.anInt3831 == 14) {
                this.aSPanel_Sub38_3826.method2804("Message_PE_RetryButton", 50);
            }
        }

    }

    private void method2274() {
        SPanel_Sub37 var1 = this.aSPanel_Sub37_3825;
        if (var1 != null) {
            this.aJPanel3824.remove(var1);
            var1.method2793();
            var1 = null;
            this.aSPanel_Sub37_3825 = null;
        }

    }

    private void method2275(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        if (this.isDebug()) {
            System.out.println("AApplet.sendLoadTimes(" + var1 + "," + var2 + ")");
        }

        try {
            String var9 = this.param.getParameter("ld_page");
            if (var9 == null) {
                return;
            }

            if (!var9.toLowerCase().startsWith("javascript:")) {
                return;
            }

            String var10 = this.method2276("java.version");
            String var11 = this.method2276("java.vendor");
            if (var11.length() > 128) {
                var11 = var11.substring(0, 128);
            }

            String var12 = Tools.replaceFirst(var9, "%v", var10);
            var12 = Tools.replaceFirst(var12, "%w", var11);
            var12 = Tools.replaceFirst(var12, "%r", "" + var1);
            var12 = Tools.replaceFirst(var12, "%f", "" + var2);
            var12 = Tools.replaceFirst(var12, "%1", "" + var3);
            var12 = Tools.replaceFirst(var12, "%2", "" + var4);
            var12 = Tools.replaceFirst(var12, "%3", "" + var5);
            var12 = Tools.replaceFirst(var12, "%4", "" + var6);
            var12 = Tools.replaceFirst(var12, "%5", "" + var7);
            var12 = Tools.replaceFirst(var12, "%6", "" + var8);
            URL var13 = new URL(var12);
            if (this.isDebug()) {
                System.out.println("AApplet.sendLoadTimes(...): Displaying page \"" + var13.toString() + "\"");
            }

            this.getAppletContext().showDocument(var13);
        } catch (Exception var14) {
            ;
        }

    }

    private String method2276(String var1) {
        try {
            String var2 = System.getProperty(var1);
            if (var2 != null) {
                return var2;
            }
        } catch (Exception var3) {
            ;
        } catch (Error var4) {
            ;
        }

        return "";
    }

    private void method2277() {
        Class108 var1 = this.aClass108_3834;
        this.aClass108_3834 = null;
        if (var1 != null) {
            var1.stop();
        }

    }

    static {
        aStringArray3836[0] = "\",\"answer\":\"";
        aStringArray3836[1] = "yes";
        aStringArray3836[2] = "no";
        aStringArray3836[3] = "{\"buy\":{\"status\":\"canswer\",\"product\":\"";
        aStringArray3836[4] = "\"}}";
        aStringArray3836[5] = "{\"block\":\"true\"}";
        aStringArray3836[6] = "error";
        aStringArray3836[7] = "nobalance";
        aStringArray3836[8] = "\",\"result\":\"";
        aStringArray3836[9] = "ok";
        aStringArray3836[10] = "{\"buy\":{\"status\":\"finished\",\"product\":\"";
        aStringArray3836[11] = "-= Playforia Applet =-\nCopyright (c) Playforia (www.playforia.info)\nProgramming: Pasi Laaksonen";
        aStringArray3836[12] = "java.version";
        aStringArray3836[13] = "ld_page";
        aStringArray3836[14] = "%r";
        aStringArray3836[15] = "%3";
        aStringArray3836[16] = "%f";
        aStringArray3836[17] = "%2";
        aStringArray3836[18] = "%w";
        aStringArray3836[19] = "%5";
        aStringArray3836[20] = "java.vendor";
        aStringArray3836[21] = "%v";
        aStringArray3836[22] = "AApplet.sendLoadTimes(...): Displaying page \"";
        aStringArray3836[23] = "%1";
        aStringArray3836[24] = "javascript:";
        aStringArray3836[25] = "%6";
        aStringArray3836[26] = "AApplet.sendLoadTimes(";
        aStringArray3836[27] = "%4";
        aStringArray3836[28] = "{\"buy\":{\"status\":\"started\",\"product\":\"";
        aStringArray3836[29] = "Message_PE_RetryButton";
        aStringArray3836[30] = "Message_CE_RetryButton";
        aStringArray3836[31] = "{\"block\":\"false\"}";
        aStringArray3836[32] = "}}";
        aStringArray3836[33] = "{\"buy\":{\"status\":\"cneeded\",\"product\":\"";
        aStringArray3836[34] = "^loadertime:i:";
        aStringArray3836[35] = "Loader_AdClickNote";
        aStringArray3836[36] = "initmessage";
        aStringArray3836[37] = "ad_clicktocontinue";
        aStringArray3836[38] = "clientconnect";
        aStringArray3836[39] = "{\"loading\":\"finished\"}";
        aStringArray3836[40] = "{\"loading\":\"started\"}";
        aStringArray3836[41] = "{\"loading\":\"inprogress\"}";
        aStringArray3836[42] = "loadtime:i:";
        aStringArray3836[43] = "Loader_LoadingGfxSfx";
        aStringArray3836[44] = "Message_Connecting";
    }
}
