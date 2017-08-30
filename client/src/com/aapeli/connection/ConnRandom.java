package com.aapeli.connection;


class ConnRandom {

    // http://www.math.utah.edu/~beebe/java/random/README
    // http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Random.java
    private final static long multiplier = 0x5DEECE66DL;
    private final static long append = 0xBL;
    private final static long mask = (1L << 48) - 1;

    private long nextseed;

    // http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Random.java#Random.setSeed%28long%29
    protected ConnRandom(long seed) {
        this.nextseed = (seed ^ multiplier) & mask;
    }

    protected int nextInt(int min, int max) {
        return min + this.nextInt() % (max - min + 1);
    }

    private int nextInt() {
        int next = this.next();
        if (next < 0) {
            next = -next;
            if (next < 0) {
                next = 0;
            }
        }

        return next;
    }

    // http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Random.java#Random.next%28int%29
    private int next() {
        this.nextseed = this.nextseed * multiplier + append & mask;
        return (int) (this.nextseed >>> 16);// next seed for 32 bits
    }
}
