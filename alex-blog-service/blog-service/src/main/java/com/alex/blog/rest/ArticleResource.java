package com.alex.blog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.alex.blog.api.ArticleService;
import com.alex.blog.api.domain.Article;
import com.alex.common.utils.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/articles")
public class ArticleResource {
  @Autowired
  private ArticleService articleService;

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@Valid @RequestBody Article article) {
    return RestUtils.eitherBadResponse(articleService.create(article));
  }

  @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@Valid @RequestBody Article article) {
    return RestUtils.eitherBadResponse(articleService.update(article));
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> listByRequest(@RequestParam(required = false, defaultValue = "") String id,
      @RequestParam(required = false) String title, @RequestParam(required = false) String category,
      @RequestParam(required = false) String author, @RequestParam(required = false, defaultValue = "0") Integer skip,
      @RequestParam(required = false, defaultValue = "20") Integer limit) {
    Article article = new Article(id, title, category, author);
    return RestUtils.eitherBadResponse(articleService.listByRequest(article, skip, limit));
  }
}