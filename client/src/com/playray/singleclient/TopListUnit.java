package com.playray.singleclient;

import java.util.StringTokenizer;

public final class TopListUnit {

    private String aString2209;
    private long aLong2210;
    private String aString2211;
    private String aString2212;
    private String[] aStringArray2213;
    private int anInt2214;
    public static int anInt2215;


    protected TopListUnit(StringTokenizer var1, int var2) {
        this.aString2209 = var1.nextToken();
        this.aLong2210 = Long.parseLong(var1.nextToken());
        this.aString2211 = var1.nextToken();
        this.aString2212 = var1.nextToken();
        this.anInt2214 = var2;
        this.aStringArray2213 = new String[var2];

        for (int var3 = 0; var3 < var2; ++var3) {
            this.aStringArray2213[var3] = var1.nextToken();
        }

    }

    public String getName() {
        return this.aString2209;
    }

    public long getTime() {
        return this.aLong2210;
    }

    public String getColumn(int var1) {
        return this.aStringArray2213[var1];
    }

    public String getBitmapUrlSmall() {
        return this.aString2211;
    }

    public String getBitmapUrlMedium() {
        return this.aString2212;
    }

    protected int method2260() {
        return this.anInt2214;
    }
}
