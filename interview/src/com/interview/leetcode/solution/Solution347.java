package com.interview.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.frequent - b.frequent);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (Entry<Integer, Integer> e : map.entrySet()) {
      if (queue.size() == k) {
        if (e.getValue() > queue.peek().frequent) {
          queue.poll();
          queue.add(new Pair(e.getKey(), e.getValue()));
        }

      } else {
        queue.add(new Pair(e.getKey(), e.getValue()));
      }
    }
    int[] ans = new int[k];
    for (int j = 0; j < k; j++) {
      ans[k - 1 - j] = queue.poll().value;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    int k = 2;
    Solution347 solution347 = new Solution347();
    int[] ans = solution347.topKFrequent(nums, k);
    for (int a : ans) {
      System.out.println(a);
    }
  }
}

class Pair {
  int value;
  int frequent;

  Pair(int v, int f) {
    this.value = v;
    this.frequent = f;
  }
}
