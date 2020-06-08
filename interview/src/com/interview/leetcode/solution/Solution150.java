package com.interview.leetcode;

import java.util.Stack;

/**
 * RPN
 */
public class Solution150 {
  Stack<Integer> stack = new Stack<>();

  public int ops(String op) {
    int ans = 0;
    int last = stack.pop();
    int first = stack.pop();
    if (op.equals("+")) {
      ans = first + last;
    }
    if (op.equals("-")) {
      ans = first - last;
    }
    if (op.equals("*")) {
      ans = first * last;
    }
    if (op.equals("/")) {
      ans = first / last;
    }
    return ans;
  }

  public int evalRPN(String[] tokens) {
    String ops = "+-*/";
    for (String item : tokens) {
      if (ops.indexOf(item) > -1) {
        int ans = ops(item);
        stack.push(ans);
      } else {
        stack.push(Integer.valueOf(item));
      }
    }
    return stack.pop();
  }
}