package com.aapeli.connection;

public class ConnCipher {

    private int seed;
    private int magic;
    private int[][] randomsAscii;
    private int[][] randomsOther;


    public ConnCipher(int magic) {
        this.magic = magic;// :-)
        this.seed = -1;
        this.randomsAscii = new int[2][125];
        this.randomsOther = new int[2][1920];
    }

    public static int getRandomSeed() {
        int min = 100000000;
        int max = 999999999;
        return min + (int) (Math.random() * (double) (max - min + 1));
    }

    public void initialise(int newSeed) {
        this.seed = newSeed;

        for (int i = 1; i <= 125; ++i) {
            this.randomsAscii[1][i - 1] = -1;
        }

        for (int i = 128; i <= 2047; ++i) {
            this.randomsOther[1][i - 128] = -1;
        }

        ConnRandom random = new ConnRandom((long) newSeed);

        int rand;
        for (int index = 1; index <= 125;) {
            rand = random.nextInt(1, 125);
            while(this.randomsAscii[1][rand - 1] >= 0) {
                rand = random.nextInt(1, 125);
            }
            this.randomsAscii[0][index - 1] = rand;
            this.randomsAscii[1][rand - 1] = index;
            index++;
        }

        for (int index = 128; index <= 2047;) {
            rand = random.nextInt(128, 2047);
            while(this.randomsOther[1][rand - 128] >= 0) {
                rand = random.nextInt(128, 2047);
            }
            this.randomsOther[0][index - 128] = rand;
            this.randomsOther[1][rand - 128] = index;
            index++;
        }

    }

    protected void reset() {
        this.seed = -1;
    }

    public String encrypt(String input) {
        if (this.seed == -1) {
            return input;
        } else {
            char[] inputChars = input.toCharArray();
            int inputLength = inputChars.length;
            StringBuilder output = new StringBuilder(inputLength + 2);
            int firstRandom = (int) (1.0D + Math.random() * 125.0D);
            int lastRandom = (int) (1.0D + Math.random() * 125.0D);
            int randMod = magicMod(firstRandom, 1, inputLength + 1);// kek
            output.append((char) this.increment(firstRandom));
            int seedling = this.seed % 99 - 49 + firstRandom - lastRandom;// lolol
            for (int index = 0; index < inputLength; ++index) {
                if (randMod == index + 1) {
                    output.append((char) this.increment(lastRandom));
                }

                int curChar = inputChars[index];
                if (curChar >= 1 && curChar <= 127) {// ascii
                    if (curChar != '\n' && curChar != '\r') {
                        curChar = this.decrement(curChar);
                        curChar = magicMod(curChar, seedling, 1, 125);
                        ++seedling;
                        curChar = this.randomsAscii[0][curChar - 1];
                        curChar = this.increment(curChar);
                        if (curChar >= 14 && curChar <= 127) {// '\r' + 1
                            curChar = magicMod(curChar, this.magic - 9, 14, 127);
                        }
                    }
                } else if (curChar >= 128 && curChar <= 2047) {// other
                    curChar = magicMod(curChar, seedling, 128, 2047);
                    seedling += 2;
                    curChar = this.randomsOther[0][curChar - 128];
                }

                output.append((char) curChar);
                ++seedling;
            }

            if (randMod == inputLength + 1) {
                output.append((char) this.increment(lastRandom));
            }

            return output.toString();
        }
    }

    public String decrypt(String input) {
        if (this.seed == -1) {
            return input;
        } else {
            char[] inputChars = input.toCharArray();
            int inputLength = inputChars.length;
            StringBuilder output = new StringBuilder(inputLength - 2);
            int firstRandom = this.decrement(inputChars[0]);
            int randMod = magicMod(firstRandom, 1, inputLength - 1);
            int lastRandom = this.decrement(inputChars[randMod]);
            int seedling = lastRandom - firstRandom - (this.seed % 99 - 49);
            int origInputLength = randMod < inputLength - 1 ? inputLength : inputLength - 1;

            for (int index = 1; index < origInputLength; ++index) {
                if (index == randMod) {
                    ++index;
                }

                int curChar = inputChars[index];
                if (curChar >= 1 && curChar <= 127) {// ascii
                    if (curChar != '\n' && curChar != '\r') {
                        if (curChar >= 14 && curChar <= 127) {// '\r' + 1
                            curChar = magicMod(curChar, 9 - this.magic, 14, 127);
                        }

                        curChar = this.decrement(curChar);
                        curChar = this.randomsAscii[1][curChar - 1];
                        curChar = magicMod(curChar, seedling, 1, 125);
                        --seedling;
                        curChar = this.increment(curChar);
                    }
                } else if (curChar >= 128 && curChar <= 2047) {// other
                    curChar = this.randomsOther[1][curChar - 128];
                    curChar = magicMod(curChar, seedling, 128, 2047);
                    seedling -= 2;
                }
                output.append((char) curChar);
                --seedling;
            }

            return output.toString();
        }
    }

    private int decrement(int val) {
        if (val > 13) {
            --val;
        }

        if (val > 10) {
            --val;
        }

        return val;
    }

    private int increment(int val) {
        if (val >= 10) {
            ++val;
        }

        if (val >= 13) {
            ++val;
        }

        return val;
    }

    private static int magicMod(int val1, int val2, int min, int max) {
        return magicMod(val1 + val2, min, max);
    }

    /*
        >>> [ f(i, 1, len("HURR") + 1) for i in range(-5, 6) ]
        [5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5]
     */
    private static int magicMod(int val, int min, int max) {// ( °͜ʖ °)
        max -= min;
        val -= min;
        int modulus = max + 1;
        if (val > max) {
            val %= modulus;
        } else if (val < 0) {
            int var5 = (-val - 1) / modulus + 1;
            val += var5 * modulus;
        }

        val += min;
        return val;
    }
}
