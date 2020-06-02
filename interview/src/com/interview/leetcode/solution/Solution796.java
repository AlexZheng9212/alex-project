package com.interview.leetcode.solution;

/**
 * Rotate String
 * 
 * Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 * Example 2: Input: A = 'abcde', B = 'abced' Output: false
 */

public class Solution796 {
  public boolean rotateStringV2(String A, String B) {
    return (A.length() == B.length()) && (A + A).contains(B);
  }

  public boolean rotateString(String A, String B) {
    if (A.length() != B.length())
      return false;
    if (A.length() == 0 && B.length() == 0)
      return true;
    StringBuilder sb = new StringBuilder(B);
    int time = B.length();
    while (time > 0) {
      char tail = sb.charAt(B.length() - 1);
      sb = sb.deleteCharAt(B.length() - 1);
      sb = sb.insert(0, tail);
      System.out.println(sb);
      if (sb.toString().equals(A)) {
        return true;
      }
      time--;
    }
    return false;
  }

  public static void main(String[] args) {
    String A = "abcd";
    String B = "bcdea";
    Solution796 s = new Solution796();
    System.out.println(s.rotateStringV2(A, B));

  }
}