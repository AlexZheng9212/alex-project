package com.alex.blog.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import com.alex.blog.api.ArticleService;
import com.alex.blog.api.constant.ArticleStatus;
import com.alex.blog.api.domain.Article;
import com.alex.blog.service.UploadFileServiceImpl;
import com.alex.common.utils.RestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.alex.common.utils.UUIDUtils.convertToUUID;

import java.io.IOException;

@RestController
@RequestMapping("/api/articles")
public class ArticleResource {
  @Autowired
  private ArticleService articleService;

  @Autowired
  private UploadFileServiceImpl uploadFileServiceImpl;

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@Valid @RequestBody Article article) {
    return RestUtils.eitherBadResponse(articleService.create(article));
  }

  @PostMapping(value = "/upload", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void uploadArticle(@RequestParam("file") MultipartFile multipartFile)
      throws IllegalStateException, IOException {
    uploadFileServiceImpl.uploadFile(multipartFile);
  }

  @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> update(@Valid @RequestBody Article article) {
    return RestUtils.eitherBadResponse(articleService.update(article));
  }

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> listByRequest(@RequestParam(required = false) String id,
      @RequestParam(required = false) String title, @RequestParam(required = false) String category,
      @RequestParam(required = false) String author, @RequestParam(required = false) ArticleStatus status,
      @RequestParam(required = false, defaultValue = "0") Integer skip,
      @RequestParam(required = false, defaultValue = "20") Integer limit) {
    Article article = new Article(id, title, category, author, status);
    return RestUtils.eitherBadResponse(articleService.listByRequest(article, skip, limit));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findById(@PathVariable("id") String id) {
    return RestUtils.eitherBadResponse(articleService.findById(convertToUUID(id)));
  }
}