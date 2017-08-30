package com.aapeli.connection;


public class GameCipher {

    private String[] cmds;


    public GameCipher(String[] cmds) {
        this.cmds = this.sortCmds(cmds);
    }

    protected int getConnCipherMagic() {
        int cmdsLength = this.cmds.length;
        int cmdsLengthMod = cmdsLength % 19;

        for (int index = 0; index < cmdsLength; ++index) {
            int cmdLength = this.cmds[index].length();

            for (int cmdIndex = 0; cmdIndex < cmdLength; ++cmdIndex) {
                cmdsLengthMod = (cmdsLengthMod + this.cmds[index].charAt(cmdIndex) * (index + 1) * (cmdIndex + 2)) % 19;
            }
        }

        return cmdsLengthMod;
    }

    public String encrypt(String input) {// encrypt values found in this.cmds
        char flagChar = this.findUnusedFlagChar(input);
        if (flagChar == 0) {
            return " " + input;
        } else {
            int cmdsLength = this.cmds.length;

            for (int cmdIndex = 0; cmdIndex < cmdsLength; ++cmdIndex) {
                int lastIndex = 0;

                while ((lastIndex = input.indexOf(this.cmds[cmdIndex], lastIndex)) >= 0) {
                    if (!this.containsChar(input, lastIndex, flagChar)) {
                        input = input.substring(0, lastIndex) + flagChar + (char) (' ' + cmdIndex) + input.substring(lastIndex + this.cmds[cmdIndex].length());
                        lastIndex += 2;
                    } else {
                        ++lastIndex;
                    }
                }
            }

            input = flagChar + input;
            return input;
        }
    }

    public String decrypt(String input) {
        char firstChar = input.charAt(0);
        input = input.substring(1);
        if (firstChar == 0) {
            return input;
        } else {
            int charIndex;
            while ((charIndex = input.indexOf(firstChar)) >= 0) {
                input = input.substring(0, charIndex) + this.cmds[input.charAt(charIndex + 1) - 32] + input.substring(charIndex + 2);
            }

            return input;
        }
    }

    private String[] sortCmds(String[] cmds) {
        int cmdsLength = cmds.length;
        int cmdMaxLength = 0;
        int[] cmdLength = new int[cmdsLength];

        for (int i = 0; i < cmdsLength; ++i) { // determine the length of each cmd and calculate the longest of lengths
            cmdLength[i] = cmds[i].length();
            if (cmdLength[i] > cmdMaxLength) {
                cmdMaxLength = cmdLength[i];
            }
        }

        String[] sortedCmds = new String[cmdsLength];
        int sortedIndex = 0;

        for (int i = 0; i < cmdsLength; ++i) { // sort cmds from longest to shortest
            int newMaxLength = 0;

            for (int j = 0; j < cmdsLength; ++j) {
                if (cmdLength[j] == cmdMaxLength) {
                    sortedCmds[sortedIndex] = cmds[j];
                    ++sortedIndex;
                } else if (cmdLength[j] < cmdMaxLength && cmdLength[j] > newMaxLength) {
                    newMaxLength = cmdLength[j];
                }
            }

            cmdMaxLength = newMaxLength;
        }

        return sortedCmds;
    }

    private char findUnusedFlagChar(String input) {
        for (char c = 1; c < 32; ++c) {
            if (input.indexOf(c) == -1) {
                return c;
            }
        }

        return '\u0000';
    }

    private boolean containsChar(String input, int pos, char c) {
        //return pos == 0 ? false : input.charAt(pos - 1) == c;
        return pos != 0 && input.charAt(pos - 1) == c;
    }
}
