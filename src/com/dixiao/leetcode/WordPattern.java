package com.dixiao.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by di on 3/24/16.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i]))
                    return false;
            } else {
                if (map.containsValue(words[i]))
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
