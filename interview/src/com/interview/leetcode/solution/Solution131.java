package com.interview.leetcode.solution;

import java.util.*;

class Solution131 {
    public int length;

    public List<List<String>> partition(String s) {
        List<String> ans = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        length = s.length();
        dfs(res, ans, 0, s);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> ans, int start, String s) {
        if (start == length) {
            List<String> tmp = new ArrayList<>(ans);
            res.add(tmp);
            return;
        }
        for (int j = start + 1; j <= length; j++) {
            String str = s.substring(start, j);
            System.out.println(str);
            if (isPartition(str)) {
                ans.add(str);
                dfs(res, ans, j, s);
                ans.remove(ans.size() - 1);
            }

        }
    }

    private boolean isPartition(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 s = new Solution131();
        String ss = "aab";
        List<List<String>> res = s.partition(ss);
        System.out.println(res.size());
        res.forEach(it -> System.out.println(it));
    }
}