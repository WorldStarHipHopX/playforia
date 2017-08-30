package com.aapeli.client;

import com.aapeli.tools.Sortable;

import java.util.StringTokenizer;

public final class Badge implements Sortable {

    private int anInt2594;
    private int anInt2595;
    private int anInt2596;
    private String aString2597;
    private boolean aBoolean2598;
    private boolean aBoolean2599;
    private static final String[] aStringArray2600 = new String[6];


    protected Badge(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ";");
        this.anInt2594 = Integer.parseInt(var2.nextToken());
        this.aString2597 = var2.nextToken();
        this.anInt2595 = Integer.parseInt(var2.nextToken());
        this.anInt2596 = Integer.parseInt(var2.nextToken());
        this.aBoolean2598 = var2.nextToken().equals("t");
        this.aBoolean2599 = var2.nextToken().equals("t");
    }

    public String toString() {
        return "[Badge: id=" + this.anInt2594 + ", label=\"" + this.aString2597 + "\", threshold=" + this.anInt2595 + ", order=" + this.anInt2596 + ", active=" + this.aBoolean2598 + ", owned=" + this.aBoolean2599 + "]";
    }

    public int compareTo(Sortable var1) {
        if (var1 == null) {
            return -1;
        } else if (!(var1 instanceof Badge)) {
            return -1;
        } else {
            int var2 = this.getOrder();
            int var3 = ((Badge) ((Badge) var1)).getOrder();
            return var2 < var3 ? -1 : (var2 > var3 ? 1 : 0);
        }
    }

    public int getBadgeId() {
        return this.anInt2594;
    }

    public String getLabel() {
        return this.aString2597;
    }

    public int getThreshold() {
        return this.anInt2595;
    }

    public int getOrder() {
        return this.anInt2596;
    }

    public boolean isActive() {
        return this.aBoolean2598;
    }

    public boolean isOwned() {
        return this.aBoolean2599;
    }

    protected void method1563() {
        this.aBoolean2599 = true;
    }

    static {
        aStringArray2600[0] = ", owned=";
        aStringArray2600[1] = ", order=";
        aStringArray2600[2] = ", active=";
        aStringArray2600[3] = ", label=\"";
        aStringArray2600[4] = "[Badge: id=";
        aStringArray2600[5] = "\", threshold=";
    }
}
