package com.alex.blog.mapper;

import java.util.List;

import com.alex.blog.api.domain.User;
import com.alex.common.annotation.MybatisIntercept;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  @MybatisIntercept
  Integer create(@Param("user") User user);

  @MybatisIntercept
  Integer update(@Param("user") User user);

  @MybatisIntercept
  User findById(@Param("id") String id);

  @MybatisIntercept
  List<User> findAll();
}