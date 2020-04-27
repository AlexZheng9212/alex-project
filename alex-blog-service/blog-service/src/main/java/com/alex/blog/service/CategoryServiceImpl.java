package com.alex.blog.service;

import java.util.List;

import com.alex.blog.api.CategoryService;
import com.alex.blog.api.domain.Category;
import com.alex.blog.api.domain.CategoryPageResult;
import com.alex.blog.mapper.CategoryMapper;
import com.alex.blog.api.error.ExecFailure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vavr.control.Either;

@Service
public class CategoryServiceImpl implements CategoryService {
  private final static Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

  @Autowired
  private CategoryMapper categoryMapper;

  @Override
  public Either<ExecFailure,CategoryPageResult> listByRequest(Integer rank) {
    try {
      List<Category> categorys = categoryMapper.listByRequest(rank);
      CategoryPageResult categoryPageResult = new CategoryPageResult();
      categoryPageResult.setData(categorys);
      return Either.right(categoryPageResult);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.notFound("categorys are not found"));
    }
  }

  @Override
  public Either<ExecFailure,Category> create(Category category) {
    try {
      categoryMapper.create(category);
      return Either.right(category);
    } catch (Exception e) {
      LOGGER.error(e.toString());
      return Either.left(ExecFailure.fail("category", "fail to create category"));
    }
  
  }

  @Override
  public Either<ExecFailure,Category> update(Category category) {
    try {
      Integer res = categoryMapper.update(category.id, category.name);
      LOGGER.info(res.toString());
      if(res < 1){
        return Either.left(ExecFailure.fail("Id is not Exist"));
      }
      return Either.right(category);
    } catch (Exception e) {
    LOGGER.error(e.toString());
    return Either.left(ExecFailure.fail("fail to update category"));
    }
  }
}