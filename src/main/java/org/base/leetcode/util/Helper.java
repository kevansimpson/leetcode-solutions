package org.base.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Helper {
    public static String[] toArray(String str) {
        if (str.startsWith("["))
            str = str.substring(1, str.length() - 1);
        return str.split(",\\s?");
    }

    public static String[][] toNestedArray(String str) {
        str = str.substring(2, str.length() - 2);
        String[] arr = str.split("],\\[", -1);
        String[][] matrix = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            matrix[i] = (arr[i].isBlank()) ? new String[0] : arr[i].split(",\\s?");
        }

        return matrix;
    }

    public static char[][] toNestedCharArray(String str) {
        String[][] arr = toNestedArray(str.replaceAll("\"", ""));
        char[][] matrix = new char[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            char[] ch = new char[arr[i].length];
            for (int j = 0; j < arr[i].length; j++)
                ch[j] = arr[i][j].charAt(0);
            matrix[i] = ch;
        }

        return matrix;
    }

    public static int[][] toNestedIntArray(String str) {
        str = str.substring(2, str.length() - 2);
        String[] arr = str.split("],\\[", -1);
        int[][] matrix = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            matrix[i] = (arr[i].isBlank()) ? new int[0] : toIntArray(arr[i]);
        }

        return matrix;
    }

    public static int[] toIntArray(String str) {
        String[] arr = toArray(str);
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++)
            result[i] = Integer.parseInt(arr[i]);

        return result;
    }

    public static List<Integer> toIntList(String str) {
        String[] arr = toArray(str);
        List<Integer> list = new ArrayList<>();
        for (String s : arr)
            if (!s.isBlank())
                list.add(Integer.parseInt(s));

        return list;
    }

    public static List<List<Integer>> toNestedIntList(String str) {
        return toNestedList(str, Integer::parseInt);
    }

    public static List<List<String>> toNestedList(String str) {
        return toNestedList(str, Function.identity());
    }

    public static <T> List<List<T>> toNestedList(
            String str, Function<String, T> fxn) {
        String[][] arr = toNestedArray(str.replaceAll("\"", ""));
        List<List<T>> list = new ArrayList<>();
        for (String[] strings : arr) {
            List<T> nest = new ArrayList<>();
            for (String string : strings) nest.add(fxn.apply(string));
            list.add(nest);
        }
        return list;
    }

    public static <T> List<T> toList(String str, Function<String, T> fxn) {
        String[] arr = toArray(str);
        List<T> list = new ArrayList<>();
        for (String s : arr) list.add(fxn.apply(s));

        return list;
    }
}
