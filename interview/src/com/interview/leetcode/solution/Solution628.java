package com.interview.leetcode.solution;

import java.util.Arrays;

/**
 * Given an integer array nums, find three numbers whose product is maximum and
 * return the maximum product.
 */
public class Solution628 {
  public int maximumProduct(int[] nums) {
    int len = nums.length;
    if (len == 3)
      return nums[0] * nums[1] * nums[2];
    Arrays.sort(nums);
    int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
    int b = nums[0] * nums[1] * nums[len - 1];
    return Math.max(a, b);
  }
}
