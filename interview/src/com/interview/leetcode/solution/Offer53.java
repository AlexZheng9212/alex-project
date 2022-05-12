package com.interview.leetcode.solution;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 
 *  
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * 
 * 提示：
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
class Offer53 {
  public static int search(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    return bs(nums, 0, nums.length - 1, target);
  }

  static int bs(int[] nums, int left, int right, int target) {
    if (left < 0 || left >= nums.length || right < 0 || right >= nums.length) {
      return 0;
    }
    if ((left == right && nums[left] != target)) {
      return 0;
    }
    int mid = (left + right) / 2;
    if (nums[mid] < target) {
      return bs(nums, mid + 1, right, target);
    }
    if (nums[mid] > target) {
      return bs(nums, left, mid - 1, target);
    }
    int tmp = 1;
    if (nums[mid] == target) {
      left = mid - 1;
      right = mid + 1;
      while (left >= 0 && nums[left] == target) {
        tmp++;
        left--;
      }
      while (right <= nums.length - 1 && nums[right] == target) {
        tmp++;
        right++;
      }
    }
    return tmp;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 6, 6, 8, 8, 10 };
    System.out.println(search(nums, 6));
  }

}