package com.playray.connection;

import java.util.Vector;

class Class134 {

    private Vector aVector2038 = new Vector();
    private int anInt2039 = 0;
    private Class133 aClass133_2040 = new Class133((int) (Math.random() * 19.0D));
    public long aLong2041;


    protected Class134() {
        this.aClass133_2040.method2095(Class133.method2094());
        this.aLong2041 = 0L;
    }

    protected void method2103(String var1) {
        long var2;
        synchronized (this) {
            var2 = (long) (this.aLong2041++);
        }

        var1 = this.aClass133_2040.method2097(var2 + " " + var1);
        this.aVector2038.addElement(var1);
    }

    protected String method2104() {
        if (this.aVector2038.size() <= this.anInt2039) {
            return null;
        } else {
            String var1 = (String) ((String) this.aVector2038.elementAt(this.anInt2039));
            var1 = this.aClass133_2040.decrypt(var1);
            if (this.aVector2038.size() > 3) {
                this.aVector2038.removeElementAt(0);
            } else {
                ++this.anInt2039;
            }

            return var1;
        }
    }

    protected void method2105() {
        this.anInt2039 = 0;
    }
}
