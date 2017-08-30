package org.moparforia.server.net.packethandlers;

import org.moparforia.server.Server;
import org.moparforia.server.net.Packet;
import org.moparforia.server.net.PacketHandler;
import org.moparforia.server.net.PacketType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TlogHandler implements PacketHandler {

    @Override
    public PacketType getType() {
        return PacketType.STRING;
    }

    @Override
    public Pattern getPattern() {
        return Pattern.compile("tlog\\t(\\d+)\\tclientconnect\\tloadtime:i:\\d+\\^loadertime:i:\\d+");
    }

    @Override
    public boolean handle(Server server, Packet packet, Matcher message) {
        return true;
    }

}
