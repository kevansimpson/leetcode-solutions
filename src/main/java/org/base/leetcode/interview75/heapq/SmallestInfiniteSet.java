package org.base.leetcode.interview75.heapq;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/?envType=study-plan-v2&envId=leetcode-75">
 *     2336. Smallest Number in Infinite Set</a>
 * <p>
 *     Stats:
 *     Runtime:   9ms  (95.68%)
 *     Memory: 44.78mb (98.72%)
 * </p>
 */
public class SmallestInfiniteSet {
    private final TreeSet<Integer> set = new TreeSet<>();
    private int minimum = 1;

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (set.isEmpty())
            return minimum++;

        int min = set.first();
        set.remove(min);
        return min;
    }

    public void addBack(int num) {
        if (minimum > num && !set.contains(num)) {
            set.add(num);
        }
    }
}
