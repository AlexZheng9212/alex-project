package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution6133 {
  
  public int maximumGroups(int[] grades) {
    int sum = 0;
    int ans = 0;
    int len = grades.length;
    for (int i : grades) {
      sum += i;
    }
    Arrays.sort(grades);
    for (int i = len - 1; i >= 0; i--) {
      int tmp = sum - grades[i];
      if (tmp <= 0) {
        break;
      }

    }
    return 0;
  }
  
  private int helper(int idx, int[] nums, int num) {

  }



  public static void main(String[] args) {
    int[] grades = { 3, 5, 6, 7, 10, 12 };
    Solution6133 solution6133 = new Solution6133();
    System.out.println(solution6133.maximumGroups(grades));
  }
}
