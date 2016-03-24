package com.dixiao.leetcode;

import javafx.util.Pair;
import org.junit.Test;

/**
 * Created by di on 2/18/16.
 */
public class LongestIncreasingPathinaMatrix {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 1;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j, mem));
            }
        }
        return max;
    }

    int helper(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) return mem[i][j];
        for(int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[ni][nj] > matrix[i][j])
                mem[i][j] = Math.max(mem[i][j], helper(matrix, ni , nj, mem));
        }
        return ++mem[i][j];
    }

    @Test
    public void test() {
        //int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = new int[][]{{1,2}};

        System.out.println(longestIncreasingPath(matrix));
    }
}
