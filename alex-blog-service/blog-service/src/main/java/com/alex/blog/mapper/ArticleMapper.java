package com.alex.blog.mapper;

import java.util.List;
import java.util.UUID;

import com.alex.blog.api.domain.Article;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
  List<Article> listByRequest(@Param("article") Article article, Integer offset, Integer limit);

  Article findById(@Param("id") UUID id);

  Integer create(@Param("acticle") Article article);

  Integer update(@Param("acticle") Article article);

}