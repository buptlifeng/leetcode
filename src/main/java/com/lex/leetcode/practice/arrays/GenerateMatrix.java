package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 中等
 *
 * @author lifeng
 */
public class GenerateMatrix {

    /**
     * 模拟算法
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            if (++left > right) {
                break;
            }
        }
        return matrix;
    }

    static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[0].length; k++) {
                System.out.print(m[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        {
            GenerateMatrix gm = new GenerateMatrix();
            print(gm.generateMatrix(3));

            print(gm.generateMatrix(4));
        }
    }

}
