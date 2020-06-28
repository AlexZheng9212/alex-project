package com.alex.blog.api;

import com.alex.blog.api.domain.User;
import com.alex.blog.api.result.UserPageResult;
import com.alex.common.error.ExecFailure;

import io.vavr.control.Either;

public interface UserService {
  public Either<ExecFailure, User> create(User user);

  public Either<ExecFailure, User> update(User user);

  public Either<ExecFailure, User> findById(String id);

  public Either<ExecFailure, UserPageResult> findAll();
}