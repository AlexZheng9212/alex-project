package com.interview.leetcode.solution;

public class Solution343 {
  public int integerBreak(int n) {
    int tmp = 1;
    if (n <= 4) {
      return n == 4 ? 4 : n - 1;
    }
    while (n > 4) {
      tmp *= 3;
      n -= 3;
    }
    return tmp * n;
  }
}
