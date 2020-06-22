package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import com.alex.common.db.entity.BaseEntity;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
  @NotNull
  public Role role;
  @NotNull
  public String email;
  @NotNull
  public String password;

  public void setPassword(String password) {
    this.password = DigestUtils.md5Hex(password);
  }
}

enum Role {
  ADMIN, VISITOR,
}