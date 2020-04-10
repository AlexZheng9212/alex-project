package com.alex.common.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailureException extends RuntimeException{
  private static final Logger logger = LoggerFactory.getLogger(FailureException.class);
  private static final long serialVersionUID = 1L;
  protected Failure<String> error;

  public FailureException(Failure<String> error){
    super(error.getMessage());
    this.error = error;
    logger.error(error.toString());
  }

  public FailureException(Failure<String> error, Throwable throwable){
    super(error.getMessage(), throwable);
    this.error = error;
    logger.error(error.toString());
  }

  public Failure<String> getError(){
    return error;
  }
}