package com.alex.common.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

public class RedisUtils {
  private RedissonClient client;

  public RedisUtils() {
  }

  public RedisUtils(RedissonClient client) {
    this.client = client;
  }

  public void put(String key, String value) {
    RBucket<String> bucket = client.getBucket(key);
    bucket.trySet(value);
  }

  public void put(String key, String value, Long ttl, TimeUnit timeUnit) {
    RBucket<String> bucket = client.getBucket(key);
    bucket.trySet(value, ttl, timeUnit);
  }

  public void putList(String key, List<String> values) {
    RList<String> rlist = client.getList(key);
    values.stream().forEach((it) -> rlist.add(it));
  }

  public void putList(String key, List<String> values, Long ttl, TimeUnit timeUnit) {
    RList<String> rlist = client.getList(key);
    values.stream().forEach((it) -> rlist.add(it));
    rlist.expire(ttl, timeUnit);
  }

  public Object get(String key) {
    return client.getBucket(key).get();
  }
}