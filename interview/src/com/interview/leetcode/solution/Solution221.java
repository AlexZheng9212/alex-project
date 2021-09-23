package com.interview.leetcode.solution;

public class Solution221 {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = matrix[i][j] - '0';
        if (dp[i][j] == 0)
          continue;
        if (i == 0 && j == 0) {

        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
        }
        ans = Math.max(ans, dp[i][j] * dp[i][j]);
      }
    }
    return ans;
  }
}
