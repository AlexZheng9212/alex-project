package com.interview.leetcode;

import java.util.HashMap;

import com.interview.leetcode.datastruct.ListNode;

public class Ebay {
  HashMap<Integer, Integer> hashmap = new HashMap<>();

  public boolean icCirle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != null && fast != null) {
      if (!hashmap.containsKey(slow.val)) {
        hashmap.put(slow.val, 1);
      }
      int count = hashmap.get(slow.val);
      hashmap.put(slow.val, count + 1);
      if (slow.val == fast.val) {
        int max = 0;
        int location = 0;
        for (int it : hashmap.keySet()) {
          int temp = hashmap.get(it);
          if (temp > max) {
            location = it;
            max = temp;
          }
        }
        System.out.println(location);
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  public String sum(ListNode node1, ListNode node2) {
    if (node1 == null) {
      return node2.toString();
    }
    if (node2 == null) {
      return node1.toString();
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    while (node1 != null) {
      sb1.append(node1.val);
      node1 = node1.next;
    }
    while (node2 != null) {
      sb2.append(node2.val);
      node2 = node2.next;
    }
    sb1.reverse();
    sb2.reverse();
    int sb1Len = 0;
    int sb2Len = 0;
    int add = 0;
    StringBuilder res = new StringBuilder();
    while (sb1Len++ < sb1.length() && sb2Len++ < sb2.length()) {
      int temp = Integer.valueOf(sb1.charAt(sb1Len)) + Integer.valueOf(sb2.charAt(sb2Len));
      System.out.println(temp);
      if (add > 0) {
        temp = temp + add;
        add--;
      }
      if (temp / 10 >= 1) {
        temp = temp % 10;
        add = 1;
      }
      res.append(temp);
    }

    return res.reverse().toString();
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(4);
    ListNode cur4 = new ListNode(5);
    ListNode cur5 = new ListNode(6);

    node2.next = cur4;
    cur4.next = cur5;

    Ebay s = new Ebay();
    System.out.println(s.sum(node1, node2));
  }
}