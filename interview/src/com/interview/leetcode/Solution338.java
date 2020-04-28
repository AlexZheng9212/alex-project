package com.interview.leetcode;

class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution338 s = new Solution338();
        int num = 5;
        int[] res = s.countBits(num);
        for (int item : res) {
            System.out.println(item);
        }
    }
}