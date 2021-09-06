package com.interview.leetcode.solution;

/**
 * Jump Game II
 * 
 */
public class Solution45 {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
      int jumptimes = Integer.MAX_VALUE;
      for (int p = i - 1; p >= 0; p--) {
        if (p == 0 || dp[p] > 0) {
          if (p + nums[p] >= i) {
            jumptimes = Math.min(jumptimes, dp[p] + 1);
          }
        }
      }
      dp[i] = jumptimes;
    }
    return dp[dp.length - 1];
  }
}
