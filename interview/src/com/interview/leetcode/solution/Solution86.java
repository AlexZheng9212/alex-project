package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 */
public class Solution86 {
  public ListNode partition(ListNode head, int x) {
    ListNode ln1 = new ListNode(0);
    ListNode ln2 = new ListNode(0);
    ListNode small = ln1;
    ListNode large = ln2;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    small.next = ln2.next;
    large.next = null;
    return ln1.next;
  }
}
