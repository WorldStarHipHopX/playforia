package org.moparforia.server.util;

/**
 * Created with IntelliJ IDEA.
 * User: Uncalled For
 * Date: 17/08/13
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
public class StatResetter {

    /*
    public static void main(String[] args) {
        DBCollection tracks = Database.getInstance().getDatabase().getCollection("tracks");
                DBCursor query = tracks.find(new BasicDBObject("category", 7));
             try {
                 while(query.hasNext()) {
                     BasicDBObject track = (BasicDBObject)query.next();

                     Database.getInstance().track_update(track,"num_completions",0);
                     Database.getInstance().track_update(track,"num_strokes",0);
                     Database.getInstance().track_update(track,"first_best_name","");
                     Database.getInstance().track_update(track,"last_best_name","");
                     Database.getInstance().track_update(track,"first_best_time",0);
                     Database.getInstance().track_update(track,"last_best_time",0);
                     Database.getInstance().track_update(track,"num_best_strokes",0);
                     Database.getInstance().track_update(track,"num_best_players",0);
                     System.out.println("ok");

                 }
             } finally {
                 query.close();
             }
             System.out.println("Updated " + tracks.getCount() + " tracks.");
    }
    */
}
