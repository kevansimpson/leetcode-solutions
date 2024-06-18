package org.base.leetcode.interview75.heapq;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/?envType=study-plan-v2&envId=leetcode-75">
 *     2542. Maximum Subsequence Score</a>
 * <p>
 *     Stats:
 *     Runtime:   61ms (45.97%)
 *     Memory: 56.78mb (93.19%)
 * </p>
 */
public class MaxSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
        int n = nums1.length;

        List<Integer> sorted = new ArrayList<>();
        for (int num : nums1)
            sorted.add(num);
        sorted.sort(Comparator.reverseOrder());

        for (int i = 0; i < nums1.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums2[j] < nums2[min])
                    min = j;
            }
            swap(nums1, min, i);
            swap(nums2, min, i);
        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(sorted);

        long max = -1;
        long sum = 0;
        for (int j = 0; j < k; j++)
            sum += sorted.get(j);
        for (int i = 0; i < n; i++) {

            max = Math.max(max, sum * nums2[i]);
            int ix = sorted.indexOf(nums1[i]);
            sorted.remove(ix);
            if (sorted.size() < k)
                break;
            else if (ix < k) {
                sum = 0;
                for (int j = 0; j < k; j++)
                    sum += sorted.get(j);
            }
        }
        return max;
    }

    void swap(int[] arr, int ix1, int ix2) {
        int temp = arr[ix1];
        arr[ix1] = arr[ix2];
        arr[ix2] = temp;
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