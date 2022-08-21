package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution611 {
  public int triangleNumber(int[] nums) {
    int result = 0;
    Arrays.sort(nums);
    int tail = nums.length - 1;
    for (int i = tail; i >= 2; i--) {
      int l = 0;
      int r = i - 1;
      while (r > l) {
        if (nums[l] + nums[r] > nums[i]) {
          result++;
          r--;
        } else {
          l++;
        }
      }
    }
    return result;
  }
}
