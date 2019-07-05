package org.inurl.xim.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;
import org.inurl.xim.core.protocol.Constant;
import org.inurl.xim.core.protocol.ErrorPacket;
import org.inurl.xim.core.protocol.HandshakeRequestPacket;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandshakeDecoderTest {

    @Test
    public void decode() {
        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(Constant.PACKET_TYPE_HANDSHAKE);
        buf.writeInt(0xff);
        buf.writeBytes("hello".getBytes());
        EmbeddedChannel channel = new EmbeddedChannel(new LoggingHandler(), new HandshakeDecoder());
        channel.writeInbound(buf.retain());
        HandshakeRequestPacket packet = channel.readInbound();
        assertNotNull(packet);
        assertEquals(0xff, packet.getFlags());
        assertEquals("hello", packet.getToken());
    }

    @Test
    public void decode1() {
        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(Constant.PACKET_TYPE_MESSAGE);
        buf.writeInt(0xff);
        buf.writeBytes("hello".getBytes());
        EmbeddedChannel channel = new EmbeddedChannel(new LoggingHandler(), new HandshakeDecoder(), new ErrorPacketEncoder());
        channel.writeInbound(buf.retain());
        ErrorPacket packet = channel.readOutbound();
        assertNotNull(packet);
    }

}