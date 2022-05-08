package com.interview.leetcode.solution;

public class Offer03 {
  public int findRepeatNumber(int[] nums) {
    int len = nums.length;
    int[] tmp = new int[len];
    for (int i = 0; i < len; i++) {
      tmp[nums[i]]++;
      if (tmp[nums[i]] > 1) {
        return nums[i];
      }
    }
    return 0;
  }
}
