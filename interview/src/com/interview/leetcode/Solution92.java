package com.interview.leetcode;

import com.interview.leetcode.datastruct.ListNode;

public class Solution92 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // create dummy
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    // find prev node
    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
    }
    // reserve node
    ListNode cur = prev.next;
    for (int j = 0; j < n - m; j++) {
      ListNode next = cur.next;
      cur.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return dummy.next;
  }
}