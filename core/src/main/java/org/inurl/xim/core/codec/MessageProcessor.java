package org.inurl.xim.core.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.inurl.xim.core.protocol.MessageRequestPacket;

/**
 * @author raylax
 */
public class MessageProcessor extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket packet) {

    }

}
