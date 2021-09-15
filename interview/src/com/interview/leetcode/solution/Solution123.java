package com.interview.leetcode.solution;

/**
 * Input: prices = [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4 (price
 * = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day 7
 * (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class Solution123 {
  public int maxProfit(int[] prices) {
    int hold1 = Integer.MIN_VALUE, sold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE, sold2 = Integer.MIN_VALUE;
    for (int p : prices) {
      hold1 = Math.max(-p, hold1);
      sold1 = Math.max(hold1 + p, sold1);
      hold2 = Math.max(sold1 - p, hold2);
      sold2 = Math.max(hold2 + p, sold2);
    }
    return sold2;
  }
}
