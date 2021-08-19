package com.interview.leetcode.realcase;

/**
 * 给定有序数组，和 target x, 找出 x 首次出现的位置
 */
public class Trips {
  public int index;

  public int find(int[] nums, int target) {
    find(nums, target, 0, nums.length - 1);
    return index;
  }

  private void find(int[] nums, int target, int left, int right) {
    if (left >= right) {
      index = left;
      return;
    }
    int mid = left + (right - left) / 2;
    if (nums[mid] < target) {
      find(nums, target, mid + 1, right);
    }
    if (nums[mid] > target) {
      find(nums, target, left, mid - 1);
    }
    if (nums[mid] == target) {
      find(nums, target, left, mid);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 2, 3, 3, 4, 5 };
    int target = 3;
    Trips trips = new Trips();
    System.out.println(trips.find(nums, target));
  }
}