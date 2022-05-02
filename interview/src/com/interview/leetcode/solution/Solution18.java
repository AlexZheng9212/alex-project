package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < len - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int start = j + 1;
        int end = len - 1;
        while (start < end) {
          int tmp = nums[i] + nums[j] + nums[start] + nums[end];
          if (tmp > target) {
            end--;
          } else if (tmp < target) {
            start++;
          } else {
            ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
            start++;
            end--;
            while (start < end && nums[start] == nums[start - 1])
              start++;
            while (start < end && nums[end] == nums[end + 1])
              end--;
          }
        }
      }
    }
    return ans;
  }
}
