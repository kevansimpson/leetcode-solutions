package org.base.leetcode.interview75.dp.oned;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75">
 *     746. Min Cost Climbing Stairs</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 42.68mb  (89.33%)
 * </p>
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);

        return Math.min(cost[0], cost[1]);
    }
}
