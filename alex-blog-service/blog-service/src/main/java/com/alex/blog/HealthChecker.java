package com.alex.blog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChecker {
  @GetMapping("/health-checker")
  public ResponseEntity<Boolean> getHealthStatus() {
    return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
  }
}