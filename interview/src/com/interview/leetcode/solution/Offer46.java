package com.interview.leetcode.solution;

public class Offer46 {
  public int translateNum(int num) {
    String n = String.valueOf(num);
    int a = 1;
    int b = 1;
    for (int i = 2; i <= n.length(); i++) {
      String tmp = n.substring(i - 2, i);
      int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
      b = a;
      a = c;
    }
    return a;
  }
}
