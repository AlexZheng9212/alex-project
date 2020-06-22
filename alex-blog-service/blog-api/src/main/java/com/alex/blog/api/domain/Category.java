package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Category {
  public String id = null;
  @NotNull
  public String name = null;
  public String description = null;
  public Integer rank = null;

  public Category toCategory() {
    return this;
  }
}