package com.kozionov.leetcode.easy.array;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
class BestTrade {

    /**
     * 241 ms	39.3 MB
     */
    static class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int max = 0;
            for(int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] <= prices[j]) {
                        int trade = prices[j] - prices[i];

                        if (trade > max) {
                            max = trade;
                        }
                    }
                }
            }

            return max;
        }
    }

    /**
     * 265 ms	39.1 MB
     */
    static class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int max = 0;
            for(int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int trade = prices[j] - prices[i];
                    if (trade > max) {
                        max = trade;
                    }
                }
            }

            return max;
        }
    }

}