package org.base.leetcode.interview75.backtrack;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75">
 *     216. Combination Sum III</a>
 * <p>
 *     Stats:
 *     Runtime:    0ms (100.00%)
 *     Memory: 40.59mb  (90.95%)
 * </p>
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > 0) {
            List<List<Integer>> all = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            findCombinations(k, n, 1, path, all);
            return all;
        }
        return emptyList();
    }

    void findCombinations(int k, int n, int start, List<Integer> path, List<List<Integer>> all) {
        if (k == 0) {
            if (n == 0)
                all.add(new ArrayList<>(path));
        }
        else {
            for (int i = start; i <= 9; i++) {
                if (i > n) break;
                path.add(i);
                findCombinations(k - 1, n - i, i + 1, path, all);
                path.remove(path.size() - 1);
            }
        }
    }
}
