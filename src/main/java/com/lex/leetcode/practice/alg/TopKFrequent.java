package com.lex.leetcode.practice.alg;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * 中等
 */
public class TopKFrequent {

    /**
     * 1.放入map，然后根据key val综合排序
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        List<String> wordList = new ArrayList<>(wordsMap.keySet());
        wordList.sort((w1, w2) -> {
            return wordsMap.get(w1).equals(wordsMap.get(w2)) ? w1.compareTo(w2) : (wordsMap.get(w2) - wordsMap.get(w1));
        });
        return wordList.subList(0, k);
    }

    /**
     * 通过堆排序实现
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentHeap(String[] words, int k) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> wordsMap.get(w1).equals(wordsMap.get(w2))
                        ? w2.compareTo(w1) : (wordsMap.get(w1) - wordsMap.get(w2)));

        for (String word : wordsMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!heap.isEmpty()) {
            ret.add(heap.poll());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();
        String[] words = new String[]{
                "i", "love", "leetcode", "i", "love", "coding"
        };
        System.out.println(solution.topKFrequent(words, 2));
        System.out.println(solution.topKFrequentHeap(words, 2));

        words = new String[]{
                "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        };
        System.out.println(solution.topKFrequent(words, 4));
        System.out.println(solution.topKFrequentHeap(words, 4));
    }

}
