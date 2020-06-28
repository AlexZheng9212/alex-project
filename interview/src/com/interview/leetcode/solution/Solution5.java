package com.interview.leetcode.solution;

/**
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 */
public class Solution5 {
  public String longestPalindrome(String s) {
    int len = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      int cur = Math.max(genLen(s, i, i), genLen(s, i, i + 1));
      if (cur > len) {
        len = cur;
        start = i - (len - 1) / 2;
      }
    }
    return s.substring(start, start + len);
  }

  private int genLen(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}