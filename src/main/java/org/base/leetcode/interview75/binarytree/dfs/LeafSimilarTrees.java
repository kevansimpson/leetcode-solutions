package org.base.leetcode.interview75.binarytree.dfs;

import org.base.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75">
 *     Leaf-Similar Trees</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 41.23mb  (60.44%)
 * </p>
 *
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2 == null;
        else if (root2 == null)
            return false;

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null)
            leaves.add(node.val);
        else {
            if (node.left != null)
                collectLeaves(node.left, leaves);
            if (node.right != null)
                collectLeaves(node.right, leaves);
        }
    }
}
