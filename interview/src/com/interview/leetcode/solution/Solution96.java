package com.interview.leetcode.solution;

/**
 * 96. Unique Binary Search Trees. Given an integer n, return the number of
 * structurally unique BST's (binary search trees) which has exactly n nodes of
 * unique values from 1 to n.
 */
public class Solution96 {
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    if (n == 0)
      return 1;
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }
}
