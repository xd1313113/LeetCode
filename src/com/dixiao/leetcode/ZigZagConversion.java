package com.dixiao.leetcode;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by di on 2/16/16.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int group = 2 * numRows - 2;
        IntStream.range(0, numRows).forEach( i -> {
            for (int j = 0; j < s.length(); j++) {
                int mod = j % group;
                if (mod == i) {
                    res.append(s.charAt(j));
                }

                if (mod >= numRows) {
                    mod = (group - mod) % numRows;
                    if (mod == i) {
                        res.append(s.charAt(j));
                    }
                }
            }
        });
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
