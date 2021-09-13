package com.interview.leetcode.solution;

public class Solution918 {
  public int maxSubarraySumCircular(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    int[] dpMax = new int[nums.length];
    int[] dpMin = new int[nums.length];
    dpMax[0] = dpMin[0] = nums[0];
    int max = nums[0];
    int min = nums[0];
    int sum = nums[0];
    for (int i = 1; i < dpMax.length; i++) {
      sum += nums[i];
      dpMax[i] = Math.max(dpMax[i - 1] + nums[i], nums[i]);
      dpMin[i] = Math.min(dpMin[i - 1] + nums[i], nums[i]);
      max = Math.max(dpMax[i], max);
      min = Math.min(dpMin[i], min);
    }
    if (max < 0)
      return max;
    return max > sum - min ? max : sum - min;
  }
}
