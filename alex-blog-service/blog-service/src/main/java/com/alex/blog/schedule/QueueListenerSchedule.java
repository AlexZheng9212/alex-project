package com.alex.blog.schedule;

import com.alex.blog.service.BlockingQueueServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueListenerSchedule {
  @Autowired
  private BlockingQueueServiceImpl blocking;

  @Scheduled(fixedDelay = 10000)
  public void cleanUpBlockingQueue() {
    blocking.consumer();
  }
}