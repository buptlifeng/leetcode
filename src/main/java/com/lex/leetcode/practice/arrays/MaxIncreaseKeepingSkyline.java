package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * 中等
 *
 * @author lifeng
 */
public class MaxIncreaseKeepingSkyline {

    /**
     * 元素只能从所在行列最大值里选比较小的那个，否则会破坏天际线
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] r = new int[m];
        int[] c = new int[n];

        // 每行最大值
        for (int i = 0; i < m; i++) {
            int rm = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] > rm) {
                    rm = grid[i][j];
                }
            }
            r[i] = rm;
        }

        // 每列最大值
        for (int j = 0; j < n; j++) {
            int cm = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (grid[i][j] > cm) {
                    cm = grid[i][j];
                }
            }
            c[j] = cm;
        }

        // 对每个元素进行计算
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.min(r[i], c[j]);
                ans += (val - grid[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            MaxIncreaseKeepingSkyline solution = new MaxIncreaseKeepingSkyline();
            int[][] grid = new int[][]{
                    {3, 0, 8, 4},
                    {2, 4, 5, 7},
                    {9, 2, 6, 3},
                    {0, 3, 1, 0}
            };
            System.out.println(solution.maxIncreaseKeepingSkyline(grid));
        }
    }

}
