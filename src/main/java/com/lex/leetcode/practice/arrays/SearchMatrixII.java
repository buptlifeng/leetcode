package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 中等
 *
 * @author lifeng
 */
public class SearchMatrixII {

    /**
     * 从右上角往2侧，也可以从左下往2侧
     * 因为这样可以保证一侧小于，一侧大于，方便选择方向
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && row > -1 && col > -1 && col < n) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        {
            SearchMatrixII solution = new SearchMatrixII();
            int[][] matrix = new int[][]{
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            };
            System.out.println(solution.searchMatrix(matrix, 5));
        }

        {
            SearchMatrixII solution = new SearchMatrixII();
            int[][] matrix = new int[][]{
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            };
            System.out.println(solution.searchMatrix(matrix, 20));
        }
    }

}
