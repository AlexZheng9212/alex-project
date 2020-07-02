package com.alex.blog.mapper;

import java.util.List;
import java.util.UUID;

import com.alex.blog.api.domain.Article;
import com.alex.common.annotation.MybatisIntercept;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
  @MybatisIntercept
  List<Article> listByRequest(@Param("article") Article article, @Param("offset") Integer offset,
      @Param("limit") Integer limit);

  @MybatisIntercept
  Article findById(@Param("id") UUID id);

  @MybatisIntercept
  Integer create(@Param("article") Article article);

  @MybatisIntercept
  Integer update(@Param("article") Article article);

  @MybatisIntercept
  Integer bulkCreate(@Param("articles") List<Article> articles);

}