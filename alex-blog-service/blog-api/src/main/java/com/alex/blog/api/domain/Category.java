package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.RandomStringUtils;

public class Category {
  public String id = RandomStringUtils.random(6);
  public String parentId = null;
  @NotNull
  public String name = null;
  public String descripition = null;
  @NotNull
  public Integer rank = null;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescripition() {
    return descripition;
  }

  public void setDescripition(String descripition) {
    this.descripition = descripition;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public Category toCategory() {
    return this;
  }
}