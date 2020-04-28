package com.interview.leetcode;

/**
 * DP状态转移
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-309-best-time-to-buy-and-sell-stock-with-cooldown/
 */

class Solution309 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int cooldown = 0;
        for (int price : prices) {
            int preSell = sell;
            sell = buy + price;
            buy = Math.max(buy, cooldown - price);
            cooldown = Math.max(cooldown, preSell);
        }
        return Math.max(sell, cooldown);
    }

    public static void main(String[] args) {
        Solution309 s = new Solution309();
        int[] prices = new int[] { 1, 2, 3, 0, 2 };
        System.out.println(s.maxProfit(prices));

    }
}