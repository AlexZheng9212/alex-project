package com.interview.leetcode.realcase;

import com.interview.leetcode.datastruct.ListNode;

/**
 * 4题链表
 */
public class Ebay {
  ListNode pos = null;
  ListNode joint = null;

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public ListNode position(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        pos = slow;
      }
    }
    ListNode node = head;
    while (pos != null && node != null) {
      pos = pos.next;
      node = node.next;
      if (pos == node) {
        joint = node;
        return joint;
      }
    }
    return null;
  }

  public int calCycleLen(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        pos = slow;
      }
    }
    slow = pos.next;
    fast = pos.next.next;
    int count = 1;
    while (slow != null && fast != null) {
      if (slow == fast) {
        return count;
      }
      fast = fast.next.next;
      slow = slow.next;
      count++;
    }
    return 0;
  }

  public int lenOfListNode(ListNode head) {
    int beforeJoint = 1;
    for (ListNode node = head; node != joint; node = node.next) {
      beforeJoint++;
    }
    return beforeJoint + calCycleLen(head);
  }

  /**
   * 1->2->3 + 1->2->4 = 2->4->7 非最优解
   */
  public void sum(ListNode node1, ListNode node2) {
    StringBuilder snode1 = new StringBuilder();
    StringBuilder snode2 = new StringBuilder();
    while (node1 != null) {
      snode1.append(node1.val);
      node1 = node1.next;
    }
    while (node2 != null) {
      snode2.append(node2.val);
      node2 = node2.next;
    }
    snode1.reverse();
    snode2.reverse();
    int snode1Len = 0;
    int snode2Len = 0;
    int add = 0;
    StringBuilder res = new StringBuilder();
    while (snode1Len < snode1.length() || snode2Len < snode2.length()) {
      int node1val = 0;
      int node2val = 0;
      if (snode2Len < snode2.length()) {
        node2val = Character.getNumericValue(snode2.charAt(snode2Len));
      }
      if (snode1Len < snode1.length()) {
        node1val = Character.getNumericValue(snode1.charAt(snode1Len));
      }
      int temp = node1val + node2val;
      if (add > 0) {
        temp += add;
        add--;
      }
      if (temp / 10 > 0) {
        add = temp / 10;
        temp = temp % 10;
      }
      res.append(temp);
      snode1Len++;
      snode2Len++;
    }
    ListNode ans = new ListNode(-1);
    ListNode ppp = ans;
    for (char it : res.reverse().toString().toCharArray()) {
      ListNode temp = new ListNode(Character.getNumericValue(it));
      ans.next = temp;
      ans = temp;
    }
    System.out.println(ppp.next.toString());
  }

  /**
   * leetcode 92变形， 需要进行翻转链表。 leetcode 445;
   */
  public ListNode sumV2(ListNode node1, ListNode node2) {
    // reverse
    ListNode pre1 = null;
    while (node1 != null) {
      ListNode temp = node1.next;
      node1.next = pre1;
      pre1 = node1;
      node1 = temp;
    }
    ListNode pre2 = null;
    while (node2 != null) {
      ListNode temp = node2.next;
      node2.next = pre2;
      pre2 = node2;
      node2 = temp;
    }
    int carry = 0;
    ListNode res = null;
    while (pre1 != null || pre2 != null || carry > 0) {
      int a = pre1 != null ? pre1.val : 0;
      int b = pre2 != null ? pre2.val : 0;
      int sum = a + b + carry;
      ListNode temp = new ListNode(sum % 10);
      carry = sum / 10;
      temp.next = res;
      res = temp;
      pre1 = pre1 != null ? pre1.next : pre1;
      pre2 = pre2 != null ? pre2.next : pre2;
    }
    return res;
  }

  public void reserve(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    System.out.println(prev.toString());
  }

  public static void main(String[] args) {
    ListNode node11 = new ListNode(1);
    ListNode node12 = new ListNode(2);
    ListNode node13 = new ListNode(4);
    node11.next = node12;
    node12.next = node13;

    ListNode node21 = new ListNode(7);
    ListNode node22 = new ListNode(7);
    node21.next = node22;

    Ebay ebay = new Ebay();
    // ebay.reserve(node11);
    ListNode l1 = new ListNode(5);
    ListNode l2 = new ListNode(5);

    ListNode res = ebay.sumV2(node11, node21);
    System.out.println(res.toString());

  }
}