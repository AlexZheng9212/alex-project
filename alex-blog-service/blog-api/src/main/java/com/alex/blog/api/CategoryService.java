package com.alex.blog.api;

import com.alex.blog.api.domain.Category;
import com.alex.blog.api.result.CategoryPageResult;
import com.alex.common.error.ExecFailure;

import io.vavr.control.Either;

public interface CategoryService {
  public Either<ExecFailure, CategoryPageResult> listByRequest(Category category);

  public Either<ExecFailure, Category> create(Category category);

  public Either<ExecFailure, Category> update(Category category);

  public Either<ExecFailure, Category> findById(String id);
}