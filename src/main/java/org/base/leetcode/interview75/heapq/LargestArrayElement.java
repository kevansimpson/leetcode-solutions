package org.base.leetcode.interview75.heapq;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75">
 *     994. Rotting Oranges</a>
 * <p>
 *     Stats:
 *     Runtime:   61ms (45.97%)
 *     Memory: 56.78mb (93.19%)
 * </p>
 */
public class LargestArrayElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }
}
