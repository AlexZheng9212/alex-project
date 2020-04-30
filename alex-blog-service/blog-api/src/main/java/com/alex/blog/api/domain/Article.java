package com.alex.blog.api.domain;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.alex.common.db.entity.BaseEntity;

public class Article extends BaseEntity {
  @NotNull
  public String title;
  @NotNull
  public String content;
  @NotNull
  public String category;
  @NotNull
  public String author;
  public List<Tag> tags;

  public Article() {
  }

  public Article(String id, String title, String category, String author) {
    this.id = UUID.fromString(id);
    this.title = title;
    this.category = category;
    this.author = author;
  }
}