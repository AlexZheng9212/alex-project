package com.alex.common.error;

public class Failure<T> {
  private T type;
  private String message;

  public Failure(){}
  public Failure(T type, String message){
    this.type = type;
    this.message = message;
  }

  public static <T> Failure<T> of(T t){
    return new Failure<T>(t, t.toString());
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
}