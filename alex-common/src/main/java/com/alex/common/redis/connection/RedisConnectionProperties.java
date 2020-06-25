package com.alex.common.redis.connection;

import java.util.Set;

import lombok.Data;

@Data
public class RedisConnectionProperties {
  private String singleServerAddress;
  private String masterServerAddress;
  private Set<String> slaveServerAddresses;
}
