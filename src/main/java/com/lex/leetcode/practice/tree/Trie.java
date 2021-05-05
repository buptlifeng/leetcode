package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 中等
 *
 * @author lifeng
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    class TrieNode {

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        // 返回 true
        System.out.println(trie.search("apple"));
        // 返回 false
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));

    }


}
