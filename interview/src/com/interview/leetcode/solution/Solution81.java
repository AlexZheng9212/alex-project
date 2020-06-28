package com.interview.leetcode.solution;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 */
public class Solution81 {
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target)
        return true;
      if (nums[mid] < nums[right]) {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else if (nums[mid] > nums[right]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        right--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution81 s = new Solution81();
    int target = 2;
    int[] nums = new int[] { 2, 5, 6, 0, 0, 1, 2 };
    boolean res = s.search(nums, target);
    System.out.println(res);
  }
}