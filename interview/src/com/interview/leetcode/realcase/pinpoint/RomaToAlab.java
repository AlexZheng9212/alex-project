package com.interview.leetcode.realcase.pinpoint;

import java.util.HashMap;
import java.util.Map;

public class RomaToAlab {
  public int ConvertToNumber(String romanNumber) {
    int length = romanNumber.length();
    Map<String, Integer> digits = new HashMap<>();
    digits.put("I", 1);
    digits.put("V", 5);
    digits.put("X", 10);
    digits.put("L", 50);
    digits.put("C", 100);
    digits.put("D", 500);
    digits.put("M", 1000);
    int number = 0;
    for (int i = 0; i < length; i++) {
      if (i == length - 1) {
        number += digits.get(String.valueOf(romanNumber.charAt(i)));
      } else if ((digits.get(String.valueOf(romanNumber.charAt(i))) >= digits
          .get(String.valueOf(romanNumber.charAt(i + 1))) || i + 1 >= length)) {
        number += digits.get(String.valueOf(romanNumber.charAt(i)));
      } else {
        number -= digits.get(String.valueOf(romanNumber.charAt(i)));
      }
    }

    return number;
  }

  public static void main(String[] args) {
    String romanNum = "XX";
    RomaToAlab romaToAlab = new RomaToAlab();
    int res = romaToAlab.ConvertToNumber(romanNum);
    System.out.println(res);
  }
}
