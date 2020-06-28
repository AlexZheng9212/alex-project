package com.interview.leetcode.solution;

import java.util.*;

class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> hset = new HashSet<>();
        boolean res = dfs(arr, hset, start);
        return res;
    }

    private boolean dfs(int[] arr, HashSet<Integer> visited, int curIndex) {
        if (curIndex > arr.length - 1 || curIndex < 0) {
            return false;
        }
        if (visited.contains(curIndex)) {
            return false;
        }
        visited.add(curIndex);
        if (arr[curIndex] == 0) {
            return true;
        }
        return dfs(arr, visited, arr[curIndex] + curIndex) || dfs(arr, visited, curIndex - arr[curIndex]);
    }

    public static void main(String[] args) {
        Solution1306 s = new Solution1306();
        int[] arr = new int[] { 3, 0, 2, 1, 2 };
        int start = 2;
        boolean res = s.canReach(arr, start);
        System.out.println(res);
    }
}