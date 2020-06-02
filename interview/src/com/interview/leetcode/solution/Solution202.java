package com.interview.leetcode.solution;

import java.util.HashSet;

class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> hset = new HashSet<>();
        hset.add(n);
        int temp = n;
        while (temp != 1) {
            temp = cal(temp);
            if (!hset.contains(temp)) {
                hset.add(temp);
            } else {
                return false;
            }
        }
        return true;
    }

    private int cal(int n) {
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            sum += mod * mod;
            n = n / 10;
        }
        System.out.println(sum);

        return sum;
    }

    public static void main(String[] args) {
        Solution202 s = new Solution202();
        boolean res = s.isHappy(19);
        System.out.println(res);
    }
}