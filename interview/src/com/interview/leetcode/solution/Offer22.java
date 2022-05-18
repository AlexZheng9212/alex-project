package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

public class Offer22 {
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    int i = 1;
    while (i < k) {
      if (fast.next != null) {
        fast = fast.next;
      }
      i++;
    }
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
