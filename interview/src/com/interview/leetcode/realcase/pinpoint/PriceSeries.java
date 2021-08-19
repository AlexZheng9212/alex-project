package com.interview.leetcode.realcase.pinpoint;

import java.math.BigDecimal;

public class PriceSeries {
  private String date;
  private BigDecimal price;

  public void setDate(String date) {
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }

  PriceSeries(String date, BigDecimal price) {
    this.date = date;
    this.price = price;
  }
}
