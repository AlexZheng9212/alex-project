package com.alex.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4J2LoggerFactory;

public class SimpleServer {
    private final static InternalLogger LOGGER = Log4J2LoggerFactory.getInstance(SimpleServer.class);
    private int port;
    private ChannelFuture cf;

    public SimpleServer(int port) {
        this.port = port;
    }

    public void action() throws InterruptedException {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap sbs = new ServerBootstrap();
            sbs.group(mainGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 20)
                    .childOption(ChannelOption.SO_KEEPALIVE, true).handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(initializer());
            LOGGER.info("Server start.....");
            cf = bindPort(sbs);

        } catch (Exception e) {
            LOGGER.error(e.toString());
            closeConnect(cf);
        }
        // finally {
        // LOGGER.info("finally~~~");
        // mainGroup.shutdownGracefully();
        // workerGroup.shutdownGracefully();
        // }
    }

    private ChannelFuture bindPort(ServerBootstrap sbs) throws InterruptedException {
        return sbs.bind(port).sync();
    }

    private void closeConnect(ChannelFuture cf) throws InterruptedException {
        cf.channel().closeFuture().sync();
    }

    private ChannelInitializer<SocketChannel> initializer() {
        return new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new SimpleServerHandler());
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        new SimpleServer(7771).action();
    }
}
