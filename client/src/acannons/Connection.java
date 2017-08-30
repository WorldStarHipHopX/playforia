package acannons;

import com.playray.connection.ConnListener;
import com.playray.tools.Tools;

public class Connection implements ConnListener {

    private ClientSettings clientSettings;
    private String lastWritten;
    private String lastRead;
    private com.playray.connection.Connection connection;
    private GamePanel gamePanel;


    public Connection(ClientSettings clientSettings) {
        this.clientSettings = clientSettings;
        this.lastWritten = this.lastRead = null;
    }

    public void dataReceived(String data) {
        try {
            this.handlePacket(data);
            this.lastRead = data;
        } catch (Exception exception) {
            Exception var2 = exception;

            try {
                this.writeData("error-debug\t" + this.clientSettings.gameApplet.method2278() + "\t" + var2.toString().trim() + "\t" + data.replace('\t', '\\') + "\t" + this.lastRead.replace('\t', '\\') + "\t" + this.lastWritten.replace('\t', '\\'));
            } catch (Exception ex) {
                ;
            }

            this.clientSettings.gameApplet.setEndState(exception);
            this.connection.disconnect();
        }

    }

    public void connectionLost(int var1) {
        if (var1 != 2 && var1 != 3) {
            if (var1 == 4) {
                this.clientSettings.gameApplet.setEndState(3);
            }
        } else {
            this.clientSettings.gameApplet.setEndState(2);
        }

    }

    public void notifyConnectionDown() {
    }

    public void notifyConnectionUp() {
    }

    protected boolean connect() {
        this.connection = new com.playray.connection.Connection(this.clientSettings.gameApplet, this, Const.NET_CMDS);
        return this.connection.connect();
    }

    protected void sendVersion() {
        this.clientSettings.gameApplet.setGameState(0);
        this.writeData("version\t24");
    }

    protected void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void writeData(String data) {
        this.lastWritten = data;
        this.connection.writeData(data);
    }

    protected void disconnect() {
        if (this.connection != null) {
            this.connection.disconnect();
        }

    }

    private void handlePacket(String cmd) throws Exception {
        String[] args = Tools.separateString(cmd, "\t");
        if (args[0].equals("error")) {
            if (args[1].equals("vernotok")) {
                this.clientSettings.gameApplet.setEndState(3);
            } else if (args[1].equals("serverfull")) {
                this.clientSettings.gameApplet.setEndState(4);
            }

            this.connection.disconnect();
        } else if (args[0].equals("versok")) {
            this.writeData("language\t" + this.clientSettings.gameApplet.param.getChatLang());
            String locale = this.clientSettings.params.getSessionLocale();
            if (locale != null) {
                this.writeData("sessionlocale\t" + locale);
            }

            this.writeData("logintype\t" + (this.clientSettings.gameApplet.hasSession() ? "reg" : "nr"));
        } else if (args[0].equals("basicinfo")) {
            this.clientSettings.gameApplet.setGameSettings(args[1].equals("t"), Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4].equals("t"), args[5].equals("t"));
        } else if (args[0].equals("userdata")) {
            this.clientSettings.gameApplet.setUserData(args[1]);
        } else if (args[0].equals("products")) {
            this.clientSettings.initProductHandler(args[1]);
        } else if (args[0].equals("broadcast")) {
            if (this.clientSettings.lobbyPanel != null) {
                this.clientSettings.lobbyPanel.broadcastMessage(args[1]);
            }
            if (gamePanel != null) {
                gamePanel.broadcastMessage(args[1]);
            }
        } else if (args[0].equals("status")) {
            if (args[1].equals("login")) {
                this.clientSettings.gameApplet.setGameState(1);
                return;
            }
            if (args[1].equals("lobby")) {
                if (args.length == 2) {
                    this.clientSettings.gameApplet.setGameState(2);
                } else {
                    this.clientSettings.gameApplet.setGameState(2, Integer.parseInt(args[2]));
                }

                return;
            }
            if (args[1].equals("game")) {
                this.clientSettings.gameApplet.setGameState(3);
                return;
            }
        } else if (args[0].equals("lobby")) {
            if (this.clientSettings.lobbyPanel != null) {
                this.clientSettings.lobbyPanel.handlePacket(args);
            }
        } else if (args[0].equals("game")) {
            if (gamePanel == null) {
                return;
            }
            gamePanel.handlePacket(args);
        }
    }
}
