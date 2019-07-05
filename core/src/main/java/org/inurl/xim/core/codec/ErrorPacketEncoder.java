package org.inurl.xim.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.inurl.xim.core.protocol.ErrorPacket;

/**
 * @author raylax
 */
public class ErrorPacketEncoder extends MessageToByteEncoder<ErrorPacket> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ErrorPacket packet, ByteBuf out) {
        out.writeByte(packet.getPacketType());
        out.writeInt(packet.getFlags());
        out.writeBytes(packet.getTrackId().getBytes());
        out.writeInt(packet.getError().getValue());
    }

}
