package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
  public static final int CORE_POOL_SIZE = 15;
  public static final int MAX_POOL_SIZE = 30;
  public static final int KEEP_ALIVE_TIME = 3000;

  public static ThreadFactory threadFactory;

  public static BlockingQueue<Runnable> workQueue;

  public static RejectedExecutionHandler rejectedExecutionHandler;

  public static void main(String[] args) {
    threadFactory = new CustomrizedThreadFactory("ThreadPoolName");
    workQueue = new ArrayBlockingQueue<>(100);
    rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
    // Executors.newSingleThreadExecutor(15);
    // 为啥ali不允许使用Executors创建线程 --->
    // newSchedule的阻塞队列使用 DelayQueue(reentrantLock)
    // newFix,singleton 使用 LinkedBlockingQueue 会导致 OOM！！
    // newCachedThreadPool 使用 SynchronousQueue
    ExecutorService executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
        TimeUnit.MILLISECONDS, workQueue, threadFactory, rejectedExecutionHandler);
    for (int i = 0; i < 15; i++) {
      Task task = new Task();
      executorService.execute(task);
    }
  }
}

class CustomrizedThreadFactory implements ThreadFactory {
  int counter = 0;
  String name;
  private List<String> stats;

  public CustomrizedThreadFactory(String name) {
    this.name = name;
    this.stats = new ArrayList<>();
  }

  @Override
  public Thread newThread(Runnable r) {
    String msg = name + "-Thread-" + counter;
    Thread thread = new Thread(r, msg);
    counter++;
    return thread;
  }

  public String getStats() {
    StringBuilder builder = new StringBuilder();
    Iterator<String> it = stats.iterator();
    while (it.hasNext()) {
      builder.append(it.next());
    }
    return builder.toString();
  }
}

class Task implements Runnable {
  @Override
  public void run() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
