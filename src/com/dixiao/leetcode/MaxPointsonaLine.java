package com.dixiao.leetcode;

import com.dixiao.model.Point;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by di on 2/29/16.
 */
public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        HashMap<Float, Integer> map = new HashMap<>();

        int max = 1;
        for (Point p1 : points) {
            map.clear();
            int same = 0;
            // In case of all points are at same position.
            map.put(Float.POSITIVE_INFINITY, 1);
            for (Point p2 : points) {
                // same reference
                if (p1 == p2) continue;
                if (p1.x == p2.x && p1.y == p2.y) {
                    same++;
                    continue;
                }
                // calculate slope for every two points.
                float slope = p2.x == p1.x ? Float.POSITIVE_INFINITY : (float) (p2.y - p1.y) / (p2.x - p1.x);
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }

            for (Integer count : map.values()) {
                max = Math.max(max, count + same);
            }
        }
        return max;
    }

    @Test
    public void test() {
        maxPoints(new Point[]{new Point(1,0), new Point(1,1), new Point(1, -1)});
    }
}
