package org.inurl.xim.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author raylax
 */
class Server {

    private String host;
    private int port;
    private Channel serverChannel;

    Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    void start() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new LoggingHandler());
            }
        });
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture channelFuture = bootstrap.bind(host, port).syncUninterruptibly();
        if (channelFuture.isSuccess()) {
            serverChannel = channelFuture.channel();
        }
    }

    void stop() {
        if (serverChannel != null) {
            serverChannel.close();
        }
    }

}
