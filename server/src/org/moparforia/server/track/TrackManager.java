package org.moparforia.server.track;

import com.github.jmkgreen.morphia.Datastore;
import org.moparforia.server.db.Database;
import org.moparforia.server.game.Player;
import org.moparforia.shared.Track;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Playforia
 * 18.6.2013
 */
public class TrackManager {

    private static ArrayList<Track> tracks;
    private static ArrayList<TrackSet> trackSets;
    private static boolean hasLoaded;
    private static final ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();;


    public final void load() throws IOException {
        tracks = new ArrayList<Track>();
        loadTracks();
        loadTrackSets();
        hasLoaded = true;
        schedule.scheduleAtFixedRate(new TrackUpdater(),5,5,TimeUnit.MINUTES);
    }

    private class TrackUpdater implements Runnable {

        @Override
        public void run() {
            Datastore ds = Database.getInstance().getDatastore();
            ArrayList<Track> list = (ArrayList<Track>) ds.find(Track.class).asList();
            int oldSize = tracks.size();
            for(Track t : list) {
                if(!tracks.contains(t)) {
                    tracks.add(t);
                }
            }

            System.out.println("Added "+ (tracks.size() - oldSize) +" tracks.");
        }
    }


    private static final void loadTracks() {
        Datastore ds = Database.getInstance().getDatastore();
        ArrayList<Track> list = (ArrayList<Track>) ds.find(Track.class).asList();
        tracks.addAll(list);
        System.out.println("Loaded "+tracks.size()+" tracks.");
    }

    public static void addStrokes(Track track, int numPlayers, int strokes) {
        tracks.get(tracks.indexOf(track)).addStrokes(numPlayers, strokes);
    }

    public static void save(Track track) {
        Database.getInstance().getDatastore().save(track);
    }

    public static void updateStats(Track track, Player player, int par, boolean newRecord) {
        int index = tracks.indexOf(track);
        long time = (System.currentTimeMillis() / 1000L) * 1000;

        if (newRecord) {
            tracks.get(index).addRecord(player.getNick(), par, time, true);
        }

        tracks.get(index).addRecord(player.getNick(), par, time, false);
        tracks.get(index).incBestPar();

    }

/*    private static final void loadTracks() throws IOException {
        // only problem i can think of is that this will overwrite maps with the same name in a type
        tracks = new ArrayList<TrackRef>();
        FileSystem fs = FileSystems.getDefault();
        int counter = 0;
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
                int[] scoreInfo = null, ratings = null;
                String[] bestPlayers = null, dummy = null;
                long[] bestTimes = null;
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
                    } else if (line.startsWith("I ")) {
                        dummy = line.substring(2).split(",");
                        scoreInfo = new int[dummy.length];
                        for (int i = 0; i < dummy.length; i++) {
                            scoreInfo[i] = Integer.parseInt(dummy[i]);
                        }
                    } else if (line.startsWith("B ") || line.startsWith("L ")) {
                        dummy = line.substring(2).split(",");
                        bestPlayers = new String[dummy.length];
                        bestTimes = new long[dummy.length];
                        int idx = line.startsWith("B ") ? 0 : 1;
                        bestPlayers[idx] = dummy[0];
                        bestTimes[idx] = Long.valueOf(dummy[1]);
                    } else if (line.startsWith("R ")) {
                        dummy = line.substring(2).split(",");
                        ratings = new int[dummy.length];
                        for (int i = 0; i < dummy.length; i++) {
                            ratings[i] = Integer.valueOf(dummy[i]);
                        }
                    }
                }
                String filename = filePath.getFileName().toString();
                filename = filename.substring(0, filename.lastIndexOf('.'));
                tracks.add(new TrackRef(filename, type, new Track(name, author, data, type.getId(), scoreInfo, bestPlayers, bestTimes, ratings), getTrackInfo(filename)));
            }
        }
        System.out.println("Loaded " + tracks.size() + " tracks");
    }*/

    private static final void loadTrackSets() throws IOException {
        if (tracks == null) {
            return;
        }
        trackSets = new ArrayList<TrackSet>();
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
                if (!line.isEmpty()) {
                    fileNames.add(line);
                }
            }
            trackSets.add(new TrackSet(setName, trackSetDifficulty, fileNames));
        }
        System.out.println("Loaded " + trackSets.size() + " track sets");
    }


    public static final ArrayList<Track> getRandomTracks(int number, TrackCategory type) {
        if (number < 1 || number > 20) {
            return null;
        }
        ArrayList<Track> usedTracks = new ArrayList<Track>();// horrible
        for (Track track : tracks) {
            if (TrackCategory.getByTypeId(track.getCategory()) == TrackCategory.ALL || TrackCategory.getByTypeId(track.getCategory()) == type) {
                usedTracks.add(track);
            }
        }
        ArrayList<Track> randomTracks = new ArrayList<Track>(number);
        for (int i = 0; i < number; i++) {
            Track track = usedTracks.get((new Random()).nextInt(usedTracks.size()));
            while (randomTracks.contains(track)) {
                track = usedTracks.get((new Random()).nextInt(usedTracks.size()));
            }
            randomTracks.add(track);
        }
        return randomTracks;
    }

    public static final ArrayList<Track> getTrackSet(int setId) {
        return new ArrayList<Track>();
    }

    public static final ArrayList<TrackSet> getTrackSets() {
        return new ArrayList<TrackSet>();
    }

    public boolean hasLoaded() {
        return hasLoaded;
    }
}
