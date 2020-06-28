package com.alex.blog.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authorization")
public class LoginResource {
  @PostMapping()
  public ResponseEntity<Object> authorizate() {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}