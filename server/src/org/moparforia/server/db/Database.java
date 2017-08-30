package org.moparforia.server.db;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.mongodb.*;
import org.moparforia.server.util.SHA1;
import org.moparforia.shared.Track;

/**
 * User: Johan
 * Date: 2013-08-05
 * Time: 12:13
 */
public class Database {

    private static Morphia morph;
    private static Mongo mongo;

    private static final Database INSTANCE;
    private static boolean authenticated = false;
    private static Datastore ds;

    private Database() {
        try {
            mongo = new Mongo("ds033828.mongolab.com", 33828);
            morph = new Morphia();
            morph.map(Track.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public DB getDatabase() {
        DB db = mongo.getDB("heroku_app16743823");

        if (!authenticated && !db.authenticate("moparforia", "Ub72LjsfRe".toCharArray())) {
            System.out.println("Database Authentication failed!");
                   return null;
               }
               authenticated = true;
               return db;
    }

    public Datastore getDatastore() {
        if(!authenticated) {
            ds = morph.createDatastore(mongo, "heroku_app16743823","moparforia","Ub72LjsfRe".toCharArray());
            authenticated = true;
        } else if(authenticated && ds == null) {
            ds = morph.createDatastore(mongo,"heroku_app16743823");
        }

        return ds;
    }

    public BasicDBObject entryFor(Track track) {
        DBCollection tracks = getDatabase().getCollection("tracks");
        DBCursor t = tracks.find(new BasicDBObject("data", track.getMap()));
        if (t.count() >= 1) {
            return (BasicDBObject) t.next();
        }
        return null;
    }

    private boolean authenticate(String authMethod, String email, String password) {
        DBCollection users = getDatabase().getCollection("mm_users");
        DBCursor query = users.find(new BasicDBObject(authMethod, email));
        if (query.count() == 1) {
            BasicDBObject user = (BasicDBObject) query.next();
            String salt = user.getString("salt");
            try {
                if (SHA1.hexdigest(password + salt).equals(user.getString("hashed_password"))) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean authenticateEmail(String email, String password) {
        return authenticate("email", email, password);
    }

    public boolean authenticateUser(String user, String password) {
        return authenticate("username", user, password);
    }


    public static void main(String[] args) {
        DBCollection tracks = getInstance().getDatabase().getCollection("tracks");

    }

    static {
        INSTANCE = new Database();
    }

}
