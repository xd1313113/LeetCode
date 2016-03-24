package com.dixiao.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by di on 3/17/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while(start < words.length) {
            int count = words[start].length();
            int last = start + 1;
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            int diff = last - start - 1;
            StringBuilder sb = new StringBuilder();
            if (last == words.length || diff == 0) {
                for (int i = start; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int m = (maxWidth - count) / diff;
                int n = (maxWidth - count) % diff;
                for (int i = start; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= m + (((i - start) < n) ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            start = last;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 14));
    }
}
