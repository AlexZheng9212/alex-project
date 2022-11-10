package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 */
public class Solution2441 {
  public int findMaxK(int[] nums) {
    Integer[] tmp = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      tmp[i] = nums[i];
    }
    Arrays.sort(tmp, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Math.abs(o2) - Math.abs(o1) == 0 ? o1 - o2 : Math.abs(o2) - Math.abs(o1);
      }
    });
    for (int i = 1; i < tmp.length; i++) {
      if (tmp[i] == -tmp[i - 1]) {
        return tmp[i];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution2441 solution2441 = new Solution2441();
    int ans = solution2441.findMaxK(new int[] { 1, 7, -7, 7, -3, 10 });
    System.out.println(ans);
  }
}
