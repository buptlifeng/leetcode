package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * 中等
 *
 * @author lifeng
 */
public class MaxProduct {

    /**
     * 找出2个不包含公共字符的单词的长度乘积的最大值
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int ans = 0, len = words.length;
        int[] wordAlphaBit = new int[len];
        for (int i = 0; i < len; i++) {
            int x = 0;
            for (char ch : words[i].toCharArray()) {
                x |= (1 << (ch - 'a'));
            }
            wordAlphaBit[i] = x;
        }
        for (int i = 0; i < len; i++) {
            for (int k = i + 1; k < len; k++) {
                // 没有公共字符
                if ((wordAlphaBit[i] & wordAlphaBit[k]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[k].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            MaxProduct mp = new MaxProduct();
            String[] words = new String[]{
                    "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
            };
            // 16
            System.out.println(mp.maxProduct(words));
        }

        {
            MaxProduct mp = new MaxProduct();
            String[] words = new String[]{
                    "a", "ab", "abc", "d", "cd", "bcd", "abcd"
            };
            // 4
            System.out.println(mp.maxProduct(words));
        }

        {
            MaxProduct mp = new MaxProduct();
            String[] words = new String[]{
                    "a", "aa", "aaa", "aaaa"
            };
            // 0
            System.out.println(mp.maxProduct(words));
        }
    }

}
