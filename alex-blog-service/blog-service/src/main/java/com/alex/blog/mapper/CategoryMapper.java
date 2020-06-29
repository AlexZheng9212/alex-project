package com.alex.blog.mapper;

import java.util.List;

import com.alex.blog.api.domain.Category;
import com.alex.common.annotation.MybatisIntercept;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
  @MybatisIntercept
  Integer create(@Param("category") Category category);

  @MybatisIntercept
  Integer update(@Param("id") String id, @Param("name") String name);

  @MybatisIntercept
  List<Category> listByRequest(@Param("category") Category category);

  @MybatisIntercept
  Category findById(String id);
}