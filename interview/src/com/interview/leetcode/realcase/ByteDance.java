package com.interview.leetcode.realcase;

import java.util.Arrays;

public class ByteDance {
  public boolean meetingRoom(int[] startTime, int[] endTime, int num) {
    Arrays.sort(startTime);
    Arrays.sort(endTime);
    int startTimeLen = startTime.length;
    int endTimeLen = endTime.length;
    int len = startTimeLen + endTimeLen;
    int[] allTime = new int[len];
    int a = 0;
    int b = 0;
    int k = 0;
    while (a < startTimeLen && b < endTimeLen) {
      if (Math.abs(startTime[a]) < Math.abs(endTime[b])) {
        allTime[k++] = startTime[a++];
      } else if (Math.abs(startTime[a]) > Math.abs(endTime[b])) {
        allTime[k++] = -1 * endTime[b++];
      } else {
        if (startTime[a] < endTime[b]) {
          allTime[k++] = startTime[a++];
        } else {
          allTime[k++] = -1 * endTime[b++];
        }
      }
    }
    while (a < startTimeLen) {
      allTime[k++] = startTime[a++];
    }
    while (b < startTimeLen) {
      allTime[k++] = -1 * endTime[b++];
    }
    int max = 0;
    int count = 0;
    for (int it : allTime) {
      if (it >= 0) {
        count++;
      } else {
        count--;
      }
      max = Math.max(count, max);
    }
    return num >= max;
  }

  public static void main(String[] args) {
    int[] startTime = { 1, 2, 2, 3, 4 };
    int[] endTime = { 2, 4, 5, 4, 6 };
    ByteDance byteDance = new ByteDance();
    System.out.println(byteDance.meetingRoom(startTime, endTime, 2));
  }
}