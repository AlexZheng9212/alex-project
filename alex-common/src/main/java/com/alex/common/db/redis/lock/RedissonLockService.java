package com.alex.common.db.redis.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.alex.common.lock.LockService;
import com.alex.common.lock.NoLockException;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedissonLockService<T> implements LockService<T> {
  private RedissonClient redissonClient;
  private long defaultTimeout;
  private static final Logger logger = LoggerFactory.getLogger(RedissonLockService.class);

  public RedissonLockService() {
  }

  public RedissonLockService(final RedissonClient redissonClient, final long defaultTimeout) {
    this.redissonClient = redissonClient;
    this.defaultTimeout = defaultTimeout;
  }

  @Override
  public T lockThenRun(final String key, Callable<T> func) throws InterruptedException {
    return lockThenRun(key, defaultTimeout, func);
  }

  @Override
  public T lockThenRun(final String key, final long timeout, Callable<T> func) throws InterruptedException {
    final RLock lock = this.redissonClient.getLock(key);
    final boolean isLocked = lock.tryLock(timeout, TimeUnit.SECONDS);
    if (isLocked) {
      try {
        return func.call();
      } catch (final Exception e) {
        logger.error(e.toString());
      } finally {
        lock.unlock();
      }
    } else {
      throw new NoLockException("No Lock !!");
    }
    return null;
  }

  // sample connect redis
  // public static void main(final String[] args) throws InterruptedException {
  // final Config config = new Config();
  // final SingleServerConfig singleServerConfig = config.useSingleServer();
  // singleServerConfig.setAddress("redis://localhost:6379");
  // final RedissonClient client = Redisson.create(config);
  // final RedissonLockService<String> r = new RedissonLockService<String>(client,
  // 20L);
  // String res = r.lockThenRun("sme:key", new Callable<String>() {
  // public String test(){
  // return "Helloworld lalala";
  // }
  // @Override
  // public String call() throws Exception {
  // return test();
  // }
  // });
  // System.out.println("the result is " + res);
  // }
}