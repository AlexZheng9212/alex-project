package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

public class Solution328 {
  public ListNode oddEvenList(ListNode head) {
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(0);
    ListNode odd = l1;
    ListNode multi = l2;
    int count = 1;
    while (head != null) {
      if (count % 2 == 0) {
        multi.next = head;
        multi = multi.next;
      } else {
        odd.next = head;
        odd = odd.next;
      }
      count++;
      head = head.next;
    }
    odd.next = l2.next;
    multi.next = null;
    return l1.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode a = new ListNode(2);
    ListNode b = new ListNode(3);
    ListNode c = new ListNode(4);
    ListNode d = new ListNode(5);
    head.next = a;
    a.next = b;
    b.next = c;
    c.next = d;
    Solution328 s = new Solution328();
    ListNode res = s.oddEvenList(head);
    System.out.println(res);
  }
}