package com.dixiao.leetcode;

import com.dixiao.model.Point;
import org.junit.Test;

import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 3/3/16.
 */
public class SurroundedRegions {
//    private class Position{
//        public int x;
//        public int y;
//        public Position(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    int[] dx = new int[]{-1, 1, 0, 0};
//    int[] dy = new int[]{0, 0, - 1, 1};
//
//    public void solve(char[][] board) {
//        if (board.length == 0) return;
//        int h = board.length;
//        int w = board[0].length;
//        boolean[][] visited  = new boolean[h][w];
//        List<Point> res = new ArrayList<>();
//        List<Point> path = new ArrayList<>();
//
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                dfs(board, i, j, visited, path, res);
//            }
//        }
//    }
//
//    public boolean dfs(char[][] board, int i, int j,boolean[][] visited, List<Point> path, List<Point> res) {
//        if (visited[i][j]) return false;
//        visited[i][j] = true;
//
//        if (board[i][j] == 'X') {
//            return false;
//        } else {
//
//            for (int d = 0; d < 4; d++) {
//                int ni = i + dx[i];
//                int nj = j + dy[j];
//                if (board[ni][nj] == 'O' && (ni == 0 || nj == 0 || ni == board.length - 1 || nj == board[0].length - 1)){
//                    path.clear();
//                    return false;
//                } else if (board[ni][nj] == 'X'){
//                    return false;
//                } else {
//                    path.add(new Point(i, j));
//                    dfs(board, ni, nj, visited, path, res);
//                }
//            }
//
//            System.out.println("x:" + i + " y:" + j);
//            System.out.println(hasNext);
//
//            if (hasNext) {
//                path.add(new Point(i, j));
//            } else {
//                res.addAll(path);
//                path.clear();
//            }
//            return hasNext;
//        }
//    }
//
//    @Test
//    public void test() {
//        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
//    }
}
