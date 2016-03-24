package com.dixiao.leetcode;

import org.junit.Test;

/**
 * Created by di on 3/24/16.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            if (i < v1.length && i < v2.length) {
                int num1 = Integer.valueOf(v1[i]);
                int num2 = Integer.valueOf(v2[i]);
                if (num1 > num2) return 1;
                if (num1 < num2) return -1;
            } else if (i < v1.length) {
                if (Integer.valueOf(v1[i]) != 0) {
                    return 1;
                }
            } else if (i < v2.length) {
                if (Integer.valueOf(v2[i]) != 0) {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(compareVersion("1", "0"));
    }
}
