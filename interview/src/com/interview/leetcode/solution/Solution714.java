package com.interview.leetcode.solution;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
/**
 * Input: prices = [1,3,2,8,4,9], fee = 2 Output: 8 Explanation: The maximum
 * profit can be achieved by: - Buying at prices[0] = 1 - Selling at prices[3] =
 * 8 - Buying at prices[4] = 4 - Selling at prices[5] = 9 The total profit is
 * ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class Solution714 {
  public int maxProfit(int[] prices, int fee) {
    int len = prices.length;
    if (len == 0)
      return 0;
    int[][] dp = new int[len][2];
    for (int i = 0; i < len; i++) {
      if (i - 1 == -1) {
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        continue;
      }
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);

    }
    return dp[len - 1][1];
  }

  public static void main(String[] args) {
    int[] prices = new int[] { 1, 3, 2, 8, 4, 9 };
    int fee = 2;
    Solution714 solution714 = new Solution714();
    System.out.println(solution714.maxProfit(prices, fee));
  }
}
