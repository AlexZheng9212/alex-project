package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

public class Solution21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode prev = new ListNode(0);
    ListNode cur = prev;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        cur = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        cur = l2;
        l2 = l2.next;
      }
    }
    while (l1 != null) {
      cur.next = l1;
      cur = l1;
      l1 = l1.next;
    }
    while (l2 != null) {
      cur.next = l2;
      cur = l2;
      l2 = l2.next;
    }
    return prev.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l11 = new ListNode(2);
    ListNode l12 = new ListNode(3);

    l1.next = l11;
    l11.next = l12;

    ListNode l2 = new ListNode(2);
    ListNode l21 = new ListNode(4);
    ListNode l22 = new ListNode(6);

    l2.next = l21;
    l21.next = l22;

    Solution21 s = new Solution21();
    ListNode res = s.mergeTwoLists(l1, l2);
    System.out.println(res.toString());

  }
}