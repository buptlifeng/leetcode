package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 简单
 */
public class FibI {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            int t = y;
            y += x;
            x = t;
        }

        return y;
    }

    public static void main(String[] args) {
        FibI solution = new FibI();
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
    }

}
