package com.interview.leetcode;

public class Solution643 {
  public double findMaxAverage(int[] nums, int k) {
    int left = 0, right = left + k; double res = Double.NEGATIVE_INFINITY;
    while(right <= nums.length){
      double temp = 0;
      for(int i = left; i<right; i++){
        temp += nums[i];
      }
      temp = temp / k;
      if(temp > res) {
        res = temp;
      }
      left++;
      right++;
    }
    return res;
  }

  public double findMaxAverageV2(int[] nums, int k) {
    double max = 0;
    for(int i = 0; i < k; i++ ){
      max += nums[i];
    }
    double temp = max;
    for(int i = k; i < nums.length; i++){
      temp += nums[i];
      temp -= nums[i-k];
      if(temp > max){
        max = temp;
      }
    }
    return max / k;
  }
  public static void main(String[] args) {
    Solution643 s = new Solution643();
    int k = 1;
    int[] nums = new int[]{5};
    double res = s.findMaxAverageV2(nums, k);
    System.out.println(res);
  }
}