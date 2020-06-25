package com.alex.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class HttpServer {
  private ChannelFuture cf;
  private int port;
  private final EventLoopGroup mainGroup;
  private final EventLoopGroup workerGroup;

  public HttpServer(int port) {
    this.port = port;
    mainGroup = new NioEventLoopGroup();
    workerGroup = new NioEventLoopGroup();
  }

  public void action() throws InterruptedException {
    try {
      ServerBootstrap sbs = new ServerBootstrap();
      sbs.group(mainGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 20)
          .childOption(ChannelOption.SO_KEEPALIVE, true).handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(initializer());
      cf = bindPort(sbs);

    } catch (Exception e) {
      e.printStackTrace();
      closeConnection(cf);
    }
  }

  private ChannelInitializer<SocketChannel> initializer() {
    return new ChannelInitializer<SocketChannel>() {
      @Override
      protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("codec", new HttpServerCodec());
        ch.pipeline().addLast("aggregator", new HttpObjectAggregator(512 * 1024));
        ch.pipeline().addLast(new HttpServerHandler());
      }
    };
  }

  private ChannelFuture bindPort(ServerBootstrap sbs) throws InterruptedException {
    return sbs.bind(port).sync();
  }

  private void closeConnection(ChannelFuture cf) throws InterruptedException {
    cf.channel().close().sync();
  }

  public static void main(String[] args) throws InterruptedException {
    new HttpServer(7772).action();
  }
}