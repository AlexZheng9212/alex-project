package com.alex.blog.config;

import com.alex.common.redis.RedisUtils;
import com.alex.common.redis.connection.RedisConnection;
import com.alex.common.redis.connection.RedisConnectionProperties;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

  @Autowired
  private ApiProperties apiProperties;

  @Bean("redisConnectionProperties")
  public RedisConnectionProperties redisConnectionProperties() {
    return apiProperties.getRedisConnection();
  }

  @Bean("singleClient")
  public RedissonClient singleClient(RedisConnectionProperties redisConnectionProperties) {
    String singleServerAddress = redisConnectionProperties.getSingleServerAddress();
    return RedisConnection.connectSingleServer(singleServerAddress);
  }

  @Bean("redisUtils")
  public RedisUtils redisUtils(RedissonClient singleClient) {
    return new RedisUtils(singleClient);
  }
}