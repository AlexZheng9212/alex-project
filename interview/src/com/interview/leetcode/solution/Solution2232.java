package com.interview.leetcode.solution;

public class Solution2232 {
  public String minimizeResult(String expression) {
    String[] sub = expression.split("\\+");
    int min = Integer.MAX_VALUE;
    int mid = expression.indexOf("+");
    int ldx = 0;
    int rdx = expression.length();
    for (int l = 0; l < mid; l++) {
      for (int r = expression.length() - 1; r > mid; r--) {
        String s1 = expression.substring(0, l);
        String s2 = expression.substring(l, r + 1);
        String s3 = expression.substring(r + 1, expression.length());
        System.out.println(s1 + " " + s2 + " " + s3);
        int tmp = fun(s1, s2, s3);
        if (tmp < min) {
          ldx = l;
          rdx = r;
          min = tmp;
        }
      }
    }
    System.out.println(ldx + " " + rdx);
    StringBuilder sb = new StringBuilder(expression);
    sb.insert(ldx, "(");
    sb.insert(rdx + 2, ")");
    return sb.toString();
  }

  private int fun(String s1, String s2, String s3) {
    int i1 = 1;
    if (!"".equals(s1)) {
      i1 = Integer.valueOf(s1);
    }
    int i3 = 1;
    if (!"".equals(s3)) {
      i3 = Integer.valueOf(s3);
    }
    String[] stmp = s2.split("\\+");
    int i2 = Integer.valueOf(stmp[0]) + Integer.valueOf(stmp[1]);
    return i1 * i2 * i3;
  }

  public static void main(String[] args) {
    Solution2232 solution2232 = new Solution2232();
    System.out.println("ans " + solution2232.minimizeResult("12+34"));
  }
}
