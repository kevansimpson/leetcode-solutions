package org.base.leetcode.interview75.dp.multid;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75">
 *     714. Best Time to Buy and Sell Stock with Transaction Fee</a>
 * Solution via https://leetcode.com/u/fun4LeetCode/
 * <p>
 *     Stats:
 *     Runtime:   4ms   (99.51%)
 *     Memory: 54.73mb  (83.97%)
 * </p>
 */
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int buy = 0, sell = Integer.MIN_VALUE;
        for (int p : prices) {
            int oldBuy = buy;
            buy = Math.max(buy, sell + p);
            sell = Math.max(sell, oldBuy - p - fee);
        }
        return buy;
    }
}
