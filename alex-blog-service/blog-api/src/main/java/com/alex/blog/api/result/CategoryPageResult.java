package com.alex.blog.api.result;

import java.util.List;

import com.alex.blog.api.domain.Category;
import com.alex.common.utils.BasicPageResult;

public class CategoryPageResult extends BasicPageResult<Category> {

  public CategoryPageResult(List<Category> data) {
    super(data);
  }
}