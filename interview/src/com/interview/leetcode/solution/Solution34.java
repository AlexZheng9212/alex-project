package com.interview.leetcode.solution;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 */
public class Solution34 {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[] { -1, -1 };
    int leftIndex = helper(nums, target, true);
    if (leftIndex == nums.length || nums[leftIndex] != target)
      return res;
    res[0] = leftIndex;
    res[1] = helper(nums, target, false) - 1;
    return res;
  }

  private int helper(int[] nums, int target, boolean isLeft) {
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target || (isLeft && nums[mid] == target)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}