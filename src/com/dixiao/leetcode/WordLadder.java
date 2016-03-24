package com.dixiao.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by di on 2/29/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        wordList.add(endWord);
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String newWord : getCandidates(hs, word, wordList)) {
                    if (newWord.equals(endWord)) {
                        return length;
                    }
                    queue.add(newWord);
                    hs.add(newWord);
                }
            }
        }
        return 0;
    }

    List<String> getCandidates(HashSet<String> hs, String word, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if (word.charAt(i) == c)
                    continue;
                char[] chars = word.toCharArray();
                chars[i] = c;
                String newWord = new String(chars);
                if (!hs.contains(newWord) && wordList.contains(newWord))
                    list.add(newWord);
            }
        }
        return list;
    }

    @Test
    public void test() {
        HashSet<String> set = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        ladderLength("hit", "cog", set);
    }
}
