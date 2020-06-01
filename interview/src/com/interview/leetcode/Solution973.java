package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation: The
 * distance between (1, 3) and the origin is sqrt(10). The distance between (-2,
 * 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to
 * the origin. We only want the closest K = 1 points from the origin, so the
 * answer is just [[-2,2]].
 */
public class Solution973 {
  public int[][] kClosest(int[][] points, int K) {
    List<int[]> res = new ArrayList<>();
    if (points.length == 0 || points[0].length == 0)
      return res.toArray(new int[res.size()][2]);
    PriorityQueue<int[]> pq = new PriorityQueue<>(K, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
    for (int[] item : points) {
      pq.offer(item);
    }
    while (!pq.isEmpty() && K-- > 0) {
      int[] temp = pq.poll();
      res.add(temp);
    }
    int[][] ans = new int[res.size()][2];
    return res.toArray(ans);
  }

  public int test(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    for (int item : nums) {
      pq.offer(item);
    }
    while (!pq.isEmpty()) {
      int cur = pq.poll();
      res.add(cur);
    }
    return res.get(res.size() - k);
  }

  public static void main(String[] args) {
    Solution973 s = new Solution973();
    int[][] points = new int[][] { { 0, 1 }, { 3, 3 }, { 5, -1 }, { 2, 4 }, { 1, 1 } };
    int K = 2;
    int[][] ans = s.kClosest(points, K);
    for (int[] it : ans) {
      System.out.println(it[0] + " " + it[1]);
    }

    int[] nums = { 3, 2, 1, 5, 6, 4 };
    System.out.println(s.test(nums, 2));
  }
}