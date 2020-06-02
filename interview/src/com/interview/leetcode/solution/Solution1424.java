package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class Solution1424 {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    ArrayList<Integer> rtmp = new ArrayList<>();
    ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        if (temp.size() <= i + j) {
          temp.add(new ArrayList<>());
        }
        temp.get(i + j).add(nums.get(i).get(j));
      }
    }
    for (int k = 0; k < temp.size(); k++) {
      Collections.reverse(temp.get(k));
      rtmp.addAll(temp.get(k));
    }
    int[] res = rtmp.stream().mapToInt(Integer::intValue).toArray();
    return res;
  }
}