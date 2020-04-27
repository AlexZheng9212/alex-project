package com.alex.blog.mapper;

import java.util.List;

import com.alex.blog.api.domain.Category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
  Integer create(@Param("category") Category category);
  Integer update(@Param("id") String id, @Param("name") String name);
  List<Category> listByRequest(Integer rank);
  Category findById(Integer id);
}