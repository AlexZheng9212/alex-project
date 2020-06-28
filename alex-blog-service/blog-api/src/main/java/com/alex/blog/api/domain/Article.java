package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import com.alex.common.db.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity {
  @NotNull
  public String title;
  @NotNull
  public String content;
  @NotNull
  public String category;
  @NotNull
  public String author;
  // public List<Tag> tags;

  public Article() {
  }

  public Article(String id, String title, String category, String author) {
    this.id = id;
    this.title = title;
    this.category = category;
    this.author = author;
  }
}