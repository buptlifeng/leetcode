package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 中等
 *
 * @author lifeng
 */
public class FindNumberIn2DArray {

    /**
     * 从对角线开始搜索：一侧单调递增，一侧单调递减
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        {
            FindNumberIn2DArray solution = new FindNumberIn2DArray();
            int[][] matrix = new int[][]{
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {18, 21, 23, 26, 30}
            };
            // true
            System.out.println(solution.findNumberIn2DArray(matrix, 1));

            // true
            System.out.println(solution.findNumberIn2DArray(matrix, 5));

            // true
            System.out.println(solution.findNumberIn2DArray(matrix, 18));

            // false
            System.out.println(solution.findNumberIn2DArray(matrix, 20));
        }
    }

}
