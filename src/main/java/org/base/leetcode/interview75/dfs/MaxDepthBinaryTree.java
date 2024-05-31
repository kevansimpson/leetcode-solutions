package org.base.leetcode.interview75.dfs;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=leetcode-75">
 *     Maximum Depth of Binary Tree</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 42.33mb  (67.70%)
 * </p>
 *
 */
public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int depth) {
        if (root == null)
            return depth;
        else
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
