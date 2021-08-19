package com.interview.leetcode.realcase.pinpoint;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.interview.leetcode.realcase.pinpoint;

/**
 * 2. 使用你熟悉的编程语言编写程序：输入一个价格时间序列，找到一个买点和一个卖点使得本次交易获利最大。 （请注意，买点需在卖点之前）
 */
public class Pinpoint {
  public DateRange findMaxProfit(List<PriceSeries> input) {
    if (input.size() == 0) {
      return new DateRange();
    }

    PriceSeries tmpMinIdx = input.get(0);
    PriceSeries minIdx = input.get(0);
    PriceSeries maxIdx = input.get(0);
    BigDecimal profit = BigDecimal.ZERO;
    for (int i = 1; i < input.size(); i++) {
      if (input.get(i).getPrice().compareTo(tmpMinIdx.getPrice()) == -1) {
        tmpMinIdx = input.get(i);
        System.out.println(tmpMinIdx.getPrice());
      }
      BigDecimal tmp = input.get(i).getPrice().subtract(tmpMinIdx.getPrice());
      System.out.println(tmp);
      if (tmp.compareTo(profit) == 1) {
        profit = tmp;
        maxIdx = input.get(i);
        minIdx = tmpMinIdx;
      }
    }
    System.out.println(minIdx.getDate() + " " + maxIdx.getDate() + " " + profit);
    return new DateRange(minIdx.getDate(), maxIdx.getDate());
  }

  public static void main(String[] args) {
    List<PriceSeries> input = new LinkedList<>();
    input.add(new PriceSeries("2020-03-12", new BigDecimal(89.05731583)));
    input.add(new PriceSeries("2020-03-13", new BigDecimal(12.2478028)));
    input.add(new PriceSeries("2020-03-14", new BigDecimal(13.65039261)));
    input.add(new PriceSeries("2020-03-15", new BigDecimal(40.12335715)));
    input.add(new PriceSeries("2020-03-16", new BigDecimal(1.750565892)));
    input.add(new PriceSeries("2020-03-17", new BigDecimal(3.750565892)));
    Pinpoint pinpoint = new Pinpoint();
    pinpoint.findMaxProfit(input);

  }
}
