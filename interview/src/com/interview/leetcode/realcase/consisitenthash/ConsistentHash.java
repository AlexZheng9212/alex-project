package com.interview.leetcode.realcase.consisitenthash;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T extends Node> {
  private final SortedMap<Long, VirtualNode<T>> ring = new TreeMap<>();
  private final MD5Hash md5Hash;

  public ConsistentHash(Collection<T> pNodes, int virualNodeCnt) throws NoSuchAlgorithmException {
    this.md5Hash = new MD5Hash();
  }

  public void addNode(T pNode, int virualNodeCnt) {
    if (virualNodeCnt < 1)
      throw new IllegalArgumentException();
    int existingReplicas = getExistingReplicas(pNode);
    for (int i = 0; i < virualNodeCnt; i++) {
      VirtualNode<T> vNode = new VirtualNode<>(pNode, i + existingReplicas);
      ring.put(md5Hash.hash(vNode.getKey()), vNode);
    }
  }

  public void removeNode(T pNode) {
    Iterator<Long> it = ring.keySet().iterator();
    while (it.hasNext()) {
      Long key = it.next();
      VirtualNode<T> vNode = ring.get(key);
      if (vNode.isVirualNodeOf(pNode)) {
        it.remove();
      }
    }
  }

  public T findPNode(String objKey) {
    if (ring.isEmpty()) {
      return null;
    }
    long hashVal = md5Hash.hash(objKey);
    SortedMap<Long, VirtualNode<T>> tailMap = ring.tailMap(hashVal);
    Long key = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
    return ring.get(key).getPNode();
  }

  public int getExistingReplicas(T pNode) {
    int replicas = 0;
    for (VirtualNode<T> node : ring.values()) {
      if (node.isVirualNodeOf(pNode)) {
        replicas++;
      }
    }
    return replicas;
  }
}
