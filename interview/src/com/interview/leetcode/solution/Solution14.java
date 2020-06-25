package com.interview.leetcode.solution;

import java.util.Arrays;

public class Solution14 {
  public String longestCommonPrefix(String[] strs) {
    // Arrays.sort(strs);
    // String word1 = strs[0];
    // String word2 = strs[strs.length - 1];
    if (strs == null || strs.length == 0)
      return "";
    String prefix = strs[0];
    for (String s : strs) {
      while (s.indexOf(prefix) != 0)
        prefix = prefix.substring(0, prefix.length() - 1);
    }
    return prefix;
  }

  public static void main(String[] args) {
    Solution14 s = new Solution14();
    String[] strs = { "flower", "flow", "flight" };
    System.out.println(s.longestCommonPrefix(strs));
  }
}