package com.interview.leetcode.solution;

public class Solution704 {
  public int search(int[] nums, int target) {
    return helper(nums, 0, nums.length - 1, target);
  }

  private int helper(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    int mid = (end + start) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] < target) {
      return helper(nums, mid + 1, end, target);
    } else {
      return helper(nums, start, mid - 1, target);
    }
  }
}
