package com.interview.coding.impl;

import com.interview.coding.Sort;
import java.util.Comparator;

public class QuickSort implements Sort{
  @Override
  public <T extends Comparable<T>> void sort(T[] arr) {
    sort(arr, 0, arr.length -1);
  }

  @Override
  public <T> void sort(T[] arr, Comparator<T> comp) {
    sort(arr, 0, arr.length-1, comp);
  }

  // Default comparator
  private <T extends Comparable<T>>void sort(T[] arr, int low, int high){
    if(low >= high){
      return;
    }
    int div = partition(arr, low, high);
    sort(arr, low, div);
    sort(arr, div + 1, high);
  }
  private <T extends Comparable<T>> int partition(T[] arr, int low , int high){
    if(low >= high){
      return high;
    }
    T privot = arr[(low + high)/2];
    int p = low - 1;
    int q = high + 1;
    while(true){
      while(arr[++p].compareTo(privot)<0){}
      while(arr[--q].compareTo(privot)>0){}
      if(p >= q){
        return q;
      }
      swap(arr, p, q);
    }

  }

  private <T extends Comparable<T>> void swap(T[] arr, int low, int high){
    T temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
  }

  // customize comparator

  private <T> void sort(T[] arr, int low, int high, Comparator<T> comp){
    if(low >= high){
      return;
    }
    int div = partition(arr, low, high, comp);
    sort(arr,low, div,comp);
    sort(arr, div+1, high,comp);
  }

  private <T> int partition(T[] arr, int low, int high, Comparator<T> comp){
    if(low >= high){
      return high;
    }
    T privot = arr[(low+high)/2];
    int p = low - 1;
    int q = high + 1;
    while(true){
      while(comp.compare(arr[++p], privot)<0){}
      while(comp.compare(arr[--q], privot)>0){}
      if(p>=q){
        return q;
      }
      swap(arr, low, high);
    }
  }

  private <T> void swap(T[] arr, int low, int high){
    T temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
  }
}