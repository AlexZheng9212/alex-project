package com.alex.blog.api.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Failure<T> {
  private T type;
  private String source;
  private String message;

  public Failure(){}
  
  public Failure(@JsonProperty("type") T type, @JsonProperty("source") String source, @JsonProperty("message") String message){
    this.type = type;
    this.source = source;
    this.message = message;
  }

  public T getType() {
    return type;
  }

  public void setType(T type) {
    this.type = type;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}