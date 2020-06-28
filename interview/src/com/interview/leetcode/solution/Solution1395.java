package com.interview.leetcode.solution;

/**
 * 给定一个数组，按顺序找出元素是线性递增或递减的数组数码
 */
class Solution1395 {
    public int numsTeam(int[] rating) {
        int len = rating.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    l++;
            }
            for (int k = i + 1; k < len; k++) {
                if (rating[i] < rating[k])
                    r++;
            }
            ans += l * r + (i - l) * (len - i - 1 - r);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}