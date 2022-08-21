package com.interview.leetcode.solution;

public class Solution1593 {
  public int findKthPositive(int[] arr, int k) {
    int l = -1;
    int r = arr.length;
    while (l + 1 != r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] - mid < k) {
        l = mid;
      } else {
        r = mid;
      }
    }
    return r + k;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 7, 11 };
    int k = 5;
    Solution1593 solution1593 = new Solution1593();
    System.out.println(solution1593.findKthPositive(arr, k));
  }
}
