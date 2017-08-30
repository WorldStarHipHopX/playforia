package org.moparforia.server.net;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelLocal;

public final class ClientState {

    public static final ChannelLocal<Long> sentCount = new ChannelLocal<Long>() {
        @Override
        protected Long initialValue(Channel channel) {
            return 0L;
        }
    };

    public static final ChannelLocal<Long> recvCount = new ChannelLocal<Long>() {
        @Override
        protected Long initialValue(Channel channel) {
            return 0L;
        }
    };

}
