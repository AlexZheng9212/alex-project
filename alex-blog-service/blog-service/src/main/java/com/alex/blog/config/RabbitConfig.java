package com.alex.blog.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alex.blog.constant.RabbitConstant;
import com.alex.common.rabbitmq.connection.RabbitConnectionProperties;
import com.alex.common.rabbitmq.connection.RabbitFactory;
import com.alex.common.rabbitmq.event.GenericPublisher;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.alex.common.rabbitmq.utils.RabbitUtils.deployChannel;

@Configuration
public class RabbitConfig {
  private final static String DEFAULT_EXCHANGE = "TEST_EXCHANGE";

  @Autowired
  private ApiProperties apiProperties;

  @Bean("rabbitConnectionProperties")
  public RabbitConnectionProperties rabbitConnectionProperties() {
    return apiProperties.getRabbitConnection();
  }

  @Bean("rabbitConnection")
  public Connection rabbitConnection(RabbitConnectionProperties rabbitConnectionProperties) {
    final String queueName = RabbitConstant.QueueName.TEST_QUEUE_NAME.toString();
    final String exchange = RabbitConstant.QueueExchange.TEST_QUEUE_EXCHANGE.toString();
    ExecutorService executorService = Executors.newScheduledThreadPool(16);
    Connection connection = RabbitFactory.createRabbitConnection(rabbitConnectionProperties, executorService);
    try {
      Channel channel = connection.createChannel();
      channel.basicQos(rabbitConnectionProperties.getPrefetchCount());
      deployChannel(channel, queueName, exchange);
      return connection;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Bean("testPublisher")
  public GenericPublisher<Object> testPublisher(Connection rabbitConnection) {
    return new GenericPublisher<>(rabbitConnection, DEFAULT_EXCHANGE);
  }
}