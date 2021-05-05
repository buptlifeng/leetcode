package com.lex.leetcode.practice.stringop;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 简单
 *
 * @author lifeng
 */
public class RemoveDuplicateChars {

    /**
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateChars solution = new RemoveDuplicateChars();
        solution.removeDuplicates("abbaca");

        solution.removeDuplicates("abbcd");
    }

}
