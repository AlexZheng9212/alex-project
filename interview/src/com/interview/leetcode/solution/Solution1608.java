package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution1608 {
  public int specialArray(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i <= nums.length; i++) {
      if (nums[nums.length - i] >= i) {
        if (nums.length - i == 0) {
          return i;
        }
        if (nums[nums.length - 1 - i] < i) {
          return i;
        }
      }
    }
    return -1;
  }
}
