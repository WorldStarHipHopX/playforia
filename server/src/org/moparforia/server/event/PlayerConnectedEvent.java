package org.moparforia.server.event;

import org.moparforia.server.Server;

public class PlayerConnectedEvent extends Event {

    private int id;
    private boolean reconnecting;

    public PlayerConnectedEvent(int id, boolean reconnecting) {
        this.id = id;
        this.reconnecting = reconnecting;
    }

    @Override
    public void process(Server server) {
        System.out.println("Player connected: " + id + ", reconnecting:" + reconnecting);
        // todo: is this event even needed
    }

}
