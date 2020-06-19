package com.alex.blog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import com.alex.blog.temp.TestMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/test")
@RestController
public class TestResource {
  private final static Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

  @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public void getMethodName(@PathParam("id") String id, @RequestBody TestMsg msg) {
    LOGGER.info(msg.toString());
  }

}