package com.alex.common.rabbitmq.event;

public interface MessageHandler<T> {
  void handleMessage(String routing, T message);
}