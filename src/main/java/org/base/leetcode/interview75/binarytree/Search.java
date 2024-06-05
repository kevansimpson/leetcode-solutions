package org.base.leetcode.interview75.binarytree;

import org.base.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan-v2&envId=leetcode-75">
 *     700. Search in a Binary Search Tree</a>
 * <p>
 *     Stats:
 *     Runtime:    3ms (100.00%)
 *     Memory: 44.37mb  (99.26%)
 * </p>
 */
public class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            while (!nodeList.isEmpty()) {
                List<TreeNode> next = new ArrayList<>();
                for (TreeNode n : nodeList) {
                    if (n.val == val)
                        return n;
                    if (n.left != null)
                        next.add(n.left);
                    if (n.right != null)
                        next.add(n.right);
                }
                nodeList = next;
            }
        }
        return null;
    }
}
