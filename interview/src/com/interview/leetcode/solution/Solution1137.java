package com.interview.leetcode.solution;

public class Solution1137 {
  public int tribonacci(int n) {

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 1;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Solution1137 solution1137 = new Solution1137();
    System.out.println(solution1137.tribonacci(25));
  }
}
