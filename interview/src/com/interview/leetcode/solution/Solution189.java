package com.interview.leetcode.solution;

public class Solution189 {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    helper(nums, 0, nums.length - 1);
    helper(nums, 0, k - 1);
    helper(nums, k, nums.length - 1);

  }

  private void helper(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[start];
      nums[start++] = nums[end];
      nums[end--] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 3;
    Solution189 solution189 = new Solution189();
    solution189.rotate(nums, k);
    for (int i : nums) {
      System.out.println(i);
    }
  }
}
