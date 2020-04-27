package com.alex.blog.api;

import com.alex.blog.api.domain.Category;
import com.alex.blog.api.domain.CategoryPageResult;
import com.alex.blog.api.error.ExecFailure;

import io.vavr.control.Either;

public interface CategoryService {
  public Either<ExecFailure, CategoryPageResult> listByRequest(Integer rank);

  public Either<ExecFailure, Category> create(Category category);

  public Either<ExecFailure, Category> update(Category category);
}