package com.alex.blog.service;

import com.alex.blog.temp.TestMsg;
import com.alex.common.rabbitmq.event.GenericPublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
  private final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

  private final static String DEFAULT_EXCHANGE = "TEST_EXCHANGE";

  @Autowired
  private GenericPublisher<Object> testPublisher;

  @Async("publisherThreadPool")
  public void sendMsg() {
    try {
      testPublisher.publishEvent(DEFAULT_EXCHANGE, new TestMsg());
    } catch (Exception e) {
      LOGGER.error("publish event failed. error stack: \n {}", e.toString());
    }
  }
}
