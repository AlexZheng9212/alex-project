package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution280 {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length - 1; i = i + 2) {
      swap(nums, i, i + 1);
    }
  }

  void swap(int[] nums, int i, int j) {
    int tmp = nums[j];
    nums[j] = nums[i];
    nums[i] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6 };
    Solution280 solution280 = new Solution280();
    solution280.wiggleSort(nums);
    for (int num : nums) {
      System.out.println(num);
    }

  }
}
