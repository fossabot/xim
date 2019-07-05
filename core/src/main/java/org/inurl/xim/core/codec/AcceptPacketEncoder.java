package org.inurl.xim.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.inurl.xim.core.protocol.AcceptPacket;

/**
 * @author raylax
 */
public class AcceptPacketEncoder extends MessageToByteEncoder<AcceptPacket> {

    @Override
    protected void encode(ChannelHandlerContext ctx, AcceptPacket packet, ByteBuf out) {
        out.writeByte(packet.getPacketType());
        out.writeInt(packet.getFlags());
        out.writeBytes(packet.getTrackId().getBytes());
        out.writeInt((int) (packet.getTimes() - System.currentTimeMillis()));
    }

}
