package org.inurl.xim.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;
import org.inurl.xim.core.protocol.Error;
import org.inurl.xim.core.protocol.ErrorPacket;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorPacketEncoderTest {

    @Test
    public void encode() {
        EmbeddedChannel channel = new EmbeddedChannel(new LoggingHandler(), new ErrorPacketEncoder());
        channel.writeOutbound(new ErrorPacket(Error.NOT_HANDSHAKE));
        ByteBuf byteBuf = channel.readOutbound();
        assertEquals(byteBuf.readByte(), Byte.MAX_VALUE);
        assertEquals(byteBuf.readInt(), 0);
        byteBuf.readBytes(36);
        assertEquals(byteBuf.readInt(), Error.NOT_HANDSHAKE.getValue());
    }

}