package com.interview.leetcode.solution;
/*
Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which 
the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

public class Solution209 {
  public int minSubArrayLen(int target, int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int left = 0, right = 0, sum = 0, len = nums.length, res = len + 1;
    while (right < len) {
      while (sum < target && right < len) {
        sum += nums[right++];
      }
      while (sum >= target) {
        res = Math.min(res, right - left);
        sum -= nums[left++];
      }
    }
    return res == len + 1 ? 0 : res;
  }

  public static void main(String[] args) {
    int target = 7;
    int[] nums = { 2, 3, 1, 2, 4, 3 };
    Solution209 s = new Solution209();
    System.out.println(s.minSubArrayLen(target, nums));
  }
}
