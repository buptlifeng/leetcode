package com.lex.leetcode.practice.stringop;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 中等
 *
 * @author lifeng
 */
public class ReverseWords {

    /**
     * Java无法使用O(1)空间实现：至少要保存结果，结果和s占用的空间是一样的
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 1.trim left
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }

        // 2.trim right
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        // 3.split words
        StringBuilder sb = new StringBuilder();
        LinkedList<String> words = new LinkedList<>();

        while (left <= right) {
            char ch = s.charAt(left);
            if (ch == ' ' && sb.length() > 0) {
                // 倒排单词
                words.addFirst(sb.toString());
                sb.setLength(0);
            } else if (ch != ' ') {
                sb.append(ch);
            }
            left++;
        }
        words.addFirst(sb.toString());

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        {
            ReverseWords rw = new ReverseWords();
            System.out.println(rw.reverseWords("the sky is blue"));

            System.out.println(rw.reverseWords("  hello world!  "));
        }
    }

}
