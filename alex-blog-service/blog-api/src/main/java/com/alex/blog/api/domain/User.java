package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import com.alex.common.db.entity.BaseEntity;

import org.apache.commons.codec.digest.DigestUtils;

public class User extends BaseEntity {
  @NotNull
  public Role role;
  @NotNull
  public String email;
  @NotNull
  public String password;

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = DigestUtils.md5Hex(password);
  }

  public String getPassword() {
    return password;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Role getRole() {
    return role;
  }
}

enum Role {
  ADMIN, VISITOR,
}