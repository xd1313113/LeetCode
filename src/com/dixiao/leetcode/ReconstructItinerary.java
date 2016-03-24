package com.dixiao.leetcode;

import java.util.*;

/**
 * Created by di on 2/18/16.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        dfs(res, map, "JFK");
        return res;
    }

    void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(res, map, map.get(cur).poll());
        }
        res.addFirst(cur);
    }
}
