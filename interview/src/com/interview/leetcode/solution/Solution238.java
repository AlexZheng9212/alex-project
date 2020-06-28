package com.interview.leetcode.solution;

// 除自己以外的乘积
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int mult = 1;
        int firstZero = 0;
        boolean isZero = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0 && !isZero) {
                isZero = true;
                firstZero = i;
            } else if (nums[i] == 0 && isZero) {
                mult = 0;
            } else if (nums[i] != 0) {
                mult *= nums[i];
            }
        }
        int[] res = new int[len];
        if (mult == 0) {
            return res;
        }
        if (isZero) {
            res[firstZero] = mult;
            return res;
        }

        for (int j = 0; j < len; j++) {
            res[j] = mult / nums[j];
        }

        return res;
    }

    public static void main(final String[] args) {

    }
}