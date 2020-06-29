package com.alex.blog.api.result;

import java.util.List;

import com.alex.blog.api.domain.Article;
import com.alex.common.utils.BasicPageResult;

public class ArticlePageResult extends BasicPageResult<Article> {
  public ArticlePageResult(List<Article> data) {
    super(data);
  }
}