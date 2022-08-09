package com.interview.leetcode.solution;

public class Solution69 {
  public int mySqrt(int x) {
    int left = 0;
    int right = x;
    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if ((long) (long) mid * mid == x) {
        return mid;
      } else if ((long) (long) mid * mid < x) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
