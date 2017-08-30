package org.moparforia.server.net;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.CharsetUtil;

public class PacketDecoder extends OneToOneDecoder {
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (msg instanceof ChannelBuffer) {
            Packet packet = new Packet(channel, ((ChannelBuffer) msg).toString(CharsetUtil.UTF_8));
            if (packet.getType() == PacketType.DATA) {
                long count = ClientState.recvCount.get(channel);
                if (count == packet.getCount()) {
                    ClientState.recvCount.set(channel, count + 1);
                } else {
                    channel.close();
                    return null;
                }
            }
            return packet;
        }
        return msg;
    }
}
