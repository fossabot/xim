package org.inurl.xim.core.codec;

import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;
import org.inurl.xim.core.protocol.HandshakeRequestPacket;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandshakeProcessorTest {

    @Test
    public void channelRead0() {
        EmbeddedChannel channel = new EmbeddedChannel(new LoggingHandler(), new HandshakeDecoder(), new HandshakeProcessor());
        channel.writeInbound(new HandshakeRequestPacket());
        assertNull(channel.pipeline().get(HandshakeDecoder.class));
        assertNull(channel.pipeline().get(HandshakeProcessor.class));
    }

}