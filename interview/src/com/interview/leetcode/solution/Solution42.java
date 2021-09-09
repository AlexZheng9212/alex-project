package com.interview.leetcode.solution;

public class Solution42 {
  public int trap(int[] height) {
    int n = height.length;
    int[] l = new int[n];
    int[] r = new int[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      l[i] = i == 0 ? height[0] : Math.max(height[i], l[i - 1]);
    }
    for (int i = n - 1; i >= 0; i--) {
      r[i] = i == n - 1 ? height[n - 1] : Math.max(height[i], r[i + 1]);
    }
    for (int i = 0; i < n; i++) {
      ans += Math.min(l[i], r[i]) - height[i];
    }
    return ans;
  }
}
