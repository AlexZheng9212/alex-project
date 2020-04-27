package com.alex.blog.rest;

import javax.validation.Valid;

import com.alex.blog.api.CategoryService;
import com.alex.blog.api.domain.Category;
import com.alex.blog.utils.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
  @Autowired
  private CategoryService categoryService;

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@Valid @RequestBody Category category) {
    return RestUtils.eitherBadResponse(categoryService.create(category));
  }

  @PatchMapping(value =  "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@Valid @RequestBody Category category) {
    return RestUtils.eitherBadResponse(categoryService.update(category));
  }
}