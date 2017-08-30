package org.moparforia.server.net;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.timeout.IdleState;
import org.jboss.netty.handler.timeout.IdleStateAwareChannelHandler;
import org.jboss.netty.handler.timeout.IdleStateEvent;
import org.moparforia.server.Server;
import org.moparforia.server.event.*;

public class ClientChannelHandler extends IdleStateAwareChannelHandler {

    private final Server server;

    public ClientChannelHandler(Server server) {
        this.server = server;
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        Packet packet = (Packet) e.getMessage();
        System.out.println("Niggers: " + e.getMessage());
        server.addEvent(new PacketReceivedEvent(packet));
    }

    @Override
    public void channelIdle(ChannelHandlerContext ctx, IdleStateEvent e) throws Exception {
        if (e.getState() == IdleState.READER_IDLE) {
            long time = System.currentTimeMillis() - e.getLastActivityTimeMillis();
            if (time > 20000) {
                e.getChannel().close();
            } else if (time > 5000) {
                e.getChannel().write("c ping\n");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        //noinspection ThrowableResultOfMethodCallIgnored
        e.getCause().printStackTrace();
        e.getChannel().close();
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        server.addEvent(new ClientConnectedEvent(e.getChannel()));
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        Channel channel = e.getChannel();
        server.addEvent(new ClientDisconnectedEvent(channel));
        final int id = channel.getId();
        if (server.hasPlayer(id)) {
            server.addEvent(new TimedEvent(30000) { // todo: confirm this time
                @Override
                public void process(Server server) {
                    if (server.hasPlayer(id) && !server.getPlayer(id).getChannel().isOpen()) {
                        System.out.println("Player timed-out: " + id);
                        server.addEvent(new PlayerDisconnectEvent(id));
                    }
                }
            });
        }
    }
}
