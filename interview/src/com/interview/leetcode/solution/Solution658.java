package com.interview.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 
 * 整数 a 比整数 b 更接近 x 需要满足：
 * 
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * 
 * 示例 1：
 * 
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * 
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution658 {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<>();
    int len = arr.length;
    int i = 0;
    for (; i < len - k; i++) {
      if (arr[i] >= x) {
        break;
      }
      if (arr[i + k] < x) {
        continue;
      }
      if (Math.abs(arr[i] - x) <= Math.abs(arr[i + k] - x)) {
        break;
      }
    }
    for (int j = 0; j < k; j++) {
      ans.add(arr[j + i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 2, 2, 3, 6, 8, 8, 9 };
    int k = 5;
    int x = 9;
    Solution658 solution658 = new Solution658();
    System.err.println(solution658.findClosestElements(arr, k, x));
  }
}
