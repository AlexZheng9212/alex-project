package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution164 {
  /**
   * input array like [1,2,3,0] and return answer 2. (3-1) think flow:
   * 先变成顺序，然后取最大间距
   * 
   * @param input
   * @return
   */

  public int maximumGap(int[] nums) {
    if (nums.length < 2) {
      return 2;
    }
    Arrays.sort(nums);
    int gap = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      int tmp = nums[i] - nums[i - 1];
      if (tmp > gap) {
        gap = tmp;
      }
    }
    return gap;
  }

  public static void main(String[] args) {
    Solution164 s = new Solution164();
    int[] nums = { 1, 3, 9, 0 };
    int ans = s.maximumGap(nums);
    System.out.println(ans);
  }
}
