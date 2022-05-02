package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
  private static Map<Character, Integer> roman = new HashMap<>();
  static {
    roman.put('I', 1);
    roman.put('V', 5);
    roman.put('X', 10);
    roman.put('L', 50);
    roman.put('C', 100);
    roman.put('D', 500);
    roman.put('M', 1000);
  }

  private int get(char s) {
    return roman.get(s);
  }

  public int romanToInt(String s) {
    int last = Integer.MAX_VALUE;
    int ans = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char t = s.charAt(i);
      int tmp = get(t);
      if (tmp > last) {
        ans = ans - 2 * last + tmp;
      } else {
        ans += tmp;
      }
      last = tmp;
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution13 solution13 = new Solution13();
    System.out.println(solution13.romanToInt("LVIII"));
  }
}
