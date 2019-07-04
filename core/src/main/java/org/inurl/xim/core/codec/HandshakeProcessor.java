package org.inurl.xim.core.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.inurl.xim.core.protocol.Handshake;

/**
 * @author raylax
 */
public class HandshakeProcessor extends SimpleChannelInboundHandler<Handshake> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Handshake msg) {

    }

}
