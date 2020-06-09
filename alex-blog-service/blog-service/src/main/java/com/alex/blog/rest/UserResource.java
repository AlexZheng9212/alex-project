package com.alex.blog.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.alex.blog.api.UserService;
import com.alex.blog.api.domain.User;
import com.alex.common.utils.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {
  @Autowired
  private UserService userService;

  @PostMapping()
  public ResponseEntity<Object> create(@Valid @NotNull @RequestBody() User user) {
    user.setPassword(user.password);
    return RestUtils.eitherBadResponse(userService.create(user));
  }

  @PatchMapping()
  public ResponseEntity<Object> update(@RequestBody() User user) {
    return RestUtils.eitherBadResponse(userService.update(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> findById(@PathVariable("id") String id) {
    return RestUtils.eitherBadResponse(userService.findById(id));
  }

  @GetMapping()
  public ResponseEntity<Object> findAll() {
    return RestUtils.eitherBadResponse(userService.findAll());
  }

}