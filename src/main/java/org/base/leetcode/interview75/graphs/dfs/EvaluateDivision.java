package org.base.leetcode.interview75.graphs.dfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75">
 *     399. Evaluate Division</a>
 * <p>
 *     Stats:
 *     Runtime:   34ms  (87.33%)
 *     Memory: 69.41mb  (76.14%)
 * </p>
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> variables = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0), div = equations.get(i).get(1);
            variables.put(key(num, div), values[i]);
            variables.put(key(div, num), 1.0 / values[i]);
            variables.put(key(num, num), 1.0);
            variables.put(key(div, div), 1.0);
            for (int j = i + 1; j < equations.size(); j++) {
                String num2 = equations.get(j).get(0), div2 = equations.get(j).get(1);
                if (num.equals(div2)) {
                    variables.put(key(num2, div), values[i] * values[j]);
                    variables.put(key(div, num2), 1.0 / (values[i] * values[j]));
                }
                else if (num2.equals(div)) {
                    variables.put(key(num, div2), values[i] * values[j]);
                    variables.put(key(div2, num), 1.0 / (values[i] * values[j]));
                }
            }
        }
        System.out.println(variables);
        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String num = query.get(0), div = query.get(1);
            answers[i] = variables.getOrDefault(key(num, div), -1.0);
        }
        System.out.println(Arrays.toString(answers));
        return answers;
    }

    String key(String num, String div) {
        return num +"/"+ div;
    }

    public record Road(int node, int weight) {}

    public int minReorder(int n, int[][] connections) {
        Deque<Road>[] roads = new Deque[n];
        for (int i = 0; i < n; i++)
            roads[i] = new LinkedList<>();

        for (int[] r : connections) {
            roads[r[0]].add(new Road(r[1], 1));
            roads[r[1]].add(new Road(r[0], 0));
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;

                for (Road road : roads[node]) {
                    if (!visited[road.node]) {
                        stack.add(road.node);
                        if (road.weight == 1)
                            count++;
                    }
                }
            }
        }

        return count;
    }
}
