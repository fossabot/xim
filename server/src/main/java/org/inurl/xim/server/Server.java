package org.inurl.xim.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.inurl.xim.core.codec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author raylax
 */
class Server {

    private static Logger logger = LoggerFactory.getLogger(Server.class);

    private String host;
    private int port;
    private NioEventLoopGroup bossGroup;
    private NioEventLoopGroup workGroup;
    private boolean stopping = false;

    Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    void start() {
        logger.info("Starting server");
        bossGroup = new NioEventLoopGroup();
        workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new LoggingHandler());
                ch.pipeline().addLast(new HandshakeDecoder());
                ch.pipeline().addLast(new HandshakeProcessor());
                ch.pipeline().addLast(new AcceptPacketEncoder());
                ch.pipeline().addLast(new ErrorPacketEncoder());
            }
        });
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture channelFuture = bootstrap.bind(host, port).syncUninterruptibly();
        if (channelFuture.isSuccess()) {
            logger.info("Server started, listening on {}:{}", host, port);
            return;
        }
        logger.error("Failed to start server");
    }

    void stop() {
        if (stopping) {
            return;
        }
        stopping = true;
        logger.info("Stopping server");
        if (workGroup != null) {
            workGroup.shutdownGracefully();
        }
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
        }
        logger.info("Server stopped");
    }

}
