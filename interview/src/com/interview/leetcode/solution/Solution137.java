package com.interview.leetcode.solution;

import java.util.*;

class Solution137 {
    int res;

    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], true);
            } else {
                hmap.put(nums[i], false);
            }
        }
        hmap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);

            if (v == true) {
                System.out.println("k: ");

                System.out.println(k);
                res = k;
            }
        });
        return res;
    }

    public static void main(String[] args) {
        Solution137 s = new Solution137();
        int[] nums = new int[] { 2, 2, 3, 2 };
        int res = s.singleNumber(nums);
        System.out.println(res);
    }
}