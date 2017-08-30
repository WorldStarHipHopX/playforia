package com.playray.client;

import com.playray.client.PersonalScoreUnit;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class PersonalScore {

    private PersonalScoreUnit aPersonalScoreUnit1922;
    private Hashtable aHashtable1923;


    public PersonalScore() {
        this((String) null);
    }

    public PersonalScore(String var1) {
        this.aPersonalScoreUnit1922 = null;
        this.aHashtable1923 = new Hashtable();
        if (var1 != null) {
            StringTokenizer var2 = new StringTokenizer(var1, "^");
            String var3 = var2.nextToken();
            if (var3.length() > 1) {
                this.aPersonalScoreUnit1922 = new PersonalScoreUnit(var3);
            }

            while (var2.hasMoreTokens()) {
                var3 = var2.nextToken();
                int var4 = var3.indexOf(58);
                String var5 = var3.substring(0, var4);
                var3 = var3.substring(var4 + 1);
                this.aHashtable1923.put(var5, new PersonalScoreUnit(var3));
            }
        }

    }

    public boolean newScore(String var1, long var2, String var4) {
        if (var1 == null) {
            if (this.method2025(var2, this.aPersonalScoreUnit1922)) {
                this.aPersonalScoreUnit1922 = new PersonalScoreUnit(var2, var4);
                return true;
            }
        } else {
            var1 = var1.toLowerCase();
            if (this.method2025(var2, (PersonalScoreUnit) ((PersonalScoreUnit) this.aHashtable1923.get(var1)))) {
                this.aHashtable1923.put(var1, new PersonalScoreUnit(var2, var4));
                return true;
            }
        }

        return false;
    }

    public PersonalScoreUnit getPersonalScore() {
        return this.getPersonalScore((String) null);
    }

    public PersonalScoreUnit getPersonalScore(String var1) {
        return var1 == null ? this.aPersonalScoreUnit1922 : (PersonalScoreUnit) ((PersonalScoreUnit) this.aHashtable1923.get(var1.toLowerCase()));
    }

    private boolean method2025(long var1, PersonalScoreUnit var3) {
        return var3 == null ? true : var1 > var3.getCompScore();
    }
}
