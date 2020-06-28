package com.interview.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.datastruct.ListNode;

public class Solution143 {
  public void reorderList(ListNode head) {
    Deque<ListNode> deque = new ArrayDeque<>();
    ListNode temp = head;
    while (temp != null) {
      deque.addLast(temp);
      temp = temp.next;
    }
    ListNode out = new ListNode(0);
    ListNode cur = out;
    while (!deque.isEmpty()) {
      cur.next = deque.pollFirst();
      ListNode tail = deque.pollLast();
      cur.next.next = tail;
      cur = tail;
    }
    if (cur != null)
      cur.next = null;
    head = cur.next;
  }
}