package com.lex.leetcode.practice.stringop;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 简单
 *
 * @author lifeng
 */
public class IsValid {

    /**
     * 判断括号是否匹配
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftChar = stack.pop();
                if (ch == ')' && leftChar != '(') {
                    return false;
                } else if (ch == ']' && leftChar != '[') {
                    return false;
                } else if (ch == '}' && leftChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        {
            IsValid iv = new IsValid();
            System.out.println(iv.isValid("{}"));
            System.out.println(iv.isValid("{}[]"));
            System.out.println(iv.isValid("{}[]()"));
            System.out.println(iv.isValid("{]"));
            System.out.println(iv.isValid("{[()]}"));
        }
    }

}
