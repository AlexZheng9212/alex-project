package com.interview.leetcode;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
  private LinkedBlockingDeque qDeque = new LinkedBlockingDeque<>(10);
  private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 1, TimeUnit.SECONDS, qDeque);

}
