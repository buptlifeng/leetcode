package com.lex.leetcode.practice.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 中等
 * 逆波兰表达式求值
 *
 * @author lifeng
 */
public class EvalRPN {

    /**
     * 不存在除数为0的情况
     * 结果只保留整数部分即可
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // number
            if (!isOp(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(n1 + n2);
                        break;
                    case "-":
                        stack.push(n1 - n2);
                        break;
                    case "*":
                        stack.push(n1 * n2);
                        break;
                    case "/":
                        stack.push(n1 / n2);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isOp(String token) {
        return "+".equals(token) || "-".equals(token)
                || "*".equals(token) || "/".equals(token);
    }

    public static void main(String[] args) {
        {
            EvalRPN solution = new EvalRPN();
            String[] tokens = new String[]{
                    "2","1","+","3","*"
            };
            // 9
            System.out.println(solution.evalRPN(tokens));
        }

        {
            EvalRPN solution = new EvalRPN();
            String[] tokens = new String[]{
                    "4","13","5","/","+"
            };
            // 6
            System.out.println(solution.evalRPN(tokens));
        }

        {
            EvalRPN solution = new EvalRPN();
            String[] tokens = new String[]{
                    "10","6","9","3","+","-11","*","/","*","17","+","5","+"
            };
            // 22
            System.out.println(solution.evalRPN(tokens));
        }
    }

}


