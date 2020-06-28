package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

public class Solution445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode prev = null;
    StringBuilder l1s = new StringBuilder();
    StringBuilder l2s = new StringBuilder();

    while (l1 != null) {
      l1s.append(l1.val);
    }
    while (l2 != null) {
      l2s.append(l2.val);
    }
    int sum = Integer.parseInt(l1s.toString()) + Integer.parseInt(l2s.toString());
    char[] s = String.valueOf(sum).toCharArray();
    for (char item : s) {
      int tmp = Integer.parseInt(String.valueOf(item));
      ListNode node = new ListNode(tmp);
      prev.next = node;
      prev = node;
    }
    return prev;
  }
}