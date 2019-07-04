package org.inurl.xim.core.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.inurl.xim.core.protocol.Message;

/**
 * @author raylax
 */
public class MessageProcessor extends SimpleChannelInboundHandler<Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) {

    }

}
