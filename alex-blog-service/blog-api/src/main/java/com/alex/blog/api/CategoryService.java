package com.alex.blog.api;

import com.alex.blog.api.domain.Category;
import com.alex.blog.api.domain.CategoryPageResult;

public interface CategoryService {
  public CategoryPageResult listByRequest(Category category);

  public Category create(Category category);

  public Category update(Category category);
}