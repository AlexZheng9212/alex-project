package com.interview.leetcode.solution;

/**
 * 爬楼梯
 */
/**
 * 1 - 1 2 - 2 3 - 3 4 - 5 5 - 8 6 - 13 7 - 21
 */
public class Solution70 {
  public int climbStairs(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    Solution70 solution70 = new Solution70();
    System.out.println(solution70.climbStairs(7));
  }
}
