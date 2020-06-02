package com.interview.leetcode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Sell {
  void sell();

  void add();
}

class Vendor implements Sell {
  public void sell() {
    System.out.println("sell");
  }

  public void add() {
    System.out.println("add");
  }
}

// class BusinessAgent implements Sell {
// Vendor vendor;

// BusinessAgent(Vendor vendor) {
// this.vendor = vendor;
// }

// public void sell() {
// vendor.sell();
// }

// public void add() {
// vendor.add();
// }
// }

class DynamicProxy implements InvocationHandler {
  private Object object;

  DynamicProxy(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before...");
    Object result = method.invoke(object, args);
    System.out.println("after...");
    return result;
  }
}

public class ProxyMethod {
  public static void main(String[] args) {
    Sell sell = new Vendor();
    DynamicProxy dynamicProxy = new DynamicProxy(sell);
    Sell proxy = (Sell) Proxy.newProxyInstance(sell.getClass().getClassLoader(), sell.getClass().getInterfaces(),
        dynamicProxy);
    proxy.add();
    proxy.sell();
  }

}
