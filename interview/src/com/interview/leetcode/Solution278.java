package com.interview.leetcode;

class VersionControl {
  public boolean isBadVersion(int version) {
    // todo
    return true;
  }
}

public class Solution278 extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2; // 不能直接 (l + r) / 2; 1 - 5 => 3 ; 3 - 5 => 4 ; 4 - 5 => 5;死循环了。。
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}