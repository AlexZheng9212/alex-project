package com.interview.leetcode.solution;

class Solution713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int head = 0, tail = 0;
        int product = 1;
        while (tail < len) {
            product *= nums[tail];
            while (head <= tail && product >= k) {
                product /= nums[head];
                head++;
            }

            tail++;
            count += tail - head + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution713 s = new Solution713();
        int k = 19;
        int[] nums = new int[] { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 };
        int res = s.numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
}