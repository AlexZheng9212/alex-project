package com.interview.leetcode;

/**
 * 分治思想，找锚点：int divide() div左边均小于div，右边均大于div，当 left >= right时候 确定锚点。然后递归。
 */
public class QuickSort {
  public void sort(int[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  public void sort(int[] nums, int left, int right) {
    if (left < right) {
      int div = divide(nums, left, right);
      sort(nums, left, div);
      sort(nums, div + 1, right);
    }
  }

  private int divide(int[] nums, int left, int right) {
    if (left >= right)
      return left;
    int div = left + (right - left) / 2;
    int l = left - 1;
    int r = right + 1;
    while (true) {
      while (nums[++l] < nums[div]) {
      }
      while (nums[--r] > nums[div]) {
      }
      if (l >= r) {
        return r;
      }
      swap(nums, l, r);
    }
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public static void main(String[] args) {
    QuickSort qs = new QuickSort();
    int[] nums = { 9, 3, 2, 1, 4, 5, 6, 7 };
    qs.sort(nums);
    for (int i : nums) {
      System.out.println(i);
    }
  }
}