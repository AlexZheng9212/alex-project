package com.interview.leetcode.solution;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution6 {
  public String convert(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    int len = s.length();
    int delta = 2 * numRows - 2;
    for (int i = 0; i < numRows; i++) {
      for (int j = i; j < len; j = j + delta) {
        sb.append(s.charAt(j));
        if (i > 0 && i < numRows - 1) {
          int t = j + delta - 2 * i;
          if (t < len) {
            sb.append(s.charAt(t));
          }
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    Solution6 solution6 = new Solution6();
    String ans = solution6.convert(s, 3);
    System.out.println(ans);
  }
}
