package com.alex.common.error;

public class FailureException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  protected Failure<String> error;

  public FailureException(Failure<String> error) {
    super(error.getMessage());
    this.error = error;
  }

  public FailureException(Failure<String> error, Throwable cause) {
    super(error.getMessage(), cause);
    this.error = error;
  }

  public Failure<String> getError() {
    return error;
  }
}