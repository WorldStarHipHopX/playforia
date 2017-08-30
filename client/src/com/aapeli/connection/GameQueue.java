package com.aapeli.connection;

import java.util.Vector;

class GameQueue {

    private Vector commands = new Vector();
    private int count = 0;
    private ConnCipher connCipher = new ConnCipher((int) (Math.random() * 19.0D));
    protected long sendSeqNum;


    protected GameQueue() {
        this.connCipher.initialise(ConnCipher.getRandomSeed());
        this.sendSeqNum = 0L;
    }

    protected void add(String var1) {
        long var2;
        synchronized (this) {
            var2 = (long) (this.sendSeqNum++);
        }

        var1 = this.connCipher.encrypt(var2 + " " + var1);
        this.commands.addElement(var1);
    }

    protected String pop() {
        if (this.commands.size() <= this.count) {
            return null;
        } else {
            String var1 = (String) ((String) this.commands.elementAt(this.count));
            var1 = this.connCipher.decrypt(var1);
            if (this.commands.size() > 3) {
                this.commands.removeElementAt(0);
            } else {
                ++this.count;
            }

            return var1;
        }
    }

    protected void clear() {
        this.count = 0;
    }
}
