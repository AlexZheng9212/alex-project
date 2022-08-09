package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution6132 {
  public int minimumOperations(int[] nums) {
    int ans = 0;
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1 && nums[0] == 0) {
      return 0;
    }
    if (len == 1 && nums[0] != 0) {
      return 1;
    }
    Arrays.sort(nums);
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        continue;
      }
      int tmp = nums[i];
      ans++;
      for (int j = i; j < len; j++) {
        nums[j] = nums[j] - tmp;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 0 };
    Solution6132 solution6132 = new Solution6132();
    System.out.println(solution6132.minimumOperations(nums));
  }
}
