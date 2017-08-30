package org.moparforia.client.trackdump;

import java.util.Vector;

class Class98 {

    private Vector aVector1604 = new Vector();
    private int anInt1605 = 0;
    private ConnCrypto aConnCrypto_1606 = new ConnCrypto((int) (Math.random() * 19.0D));
    protected long aLong1607;


    protected Class98() {
        this.aConnCrypto_1606.setKey(ConnCrypto.method1763());
        this.aLong1607 = 0L;
    }

    protected void method1772(String var1) {
        long var2;
        synchronized (this) {
            var2 = (long) (this.aLong1607++);
        }

        var1 = this.aConnCrypto_1606.encrypt(var2 + " " + var1);
        this.aVector1604.addElement(var1);
    }

    protected String method1773() {
        if (this.aVector1604.size() <= this.anInt1605) {
            return null;
        } else {
            String var1 = (String) ((String) this.aVector1604.elementAt(this.anInt1605));
            var1 = this.aConnCrypto_1606.decrypt(var1);
            if (this.aVector1604.size() > 3) {
                this.aVector1604.removeElementAt(0);
            } else {
                ++this.anInt1605;
            }

            return var1;
        }
    }

    protected void method1774() {
        this.anInt1605 = 0;
    }
}
