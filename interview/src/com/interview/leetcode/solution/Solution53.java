package com.interview.leetcode.solution;

public class Solution53 {
  public int maxSubArray(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
      max = Math.max(dp[i], max);
    }
    return dp[dp.length - 1];
  }
}
