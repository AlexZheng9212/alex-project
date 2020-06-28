package com.alex.blog.service;

import java.util.List;
import java.util.UUID;

import com.alex.blog.api.ArticleService;
import com.alex.blog.api.domain.Article;
import com.alex.blog.api.result.*;
import com.alex.blog.mapper.ArticleMapper;
import com.alex.common.error.ExecFailure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vavr.control.Either;

@Service
public class ArticleServiceImpl implements ArticleService {
  private final static Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public Either<ExecFailure, Integer> create(Article article) {
    try {
      article.id = UUID.randomUUID().toString();
      Integer res = articleMapper.create(article);
      return Either.right(res);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("Article", "fail to create Article", e.toString()));
    }
  }

  @Override
  public Either<ExecFailure, Integer> update(Article article) {
    try {
      Integer res = articleMapper.update(article);
      if (res < 1) {
        return Either.left(ExecFailure.notFound("article id is not found"));
      }
      return Either.right(res);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("Article", "fail to updare Article", e.toString()));
    }
  }

  @Override
  public Either<ExecFailure, ArticlePageResult> listByRequest(Article article, Integer offset, Integer limit) {
    try {
      List<Article> articles = articleMapper.listByRequest(article, offset, limit);
      ArticlePageResult articlePageResult = new ArticlePageResult();
      articlePageResult.setData(articles);
      return Either.right(articlePageResult);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("Article", "fail to find articles", e.toString()));
    }
  }
}