package com.interview.leetcode.solution;

/**
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * 
 * 返回交换 任意 次之后 num 的 最大 可能值。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 * 
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 * 
 */
public class Solution2231 {
  public int largestInteger(int num) {
    int[] isEven = new int[10];
    int[] count = new int[10];
    String tmp = String.valueOf(num);
    for (int i = 0; i < tmp.length(); i++) {
      int a = tmp.charAt(i) - '0';
      if (a % 2 == 0) {
        ++count[a];
        isEven[i] = 1;
      } else {
        ++count[a];
      }
    }
    int maxEven = 8;
    int maxOdd = 9;
    int cal = 0;
    int ans = 0;
    for (int j = 0; j < tmp.length(); j++) {
      if (isEven[j] == 1) {
        while (maxEven > 0 && count[maxEven] == 0) {
          maxEven = maxEven - 2;
        }
        cal = maxEven;
        --count[maxEven];
      } else {
        while (maxOdd > 0 && count[maxOdd] == 0) {
          maxOdd = maxOdd - 2;
        }
        cal = maxOdd;
        --count[maxOdd];
      }
      ans = 10 * ans + cal;
    }
    return ans;
  }
}
