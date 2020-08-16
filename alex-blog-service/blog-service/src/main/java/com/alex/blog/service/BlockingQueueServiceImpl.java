package com.alex.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

@Service
public class BlockingQueueServiceImpl {
  private ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(100);

  public void processor(String msg) {
    try {
      arrayBlockingQueue.put(msg);
      if (arrayBlockingQueue.remainingCapacity() == 0) {
        consumer();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void consumer() {
    try {
      if (arrayBlockingQueue.isEmpty()) {
        return;
      }
      List<String> list = new ArrayList<>();
      arrayBlockingQueue.drainTo(list);
      // TODO: biz logic
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}