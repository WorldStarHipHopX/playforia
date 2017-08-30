package com.playray.client;

import com.playray.tools.Tools;

public final class PersonalScoreUnit {

    private long aLong1924;
    private long aLong1925;
    private String aString1926;


    protected PersonalScoreUnit(long var1, String var3) {
        this.aLong1924 = System.currentTimeMillis();
        this.aLong1925 = var1;
        this.aString1926 = var3;
    }

    protected PersonalScoreUnit(String var1) {
        int var2 = var1.indexOf(44);
        int var3 = var1.indexOf(44, var2 + 1);
        this.aLong1924 = Long.parseLong(var1.substring(0, var2));
        this.aLong1925 = Long.parseLong(var1.substring(var2 + 1, var3));
        this.aString1926 = Tools.changeFromSaveable(var1.substring(var3 + 1));
    }

    public long getTimeStamp() {
        return this.aLong1924;
    }

    public long getCompScore() {
        return this.aLong1925;
    }

    public String getClientData() {
        return this.aString1926;
    }
}
