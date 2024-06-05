package org.base.leetcode.interview75.binarytree.dfs;

import org.base.leetcode.model.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75">
 *     236. Lowest Common Ancestor of a Binary Tree</a>
 * <p>
 *     Stats:
 *     Runtime:   10ms (13.00%)
 *     Memory: 45.25mb (12.26%)
 * </p>
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        setParent(root, parentMap);
        Set<TreeNode> parentsP = new HashSet<>();
        TreeNode parent = p;
        while (!parentsP.contains(parent)) {
            parentsP.add(parent);
            parent = parentMap.get(parent);
        }

        parent = q;
        while (!parentsP.contains(parent)) {
            parent = parentMap.get(parent);
        }
        return parent;
    }

    public void setParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            setParent(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            setParent(root.right, parentMap);
        }
    }
}
