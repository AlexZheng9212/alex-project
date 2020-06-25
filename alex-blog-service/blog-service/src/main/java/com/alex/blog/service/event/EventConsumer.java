package com.alex.blog.service.event;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.alex.blog.temp.TestMsg;
import com.alex.common.rabbitmq.event.GenericConsumerBuilder;
import com.rabbitmq.client.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
  private final static Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);

  @Autowired
  private Connection connection;

  @PostConstruct
  void init() throws IOException {
    GenericConsumerBuilder<TestMsg> builder = new GenericConsumerBuilder<TestMsg>(TestMsg.class,
        connection.createChannel(), "test queue");
    builder.setMessageHandler(this::handleEvent);
    builder.createGenericConsumer().run();
  }

  private void handleEvent(String routingKey, TestMsg testMsg) {
    LOGGER.info("receive msg: {}, routingKey: {}", testMsg.toString(), routingKey);
  }
}