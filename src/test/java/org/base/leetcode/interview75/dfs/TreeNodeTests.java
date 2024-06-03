package org.base.leetcode.interview75.dfs;

import org.junit.jupiter.api.Test;

import static org.base.leetcode.interview75.dfs.TreeNode.fromString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeNodeTests {
    @Test
    public void testFromString() {
        TreeNode allRight = new TreeNode(1,
                null, new TreeNode(2,
                    null, new TreeNode(3,
                        null, new TreeNode(4,
                            null, new TreeNode(5)))));
        assertTrue(TreeNode.equals(allRight, fromString("[1,null,2,null,3,null,4,null,5]")));

        TreeNode example1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        assertTrue(TreeNode.equals(example1, fromString("[10,5,-3,3,2,null,11,3,-2,null,1]")));

        TreeNode example2 = new TreeNode(1000000000,
                new TreeNode(1000000000,
                        new TreeNode(294967296,
                                new TreeNode(1000000000,
                                        new TreeNode(1000000000,
                                                new TreeNode(1000000000),
                                                null),
                                        null),
                                null),
                        null),
                null);
        assertTrue(TreeNode.equals(example2, fromString(
                "[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]")));
    }
}
