package org.base.leetcode.interview75.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeDfsTests {

    @Test
    public void testMaxDepthBinaryTree() {
        TreeNode example1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        MaxDepthBinaryTree maxDepth = new MaxDepthBinaryTree();
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

        CountGoodNodesBinaryTree goodNodes = new CountGoodNodesBinaryTree();
        assertEquals(4, goodNodes.goodNodes(example1));
        assertEquals(3, goodNodes.goodNodes(example2));
        assertEquals(1, goodNodes.goodNodes(new TreeNode(1)));
    }
}
