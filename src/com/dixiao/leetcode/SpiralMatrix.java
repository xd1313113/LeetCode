package com.dixiao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 2/28/16.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if(top > down || left > right) break;
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if(top > down || left > right) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            if(top > down || left > right) break;
            for (int i = down; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if(top > down || left > right) break;
        }
        return res;
    }

    @Test
    public void test() {
        //spiralOrder(new int[][]{{2,3}, {1,4}});
        float a = (float)5 /0;
        System.out.print(a);
    }
}
