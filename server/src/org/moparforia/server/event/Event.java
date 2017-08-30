package org.moparforia.server.event;

import org.moparforia.server.Server;

public abstract class Event {

    public boolean shouldProcess(Server server) {
        return true;
    }

    public abstract void process(Server server);

}
