package org.inurl.xim.core.codec;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.inurl.xim.core.protocol.AcceptPacket;
import org.inurl.xim.core.protocol.Error;
import org.inurl.xim.core.protocol.ErrorPacket;
import org.inurl.xim.core.protocol.HandshakeRequestPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author raylax
 */
public class HandshakeProcessor extends SimpleChannelInboundHandler<HandshakeRequestPacket> {

    private static Logger logger = LoggerFactory.getLogger(HandshakeProcessor.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HandshakeRequestPacket packet) {
        if (handshake(packet)) {
            ctx.pipeline().remove(HandshakeDecoder.class);
            ctx.pipeline().remove(HandshakeProcessor.class);
            ctx.writeAndFlush(new AcceptPacket(packet));
            return;
        }
        ctx.writeAndFlush(new ErrorPacket(Error.AUTHORIZATION_FAILURE));
        ctx.close();
    }

    private boolean handshake(HandshakeRequestPacket packet) {
        logger.warn(JSON.toJSONString(packet));
        return true;
    }

}
