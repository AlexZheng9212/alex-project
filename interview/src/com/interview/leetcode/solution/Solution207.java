package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }
    int[] flags = new int[numCourses];
    for (int[] tmp : prerequisites) {
      graph.get(tmp[1]).add(tmp[0]);
    }
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(graph, flags, i)) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(List<List<Integer>> list, int[] flags, int i) {
    if (flags[i] == 1) {
      return false;
    }
    if (flags[i] == -1) {
      return true;
    }
    flags[i] = 1;
    for (int j : list.get(i)) {
      if (!dfs(list, flags, j)) {
        return false;
      }
    }
    flags[i] = -1;
    return true;
  }

}
