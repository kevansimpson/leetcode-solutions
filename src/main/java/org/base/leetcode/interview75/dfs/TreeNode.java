package org.base.leetcode.interview75.dfs;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int v) { val = v; }
    TreeNode(int v, TreeNode l, TreeNode r) {
        this(v);
        left = l;
        right = r;
    }
}
