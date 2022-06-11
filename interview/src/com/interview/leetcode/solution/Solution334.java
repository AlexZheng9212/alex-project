package com.interview.leetcode.solution;

public class Solution334 {
  public boolean increasingTriplet(int[] nums) {
    int len = nums.length;
    if (len < 3) {
      return false;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 2, 1, 5, 0, 4, 6 };
    Solution334 solution334 = new Solution334();
    System.out.println(solution334.increasingTriplet(nums));
  }
}
