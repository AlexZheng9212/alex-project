package com.interview.leetcode.solution;

public class Solution344 {
  public void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    Solution344 sol = new Solution344();
    char[] s = new char[] { 'a', 'b', 'c' };
    sol.reverseString(s);
    for (char c : s) {
      System.out.println(c);
    }
  }
}