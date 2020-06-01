package com.interview.leetcode.datastruct;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    ListNode head = this;
    StringBuilder sb = new StringBuilder();
    while (head != null) {
      sb.append(head.val + " ");
      head = head.next;
    }
    return sb.toString();
  }
}