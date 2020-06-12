package com.alex.blog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.blog.service.TestServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/api/test")
@RestController
public class TestResource {
  @Autowired
  private TestServiceImpl testServiceImpl;

  @GetMapping()
  public void getMethodName() {
    for (int i = 0; i < 10; i++) {
      testServiceImpl.testFunction1();
      testServiceImpl.testFunction2();
    }
  }

}