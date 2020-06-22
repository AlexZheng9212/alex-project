package com.alex.blog.api.domain;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.alex.common.db.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {
  @NotNull
  public UUID articleId;
  @NotNull
  public String content;
  @NotNull
  public String userId;
}