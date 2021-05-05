package com.lex.leetcode.practice.stringop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * 简单
 *
 * @author lifeng
 */
public class LongestWords {

    class Node {

        Map<Character, Node> chils = new HashMap<>();
        int end = 0;
        char ch;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    class Trie {
        Node root;
        String[] words;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char cha : word.toCharArray()) {
                cur.chils.putIfAbsent(cha, new Node(cha));
                cur = cur.chils.get(cha);
            }
            cur.end = index;
        }

        public String dfs() {
            String ret = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ret.length() ||
                                (word.length() == ret.length() && word.compareTo(ret) < 0)) {
                            ret = word;
                        }
                    }
                    for (Node nn : node.chils.values()) {
                        stack.push(nn);
                    }
                }
            }
            return ret;
        }

    }

    /**
     * 最长的单词
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        int index = 0;
        for (String wd : words) {
            trie.insert(wd, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }

    public static void main(String[] args) {
        {
            LongestWords solution = new LongestWords();
            String[] words = new String[]{
                    "w", "wo", "wor", "worl", "world"
            };
            System.out.println(solution.longestWord(words));
        }

        {
            LongestWords solution = new LongestWords();
            String[] words = new String[]{
                    "a", "banana", "app", "appl", "ap", "apply", "apple"
            };
            System.out.println(solution.longestWord(words));
        }
    }

}
