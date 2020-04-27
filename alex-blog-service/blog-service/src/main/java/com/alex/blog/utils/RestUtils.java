package com.alex.blog.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.vavr.control.Either;

public class RestUtils {
  public static<L,R> ResponseEntity<Object> eitherBadResponse(Either<L,R> response){
    if(response.isRight()){
      return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(response.getLeft(), HttpStatus.BAD_REQUEST);
    }
  }
}