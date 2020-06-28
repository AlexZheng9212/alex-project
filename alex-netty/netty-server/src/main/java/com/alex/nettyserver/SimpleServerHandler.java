package com.alex.nettyserver;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4J2LoggerFactory;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {
  private final static InternalLogger LOGGER = Log4J2LoggerFactory.getInstance(SimpleServerHandler.class);

  // read data
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    simpleRead(ctx, msg);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    LOGGER.info("Server has read data completed");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    LOGGER.info("Server got error");
    ctx.close();
  }

  private void simpleRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
    ByteBuf byteBuf = (ByteBuf) msg;
    byte[] req = new byte[byteBuf.readableBytes()];
    byteBuf.readBytes(req);
    String reqStr = new String(req);
    LOGGER.info("server recive data: {}", reqStr);
    String responseStr = new StringBuilder("From Server Response").append(reqStr).toString();
    ctx.writeAndFlush(Unpooled.copiedBuffer(responseStr.getBytes()));
  }
}