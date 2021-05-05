package com.lex.leetcode.practice.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 中等
 *
 * @author lifeng
 */
public class GroupAnaGrams {

    /**
     * 每个单词，使用一个26字符数组来标记
     * 比较每个单词是否存在一样的数组（值）
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : strs) {
            int[] charNums = new int[26];
            for (char ch : word.toCharArray()) {
                charNums[ch - 'a']++;
            }
            // 处理单词特征
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charNums[i] > 0) {
                    sb.append(i + 'a');
                    sb.append(charNums[i]);
                }
            }
            String key = sb.toString();
            List<String> candidates = wordMap.getOrDefault(key, new ArrayList<>());
            candidates.add(word);
            wordMap.put(key, candidates);
        }

        return new ArrayList<>(wordMap.values());
    }

}
