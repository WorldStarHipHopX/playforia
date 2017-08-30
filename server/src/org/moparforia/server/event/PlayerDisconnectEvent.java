package org.moparforia.server.event;

import org.moparforia.server.Server;

public class PlayerDisconnectEvent extends Event {

    private final int id;

    public PlayerDisconnectEvent(int id) {
        this.id = id;
    }

    @Override
    public void process(Server server) {
        System.out.println("Player disconnected: " + id);
        server.getPlayers().remove(id);
        // todo: some shit here like removing them from the game and notifying people in game they're gone and not just dc'd
    }

}
