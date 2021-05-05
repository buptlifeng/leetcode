package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 中等
 *
 * @author lifeng
 */
public class MinPathSum {

    /**
     * 典型dp
     * dp[i,j]表示到i,j位置的最小和
     * 则：
     * dp[i,j] = min{dp[i-1,j],dp[i,j-1]} + grid[i,j]
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        {
            MinPathSum solution = new MinPathSum();
            int[][] grid = new int[][]{
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}
            };
            // 7
            System.out.println(solution.minPathSum(grid));
        }

        {
            MinPathSum solution = new MinPathSum();
            int[][] grid = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6}
            };
            // 12
            System.out.println(solution.minPathSum(grid));
        }
    }

}
