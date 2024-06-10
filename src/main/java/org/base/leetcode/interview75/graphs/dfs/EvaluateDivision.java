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
    public record Fraction(String num, String div) {}

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<Fraction, Double> variables = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0), div = equations.get(i).get(1);
            variables.put(new Fraction(num, div), values[i]);
            variables.put(new Fraction(div, num), 1.0 / values[i]);
            variables.put(new Fraction(num, num), 1.0);
            variables.put(new Fraction(div, div), 1.0);
            for (int j = i + 1; j < equations.size(); j++) {
                String num2 = equations.get(j).get(0), div2 = equations.get(j).get(1);
                if (num.equals(div2)) {
                    variables.put(new Fraction(num2, div), values[i] * values[j]);
                    variables.put(new Fraction(div, num2), 1.0 / (values[i] * values[j]));
                }
                else if (num2.equals(div)) {
                    variables.put(new Fraction(num, div2), values[i] * values[j]);
                    variables.put(new Fraction(div2, num), 1.0 / (values[i] * values[j]));
                }
                else if (num.equals(num2)) {
                    variables.put(new Fraction(div, div2), (1.0 / values[i]) / values[j]);
                    variables.put(new Fraction(div2, div), values[i] / (1.0 / values[j]));
                }
                else if (div.equals(div2)) {
                    variables.put(new Fraction(num, num2), values[i] / values[j]);
                    variables.put(new Fraction(num2, num), 1.0 / (values[i] / values[j]));
                }
            }
        }

        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String num = query.get(0), div = query.get(1);
            answers[i] = BigDecimal.valueOf(variables.getOrDefault(new Fraction(num, div), -1.0))
                    .setScale(5, RoundingMode.HALF_EVEN).doubleValue();
        }

        return answers;
    }
}
