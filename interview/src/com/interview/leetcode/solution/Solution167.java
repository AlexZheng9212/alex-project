package com.interview.leetcode.solution;

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int sum = numbers[i] + numbers[mid];
                if (sum == target) {
                    return new int[] { i, mid };
                } else if (sum < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[] { -1, -1 };
    }
    // two pointers;
    // public int[] twoSum(int[] numbers, int target) {
    // int head = 0;
    // int tail = numbers.length - 1;
    // int[] res = new int[2];
    // while (head <= tail) {
    // if (numbers[head] + numbers[tail] == target) {
    // res[0] = head;
    // res[1] = tail;
    // break;
    // }
    // if (numbers[head] + numbers[tail] > target) {
    // tail--;
    // }
    // if (numbers[head] + numbers[tail] < target) {
    // head++;
    // }
    // }

    // return res;
    // }

}