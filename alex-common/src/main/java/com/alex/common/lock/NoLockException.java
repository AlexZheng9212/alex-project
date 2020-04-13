package com.alex.common.lock;

public class NoLockException extends RuntimeException {

  private static final long serialVersionUID = 7199047670262393328L;

  public NoLockException(String message) {
    super(message);
  }
}