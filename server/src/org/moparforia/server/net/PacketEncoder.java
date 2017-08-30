package org.moparforia.server.net;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.CharsetUtil;

import static org.jboss.netty.buffer.ChannelBuffers.copiedBuffer;

public class PacketEncoder extends OneToOneEncoder {

    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        if (msg instanceof Packet) {
            Packet packet = (Packet) msg;
            String encoded;
            if (packet.getType() != PacketType.NONE) {
                encoded = packet.getType().toString().toLowerCase().charAt(0) + " ";
                if (packet.getType() == PacketType.DATA) {
                    long count = ClientState.sentCount.get(channel);
                    encoded += count + " ";
                    ClientState.sentCount.set(channel, count + 1);
                }
            } else {
                encoded = "";
            }
            encoded += packet.getMessage() + '\n';
            return copiedBuffer(ctx.getChannel().getConfig().getBufferFactory().getDefaultOrder(), encoded, CharsetUtil.UTF_8);
        } else if (msg instanceof String) {
            String m = (String) msg;
            if (!m.endsWith("\n")) {
                m += "\n";
            }
            if (m.startsWith("d ")) {
                long count = ClientState.sentCount.get(channel);
                m = "d " + count + " " + m.substring(2);
                ClientState.sentCount.set(channel, count + 1);
            }
            return copiedBuffer(ctx.getChannel().getConfig().getBufferFactory().getDefaultOrder(), m, CharsetUtil.UTF_8);
        }
        return msg;
    }

}
