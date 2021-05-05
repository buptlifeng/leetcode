package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 中等
 */
public class UniquePaths {

    /**
     * DP问题
     * <p>
     * f(i,j)=f(i-1,j)+f(i,j-1)
     * 从第一列开始计算，然后顺序计算出所有的值即可
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int[][] dp = new int[m][n];

        // 第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        // 第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(3, 7));

        System.out.println(solution.uniquePaths(3, 2));

        System.out.println(solution.uniquePaths(7, 3));

        System.out.println(solution.uniquePaths(3, 3));
    }

}
