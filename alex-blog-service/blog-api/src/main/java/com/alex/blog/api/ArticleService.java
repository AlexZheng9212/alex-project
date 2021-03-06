package com.alex.blog.api;

import java.util.List;
import java.util.UUID;

import com.alex.blog.api.domain.Article;
import com.alex.blog.api.result.ArticlePageResult;
import com.alex.common.error.ExecFailure;

import org.springframework.web.multipart.MultipartFile;

import io.vavr.control.Either;

public interface ArticleService {
  public Either<ExecFailure, Integer> create(Article article);

  public Either<ExecFailure, Integer> update(Article article);

  public Either<ExecFailure, ArticlePageResult> listByRequest(Article article, Integer offset, Integer limit);

  public Either<ExecFailure, Article> findById(UUID id);

  public Either<ExecFailure, ArticlePageResult> bulkCreate(MultipartFile multipartFile);
}