package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 简单
 *
 * @author lifeng
 */
public class SpiralOrder {

    /**
     * 完全模拟4条线的操作
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[] ans = new int[rows * cols];

        int left = 0, right = cols - 1, top = 0, bottom = rows - 1, idx = 0;
        while (true) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                ans[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            // 从上到下
            for (int j = top; j <= bottom; j++) {
                ans[idx++] = matrix[j][right];
            }
            if (--right < left) {
                break;
            }

            // 从右到左
            for (int k = right; k >= left; k--) {
                ans[idx++] = matrix[bottom][k];
            }
            if (--bottom < top) {
                break;
            }

            // 从下到上
            for (int m = bottom; m >= top; m--) {
                ans[idx++] = matrix[m][left];
            }
            if (++left > right) {
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        {
            SpiralOrder solution = new SpiralOrder();
            int[][] matrix = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println(solution.spiralOrder(matrix));
        }

        {
            SpiralOrder solution = new SpiralOrder();
            int[][] matrix = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}
            };
            System.out.println(solution.spiralOrder(matrix));
        }
    }

}
