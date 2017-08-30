package org.moparforia.server.event;

import org.moparforia.server.Server;

@SuppressWarnings("SameParameterValue")
public abstract class TimedEvent extends Event {

    private final long time;

    public TimedEvent(long time) {
        this.time = System.currentTimeMillis() + time;
    }

    @Override
    public boolean shouldProcess(Server server) {
        return System.currentTimeMillis() > time;
    }

    @Override
    public abstract void process(Server server);

}
