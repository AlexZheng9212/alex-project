package com.interview.leetcode.solution;

public class Solution1140 {
  public int stoneGameII(int[] piles) {
    int n = piles.length;
    int[] sums = piles;
    int[][] dp = new int[n + 1][n + 1];
    for (int i = n - 2; i >= 0; i--) {
      sums[i] += sums[i + 1];
    }
    for (int j = 0; j < n; j++) {
      dp[j][n] = sums[j];
    }
    for (int i = n - 1; i >= 0; i--) {
      for (int m = n - 1; m >= 1; m--) {
        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
          dp[i][m] = Math.max(dp[i][m], sums[i] - dp[i + x][Math.max(m, x)]);
        }
      }
    }
    return dp[0][1];
  }
}
