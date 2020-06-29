package com.alex.blog.api.constant;

public enum ArticleStatus {
  PUBLISH("Publish"), DRAFT("Draft");

  private String status;

  private ArticleStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}