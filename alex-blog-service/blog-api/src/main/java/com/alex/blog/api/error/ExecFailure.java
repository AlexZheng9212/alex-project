package com.alex.blog.api.error;

public class ExecFailure extends Failure<ExecError> {
  public ExecFailure(){}

  public ExecFailure(ExecError type, String source, String message){
    super(type,source, message);
  }

  public static ExecFailure fail(String source){
    return new ExecFailure(ExecError.FAILED, source, source);
  }

  public static ExecFailure fail(String source, String message){
    return new ExecFailure(ExecError.FAILED, source, message);
  }

  public static ExecFailure invalid(String source){
    return new ExecFailure(ExecError.INVALID, source, source);
  }

  public static ExecFailure invalid(String source, String message){
    return new ExecFailure(ExecError.INVALID, source, message);
  }

  public static ExecFailure notFound(String source){
    return new ExecFailure(ExecError.NOT_FOUND, source, source);
  }

  public static ExecFailure notFound(String source, String message){
    return new ExecFailure(ExecError.NOT_FOUND, source, message);
  }
}