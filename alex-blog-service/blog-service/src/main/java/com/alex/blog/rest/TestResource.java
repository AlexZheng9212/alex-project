package com.alex.blog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.common.redis.RedisUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/api/test")
@RestController
public class TestResource {
  private final static Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

  @Autowired
  private RedisUtils redisUtils;

  @GetMapping()
  public void getMethodName() {
    redisUtils.put("ohhh", "lalalallala");
    LOGGER.info(redisUtils.get("ohhh").toString());
    LOGGER.info("test api.......");
  }

}