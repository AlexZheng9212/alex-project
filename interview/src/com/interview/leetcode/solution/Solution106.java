package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

/**
 * 获取两个链表的连接点。 其实是路程问题。这类题的解法就是尝试。和链表数据结构没有太大关系。
 */
public class Solution106 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      a = a.next == null ? headB : a.next;
      b = b.next == null ? headA : b.next;
    }
    return a;
  }

  public static void main(String[] args) {
    ListNode headA = new ListNode(1);
    ListNode a1 = new ListNode(2);
    ListNode a2 = new ListNode(3);
    ListNode a3 = new ListNode(4);
    ListNode headB = new ListNode(5);

    headA.next = a1;
    a1.next = a2;
    a2.next = a3;
    headB.next = a2;

    Solution106 s = new Solution106();
    ListNode res = s.getIntersectionNode(headA, headB);
    System.out.println(res.val);

  }
}