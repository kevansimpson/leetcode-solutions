package org.base.leetcode.interview75.heapq;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75">
 *     2336. Smallest Number in Infinite Set</a>
 * <p>
 *     Stats:
 *     Runtime:   9ms  (95.68%)
 *     Memory: 44.88mb (97.27%)
 * </p>
 */
public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final Set<Integer> set = new HashSet<>();
    private int minimum = 1;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (queue.isEmpty())
            return minimum++;

        int min = queue.poll();
        set.remove(min);
        return min;
    }

    public void addBack(int num) {
        if (minimum > num && !set.contains(num)) {
            queue.offer(num);
            set.add(num);
        }
    }
}
