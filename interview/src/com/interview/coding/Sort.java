package com.interview.coding;

import java.util.Comparator;

public interface Sort {
  <T extends Comparable<T>> void sort(T[] arr);
  <T> void sort(T[] arr, Comparator<T> comp);
}