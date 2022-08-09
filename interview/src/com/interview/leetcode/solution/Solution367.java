package com.interview.leetcode.solution;

public class Solution367 {
  public boolean isPerfectSquare(int num) {
    return helper(1, num, num);
  }

  private boolean helper(int left, int right, int target) {
    if (left > right) {
      return false;
    }
    int mid = left + (right - left) / 2;
    if (target / mid == mid) {
      if (target % mid == 0) {
        return true;
      }
      return helper(mid + 1, right, target);
    }
    if (target / mid > mid) {
      return helper(left, mid - 1, target);
    }
    return helper(mid + 1, right, target);
  }
}
