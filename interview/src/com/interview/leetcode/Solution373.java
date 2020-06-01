package com.interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {
  /**
   * AC, Time Limit Exceeded
   * 
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0)
      return res;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums1[i]);
        temp.add(nums2[j]);
        res.add(temp);
      }
    }
    Collections.sort(res, new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        int o1sum = o1.stream().reduce(0, Integer::sum);
        int o2sum = o2.stream().reduce(0, Integer::sum);
        return o1sum - o2sum;
      }
    });
    k = res.size() < k ? res.size() : k;
    return res.subList(0, k);
  }

  /**
   * priportyQueue
   * 
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  public List<List<Integer>> kSmallestPairsV2(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, (a, b) -> (a.get(0) + a.get(1) - (b.get(0) + b.get(1))));
    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return res;
    }
    for (int i = 0; i < nums1.length && i < k; i++) {
      List<Integer> item = new ArrayList<>();
      item.add(nums1[i]);
      item.add(nums2[0]);
      item.add(0);
      pq.offer(item);
    }
    while (!pq.isEmpty() && k-- > 0) {
      List<Integer> cur = pq.poll();
      res.add(cur.subList(0, 2));
      if (cur.get(2) + 1 == nums2.length)
        continue;
      List<Integer> temp = new ArrayList<>();
      temp.add(cur.get(0));
      temp.add(nums2[cur.get(2) + 1]);
      temp.add(cur.get(2) + 1);
      pq.offer(temp);
    }
    return res;
  }

  public static void main(String[] args) {
    Solution373 s = new Solution373();
    int[] nums1 = new int[] {};
    int[] nums2 = new int[] {};

    s.kSmallestPairsV2(nums1, nums2, 3);
  }
}