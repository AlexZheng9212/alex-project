package com.interview.leetcode.solution;

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] res = new int[2];
        while (head <= tail) {
            if (numbers[head] + numbers[tail] == target) {
                res[0] = head;
                res[1] = tail;
                break;
            }
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            }
            if (numbers[head] + numbers[tail] < target) {
                head++;
            }
        }

        return res;
    }
}