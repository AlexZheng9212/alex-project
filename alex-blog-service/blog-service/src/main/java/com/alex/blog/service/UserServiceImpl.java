package com.alex.blog.service;

import java.util.List;
import java.util.UUID;

import com.alex.blog.api.UserService;
import com.alex.blog.api.domain.User;
import com.alex.blog.api.result.UserPageResult;
import com.alex.blog.mapper.UserMapper;
import com.alex.common.error.ExecFailure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vavr.control.Either;

@Service
public class UserServiceImpl implements UserService {
  private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  private UserMapper userMapper;

  @Override
  public Either<ExecFailure, User> create(User user) {
    try {
      user.id = UUID.randomUUID();
      userMapper.create(user);
      return Either.right(user);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("fail", "create user failed"));
    }
  }

  @Override
  public Either<ExecFailure, User> update(User user) {
    try {
      Integer res = userMapper.update(user);
      if (res < 1) {
        return Either.left(ExecFailure.fail("Id is not Exist"));
      }
      return Either.right(user);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("fail", "update user failed"));
    }
  }

  @Override
  public Either<ExecFailure, User> findById(String id) {
    try {
      User user = userMapper.findById(id);
      return Either.right(user);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("fail", "find user by id: {id}failed"));
    }
  }

  @Override
  public Either<ExecFailure, UserPageResult> findAll() {
    try {
      List<User> users = userMapper.findAll();
      UserPageResult userPageResult = new UserPageResult(users);
      return Either.right(userPageResult);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("fail", "findAll"));
    }

  }
}