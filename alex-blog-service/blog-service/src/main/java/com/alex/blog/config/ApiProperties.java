package com.alex.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

import com.alex.common.rabbitmq.connection.RabbitConnectionProperties;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
public class ApiProperties {
  @Setter
  @Getter
  private RabbitConnectionProperties rabbitConnection = new RabbitConnectionProperties();

  @Setter
  @Getter
  private String env;
}