package org.moparforia.server.net;

import org.moparforia.server.Server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PacketHandler {
    public PacketType getType();

    public Pattern getPattern();

    public boolean handle(Server server, Packet packet, Matcher message);
}
