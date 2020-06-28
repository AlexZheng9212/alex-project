package com.interview.leetcode.solution;

/**
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] Output: false
 */
public class Solution1232 {
  public boolean checkStraightLine(int[][] coordinates) {
    int[] point1 = coordinates[0];
    int[] point2 = coordinates[1];
    float liner = helper(point1, point2);
    float c = point1[1] - point1[0] * liner;
    for (int i = 2; i < coordinates.length; i++) {
      float x = coordinates[i][0];
      float y = coordinates[i][1];
      if (y != liner * x + c) {
        return false;
      }
    }
    return true;
  }

  private float helper(int[] point1, int[] point2) {
    if (point2[0] - point1[0] == 0)
      return 0;
    return (point2[1] - point1[1]) / (point2[0] - point1[0]);
  }

  public static void main(String[] args) {
    int[][] coordinates = new int[][] { { 1, 1 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
    Solution1232 s = new Solution1232();
    System.out.println(s.checkStraightLine(coordinates));
  }
}