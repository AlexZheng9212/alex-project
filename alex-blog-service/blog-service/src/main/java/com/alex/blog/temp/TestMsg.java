package com.alex.blog.temp;

import lombok.Data;

@Data
public class TestMsg {
  public String msg;
  public int number;

  @Override
  public String toString() {
    return this.msg + this.number;
  }
}