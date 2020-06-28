package com.alex.blog.rest;

import javax.validation.Valid;

import com.alex.blog.api.CategoryService;
import com.alex.blog.api.domain.Category;
import com.alex.common.utils.RestUtils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
  @Autowired
  private CategoryService categoryService;

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@Valid @RequestBody Category category) {
    category.setId(RandomStringUtils.randomAlphabetic(6));
    return RestUtils.eitherBadResponse(categoryService.create(category));
  }

  @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@Valid @RequestBody Category category) {
    return RestUtils.eitherBadResponse(categoryService.update(category));
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> listByRequest(@RequestParam(required = false) String id,
      @RequestParam(required = false) String parentId, @RequestParam(required = false) Integer rank) {
    Category category = new Category();
    category.setId(id);
    category.setRank(rank);
    return RestUtils.eitherBadResponse(categoryService.listByRequest(category));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getMethodName(@PathVariable("id") String id) {
    return RestUtils.eitherBadResponse(categoryService.findById(id));
  }

}