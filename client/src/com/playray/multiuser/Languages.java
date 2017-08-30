package com.playray.multiuser;

import com.playray.client.ImageManager;
import com.playray.client.TextManager;

import java.awt.Image;

public final class Languages {

    public static final int LANGUAGE_UNKNOWN = 0;
    public static final String[][] aStringArrayArray2167 = {
            {"null", "-", }, {"bg", "null", }, {"de", "null", }, {"en", "uk", }, {"es", "null", },
            {"et", "ee", }, {"fi", "null", }, {"fr", "null", }, {"hu", "null", }, {"it", "null", },
            {"lv", "null", }, {"nl", "null", }, {"no", "null", }, {"pl", "null", }, {"pt", "null", },
            {"ro", "null", }, {"ru", "null", }, {"sv", "se", }, {"tr", "null", }, {"lt", "null", },
    };
    private static final int anInt2168 = aStringArrayArray2167.length;
    private TextManager aTextManager2169;
    private ImageManager anImageManager2170;
    private Image[] anImageArray2171;


    public Languages(TextManager var1, ImageManager var2) {
        this.aTextManager2169 = var1;
        this.anImageManager2170 = var2;
    }

    public static int getLanguageIdByString(String var0) {
        if (var0 == null) {
            return LANGUAGE_UNKNOWN;
        } else {
            int var1 = var0.indexOf(95);
            if (var1 > 0) {
                var0 = var0.substring(0, var1);
            }

            var0 = var0.toLowerCase();

            for (int var2 = 1; var2 < anInt2168; ++var2) {
                if (var0.equals(aStringArrayArray2167[var2][0])) {
                    return var2;
                }

                if (aStringArrayArray2167[var2][1] != null && var0.equals(aStringArrayArray2167[var2][1])) {
                    return var2;
                }
            }

            return LANGUAGE_UNKNOWN;
        }
    }

    public Image getFlag(int var1) {
        if (this.anImageArray2171 == null) {
            Image var2 = this.anImageManager2170.getShared("language-flags.png");
            this.anImageArray2171 = this.anImageManager2170.separateImages(var2, anInt2168);
        }

        return this.anImageArray2171[var1];
    }

    public String getName(int var1) {
        return this.aTextManager2169.getShared("Language_" + aStringArrayArray2167[var1][0]);
    }

    public String get2charID(int var1) {
        return var1 == 0 ? "??" : aStringArrayArray2167[var1][0].toUpperCase();
    }
}
