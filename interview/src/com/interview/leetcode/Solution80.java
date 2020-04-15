package com.interview.leetcode;

public class Solution80 {
  public int removeDuplicates(int[] nums) {
    int res = 0;
    for(int i = 0; i < nums.length; i++){
      if(res > 1 && nums[i] == nums[res-2]){
        continue;
      }
      nums[res] = nums[i];
      res++;
    }
    return res;
  }
  public static void main(String[] args) {
    Solution80 s = new Solution80();
    int[] nums = new int[]{1,1,1,2,2,3};
    int res = s.removeDuplicates(nums);
    System.out.println(res);
  }
}