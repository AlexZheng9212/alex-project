package com.interview.leetcode;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int low, int high, int target) {
        if (low >= high)
            return nums[target];
        int div = partition(nums, low, high);
        if (target <= div) {
            return quickSort(nums, low, div, target);
        }
        return quickSort(nums, div + 1, high, target);

    }

    public int partition(int[] nums, int low, int high) {
        if (low >= high) {
            return low;
        }
        int privot = nums[(low + high) / 2];
        int l = low - 1;
        int h = high + 1;
        while (true) {
            while (nums[++l] < privot) {
            }
            while (nums[--h] > privot) {
            }
            if (l >= h) {
                return h;
            }
            swap(nums, l, h);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        Solution215 s = new Solution215();
        int[] nums = new int[] { 2, 3, 4, 5, 6, 1 };
        int k = 2;
        int res = s.findKthLargest(nums, k);
        System.out.println(res);
    }
}