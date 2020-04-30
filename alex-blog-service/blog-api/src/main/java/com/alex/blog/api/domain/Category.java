package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

public class Category {
  public String id = null;
  public String parentId = null;
  @NotNull
  public String name = null;
  public String description = null;
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
    return description;
  }

  public void setDescripition(String description) {
    this.description = description;
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