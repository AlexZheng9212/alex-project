package com.interview.leetcode.solution;

import java.util.Arrays;

class Solution179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] resnums = new String[len];
        String res = "";
        for (int i = 0; i < len; i++) {
            resnums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(resnums, (a, b) -> (b + a).compareTo(a + b));

        for (String item : resnums) {
            res += item;
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }

    public static void main(String[] args) {
        Solution179 s = new Solution179();
        int[] nums = new int[] { 3, 30, 34, 5, 9 };
        String res = s.largestNumber(nums);
        System.out.println(res);

    }
}