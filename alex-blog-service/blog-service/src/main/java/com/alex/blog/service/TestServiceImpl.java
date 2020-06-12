package com.alex.blog.service;

import com.alex.blog.config.ApiProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
  private final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

  @Autowired
  private ApiProperties apiProperties;

  @Async("publisherThreadPool")
  public void testFunction1() {
    LOGGER.info(apiProperties.getRabbitConnection().getVirtualhost());
    LOGGER.info(apiProperties.getRabbitConnection().getAddresses().get(0));
    
    LOGGER.info("testing 1 thread pool");
  }

  @Async("publisherThreadPool")
  public void testFunction2() {
    LOGGER.info("testing 2 thread pool");
  }
}
