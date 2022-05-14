package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
  List<String> ans = new ArrayList<>();
  static Map<Character, String> map = new HashMap<>();
  static {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return ans;
    }
    back(new StringBuilder(), digits, 0);
    return ans;
  }

  void back(StringBuilder tmp, String digits, int idx) {
    if (idx == digits.length()) {
      ans.add(tmp.toString());
      return;
    }
    char c = digits.charAt(idx);
    String m = map.get(c);
    for (int i = 0; i < m.length(); i++) {
      tmp.append(m.charAt(i));
      back(tmp, digits, idx + 1);
      tmp.deleteCharAt(tmp.length() - 1);
    }
  }
}
