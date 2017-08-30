package org.moparforia.server.event;

import org.moparforia.server.Server;
import org.moparforia.server.net.Packet;
import org.moparforia.server.net.PacketHandler;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class PacketReceivedEvent extends Event {

    private final Packet packet;

    public PacketReceivedEvent(Packet packet) {
        this.packet = packet;
    }

    @Override
    public void process(Server server) {
        if (!processMessage(server, packet)) {
            System.out.println("Unhandled packet: " + packet);
        }
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private static boolean processMessage(Server server, Packet packet) {
        // todo: smarter, should this method be on the server class ?
        ArrayList<PacketHandler> handlers = server.getPacketHandlers(packet.getType());
        //todo packethandlers for each game type
        boolean processed = false;
        if (handlers != null)
            for (PacketHandler ph : handlers) {
                Matcher matcher = ph.getPattern().matcher(packet.getMessage());
                if (matcher.matches() && ph.handle(server, packet, matcher)) {
                    processed = true;
                }
            }
        return processed;
    }

}
