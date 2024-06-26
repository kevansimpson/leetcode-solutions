package org.base.leetcode.interview75.binarytree.dfs;

import org.base.leetcode.interview75.binarytree.dfs.*;
import org.base.leetcode.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.base.leetcode.model.TreeNode.fromString;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeDfsTests {

    @Test
    public void testMaxDepthBinaryTree() {
        TreeNode example1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        MaxDepth maxDepth = new MaxDepth();
        assertEquals(3, maxDepth.maxDepth(example1));
    }

    @Test
    public void testLeafSimilarTrees() {
        TreeNode example1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7), new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(9), new TreeNode(8)));
        LeafSimilarTrees simLeafs = new LeafSimilarTrees();

        List<Integer> leaves = new ArrayList<>();
        simLeafs.collectLeaves(example1, leaves);
        assertEquals(List.of(6, 7, 4, 9, 8), leaves);
        assertTrue(simLeafs.leafSimilar(example1, example1));
    }

    @Test
    public void testCountGoodNodes() {
        TreeNode example1 = new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        TreeNode example2 = new TreeNode(3,
                new TreeNode(3, new TreeNode(4), new TreeNode(2)),
                null);

        CountGoodNodes goodNodes = new CountGoodNodes();
        assertEquals(4, goodNodes.goodNodes(example1));
        assertEquals(3, goodNodes.goodNodes(example2));
        assertEquals(1, goodNodes.goodNodes(new TreeNode(1)));
    }

    @Test
    public void testPathSum3() {
        TreeNode example1 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        TreeNode example1a = fromString("[10,5,-3,3,2,null,11,3,-2,null,1]");
        assertTrue(TreeNode.equals(example1, example1a));

        PathSum3 pathSum3 = new PathSum3();
        assertEquals(3, pathSum3.pathSum(example1, 8));
        assertEquals(2, pathSum3.pathSum(fromString(
                "[1,null,2,null,3,null,4,null,5]"), 3));
        assertEquals(0, pathSum3.pathSum(fromString(
                "[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]"), 0));
    }

    @Test
    public void testLongestZigZag() {
        LongestZigZagPath zigZag = new LongestZigZagPath();
        assertEquals(3, zigZag.longestZigZag(fromString(
                "[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]")));
        assertEquals(4, zigZag.longestZigZag(fromString(
                "[1,1,1,null,1,null,null,1,1,null,1]")));
        assertEquals(0, zigZag.longestZigZag(fromString("[1]")));
        assertEquals(2, zigZag.longestZigZag(fromString(
                "[1,1,1,1,1,1,1,null,null,null,null,null,null,1,1,null,null,1]")));
    }

    @Test
    public void testLowestCommonAncestor() {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode example1 = fromString("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode actual1 = lca.lowestCommonAncestor(example1, example1.left, example1.right);
        assertNotNull(actual1);
        assertEquals(3, actual1.val);
        assertEquals(example1, actual1);

        TreeNode example2 = fromString("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode actual2 = lca.lowestCommonAncestor(example2,
                example2.left, example2.left.right.right);
        assertNotNull(actual2);
        assertEquals(5, actual2.val);
        assertEquals(example2.left, actual2);

        TreeNode example3 = fromString("[1,2]");
        TreeNode actual3 = lca.lowestCommonAncestor(example3,
                example3, example3.left);
        assertNotNull(actual3);
        assertEquals(1, actual3.val);
        assertEquals(example3, actual3);
    }
}
