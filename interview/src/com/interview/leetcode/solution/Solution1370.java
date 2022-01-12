package com.interview.leetcode.solution;

public class Solution1370 {
  public String sortString(String s) {
    int[] a = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      a[c - 'a']++;
    }
    int size = 0;
    StringBuilder sb = new StringBuilder();
    while (size < s.length()) {
      for (int i = 0; i < a.length; i++) {
        if (a[i] > 0) {
          sb.append((char) (i + 'a'));
          a[i]--;
          size++;
        }
      }
      for (int i = a.length - 1; i >= 0; i--) {
        if (a[i] > 0) {
          sb.append((char) (i + 'a'));
          a[i]--;
          size++;
        }
      }
    }
    return sb.toString();
  }
}
