package com.interview.leetcode.solution;

public class Solution852 {
  public int peakIndexInMountainArray(int[] arr) {
    if (arr.length == 1) {
      return arr[0];
    }
    if (arr.length == 2) {
      return arr[0] < arr[1] ? arr[1] : arr[0];
    }
    return helper(arr, 0, arr.length - 1);
  }

  private int helper(int[] arr, int left, int right) {
    int mid = left + (right - left) / 2;
    int l = mid - 1;
    int r = mid + 1;
    if (l < left) {
      l = left;
    }
    if (r > right) {
      r = right;
    }
    if (arr[l] <= arr[mid] && arr[mid] >= arr[r]) {
      return mid;
    }
    if (arr[l] <= arr[mid] && arr[mid] <= arr[r]) {
      return helper(arr, r, right);
    }
    return helper(arr, left, l);

  }
}
