package com.interview.leetcode.realcase.pinpoint;

public class DateRange {
  private String minDate;
  private String maxDate;

  public void setMaxDate(String maxDate) {
    this.maxDate = maxDate;
  }

  public String getMaxDate() {
    return maxDate;
  }

  public void setMinDate(String minDate) {
    this.minDate = minDate;
  }

  public String getMinDate() {
    return minDate;
  }

  DateRange() {
  }

  DateRange(String minDate, String maxDate) {
    this.minDate = minDate;
    this.maxDate = maxDate;
  }
}
