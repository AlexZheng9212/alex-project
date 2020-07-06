package com.alex.blog.api.domain;

import javax.validation.constraints.NotNull;

import com.alex.blog.api.constant.ArticleStatus;
import com.alex.common.db.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static com.alex.common.utils.UUIDUtils.convertToUUID;

@Data
@ToString
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
  @NotNull
  public ArticleStatus status;
  // public List<Tag> tags;

  public Article() {
  }

  public Article(String id, String title, String category, String author, ArticleStatus status) {
    this.id = convertToUUID(id);
    this.title = title;
    this.category = category;
    this.author = author;
    this.status = status;
  }
}