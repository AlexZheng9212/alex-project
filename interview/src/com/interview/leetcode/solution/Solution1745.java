package com.interview.leetcode.solution;

import java.util.Arrays;

/**
 * 1745 dp
 */
public class Solution1745 {
  public boolean checkPartitioning(String s) {
    int len = s.length();
    int[][] dp = new int[len][len];
    Arrays.stream(dp).forEach(i -> Arrays.fill(i, 1));
    for (int l = 2; l <= len; l++) {
      for (int i = 0, j = i + l - 1; j < len; i++, j++) {
        if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1] == 1) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < len; i++) {
      for (int j = i; j + 1 < len; j++) {
        if ((dp[0][i - 1] & dp[i][j] & dp[j + 1][len - 1]) == 1) {
          return true;
        }
      }
    }
    return false;
  }
}
