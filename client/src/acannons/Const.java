package acannons;


public class Const {

    public static final String[] NET_CMDS = new String[50];
    public static final String SHIELD = "shield";//todo ???????
    public static final String TELEPORT = "teleport";//todo ???????


    static {
        NET_CMDS[0] = "status\t";
        NET_CMDS[1] = "basicinfo\t";
        NET_CMDS[2] = "userdata\t";
        NET_CMDS[3] = "logintype\t";
        NET_CMDS[4] = "login\t";
        NET_CMDS[5] = "login";
        NET_CMDS[6] = "nickinuse";
        NET_CMDS[7] = "rlf";
        NET_CMDS[8] = "invalidnick";
        NET_CMDS[9] = "reg";
        NET_CMDS[10] = "lobby\t";
        NET_CMDS[11] = "lobby";
        NET_CMDS[12] = "numberofusers\t";
        NET_CMDS[13] = "ownjoin\t";
        NET_CMDS[14] = "join\t";
        NET_CMDS[15] = "language\t";
        NET_CMDS[16] = "joinfromgame\t";
        NET_CMDS[17] = "part\t";
        NET_CMDS[18] = "gamelist\t";
        NET_CMDS[19] = "full\t";
        NET_CMDS[20] = "add\t";
        NET_CMDS[21] = "change\t";
        NET_CMDS[22] = "remove\t";
        NET_CMDS[23] = "say\t";
        NET_CMDS[24] = "sayp\t";
        NET_CMDS[25] = "create\t";
        NET_CMDS[26] = "game\treadytostart";
        NET_CMDS[27] = "game\taction\t";
        NET_CMDS[28] = "game\tresult\t";
        NET_CMDS[29] = "game\tendround\t";
        NET_CMDS[30] = "game\tready\t";
        NET_CMDS[31] = "game\tscore\t";
        NET_CMDS[32] = "game\tstartaction";
        NET_CMDS[33] = "game\tstartround\t";
        NET_CMDS[34] = "game\tstartturn\t";
        NET_CMDS[35] = "game\tshout\t";
        NET_CMDS[36] = "game\t";
        NET_CMDS[37] = "gameinfo\t";
        NET_CMDS[38] = "players";
        NET_CMDS[39] = "owninfo\t";
        NET_CMDS[40] = "startgame\t";
        NET_CMDS[41] = "endgame";
        NET_CMDS[42] = "quit";
        NET_CMDS[43] = "products\t";
        NET_CMDS[44] = "game\tbuy";
        NET_CMDS[45] = "ok\t";
        NET_CMDS[46] = "nobalance";
        NET_CMDS[47] = "failed";
        NET_CMDS[48] = "game";
        NET_CMDS[49] = "sessionlocale\t";
    }
}
