package com.alex.blog.mapper;

import java.util.List;

import com.alex.blog.api.domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  Integer create(@Param("user") User user);

  Integer update(@Param("user") User user);

  User findById(@Param("id") String id);

  List<User> findAll();
}