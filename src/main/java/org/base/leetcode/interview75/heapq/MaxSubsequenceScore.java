package org.base.leetcode.interview75.heapq;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/?envType=study-plan-v2&envId=leetcode-75">
 *     2542. Maximum Subsequence Score</a>
 * <p>
 *     Stats:
 *     Runtime:   64ms (92.70%)
 *     Memory: 62.52mb (67.96%)
 * </p>
 */
public class MaxSubsequenceScore {
    public record Pair(int num1, int num2) {}

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long max = -1;
        int n = nums1.length;
        if (k == 1) {
            for (int i = 0; i < n; i++)
                max = Math.max(max, (long) nums1[i] * nums2[i]);
            return max;
        }

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(nums1[i], nums2[i]);

        Arrays.sort(pairs, Comparator.comparingInt(p -> p.num2));

        long sum = 0;
        int threshold = n - k;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = n - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (i <= threshold)
                max = Math.max(max, (sum + p.num1) * p.num2);

            if (queue.size() < k - 1) {
                sum += p.num1;
                queue.add(p.num1);
            }
            else if (p.num1 > queue.peek()) {
                sum -= queue.poll();
                sum += p.num1;
                queue.add(p.num1);
            }
        }
        return max;
    }
}
/*
[3, 1, 3, 2]
[1, 2, 3, 4]
[3, 3, 2, 1]

[2, 1, 4, 1, 3]
[5, 6, 7, 9, 10]
[4, 3, 2, 1, 1]
 */