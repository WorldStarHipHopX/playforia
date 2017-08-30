package org.moparforia.client;

import java.io.*;
import java.util.ArrayList;

/**
 * Playforia
 * 7.7.2013
 */
public class recordz {

    public static final void main(String[] args) throws Exception {
        File[] tracks = listTracks("tracks/");
        BufferedWriter out = new BufferedWriter(new FileWriter("tracks/trackscores.trackscores"));
        for(File trackfile : tracks) {
            BufferedReader in = new BufferedReader(new FileReader(trackfile));
            String stats = null, firstbest = null, lastbest = null, ratings = null;
            for(String line = ""; line != null; line = in.readLine()) {
                if(line.startsWith("I "))
                    stats = line.substring(2);
                else if(line.startsWith("B "))
                    firstbest = line.substring(2);
                else if(line.startsWith("L "))
                    lastbest = line.substring(2);
                else if(line.startsWith("R "))
                    ratings = line.substring(2);
            }
            out.write(trackfile.getName().substring(0, trackfile.getName().length() - 6));
            out.write('|');
            out.write(stats == null ? "" : stats);
            out.write('|');
            out.write(firstbest == null ? "" : firstbest);
            out.write('|');
            out.write(lastbest == null ? "" : lastbest);
            out.write('|');
            out.write(ratings == null ? "" : ratings);
            out.write('\n');
            out.flush();
            in.close();
        }
        out.close();
    }

    private static File[] listTracks(String dir) {
        ArrayList<File> list = new ArrayList<File>();
        File dirfile = new File(dir);
        for(File subdir : dirfile.listFiles()) {
            if(subdir.isDirectory()) {
                for(File file : subdir.listFiles()) {
                    if(file.getName().endsWith(".track")) {
                        list.add(file);
                    }
                }
            }
        }
        return list.toArray(new File[0]);
    }
}
