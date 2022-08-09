package com.interview.leetcode.solution;

public class Solution35 {
  public int searchInsert(int[] nums, int target) {
    return helper(nums, 0, nums.length - 1, target);
  }

  private int helper(int[] nums, int left, int right, int target) {
    if (left >= right) {
      if (nums[left] == target) {
        return left;
      } else if (nums[left] > target) {
        return left;
      } else {
        return left + 1;
      }
    }
    int mid = left + (right - left) / 2;
    if (target == nums[mid]) {
      return mid;
    }
    if (nums[mid] < target) {
      return helper(nums, mid + 1, right, target);
    }
    return helper(nums, left, mid - 1, target);

  }

  public static void main(String[] args) {

  }
}
