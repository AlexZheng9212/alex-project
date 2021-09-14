package com.interview.leetcode.solution;

public class Solution121 {
  public int maxProfit(int[] prices) {
    int max = 0;
    int tmp = 0;
    for (int i = 1; i < prices.length; i++) {
      tmp += prices[i] - prices[i - 1];
      tmp = Math.max(tmp, 0);
      max = Math.max(max, tmp);
    }
    return max;
  }
}
