package org.moparforia.server.util;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.moparforia.shared.Track;
import org.moparforia.server.db.Database;
import org.moparforia.server.track.TrackCategory;
import org.moparforia.server.track.TrackSet;
import org.moparforia.server.track.TrackSetDifficulty;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User: Johan
 * Date: 2013-08-09
 * Time: 08:35
 */
public class StockTrackUploader {

    private static ArrayList<Track> tracks;

    public static void main(String[] args) {
        try {
            loadTracks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadTracks() throws IOException {
        tracks = new ArrayList<Track>();
        FileSystem fs = FileSystems.getDefault();
        for (TrackCategory type : TrackCategory.values()) {
            if (type == TrackCategory.ALL || type == TrackCategory.CUSTOM || type == TrackCategory.UNKNOWN) {
                continue;
            }
            Path tracksPath = fs.getPath("tracks", type.getDir());
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(tracksPath, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return entry.toString().endsWith(".track");
                }
            });
            for (Path filePath : directoryStream) {
                String name = null, author = null, data = null;
                Scanner scanner = new Scanner(filePath);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.startsWith("V ")) {
                        // hi
                    } else if (line.startsWith("S ")) {
                        // hi? get on it, watson
                    } else if (line.startsWith("A ")) {
                        author = line.substring(2);
                    } else if (line.startsWith("N ")) {
                        name = line.substring(2);
                    } else if (line.startsWith("T ")) {
                        data = line.substring(2);
                    }
                }
                tracks.add(new Track(name, author, data, type.getId()));
            }
        }
        uploadTracks();
        System.out.println("Done.");
    }

    private static final void loadTrackSets() throws IOException {
        if (tracks == null) {
            return;
        }
        ArrayList<TrackSet> trackSets = new ArrayList<TrackSet>();
        FileSystem fs = FileSystems.getDefault();
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(fs.getPath("tracks", "sets"), new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return entry.getFileName().toString().endsWith(".trackset");
            }
        });
        for (Path filePath : directoryStream) {
            Scanner scanner = new Scanner(filePath);
            String setName = scanner.nextLine();
            TrackSetDifficulty trackSetDifficulty = TrackSetDifficulty.valueOf(scanner.nextLine());
            ArrayList<String> fileNames = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if(!line.isEmpty()) {
                    fileNames.add(line);
                }
            }
            trackSets.add(new TrackSet(setName, trackSetDifficulty, fileNames));
        }
        uploadTrackSets(trackSets);
    }

    private static void uploadTracks() {
        ArrayList<DBObject> _tracks = new ArrayList<DBObject>();
        for (Track track : tracks){
            _tracks.add(new BasicDBObjectBuilder().append("name", track.getName()).
                    append("author", track.getAuthor()).
                    append("data", track.getData()).
                    append("category", track.getCategory()).
                    append("version", 1).
                    append("num_completions", 0).
                    append("num_strokes", 0).
                    append("num_best_strokes", 0).
                    append("first_best_name", "").
                    append("first_best_time", 0).
                    append("last_best_name", "").
                    append("last_best_time", 0).
                    append("ratings", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}).
                    append("num_best_players", 0).get());
        }
        DBCollection tracks = Database.getInstance().getDatabase().getCollection("tracks");
        tracks.insert(_tracks);
    }

    private static void uploadTrackSets(ArrayList<TrackSet> trackSets) {
        ArrayList<DBObject> _tracks = new ArrayList<DBObject>();
        for (TrackSet track : trackSets){
            _tracks.add(new BasicDBObjectBuilder().append("name", track.getName()).
                    append("difficulty", track.getDifficulty().getId()).
                    append("times_played", 0).
                    append("ratings", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}).get());
        }
        DBCollection tracks = Database.getInstance().getDatabase().getCollection("track_sets");
        tracks.insert(_tracks);
    }
}
