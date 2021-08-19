package com.interview.leetcode.realcase.pinpoint;

public class AlabToRoma {
  public static String a2r(int number) {
    String rNumber = "";
    int[] aArray = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] rArray = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    if (number < 1 || number > 3999) {
      rNumber = "-1";
    } else {
      for (int i = 0; i < aArray.length; i++) {
        while (number >= aArray[i]) {
          rNumber += rArray[i];
          number -= aArray[i];
        }
      }
    }
    return rNumber;
  }

  public static void main(String[] args) {
    System.out.println(AlabToRoma.a2r(4));
  }
}
