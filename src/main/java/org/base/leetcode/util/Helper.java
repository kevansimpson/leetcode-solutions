package org.base.leetcode.util;

public class Helper {
    public static int[] toIntArray(String str) {
        str = str.replace("[", "").replace("]", "");
        String[] arr = str.split(", ");
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++)
            result[i] = Integer.parseInt(arr[i]);

        return result;
    }
}
