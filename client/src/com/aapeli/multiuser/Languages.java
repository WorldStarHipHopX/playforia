package com.aapeli.multiuser;

import com.aapeli.client.ImageManager;
import com.aapeli.client.TextManager;

import java.awt.Image;

public final class Languages {

    public static final int LANGUAGE_UNKNOWN = 0;
    public static final String[][] aStringArrayArray1664 = {
            {"null", "-", }, {"bg", "null", }, {"de", "null", }, {"en", "null", }, {"es", "null", },
            {"et", "ee", }, {"fi", "null", }, {"fr", "null", }, {"hu", "null", }, {"it", "null", },
            {"lv", "null", }, {"nl", "null", }, {"no", "null", }, {"pl", "null", }, {"pt", "null", },
            {"ro", "null", }, {"ru", "null", }, {"sv", "se", }, {"tr", "null", }, {"lt", "null", },
    };
    private static final int anInt1665 = aStringArrayArray1664.length;
    private TextManager aTextManager1666;
    private ImageManager anImageManager1667;
    private Image[] anImageArray1668;

    public Languages(TextManager var1, ImageManager var2) {
        this.aTextManager1666 = var1;
        this.anImageManager1667 = var2;
    }

    public static int getLanguageIdByString(String var0) {
        if (var0 == null) {
            return LANGUAGE_UNKNOWN;
        } else {
            int var1 = var0.indexOf('_');
            if (var1 > 0) {
                var0 = var0.substring(0, var1);
            }

            var0 = var0.toLowerCase();

            for (int var2 = 1; var2 < anInt1665; ++var2) {
                if (var0.equals(aStringArrayArray1664[var2][0])) {
                    return var2;
                }

                if (aStringArrayArray1664[var2][1] != null && var0.equals(aStringArrayArray1664[var2][1])) {
                    return var2;
                }
            }

            return LANGUAGE_UNKNOWN;
        }
    }

    public Image getFlag(int var1) {
        if (this.anImageArray1668 == null) {
            Image var2 = this.anImageManager1667.getShared("language-flags.png");
            this.anImageArray1668 = this.anImageManager1667.separateImages(var2, anInt1665);
        }

        return this.anImageArray1668[var1];
    }

    public String getName(int var1) {
        return this.aTextManager1666.getShared("Language_" + aStringArrayArray1664[var1][0]);
    }
}
