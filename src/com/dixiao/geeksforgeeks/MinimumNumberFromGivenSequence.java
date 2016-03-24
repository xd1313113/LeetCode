package com.dixiao.geeksforgeeks;

import org.junit.Test;

/**
 * Created by di on 2/27/16.
 */
public class MinimumNumberFromGivenSequence {

    public int[] generateNumber(String p) {
        if (p.length() == 0) return new int[0];
        int i = 0;
        int num  = 1;
        int[] res = new int[p.length() + 1];

        while (i < p.length()) {
            if (p.charAt(i) == 'I') {
                res[i] = num++;
            } else {
                int j = i + 1;
                while(j <= p.length()) {
                    if (j == p.length() || p.charAt(j) != 'D') {
                        res[j] = num++;
                        break;
                    }
                    j++;
                }

                for (int index = j - 1; index >= i; index--) {
                    res[index] = num++;
                }
                i = j;
            }
            i++;
        }
        if (res[p.length()] == 0) {
            res[p.length()] = num;
        }
        return res;
    }

    @Test
    public void test() {
        for (Integer i : generateNumber("DDIIIDDI")) {
            System.out.println(i);
        }
    }
}
