package com.dixiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by di on 3/5/16.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (!map.containsKey(c1)) {
                map.put(c1, t.charAt(i));
            } else {

                if (t.charAt(i) != map.get(c1))
                    return false;
            }
        }
        return true;
    }
}
