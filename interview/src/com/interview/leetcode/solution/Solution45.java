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

  public int jump2(int[] nums) {
    int n = nums.length;
    int end = 0;
    int maxPos = 0;
    int step = 0;
    for (int i = 0; i < n - 1; i++) {
      maxPos = Math.max(maxPos, i + nums[i]);
      if (i == end) {
        end = maxPos;
        step++;
      }
    }
    return step;
  }
}
