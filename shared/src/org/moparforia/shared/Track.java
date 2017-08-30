package org.moparforia.shared;

import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.util.Arrays;

/**
 * track shit
 */
@Entity(value="tracks", noClassnameStored=true)
public class Track {

    @Id
    public ObjectId id;

    @Property("name")
    private String trackName;
    @Property("author")
    private String author;
    @Property("data")
    private String trackData;
    @Property("category")
    private int category;

    @Property("num_completions")
    private int totalNumberOfAttempts;
    @Property("num_strokes")
    private int totalStrokes;
    @Property("num_best_strokes")
    private int bestPar;
    @Property("num_best_players")
    private int numberOfBestPar;

    @Property("first_best_name")
    private String firstBestPlayer;
    @Property("first_best_time")
    private long firstBestTime;
    @Property("last_best_name")
    private String lastBestPlayer;
    @Property("last_best_time")
    private long lastBestTime;
    @Property("ratings")
    private int[] ratings;

    /**
     * man thats an ugly constructor
     *
     * @param name        name of this track
     * @param author      the author homie that wrote this track
     * @param data        the track data string
     * @param scoreInfo   totalattempts=[0] completions=[1]
     *                    bestPar[2] numberOfBestPar[3]
     * @param bestPlayers first[0] last[1]
     * @param bestTimes   first[0] last[1]
     * @param ratings     should be a 10 element array with with number of votes 1-10 in each.
     */
    public Track(String name, String author, String data, int category, int[] scoreInfo,
                 String[] bestPlayers, long[] bestTimes, int[] ratings) {
        this.trackName = name;
        this.author = author;
        this.trackData = data;
        this.category = category;
        this.totalNumberOfAttempts = scoreInfo[0];
        this.totalStrokes = scoreInfo[1];
        this.bestPar = scoreInfo[2];
        this.numberOfBestPar = scoreInfo[3];
        this.firstBestPlayer = bestPlayers[0];
        this.lastBestPlayer = bestPlayers[1];
        this.firstBestTime = bestTimes[0];
        this.lastBestTime = bestTimes[1];
        this.ratings = ratings;
    }

    public Track(String name, String author, String data, int category) {
        this.trackName = name;
        this.author = author;
        this.trackData = data;
        this.category = category;
    }

    public Track() {
        this("mophiatest", "fc", "data",
                7, new int[]{0, 0, 0, 0}, new String[]{"", ""}, new long[]{0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public static Track fromDb(BasicDBObject object) throws Exception{
        String name = object.getString("name");
        String author = object.getString("author");
        int category;
        try {
            category = object.getInt("category");
        } catch (Exception e) {
            category = 7;
        }
        String data = object.getString("data");

        int numCompletions = object.getInt("num_completions");
        int numAttempts = object.getInt("num_strokes");
        int bestPar = object.getInt("num_best_strokes");
        int numBestPar = object.getInt("num_best_players");

        int[] scoreInfo = new int[]{numCompletions, numAttempts, bestPar, numBestPar};

        String firstBestPlayer = object.getString("first_best_name");
        String lastBestPlayer = object.getString("last_best_name");
        String[] bestPlayers = new String[]{firstBestPlayer, lastBestPlayer};

        long firstBestTime = object.getLong("first_best_time");
        long lastBestTime = object.getLong("last_best_time");
        long[] bestTimes = new long[]{firstBestTime, lastBestTime};

        BasicDBList ratings = (BasicDBList) object.get("ratings");
        return new Track(name, author, data, category, scoreInfo, bestPlayers, bestTimes, Tools.toIntArray(ratings));
    }


    /**
     * new Track(1,"Boats and hoes","fc","B3A48DE48DE48DE48DE48DE48DEBAQQ46D3EG13DEG14DEG13D5E13DEE14DEE13D5E13DEE14DEE13D5E13DEE14DEE13D5E13DEE6DBMAQE6DEE13D5ECAAE11DEE6DBAQQE6DEE11DCBA6E13DBOAQE6DEE6DBOAQE13D5E21DEE21D5E21DEE21D5E21DEE21D5E21DEE21D4E46DEE48DE48DE48DE48DE48DE48D",
     * new int[]{2629492,7166639,2,1191141},new String[] {"fc","Tiikoni"}, new int[]{1034197200000,1370170660930},
     * new int[]{1630,567,647,835,1148,3945,3755,3346,2924,2672,21566});
     */

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return trackName;
    }

    public String getAuthor() {
        return author;
    }

    public String getData() {
        return trackData;
    }

    public int getCategory() {
        return category;
    }

    public String getMap() {
        return trackData;
    }

    public void setMap(String data) {
        this.trackData = data;
    }

    public int getBestPar() {
        return bestPar;
    }

    public int getNumberOfBestPar() {
        return numberOfBestPar;
    }

    public String getFirstBestPlayer() {
        return firstBestPlayer;
    }

    public long getFirstBestTime() {
        return firstBestTime;
    }

    public String getLastBestPlayer() {
        return lastBestPlayer;
    }

    public long getLastBestTime() {
        return lastBestTime;
    }

    public int getTotalStrokes() {
        return totalStrokes;
    }

    public void addStrokes(int numberOfPlayers, int strokesToAdd) {
        totalNumberOfAttempts += numberOfPlayers;
        totalStrokes += strokesToAdd;
    }

    public void incBestPar() {
        numberOfBestPar++;
    }

    public void rate(String rating) {
        ratings[Integer.parseInt(rating) - 1]++;
    }

    public void addRecord(String nick, int par, long time, boolean newRecord) {
        System.out.println("add record: " + getName() + " by " + nick + " by getting a " + par);

        if (newRecord) {
            numberOfBestPar = 0;
            this.firstBestPlayer = nick;
            this.firstBestTime = time;
            this.bestPar = par;
        } else {
            this.lastBestPlayer = nick;
            this.lastBestTime = time;
        }
    }

    public void resetStats() {
        Arrays.fill(ratings, 0);
        firstBestPlayer = "";
        lastBestPlayer = "";
        firstBestTime = 0;
        lastBestTime = 0;
    }

    private String ratingsToString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < ratings.length - 1; i++) {
            buffer.append(ratings[i]).append(",");
        }
        return buffer.toString() + ratings[ratings.length - 1];
    }

    /**
     * {track ID}
     * V 1
     * A {AUTHOR OF TRACK}
     * N {NAME OF TRACK}
     * T data
     * I {NUMBER OF PLAYERS TO COMLETE},{NUMBER OF shots?},{BEST NUMBER OF STROKES},{NUMBER OF PEOPLE THAT GOT BEST STROKE}
     * B {FIRST BEST PAR PLAYER},{UNIX TIMESTAMP OF FIRST BEST PAR}000
     * L {LAST BEST PAR PLAYER},{UNIX TIMESTAMP OF LAST BEST PAR}000
     * R {RATING: 0},{RATING: 1},{RATING: 2},{RATING: 3},{RATING: 4},{RATING: 5},{RATING: 6},{RATING: 7},{RATING: 8},{RATING: 9},{RATING: 10}
     */
    @Override
    public String toString() {
        if (firstBestPlayer == null || lastBestPlayer == null ||
                firstBestPlayer.equals("") || lastBestPlayer.equals("")) { // no top score!??!?
            return Tools.tabularize(
                    "V 1",
                    "A " + author,
                    "N " + trackName,
                    "T " + trackData,
                    "I " + Tools.commaize(totalNumberOfAttempts, totalStrokes, bestPar, numberOfBestPar),
                    "R " + ratingsToString());
        }
        return Tools.tabularize(
                "V 1",
                "A " + author,
                "N " + trackName,
                "T " + trackData,
                "I " + Tools.commaize(totalNumberOfAttempts, totalStrokes, bestPar, numberOfBestPar),
                "B " + Tools.commaize(firstBestPlayer, firstBestTime),
                "L " + Tools.commaize(lastBestPlayer, lastBestTime),
                "R " + ratingsToString());
    }

    /**
     * {track ID}
     * V 1
     * A {AUTHOR OF TRACK}
     * N {NAME OF TRACK}
     * T data
     */
    public String toSaveString() {
        return Tools.tabularize(
                "V 1",
                "A " + author,
                "N " + trackName,
                "T " + trackData);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Track)) {
            return false;
        }
        Track t = (Track) o;
        return trackName.equals(t.trackName) && author.equals(t.author);
    }
}