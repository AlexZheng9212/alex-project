package com.alex.common.redis.connection;

import java.util.Set;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

// import static com.alex.common.lang.Codecs.NO_NULL_FIELD_ORDERED_MAPPER;

public class RedisConnection {
  public static RedissonClient connectSingleServer(String address) {
    Config config = new Config();
    config.useSingleServer().setAddress(address);
    return Redisson.create(config);
  }

  public static RedissonClient connectMasterSlaveServer(String masterAddress, Set<String> slaveAddresses) {
    Config config = new Config();
    config.useMasterSlaveServers().setMasterAddress(masterAddress).setSlaveAddresses(slaveAddresses);
    config.setCodec(new StringCodec("UTF-8"));
    return Redisson.create(config);
  }

  // TODO public static RedissonClient connectClusterServer(){}
}