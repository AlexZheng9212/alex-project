package com.interview.leetcode.solution;

/**
 * 188. Best Time to Buy and Sell Stock IV
 */
/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */
/**
 * Input: k = 2, prices = [3,2,6,5,0,3] Output: 7 Explanation: Buy on day 2
 * (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day
 * 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * 
 */
public class Solution188 {
  public int maxProfit(int k, int[] prices) {
    int len = prices.length;
    if (len == 0)
      return 0;
    int[][][] dp = new int[len][k + 1][2];
    for (int i = 0; i < len; i++) {
      for (int t = k; t >= 1; t--) {
        if (i - 1 == -1) {
          dp[0][t][0] = -prices[0];
          dp[0][t][1] = 0;
          continue;
        }
        dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t - 1][1] - prices[i]);
        dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t][0] + prices[i]);
      }
    }
    return dp[len - 1][k][1];
  }
}
