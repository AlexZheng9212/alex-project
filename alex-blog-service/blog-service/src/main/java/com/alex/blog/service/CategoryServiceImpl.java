package com.alex.blog.service;

import com.alex.blog.api.CategoryService;
import com.alex.blog.api.domain.Category;
import com.alex.blog.api.domain.CategoryPageResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

  @Override
  public CategoryPageResult listByRequest(Category category) {
    return null;
  }

  @Override
  public Category create(Category category) {
    LOGGER.info("TODO");
    return category;
  }

  @Override
  public Category update(Category category) {
    LOGGER.info("TODO");
    return category;
  }
}