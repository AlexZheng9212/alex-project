package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution1385 {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    Arrays.sort(arr2);
    int ans = 0;
    for (int i : arr1) {
      int left = i - d;
      int right = i + d;
      if (!helper(arr2, left, right)) {
        ans++;
      }
    }
    return ans;
  }

  private static boolean helper(int[] arr2, int l, int r) {
    int left = 0;
    int right = arr2.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr2[mid] >= l && arr2[mid] <= r) {
        return true;
      } else if (arr2[mid] < l) {
        left = mid + 1;
      } else if (arr2[mid] > r) {
        right = mid - 1;
      }
    }
    return false;
  }
}
