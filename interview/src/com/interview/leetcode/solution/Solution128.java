package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution128 {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return 1;
    }
    for (int i = 0; i < len; i++) {
      map.put(nums[i], 0);
    }
    int ans = 1;
    int start = 0;
    int[] keys = new int[map.keySet().size()];
    int j = 0;
    for (int item : map.keySet()) {
      keys[j++] = item;
    }
    Arrays.sort(keys);
    for (int i = 1; i < keys.length; i++) {
      if ((keys[i] - keys[i - 1]) == 1) {
        int tmp = i - start + 1;
        if (ans < tmp) {
          ans = tmp;
        }
      } else {
        start = i;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 0, 1 };
    Solution128 solution128 = new Solution128();
    System.out.println(solution128.longestConsecutive(nums));
  }
}
