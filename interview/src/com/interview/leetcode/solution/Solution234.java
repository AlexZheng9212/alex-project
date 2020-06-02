package com.interview.leetcode.solution;

import com.interview.leetcode.datastruct.ListNode;

public class Solution234 {
  public boolean isPalindrome(ListNode head) {
    StringBuilder sb = new StringBuilder();
    StringBuilder rsb = new StringBuilder();
    while (head != null) {
      sb.append(head.val);
      rsb.append(head.val);
      head = head.next;
    }
    rsb.reverse();
    String s1 = sb.toString();
    String s2 = rsb.toString();
    return s1.equals(s2);
  }
}