package com.interview.leetcode;

import java.util.Arrays;

public class MergeSort {
  public void sort(int[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  public void sort(int[] nums, int start, int end) {
    int mid = (start + end) / 2;
    if (start < end) {
      sort(nums, start, mid);
      sort(nums, mid + 1, end);
      merge(nums, start, mid, end);
      System.out.println(Arrays.toString(nums));
    }
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int l = left, r = mid + 1, n = 0;
    while (l <= mid && r <= right) {
      if (nums[l] <= nums[r]) {
        temp[n++] = nums[l++];
      } else {
        temp[n++] = nums[r++];
      }
    }
    while (l <= mid) {
      temp[n++] = nums[l++];
    }
    while (r <= right) {
      temp[n++] = nums[r++];
    }
    for (int k = 0; k < temp.length; k++) {
      nums[left + k] = temp[k];
    }
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int[] nums = { 1, 3, 2, 2, 6, 4, 8, 9, 0 };
    ms.sort(nums);
  }
}