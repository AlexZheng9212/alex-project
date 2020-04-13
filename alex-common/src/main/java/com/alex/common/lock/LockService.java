package com.alex.common.lock;

import java.util.concurrent.Callable;

public interface LockService<T> {
  public T lockThenRun(String key, Callable<T> func) throws InterruptedException;

  public T lockThenRun(String key, long timeout, Callable<T> func) throws InterruptedException;

}