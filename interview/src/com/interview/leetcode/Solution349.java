package com.interview.leetcode;

import java.util.*;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numset1 = new HashSet<>();
        Set<Integer> numset2 = new HashSet<>();
        List<Integer> resList = new ArrayList<>();
        for (int item1 : nums1) {
            numset1.add(item1);
        }
        for (int item2 : nums2) {
            numset2.add(item2);
        }
        if (numset1.size() > numset2.size()) {
            for (int item : numset2) {
                if (numset1.contains(item)) {
                    resList.add(item);
                }
            }
        } else {
            for (int item : numset1) {
                if (numset2.contains(item)) {
                    resList.add(item);
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;

    }

    public static void main(String[] args) {

    }
}