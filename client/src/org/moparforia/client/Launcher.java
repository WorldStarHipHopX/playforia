package org.moparforia.client;

import agolf.AGolf;
import com.aapeli.connection.GameCipher;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Playforia
 * 28.5.2013
 */
public class Launcher extends JFrame {

    private static Launcher instance;
    private Applet game;
    private Map<String, Game> gaemz;
    private String selectedGame;
    private JCheckBox serverBox;

    public static boolean debug() {
        return true;
    }

    public static boolean isUsingCustomServer() {
        return true;//instance.serverBox.isSelected();
    }

    private int[] decodeCoords(String input) {
        int result = Integer.valueOf(input, 36);
        return new int[] {
                result / 4 / 375,
                result / 4 % 375,
                result % 4
        };
    }

    private static String encodeCoords(int x, int y, int mod) {
        int var4 = x * 375 * 4 + y * 4 + mod;//mod.. or something, possible values 0..3

        String out;
        for (out = Integer.toString(var4, 36); out.length() < 4; out = "0" + out) {
            ;
        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        /*Pattern p = Pattern.compile("(game|lobby)\\t(challenge|accept|cancel|cfail|nc)\\t(t|f|refuse|[ -~]+)(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?(?:\\t)?(\\d+)?");
        System.out.println(p.matcher("lobby\tchallenge\t~Guest6171\t10\t1\t20\t60\t0\t1\t0\t0").matches());
        System.out.println(p.matcher("lobby\tcfail\trefuse").matches());
        System.out.println(p.matcher("lobby\tcancel\t~Guest6171").matches());
        System.out.println(p.matcher("lobby\taccept\t~Guest6171").matches());
        System.out.println(p.matcher("lobby\tnc\tt").matches());
        System.out.println(p.matcher("lobby\tnc\tf").matches());
        Matcher m = p.matcher("lobby\tchallenge\t~Guest6171\t10\t1\t20\t60\t0\t1\t0\t0");
        System.out.println(m.matches());
        for(int i = 1; i < m.groupCount(); i++)
            System.out.println(m.group(i));
        */

        instance = new Launcher();
    }

    static class ConnCipher {

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
                    System.out.println("encrypt index: " + index);

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
                    System.out.println("decrypt index: " + index);

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


    static class ConnRandom {

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


    private void doMagic(Object parent, Component[] c, String initialValue) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] instanceof JPanel) {
                doMagic(c[i], ((JPanel) c[i]).getComponents(), initialValue);
            } else if (c[i] instanceof JComboBox) {
                JComboBox comboBox = (JComboBox) c[i];
                for (int j = 0; j < comboBox.getItemCount(); j++)
                    if (comboBox.getItemAt(j).toString().equals(initialValue)) {
                        comboBox.setSelectedIndex(j);
                        break;
                    }
                serverBox = new JCheckBox("Use localhost");
                ((JPanel) parent).add(serverBox);
            }
        }
    }

    public Launcher() {
        gaemz = new TreeMap<String, Game>();
        gaemz.put("AGolf", new Game("localhost", 4242, 735, 525));

        serverBox = new JCheckBox();
        serverBox.setSelected(true);
        selectedGame = "AGolf";
            game = new AGolf();


        game.setStub(new Stub());
        game.setSize(gaemz.get(selectedGame).width, gaemz.get(selectedGame).height);
        game.init();
        game.start();
        add(game);
        setSize(gaemz.get(selectedGame).width + 20, gaemz.get(selectedGame).height + 40);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String[] login() {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2, 2));
        JLabel userLabel = new JLabel("user");
        JLabel passLabel = new JLabel("pass");
        final JTextField userField = new JTextField();
        final JPasswordField passField = new JPasswordField();

        pane.add(userLabel);
        pane.add(userField);
        pane.add(passLabel);
        pane.add(passField);

        int option = JOptionPane.showConfirmDialog(this,pane,"Login",JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION) {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            return new String[]{user, pass};
        } else {
            return new String[]{null,null};
        }

    }

    class Stub implements AppletStub {
        private Map<String, String> params;

        public Stub() {
            Game g = gaemz.get(selectedGame);
            params = new HashMap<String, String>();
            params.put("initmessage", "Loading game...");
            params.put("ld_page", "javascript:Playray.Notify.delegate({ jvm: { version: '%v', vendor: '%w', t1: '%r', t2: '%f' } })");
            params.put("image", "/appletloader_playforia.gif");
            if(serverBox.isSelected()) {
                params.put("server", "149.255.111.161" + ":" + g.port);
            } else {
                params.put("server", "game05.playforia.net" + ":" + g.port);
            }
            params.put("server", "127.0.0.1:" + g.port);

            params.put("locale", "en");
            params.put("lang", "en_US");
            params.put("sitename", "playray");
            params.put("quitpage", "http://www.playforia.com/games/");
            params.put("regremindshowtime", "3,8,15,25,50,100,1000");
            params.put("registerpage", "http://www.playforia.com/account/create/");
            params.put("creditpage", "http://www.playforia.com/shop/buy/");
            params.put("userinfopage", "http://www.playforia.com/community/user/");
            params.put("userinfotarget", "_blank");
            params.put("userlistpage", "javascript:Playray.GameFaceGallery('%n','#99FF99','agolf','%s')");
            params.put("guestautologin", "true");
            params.put("disableguestlobbychat", "true");
            params.put("json", "Playray.Notify.delegate(%o)");
            params.put("centerimage", "true");
            params.put("java_arguments", "-Xmx128m");
            params.put("localizationUrl", "");
            params.put("sharedLocalizationUrl", "");

            //if(serverBox.isSelected())
                //params.put("tracktestmode", "true");
            //params.put("session", "7vkBHjUIcQKg-J,c2bXzYdy,lJd");
            //params.put("sessionlang", "en");
        }

        public boolean isActive() {
            return true;
        }

        public URL getDocumentBase() {
            try {
                return new URL("http://" + gaemz.get(selectedGame).host + "/" + selectedGame + "/");
            } catch (Exception ex) {
                System.err.println("getdocumentbase exc eption");
                return null;
            }
        }

        public URL getCodeBase() {
            return getDocumentBase();
        }

        public String getParameter(String name) {
            if (!params.containsKey(name))
                return "";
            return params.get(name);
        }

        public AppletContext getAppletContext() {
            return null;
        }


        public void appletResize(int width, int height) {
        }
    }

    class Game {
        public String host;
        public int port;
        public int width;
        public int height;

        public Game(String host, int port, int width, int height) {
            this.host = host;
            this.port = port;
            this.width = width;
            this.height = height;
        }
    }
}
