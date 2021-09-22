package com.interview.leetcode.solution;

/**
 * 931. Minimum Falling Path Sum
 * 
 * 基本款 二维dp数组 matrix dp[i,j] 依赖于 dp[i-1,j-1] dp[i-1,j] dp[i-1,j+1]
 */
public class Solution931 {
  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - 1 >= 0)
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        if (j + 1 < n)
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
        dp[i][j] += matrix[i][j];
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, dp[m - 1][i]);
    }
    return res;
  }
}
