package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

/**
 * merge k ListNodes, similar with Solution21
 */
public class Solution23 {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = new ListNode(0);
    ListNode cur = res;

    for (ListNode item : lists) {
      while (res != null && item != null) {
        if (res.val < item.val) {

        }
      }

    }

  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode a1 = new ListNode(2);
    ListNode a2 = new ListNode(3);
    a.next = a1;
    a1.next = a2;

    ListNode b = new ListNode(2);
    ListNode b1 = new ListNode(4);
    ListNode b2 = new ListNode(10);
    b.next = b1;
    b1.next = b2;

    ListNode c = new ListNode(3);
    ListNode c1 = new ListNode(6);
    ListNode c2 = new ListNode(9);
    c.next = c1;
    c2.next = c2;

    ListNode[] lists = { a, b, c };
  }
}