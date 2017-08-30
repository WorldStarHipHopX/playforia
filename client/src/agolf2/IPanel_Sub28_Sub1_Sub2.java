package agolf2;

public class IPanel_Sub28_Sub1_Sub2 extends IPanel_Sub28_Sub1 {

    private boolean aBoolean4743;
    private boolean aBoolean4744;
    private static final String[] aStringArray4745 = new String[16];


    public IPanel_Sub28_Sub1_Sub2(Class58_Sub1 var1, int var2, int var3, boolean var4) {
        super(var1, 2, var2, var3, var4);
        this.aBoolean4743 = this.aBoolean4744 = true;
    }

    protected boolean method692(String[] var1) {
        int var2;
        if (var1[1].equals("next")) {
            var2 = Integer.parseInt(var1[2]);
            this.aChatGame_Sub1_3645.addHighlightMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_PlayerVoteSkipTrack", this.anIPanel_Sub31_3643.method744(var2).method1327()));
            this.anIPanel_Sub31_3643.method737(var2);
            return true;
        } else if (var1[1].equals("nextnote")) {
            this.method683();
            this.aChatGame_Sub1_3645.addPlainMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_VoteSkipTrackAccepted"));
            this.anIPanel_Sub31_3643.method741();
            return true;
        } else if (var1[1].equals("clearnext")) {
            this.anIPanel_Sub31_3643.method738();
            if (this.method685() && this.anIPanel_Sub31_3643.method743() > 1) {
                GameBall_Sub1 var3 = this.aClass43_Sub1_2331.method1325()[this.aSynchronizedInteger_2333.method1174()];
                if (var3.method1247() && !var3.method1244()) {
                    this.anIPanel_Sub29_3647.method717();
                }
            }

            return true;
        } else if (var1[1].equals("newgame")) {
            var2 = Integer.parseInt(var1[2]);
            this.aChatGame_Sub1_3645.addHighlightMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_PlayerWantNewGame", this.anIPanel_Sub31_3643.method744(var2).method1327()));
            this.anIPanel_Sub31_3643.method739(var2);
            if (this.aBoolean4744) {
                this.aChatGame_Sub1_3645.addPlainMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_WantNewGameHelp"));
                this.aBoolean4744 = false;
            }

            return true;
        } else if (var1[1].equals("newgamenote")) {
            this.aChatGame_Sub1_3645.addPlainMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_WantNewGameAccepted"));
            return true;
        } else if (var1[1].equals("clearnewgame")) {
            this.anIPanel_Sub31_3643.method740();
            this.anIPanel_Sub29_3647.method719();
            return true;
        } else if (var1[1].equals("part")) {
            var2 = Integer.parseInt(var1[2]);
            this.anIPanel_Sub31_3643.method734(var2);
            this.anGameOverPanel__3642.method767().repaint();
            if (this.anIPanel_Sub31_3643.method743() == 1) {
                this.anIPanel_Sub29_3647.method720();
            }

            return true;
        } else {
            return false;
        }
    }

    protected void method694() {
        if (this.method685()) {
            this.aChatGame_Sub1_3645.addHighlightMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_LocalWantNewGame"));
            this.anIPanel_Sub31_3643.method739(this.aSynchronizedInteger_2333.method1174());
            this.method695("newgame");
        }

    }

    protected void method693() {
        if (this.method685()) {
            this.aChatGame_Sub1_3645.addHighlightMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_LocalVoteSkipTrack"));
            this.anIPanel_Sub31_3643.method737(this.aSynchronizedInteger_2333.method1174());
            if (this.aBoolean4743) {
                this.aChatGame_Sub1_3645.addPlainMessage(this.aClass58_Sub1_3641.textManager.getGame("Game2_VoteSkipTrackHelp"));
                this.aBoolean4743 = false;
            }

            this.method695("next");
        }

    }

    protected void method695(String var1) {
        this.aClass58_Sub1_3641.aClass36_Sub1_3572.method1179("game2\t" + var1);
    }

    static {
        aStringArray4745[0] = "Game2_VoteSkipTrackHelp";
        aStringArray4745[1] = "next";
        aStringArray4745[2] = "Game2_LocalVoteSkipTrack";
        aStringArray4745[3] = "clearnewgame";
        aStringArray4745[4] = "part";
        aStringArray4745[5] = "Game2_WantNewGameAccepted";
        aStringArray4745[6] = "newgamenote";
        aStringArray4745[7] = "Game2_WantNewGameHelp";
        aStringArray4745[8] = "clearnext";
        aStringArray4745[9] = "Game2_PlayerWantNewGame";
        aStringArray4745[10] = "Game2_VoteSkipTrackAccepted";
        aStringArray4745[11] = "nextnote";
        aStringArray4745[12] = "newgame";
        aStringArray4745[13] = "Game2_PlayerVoteSkipTrack";
        aStringArray4745[14] = "game2\t";
        aStringArray4745[15] = "Game2_LocalWantNewGame";
    }
}
