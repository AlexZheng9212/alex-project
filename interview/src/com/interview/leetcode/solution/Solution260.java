package com.interview.leetcode.solution;

import java.util.*;

class Solution260 {
    public int[] singleNumber(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], true);
            } else {
                hmap.put(nums[i], false);
            }
        }

        hmap.forEach((k, v) -> {

            if (v == true) {

                res.add(k);
            }
        });
        int[] result = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
}