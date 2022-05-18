package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int len = s.length();
    int st = 0;
    int ed = 0;
    int res = 0;
    Set<Character> set = new HashSet<>();
    while (st < len && ed < len) {
      if (set.contains(s.charAt(ed))) {
        set.remove(s.charAt(st));
        st++;
      } else {
        set.add(s.charAt(ed));
        ed++;
        res = Math.max(res, ed - st);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    System.out.println(solution3.lengthOfLongestSubstring("dvdf"));
  }
}
