package org.inurl.xim.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.inurl.xim.core.protocol.Constant;
import org.inurl.xim.core.protocol.Error;
import org.inurl.xim.core.protocol.ErrorPacket;
import org.inurl.xim.core.protocol.HandshakeRequestPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author raylax
 */
public class HandshakeDecoder extends ByteToMessageDecoder {

    private static Logger logger = LoggerFactory.getLogger(HandshakeDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) {
        int packetType = byteBuf.readByte();
        if (packetType != Constant.PACKET_TYPE_HANDSHAKE) {
            ctx.writeAndFlush(new ErrorPacket(Error.NOT_HANDSHAKE));
            return;
        }
        HandshakeRequestPacket packet = new HandshakeRequestPacket();
        int flags = byteBuf.readInt();
        packet.setFlags(flags);
        int count = byteBuf.readableBytes();
        byte[] data = new byte[count];
        byteBuf.readBytes(data);
        packet.setToken(new String(data));
        out.add(packet);
    }

}
