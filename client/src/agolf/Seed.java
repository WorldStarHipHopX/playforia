package agolf;


public class Seed {

    private long rnd;


    public Seed(long init) {
        this.rnd = (init ^ 25214903917L) & (1L << 48) - 1L;
    }

    public int next() {
        this.rnd = this.rnd * 25214903917L + 11L & (1L << 48) - 1L;
        int var1 = (int) (this.rnd >>> 16);
        if (var1 < 0) {
            var1 = -var1;
            if (var1 < 0) {
                var1 = 0;
            }
        }

        return var1;
    }

    public Seed clone() {
        Seed clone = new Seed(0);
        clone.rnd = this.rnd;
        return clone;
    }
}
