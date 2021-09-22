package com.interview.leetcode.solution;

import java.util.List;

public class Solution120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(m - 1).size();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i][j] = triangle.get(i - 1).get(j - 1);
        if (i == 1 && j == 1)
          continue;
        if (j == 1)
          dp[i][j] += dp[i - 1][j];
        else if (j == i)
          dp[i][j] += dp[i - 1][j - 1];
        else
          dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      res = Math.min(res, dp[m][i]);
    }
    return res;
  }
}
