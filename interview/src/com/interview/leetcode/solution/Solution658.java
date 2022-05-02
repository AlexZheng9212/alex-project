package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution658 {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    int len = arr.length;
    int i = 0;
    for (; i < len - k; i++) {
      if (arr[i] >= x) {
        break;
      }
      if (arr[i + k] < x) {
        continue;
      }
      if (Math.abs(arr[i] - x) <= Math.abs(arr[i + k] - x)) {
        break;
      }
    }
    for (int j = 0; j < k; j++) {
      ans.add(arr[j + i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 2, 2, 3, 6, 8, 8, 9 };
    int k = 5;
    int x = 9;
    Solution658 solution658 = new Solution658();
    System.err.println(solution658.findClosestElements(arr, k, x));
  }
}
