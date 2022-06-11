package com.interview.leetcode.solution;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution6095 {
  public boolean strongPasswordCheckerII(String password) {
    if (password.length() < 8) {
      return false;
    }
    boolean isUpper = false;
    boolean isLower = false;
    boolean isNum = false;
    boolean isSpecial = false;
    char[] cs = password.toCharArray();
    List<String> ls = Arrays.asList("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+");
    for (int i = 0; i < password.length(); i++) {
      if (i > 0) {
        if (cs[i] == cs[i - 1]) {
          return false;
        }
      }
      if (Integer.valueOf(cs[i]) >= 65 && Integer.valueOf(cs[i]) <= 90) {
        isUpper = true;
      }
      if (Integer.valueOf(cs[i]) >= 97 && Integer.valueOf(cs[i]) <= 122) {
        isLower = true;
      }
      if (Integer.valueOf(cs[i]) >= 48 && Integer.valueOf(cs[i]) <= 57) {
        isNum = true;
      }
      if (ls.contains(String.valueOf(cs[i]))) {
        isSpecial = true;
      }
    }

    return isUpper && isLower && isNum && isSpecial;
  }

}
