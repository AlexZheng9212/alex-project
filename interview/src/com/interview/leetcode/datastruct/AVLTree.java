package com.interview.leetcode.datastruct;

import java.util.ArrayList;

class AVLNode {
  AVLNode left;
  AVLNode right;
  int height;
  int key;
  ArrayList<Object> values;

  public AVLNode(int key, Object value) {
    this.key = key;
    this.values.add(value);
    height = 1;
  }

  public AVLNode(int key, ArrayList<Object> values) {
    this.key = key;
    this.values = values;
    height = 1;
  }
}

public class AVLTree implements AVLTreeOps {
  AVLNode root;
  int size;

  public AVLTree() {
  }

  @Override
  AVLNode put(int key, Object value) {
    return put(root, key, value);
  }

  AVLNode put(AVLNode node, int key, Object value) {
    if (node == null) {
      root = new AVLNode(key, value);
      size++;
      return root;
    }
    if (key < node.key) {
      node.left = put(node.left, key, value);
    } else if (key > node.key) {
      node.right = put(node.right, key, value);
    } else {
      node.values.add(value);
      return node;
    }

    node.height = 1 + Math.max(height(node.left), height(node.right));
    int balance = getBalance(node);

    if (balance > 1 && key < node.left.key) {
      return rightRotate(node);
    }
    if (balance < -1 && key > node.right.key) {
      return leftRotate(node);
    }

    if (balance > 1 && key < node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if (balance < -1 && key > node.right.key) {
      node.right = leftRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  private AVLNode leftRotate(AVLNode node) {
  }

  private AVLNode rightRotate(AVLNode node) {
    AVLNode temp = node.left;
    AVLNode T2 = temp.right;
    temp.right = node;
    node.left = T2;
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
    return temp;
  }

  private int getBalance(AVLNode node) {
    if (node == null) {
      return 0;
    }
    return height(node.left) - height(node.right);
  }

  private int height(AVLNode node) {
    if (node == null)
      return 0;
    return node.height;
  }

  private int calHeight(AVLNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(calHeight(node.left), calHeight(node.right));
  }

}