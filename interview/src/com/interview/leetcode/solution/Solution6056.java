package com.interview.leetcode.solution;

public class Solution6056 {
  public String largestGoodInteger(String num) {
    char[] tmp = num.toCharArray();
    int len = num.length();
    if (len < 3) {
      return "";
    }
    int i = 2;
    int max = Integer.MIN_VALUE;
    String ans = "";
    for (; i < len; i++) {
      if (tmp[i - 2] == tmp[i - 1] && tmp[i - 1] == tmp[i]) {
        StringBuilder sb = new StringBuilder();
        sb.append(tmp, i - 2, 3);
        int a = Integer.valueOf(sb.toString());
        if (a > max) {
          ans = sb.toString();
          max = a;
        }
      }
    }
    return max == Integer.MIN_VALUE ? "" : ans;
  }
}
