package com.alex.common.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Failure<T> {
  private T type;
  private String message;
  public Failure(){}
  public Failure(@JsonProperty("type") T type, @JsonProperty("message") String message){
    this.type = type;
    this.message = message;
  }
  public static <C> Failure <C> of(C c){
    return new Failure<C>(c, c.toString());
  }
  /**
   * @param type the type to set
   */
  public void setType(T type) {
    this.type = type;
  }
  /**
   * @return the type
   */
  public T getType() {
    return type;
  }
  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}