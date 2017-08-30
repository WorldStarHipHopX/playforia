package com.playray.client;

import com.playray.tools.Sortable;

import java.util.StringTokenizer;

public final class Badge implements Sortable {

    private int anInt2791;
    private int anInt2792;
    private int anInt2793;
    private String aString2794;
    private boolean aBoolean2795;
    private boolean aBoolean2796;
    private static final String[] aStringArray2797 = new String[6];


    protected Badge(String var1) {
        StringTokenizer var2 = new StringTokenizer(var1, ";");
        this.anInt2791 = Integer.parseInt(var2.nextToken());
        this.aString2794 = var2.nextToken();
        this.anInt2792 = Integer.parseInt(var2.nextToken());
        this.anInt2793 = Integer.parseInt(var2.nextToken());
        this.aBoolean2795 = var2.nextToken().equals("t");
        this.aBoolean2796 = var2.nextToken().equals("t");
    }

    public String toString() {
        return "[Badge: id=" + this.anInt2791 + ", label=\"" + this.aString2794 + "\", threshold=" + this.anInt2792 + ", order=" + this.anInt2793 + ", active=" + this.aBoolean2795 + ", owned=" + this.aBoolean2796 + "]";
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
        return this.anInt2791;
    }

    public String getLabel() {
        return this.aString2794;
    }

    public int getThreshold() {
        return this.anInt2792;
    }

    public int getOrder() {
        return this.anInt2793;
    }

    public boolean isActive() {
        return this.aBoolean2795;
    }

    protected boolean method1904() {
        return this.aBoolean2796;
    }

    protected void method1905() {
        this.aBoolean2796 = true;
    }

    static {
        aStringArray2797[0] = ", order=";
        aStringArray2797[1] = "\", threshold=";
        aStringArray2797[2] = ", label=\"";
        aStringArray2797[3] = "[Badge: id=";
        aStringArray2797[4] = ", active=";
        aStringArray2797[5] = ", owned=";
    }
}
