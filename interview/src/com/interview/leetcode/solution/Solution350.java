package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input:nums1=[4,9,5],nums2=[9,4,9,8,4]Output:[4,9]
public class Solution350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> hmap = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      hmap.put(nums1[i], hmap.getOrDefault(nums1[i], 0) + 1);
    }
    for (int j = 0; j < nums2.length; j++) {
      if (hmap.get(nums2[j]) != null && hmap.get(nums2[j]) > 0) {
        res.add(nums2[j]);
        hmap.put(nums2[j], hmap.get(nums2[j]) - 1);
      }
    }
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int[] nums1 = { 2, 2, 5 };
    int[] nums2 = { 2, 2, 9, 4, 8 };
    Solution350 solution350 = new Solution350();
    int[] res = solution350.intersect(nums1, nums2);
    for (int item : res) {
      System.out.println(item);
    }
  }
}
