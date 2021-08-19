package com.interview.leetcode.realcase.consisitenthash;

public class VirtualNode<T extends Node> implements Node {
  final T pNode;
  final int ridx;

  VirtualNode(T pNode, int ridx) {
    this.pNode = pNode;
    this.ridx = ridx;
  }

  @Override
  public String getKey() {
    return pNode.getKey() + "-" + ridx;
  }

  public boolean isVirualNodeOf(T node) {
    return pNode.getKey().equals(node.getKey());
  }

  public T getPNode() {
    return pNode;
  }
}
