package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 * 中等
 *
 * @author lifeng
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        boolean up = true;
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0, col = 0, idx = 0;
        while (row < m && col < n) {
            if (up) {
                while (row >= 0 && col < n) {
                    ans[idx++] = mat[row--][col++];
                }
                // 行先+1，恢复到当前行，还要继续看列是否越界
                row++;
                // 列越界的情况下，需要再次处理
                if (col == n) {
                    col--;
                    row++;
                }
            } else {
                while (row < m && col >= 0) {
                    ans[idx++] = mat[row++][col--];
                }
                // 列需要先恢复到当前列，还要看行是否越界
                col++;
                // 行越界的情况下，需要再次处理
                if (row == m) {
                    row--;
                    col++;
                }
            }
            up = !up;
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            FindDiagonalOrder solution = new FindDiagonalOrder();
            int[][] mat = new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int[] ans = solution.findDiagonalOrder(mat);
            // 1 2 4 7 5 3 6 8 9
            for (int n : ans) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        {
            FindDiagonalOrder solution = new FindDiagonalOrder();
            int[][] mat = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}
            };
            int[] ans = solution.findDiagonalOrder(mat);
            // 1 2 5 9 6 3 4 7 10 11 8 12
            for (int n : ans) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
