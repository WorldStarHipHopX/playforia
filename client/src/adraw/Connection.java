package adraw;

import adraw.game.GamePanel;
import adraw.lobby.LobbyPanel;
import com.aapeli.applet.AApplet;
import com.aapeli.tools.Tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable {

    private GameApplet gameApplet;
    private LobbyPanel lobbyPanel;
    private GamePanel gamePanel;
    private String server;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private DataOutputStream out;
    private ConnCrypto connCrypto;
    private String lastLineWritten;
    private String aString955;
    private boolean error;

    protected Connection(GameApplet var1, String var2, int var3) {
        this.gameApplet = var1;
        this.server = var2;
        this.port = var3;
        this.connCrypto = new ConnCrypto();
        this.lastLineWritten = this.aString955 = null;
        this.error = false;
    }

    public void run() {
        Exception var1 = null;
        String var2 = null;

        try {
            this.writeData("version\t" + 16);

            do {
                var2 = this.readLine();
                if (!this.error) {
                    this.handleCommand(var2);
                    this.aString955 = var2;
                }
            } while (!this.error);
        } catch (Exception var5) {
            var1 = var5;
        }

        if (var1 != null) {
            try {
                this.writeData("error-debug\t" + this.gameApplet.getGameState() + "\t" + var1.toString().trim() + "\t" + var2.replace('\t', '\\') + "\t" + this.aString955.replace('\t', '\\') + "\t" + this.lastLineWritten.replace('\t', '\\') + "\t[Rem]");
            } catch (Exception var4) {
                ;
            }

            this.gameApplet.setEndState(AApplet.END_ERROR_CONNECTION);
        }

        this.disconnect();
    }

    protected void connectAndRead() {
        try {
            this.connect();
            this.readLine();
        } catch (Exception var1) {
            var1.printStackTrace();
            this.gameApplet.setEndState(AApplet.END_ERROR_CONNECTION);
            this.disconnect();
        }
    }

    protected void method1125() {
        this.gameApplet.setGameState(0);
        Thread var1 = new Thread(this);
        var1.start();
    }

    protected void setLobbyPanel(LobbyPanel var1) {
        this.lobbyPanel = var1;
    }

    protected void setGamePanel(GamePanel var1) {
        if (this.gamePanel != null) {
            this.gamePanel.method278();
        }

        this.gamePanel = var1;
    }

    public void writeData(String var1) {
        this.lastLineWritten = var1;

        try {
            synchronized (connCrypto.syncObjectOut) {
                System.out.println("CLIENT> WRITE \"" + var1 + "\"");
                var1 = this.connCrypto.encrypt(var1);
                this.out.writeBytes(var1 + '\n');
            }

            this.out.flush();
        } catch (IOException var6) {
            this.error = true;
        }
    }

    private void connect() throws Exception {
        System.out.println("openConnection " + server + " " + port);
        this.socket = new Socket(this.server, this.port);
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new DataOutputStream(this.socket.getOutputStream());
    }

    private void disconnect() {
        try {
            this.out.close();
        } catch (Exception var3) {
            ;
        }

        try {
            this.in.close();
        } catch (Exception var2) {
            ;
        }

        try {
            this.socket.close();
        } catch (Exception var1) {
            ;
        }
    }

    private String readLine() throws IOException {
        synchronized (connCrypto.syncObjectIn) {
            String var2 = this.in.readLine();
            if (var2 != null) {
                var2 = this.connCrypto.decrypt(var2);
                System.out.println("CLIENT> READ \"" + var2 + "\"");
                return var2;
            }

            this.error = true;
            return null;
        }
    }

    private void handleCommand(String command) throws Exception {
        String[] cmd = Tools.separateString(command, "\t");
        if (cmd[0].equals("error")) {
            if (cmd[1].equals("vernotok")) {
                this.gameApplet.setEndState(AApplet.END_ERROR_VERSION);
            } else if (cmd[1].equals("serverfull")) {
                this.gameApplet.setEndState(AApplet.END_ERROR_SERVERFULL);
            } else if (cmd[1].equals("rlf")) {
                this.gameApplet.setEndState(AApplet.END_ERROR_REGLOGIN_FAILED);
            }

            this.error = true;
        } else if (cmd[0].equals("io")) {
            this.connCrypto.setKey(Integer.parseInt(cmd[1]));
            this.writeData("logintype\t" + (this.gameApplet.hasSession() ? "reg" : "nr"));
        } else if (this.connCrypto.method1109()) {
            if (cmd[0].equals("ping")) {
                this.writeData("pong");
            } else if (cmd[0].equals("basicinfo")) {
                this.gameApplet.setGameSettings(cmd[1].equals("t"), Integer.parseInt(cmd[2]), cmd[3].equals("t"), cmd[4].equals("t"));
            } else if (cmd[0].equals("broadcast")) {
                if (this.lobbyPanel != null) {
                    this.lobbyPanel.broadcastMessage(cmd[1]);
                }

                if (this.gamePanel != null) {
                    this.gamePanel.addServerMessage(cmd[1]);
                }

            } else {
                if (cmd[0].equals("status")) {
                    if (cmd[1].equals("login")) {
                        this.gameApplet.setGameState(1);
                        return;
                    }

                    if (cmd[1].equals("lobby")) {
                        if (cmd.length == 2) {
                            this.gameApplet.setGameState(2, -1);
                            return;
                        }

                        this.gameApplet.setGameState(2, Integer.parseInt(cmd[2]));
                        return;
                    }

                    if (cmd[1].equals("game")) {
                        this.gameApplet.setGameState(3);
                        return;
                    }
                }

                if (cmd[0].equals("lobby")) {
                    if (this.lobbyPanel != null) {
                        this.lobbyPanel.handlePacket(cmd);
                    }
                } else {
                    if (cmd[0].equals("game")) {
                        if (this.gamePanel == null) {
                            return;
                        }

                        this.gamePanel.handlePacket(cmd);
                    }

                }
            }
        }
    }
}
