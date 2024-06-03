package org.base.leetcode.interview75.dfs;

import java.util.function.Function;

/**
 * <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75">
 *     1372. Longest ZigZag Path in a Binary Tree</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 42.33mb  (67.70%)
 * </p>
 *
 */
public class LongestZigZagPath {

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxZigZag(root.left, true, 0), maxZigZag(root.right, false, 0));
    }

    public int maxZigZag(TreeNode root, boolean direction, int count) {
        if (root == null)
            return count;

        if (direction) { // left
            return Math.max(
                    maxZigZag(root.right, false, 1 + count),
                    maxZigZag(root.left, true, 0));
        }
        else {
            return Math.max(
                    maxZigZag(root.right, false, 0),
                    maxZigZag(root.left, true, 1 + count));
        }
    }
}
