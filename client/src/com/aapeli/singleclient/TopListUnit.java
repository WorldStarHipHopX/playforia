package com.aapeli.singleclient;

import java.util.StringTokenizer;

public final class TopListUnit {

    private String name;
    private long time;
    private String avatarUrlSmall;
    private String avatarUrlMedium;
    private String[] extraColumns;
    private int extraColumnsCount;


    protected TopListUnit(StringTokenizer player, int extraCols) {
        this.name = player.nextToken();
        this.time = Long.parseLong(player.nextToken());
        this.avatarUrlSmall = player.nextToken();
        this.avatarUrlMedium = player.nextToken();
        this.extraColumnsCount = extraCols;
        this.extraColumns = new String[extraCols];

        for (int var3 = 0; var3 < extraCols; ++var3) {
            this.extraColumns[var3] = player.nextToken();
        }

    }

    public String getName() {
        return this.name;
    }

    public long getTime() {
        return this.time;
    }

    public String getColumn(int var1) {
        return this.extraColumns[var1];
    }

    public String getBitmapUrlSmall() {
        return this.avatarUrlSmall;
    }

    public String getBitmapUrlMedium() {
        return this.avatarUrlMedium;
    }

    protected int getExtraColumnsCount() {
        return this.extraColumnsCount;
    }
}
