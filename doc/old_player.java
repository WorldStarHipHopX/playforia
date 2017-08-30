package org.server;

import java.util.Random;

/**
 * Playforia
 * 30.5.2013
 */
public class Player {

    private static final Random random = new Random();
    public static final int ELEV_NORMAL = 0;
    public static final int ELEV_SHERIFF = 1;
    public static final int ELEV_ADMIN = 2;
    public String nick;
    public String locale;
    public String profilePage;
    public String avatarUrl;
    public int elevation;
    public int points;
    public boolean isEmailVerified;
    public boolean isRegistered;
    public boolean isVip;
    public boolean isSheriff;
    public boolean isNotAcceptingChallenges;

    public Player(String locale) {
        this("mopar" + random.nextInt(10000), locale);
    }

    public Player(String nick, String locale) {
        this.nick = nick;
        this.locale = locale;
        profilePage = "-";
        avatarUrl = "-";
        isRegistered = true;
        isVip = false;
        isSheriff = false;
        isEmailVerified = true;
        elevation = ELEV_NORMAL;
        points = 0;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Player))
            return false;
        Player p = (Player) o;
        return nick.equals(p.nick) && points == p.points && locale.equals(p.locale);
    }

    @Override
    public String toString() {
        String tmp = "";
        if(isRegistered)
            tmp += "r";
        if(isVip)
            tmp += "v";
        if(isSheriff)
            tmp += "s";
        if(isNotAcceptingChallenges)
            tmp += "n";
        Object[] arr = new Object[] {"3:" + nick, tmp, points, locale, profilePage, avatarUrl};
        return Tools.triangelize(arr);
    }
}
