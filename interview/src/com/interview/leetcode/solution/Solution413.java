package com.interview.leetcode.solution;

/**
 * 413. Arithmetic Slices
 */
/**
 * 问一个数组中，有多少个连续的等差数列
 */

public class Solution413 {
  public int numberOfArithmeticSlices(int[] nums) {
    int len = nums.length;
    if (len < 3)
      return 0;
    int sum = 0;
    int cnt = 1;
    for (int i = 1; i < len - 1; i++) {
      if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
        sum += cnt++;
      } else {
        cnt = 1;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Solution413 solution413 = new Solution413();
    System.out.println(solution413.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));
  }
}
