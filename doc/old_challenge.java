package org.server;

/**
 * Playforia
 * 7.6.2013
 */
public class Challenge {

    public Player challenger;
    public Player challenged;
    public int numTracks;
    public int trackType;
    public int maxStrokes;
    public int timeLimit;
    public int waterEvent;
    public int collision;
    public int scoring;
    public int scoringEnd;

    // ("challenge\t" + this.opponentName + "\t" + this.tracksNum + "\t" + this.trackType + "\t" + this.maxStrokes + "\t" + this.timeLimit +
    // "\t" + this.waterEvent + "\t" + this.collision + "\t" + this.scoring + "\t" + this.scoringEnd

    public Challenge(Player challenger) {
        this.challenger = challenger;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Challenge))
            return false;
        Challenge c = (Challenge) o;
        return numTracks == c.numTracks && trackType == c.trackType && maxStrokes == c.maxStrokes
                && timeLimit == c.timeLimit && waterEvent == c.waterEvent && collision == c.collision
                && scoringEnd == c.scoringEnd && scoring == c.scoring
                && challenger.equals(c.challenger) && challenged.equals(c.challenged);
    }
}
