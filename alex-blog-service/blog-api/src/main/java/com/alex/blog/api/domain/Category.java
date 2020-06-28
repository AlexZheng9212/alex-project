package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Category {
  public String id = null;
  public String parentId = null;
  @NotNull
  public String name = null;
  public String description = null;
  public Integer rank = null;

  public Category toCategory() {
    return this;
  }
}