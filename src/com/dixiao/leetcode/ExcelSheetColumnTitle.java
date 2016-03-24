package com.dixiao.leetcode;

/**
 * Created by di on 3/24/16.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + n % 26);
    }
}
