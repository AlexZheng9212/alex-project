package com.interview.leetcode.solution;

/**
 * Input: prices = [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1)
 * and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price =
 * 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 =
 * 7.
 */
public class Solution122 {
  public int maxProfit(int[] prices) {
    int tmp = 0, max = 0;
    for (int i = 1; i < prices.length; i++) {
      tmp = prices[i] - prices[i - 1];
      tmp = Math.max(tmp, 0);
      max += tmp;
    }
    return max;
  }

  public static void main(String[] args) {
    Solution122 solution122 = new Solution122();
    System.out.println(solution122.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }));
  }
}
