package com.alex.blog.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alex.common.rabbitmq.connection.RabbitConnectionProperties;
import com.alex.common.rabbitmq.connection.RabbitFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
  @Autowired
  private ApiProperties apiProperties;

  @Bean
  public RabbitConnectionProperties rabbitConnectionProperties() {
    return apiProperties.getRabbitConnection();
  }

  @Bean
  public Connection connection(RabbitConnectionProperties rabbitConnectionProperties) {
    ExecutorService executorService = Executors.newScheduledThreadPool(16);
    Connection connection = RabbitFactory.createRabbitConnection(rabbitConnectionProperties, executorService);
    try {
      Channel channel = connection.createChannel();
      channel.basicQos(rabbitConnectionProperties.getPrefetchCount());
      channel.close();
      return connection;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}