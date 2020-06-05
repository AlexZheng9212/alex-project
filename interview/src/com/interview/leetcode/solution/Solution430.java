package com.interview.leetcode.solution;

import java.util.Stack;

/**
 * 双向链表实现栈
 */
public class Solution430 {
  /**
   * 防止和现有datastruct中的Node冲突
   * 
   * 1 > 2 > 3 > 4 > 5 > 6 > null
   * 
   * null > null > 7 > 8 > 9 > 10 > null
   * 
   * null > 11 > 12
   * 
   * 打平！！ 有child的先走child，再走接下来的。
   *
   */
  class Node {
    int val;
    Node prev;
    Node next;
    Node child;
  }

  public Node flatten(Node head) {
    if (head == null) {
      return null;
    }
    Stack<Node> stack = new Stack<>();
    Node res = head;
    while (head.next != null || head.child != null) {
      if (head.child != null) {
        stack.add(head.next);
        head.next = head.child;
        head.next.prev = head;
        head.child = null;
      }
      head = head.next;
      if (head.next == null && head.child == null && !stack.isEmpty()) {
        head.next = stack.pop();
        if (head.next != null) {
          head.next.prev = head;
        }
      }
    }
    return res;
  }
}