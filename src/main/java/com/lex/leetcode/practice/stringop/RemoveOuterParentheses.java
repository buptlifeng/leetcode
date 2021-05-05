package com.lex.leetcode.practice.stringop;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * 简单
 *
 * @author lifeng
 */
public class RemoveOuterParentheses {

    /**
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (ch == ')') {
                count--;
            }
            if (count > 0) {
                sb.append(ch);
            }
            if (ch == '(') {
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses solution = new RemoveOuterParentheses();

        System.out.println(solution.removeOuterParentheses("()()"));
        System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
    }

}
