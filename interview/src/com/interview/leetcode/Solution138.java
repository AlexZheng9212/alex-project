package com.interview.leetcode;

import java.util.HashMap;

import com.interview.leetcode.datastruct.Node;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * The Linked List is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) where random pointer points to, or null if it does not
 * point to any node.
 */
public class Solution138 {
  private HashMap<Node, Node> hmap = new HashMap<>();

  public Node copyRandomList(Node head) {
    return clone(head);
  }

  private Node clone(Node head) {
    if (head == null)
      return null;
    if (hmap.containsKey(head))
      return hmap.get(head);
    Node newNode = new Node(head.val);
    hmap.put(head, newNode);
    newNode.next = clone(head.next);
    newNode.random = clone(head.random);
    return newNode;
  }
}