package org.base.leetcode.interview75.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75">
 *     17. Letter Combinations of a Phone Number</a>
 * <p>
 *     Stats:
 *     Runtime:    1ms (66.91%)
 *     Memory: 41.66mb (91.54%)
 * </p>
 */
public class LetterCombinations {
    private static final Map<Character, List<String>> phoneNumbers = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        List<String> combos = new ArrayList<>();
        if (digits.length() > 0)
            mapDigits("", 0, digits, combos);
        return combos;
    }

    void mapDigits(String current, int index, String digits, List<String> combos) {
        if (index == digits.length() - 1) {
            for (String letter : phoneNumbers.get(digits.charAt(index))) {
                combos.add(current + letter);
            }
        }
        else {
            for (String letter : phoneNumbers.get(digits.charAt(index))) {
                mapDigits(current + letter, index + 1, digits, combos);
            }
        }
    }
}
