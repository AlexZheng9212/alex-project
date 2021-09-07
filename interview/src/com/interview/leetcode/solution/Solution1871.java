package com.interview.leetcode.solution;

/**
 * Input: s = "011010", minJump = 2, maxJump = 3 Output: true Explanation: In
 * the first step, move from index 0 to index 3. In the second step, move from
 * index 3 to index 5.
 * 
 */
/**
 * 区间交集问题。。
 */
public class Solution1871 {
  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length();
    if (s.charAt(n - 1) != '0')
      return false;
    int[] diff = new int[n + 1];
    diff[minJump] = 1;
    diff[maxJump + 1] = -1;
    int reach = 0;
    for (int i = 1; i < n; i++) {
      reach += diff[i];
      if (reach == 0)
        continue;
      if (s.charAt(i) == '1')
        continue;
      if (i + minJump <= n)
        diff[i + minJump] += 1;
      if (i + maxJump + 1 < n)
        diff[i + maxJump + 1] -= 1;
    }
    return reach > 0;
  }

  // 双指针走不通
  // private boolean fun(String s, int left, int right, int minJump, int maxJump,
  // int start) {

  // for (int j = left; j <= right; j++) {
  // if (s.charAt(j) == '0') {
  // if (j == s.length() - 1) {
  // return true;
  // }
  // System.out.println("left" + j + minJump);
  // if (j + minJump > s.length() - 1) {
  // return false;
  // }
  // return fun(s, Math.min(j + minJump, s.length() - 1), Math.min(j + maxJump,
  // s.length() - 1), minJump, maxJump,
  // j);
  // }
  // }
  // return false;
  // }

  public static void main(String[] args) {
    String s = "0000000000";
    int minJump = 2;
    int maxJump = 5;
    Solution1871 solution1871 = new Solution1871();
    System.out.println(solution1871.canReach(s, minJump, maxJump));
  }
}
