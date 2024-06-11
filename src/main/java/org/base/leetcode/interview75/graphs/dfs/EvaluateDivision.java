package org.base.leetcode.interview75.graphs.dfs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75">
 *     399. Evaluate Division</a>
 * <p>
 *     Stats:
 *     Runtime:    3ms  (13.55%)
 *     Memory: 41.66mb  (95.19%)
 * </p>
 */
public class EvaluateDivision {
    public record Equation(String variable, double value) {}

    private double calculated;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Equation>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String num = list.get(0);
            String div = list.get(1);
            graph.putIfAbsent(num, new ArrayList<>());
            graph.putIfAbsent(div, new ArrayList<>());
            graph.get(num).add(new Equation(div, values[i]));
            graph.get(div).add(new Equation(num, 1.0 / values[i]));
        }

        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String num = list.get(0);
            String div = list.get(1);
            if (!graph.containsKey(num) || !graph.containsKey(div)) {
                answers[i] = -1.0;
                continue;
            }

            calculated = -1.0;
            resolve(num, div, 1.0, new HashSet<>(), graph);
            answers[i] = BigDecimal.valueOf(calculated).setScale(5, RoundingMode.HALF_EVEN).doubleValue();
        }

        return answers;
    }

    void resolve(String num, String div, double value, Set<String> visited, Map<String, List<Equation>> graph) {
        if (num.equals(div)) {
            calculated = value;
            return;
        }

        visited.add(num);
        for (Equation equation : graph.get(num)) {
            if (!visited.contains(equation.variable))
                resolve(equation.variable, div, value * equation.value, visited, graph);
        }
    }
}
/*
equations = [["a","b"],["b","c"]]
values = [2.0,3.0]
queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

a = [(a/b,2.0)]

b = [(b/a,0.5),(b/c,3.0)]

c = [(c/b,1/3)]

stack = [a/c]
 */

/*
[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
values =[3.0,4.0,5.0,6.0]
queries =[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]

x1 = [(x2,3.0)]

x2 = [(x1, 1/3), (x3,4.0)]

x3 = [(x2, 1/4), (x4,5.0)]

x4 = [(x3, 1/5), (x5,6.0)]

x5 = [(x4, 1/6)]

stack = [x2] - weight: 3.0
        [x3] - 12.0
        [x4] - 60.0
        [x5] - 360.0 // return
 */