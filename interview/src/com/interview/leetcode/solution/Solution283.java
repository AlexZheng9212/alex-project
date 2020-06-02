package com.interview.leetcode.solution;

public class Solution283 {
  public void moveZeroes(int[] nums) {
    int slow = 0, fast = 1;
    while (fast < nums.length) {
      if (nums[slow] == 0 && nums[fast] != 0) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
        fast++;
        slow++;
      } else if (nums[slow] == 0 && nums[fast] == 0) {
        fast++;
      } else {
        fast++;
        slow++;
      }
    }
  }

  public static void main(String[] args) {
    Solution283 s = new Solution283();
    int[] nums = new int[] { 0, 1, 0, 0, 3, 12 };
    s.moveZeroes(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }
}