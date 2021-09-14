package com.lex.leetcode.practice.dp;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 困难
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/9/8 下午10:13
 */
public class LongestValidParentheses {

    /**
     * dp[i]代表下标i结尾的最大有效长度
     * 1.s[i-1] = '(' ，s[i] = ')'，则：dp[i] = dp[i-2] + 2
     * 2.s[i-1] = ')' ，s[i] = ')'，则：
     * 如果倒数第二个)存在配套的(，则对于最后一个)，如果是有效的，
     * 一定存在相应的(，形成诸如：((...))这种形式，注意，...代表中间还可能存在着有效的最大长度
     * 因此：
     * dp[i] = dp[i-2] + 2
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            // 有效的肯定以)结尾，否则以(结尾，长度为0
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // dp[i - dp[i - 1] - 2] 表示：倒数第二个)组成的最长有效长度，
                    // 使用下标i减去这个长度，再减去2（代表最后一个右括号组成的有效括号对）代表可能存在的有效括号对
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int longestValidParenthesesStack(String s) {
        int n = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public int longestValidParenthesesOnO1(String s) {
        int n = s.length();
        int max = 0, left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int j = n - 1; j > -1; j--) {
            if (s.charAt(j) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        {
            LongestValidParentheses lvp = new LongestValidParentheses();
            // 4
            String str = "()()";
            System.out.println(lvp.longestValidParentheses(str));
            System.out.println(lvp.longestValidParenthesesStack(str));
            System.out.println(lvp.longestValidParenthesesOnO1(str));

        }
        {
            LongestValidParentheses lvp = new LongestValidParentheses();
            // 2
            String str = "()";
            System.out.println(lvp.longestValidParentheses(str));
            System.out.println(lvp.longestValidParenthesesStack(str));
            System.out.println(lvp.longestValidParenthesesOnO1(str));
        }

        {
            LongestValidParentheses lvp = new LongestValidParentheses();
            // 2
            String str = "(()";
            System.out.println(lvp.longestValidParentheses(str));
            System.out.println(lvp.longestValidParenthesesStack(str));
            System.out.println(lvp.longestValidParenthesesOnO1(str));
        }

        {
            LongestValidParentheses lvp = new LongestValidParentheses();
            // 4 ()()
            String str = ")()())";
            System.out.println(lvp.longestValidParentheses(str));
            System.out.println(lvp.longestValidParenthesesStack(str));
            System.out.println(lvp.longestValidParenthesesOnO1(str));

        }

        {
            LongestValidParentheses lvp = new LongestValidParentheses();
            // 0
            String str = "";
            System.out.println(lvp.longestValidParentheses(str));
            System.out.println(lvp.longestValidParenthesesStack(str));
            System.out.println(lvp.longestValidParenthesesOnO1(str));

        }
    }

}
