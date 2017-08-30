package agolf;

import java.util.Hashtable;

public class TrackCollection {

    private Hashtable tracks = new Hashtable();


    public void addTrack(String author, String name, String data) {
        String key = author + "\t" + name;
        this.tracks.put(key, data);
    }

    public String getTrack(String author, String name) {
        System.out.println("--------------- GET TRACK");
        String key = author + "\t" + name;
        return (String) this.tracks.get(key);
    }
}
