package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution80 {
  List<Integer> r = new ArrayList<>();

  public int removeDuplicates(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (res > 1 && nums[i] == nums[res - 2]) {
        continue;
      }
      r.add(nums[i]);
      nums[res] = nums[i];
      res++;
    }
    return res;
  }

  public int removeDuplicatesV2(int[] nums) {
    return process(nums, 2);
  }

  private int process(int[] nums, int k) {
    int u = 0;
    for (int x : nums) {
      if (u < k || nums[u - k] != x) {
        nums[u++] = x;
      }
    }
    return u;
  }

  public static void main(String[] args) {
    Solution80 s = new Solution80();
    int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 3, 3 };
    int res = s.removeDuplicates(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println(s.r.toString());
    System.out.println(res);
  }
}