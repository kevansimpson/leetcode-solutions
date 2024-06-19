package org.base.leetcode.interview75.heapq;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75">
 *     2462. Total Cost to Hire K Workers</a>
 * <p>
 *     Stats:
 *     Runtime:   46ms (89.08%)
 *     Memory: 56.01mb (86.88%)
 * </p>
 */
public class TotalCostWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headQ = new PriorityQueue<>();
        PriorityQueue<Integer> tailQ = new PriorityQueue<>();
        int n = costs.length, ixHead = 0, ixTail = n - 1;
        for (int i = 0; i < candidates; i++)
            headQ.add(costs[ixHead++]);
        for (int i = n - 1; i >= Math.max(candidates, n - candidates); i--)
            tailQ.add(costs[ixTail--]);

        long sum = 0;
        for (int hired = 0; hired < k; hired++) {
            if (tailQ.isEmpty() || !headQ.isEmpty() && headQ.peek() <= tailQ.peek()) {
                sum += headQ.poll();
                if (ixHead <= ixTail)
                    headQ.add(costs[ixHead++]);
            }
            else {
                sum += tailQ.poll();
                if (ixHead <= ixTail)
                    tailQ.add(costs[ixTail--]);
            }
        }

        return sum;
    }
}
