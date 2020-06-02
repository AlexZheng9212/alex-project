package com.interview.algorithms.basicdatastruct;

import java.util.ArrayList;

/**
 * 10.1-1
 * 
 * @param args
 */
public class MyStack {
  private ArrayList<Integer> arrayList;

  public MyStack() {
    arrayList = new ArrayList<>();
  }

  public void push(Integer val) {
    arrayList.add(val);
  }

  public Integer pop() {
    if (arrayList.size() == 0) {
      return null;
    }
    Integer val = arrayList.get(0);
    arrayList.remove(0);
    return val;
  }

  public static void main(String[] args) {
    MyStack ms = new MyStack();
    ms.push(156);
    System.out.println(ms.pop());
    System.out.println(ms.pop());

  }
}

/**
 * 10.1-2
 */
class OneArrayImplTwoStack {
  int size;
  int[] array;
  int leftPointer = -1;
  int rightPointer = size;

  public OneArrayImplTwoStack(int n) {
    size = n;
    array = new int[n];
    rightPointer = n;
  }

  public void lPush(int val) {
    int delta = Math.abs(leftPointer - rightPointer);
    if (delta == 1) {
      return; // stack is full
    }
    leftPointer++;
    array[leftPointer] = val;
  }

  public void rPush(int val) {
    int delta = Math.abs(leftPointer - rightPointer);
    if (delta == 1) {
      return; // stack is full
    }
    rightPointer--;
    array[rightPointer] = val;
  }

  public Integer lPop() {
    if (leftPointer < 0) {
      return null;
    }
    return array[leftPointer--];
  }

  public Integer rPop() {
    if (rightPointer > size) {
      return null;
    }
    return array[rightPointer++];
  }

  public static void main(String[] args) {
    int n = 5;
    OneArrayImplTwoStack one = new OneArrayImplTwoStack(n);
    one.lPush(1);
    one.lPush(2);
    one.lPush(3);
    one.rPush(4);
    one.rPush(5);
    one.rPush(6);
    System.out.println(one.lPop());
    System.out.println(one.lPop());
    System.out.println(one.rPop());
  }
}
