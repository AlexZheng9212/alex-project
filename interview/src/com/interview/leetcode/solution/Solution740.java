package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution740 {
  public int deleteAndEarn(int[] nums) {
    Arrays.sort(nums);
    int[] tmp = new int[nums[nums.length - 1] + 1];
    for (int i = 0; i < nums.length; i++) {
      tmp[nums[i]] += nums[i];
    }
    int[] dp = new int[tmp.length];
    dp[0] = tmp[0];
    dp[1] = Math.max(tmp[0], tmp[1]);
    for (int i = 2; i < tmp.length; i++) {
      dp[i] = Math.max(tmp[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Solution740 solution740 = new Solution740();
    System.out.println(solution740.deleteAndEarn(new int[] { 3, 1 }));
  }
}
