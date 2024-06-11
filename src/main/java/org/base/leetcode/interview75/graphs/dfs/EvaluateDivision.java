package org.base.leetcode.interview75.graphs.dfs;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public record Equation(Fraction fraction, double value) {}
    public record Fraction(String num, String div) {}

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<Fraction, Double> variables = new HashMap<>();
        Map<String, Deque<Equation>> graph = new TreeMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0), div = equations.get(i).get(1);
            variables.put(new Fraction(num, div), values[i]);
            variables.put(new Fraction(div, num), 1.0 / values[i]);
            variables.put(new Fraction(num, num), 1.0);
            variables.put(new Fraction(div, div), 1.0);
            graph.putIfAbsent(num, new LinkedList<>());
            graph.putIfAbsent(div, new LinkedList<>());
            graph.get(num).add(new Equation(new Fraction(num, div), values[i]));
        }

        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String num = queries.get(i).get(0), div = queries.get(i).get(1);
            Fraction query = new Fraction(num, div);
            answers[i] = BigDecimal.valueOf(resolve(query, variables, graph))
                    .setScale(5, RoundingMode.HALF_EVEN).doubleValue();
            variables.put(query, answers[i]);
        }

        return answers;
    }

    double resolve(Fraction query, Map<Fraction, Double> variables, Map<String, Deque<Equation>> graph) {
        // numerator and denominator must be defined
        if (graph.containsKey(query.num) && graph.containsKey(query.div)) {
            if (variables.containsKey(query))
                return variables.get(query);
            else {
                Fraction reciprocal = new Fraction(query.div, query.num);
                if (variables.containsKey(reciprocal))
                    return 1.0 / variables.get(reciprocal);
            }

            for (Equation equation : graph.get(query.num))
                if (!query.div.equals(equation.fraction.div)) {
                    Fraction left = new Fraction(query.num, equation.fraction.div);
                    Fraction right = new Fraction(equation.fraction.div, query.div);

                    double leftVal = resolve(left, variables, graph);
                    variables.put(left, leftVal);
                    double rightVal = resolve(right, variables, graph);
                    variables.put(right, rightVal);
                    return leftVal * rightVal;
                }

        }

        return -1.0;
    }
}
