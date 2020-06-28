package com.alex.common.utils;

import java.util.List;

public class BasicPageResult<T> {
  public List<T> data;

  public BasicPageResult() {
  }

  public BasicPageResult(List<T> data) {
    this.data = data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public List<T> getData() {
    return data;
  }

}