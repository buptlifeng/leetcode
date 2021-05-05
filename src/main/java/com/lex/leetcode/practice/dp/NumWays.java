package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 简单
 *
 * @author lifeng
 */
public class NumWays {

    /**
     * dp[n] = dp[n-1] + dp[n-2]
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int n1 = 1, n2 = 1;
        for (int i = 2; i <= n; i++) {
            int now = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = now;
        }

        return n2;
    }

    public static void main(String[] args) {
        {
            NumWays solution = new NumWays();
            // 2
            System.out.println(solution.numWays(2));

            // 21
            System.out.println(solution.numWays(7));

            // 3
            System.out.println(solution.numWays(3));
        }
    }

}
