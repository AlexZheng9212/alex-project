package com.interview.leetcode.solution;

public class Solution205 {
  public boolean isIsomorphic(String s, String t) {
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
        return false;
      }
      m1[s.charAt(i)] = i + 1;
      m2[t.charAt(i)] = i + 1;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "abb";
    String t = "bac";
    Solution205 solution205 = new Solution205();
    System.out.println(solution205.isIsomorphic(s, t));
  }
}
