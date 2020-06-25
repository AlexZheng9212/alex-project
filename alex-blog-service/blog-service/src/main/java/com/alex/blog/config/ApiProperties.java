package com.alex.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

import com.alex.common.rabbitmq.connection.RabbitConnectionProperties;
import com.alex.common.redis.connection.RedisConnectionProperties;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
@Data
public class ApiProperties {
  private RedisConnectionProperties redisConnection = new RedisConnectionProperties();

  private RabbitConnectionProperties rabbitConnection = new RabbitConnectionProperties();

  private String env;
}
