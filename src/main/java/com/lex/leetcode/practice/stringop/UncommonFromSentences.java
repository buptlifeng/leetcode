package com.lex.leetcode.practice.stringop;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 * 简单
 */
public class UncommonFromSentences {

    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> countMap = new HashMap<>();
        Set<String> onceSet = new HashSet<>();
        for (String word : A.split(" ")) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : B.split(" ")) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            if (countMap.get(word) == 1) {
                onceSet.add(word);
            }
        }

        return onceSet.toArray(new String[0]);
    }

}
