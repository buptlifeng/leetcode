package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * 中等
 * <p>
 * 原地旋转
 * n X n的矩阵
 */
public class Rotate1 {

    /**
     * 1.对角线互换
     * 2.水平互换位置
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // 1.对角线互换
        for (int i = 1; i < n; i++) {

            for (int k = 0; k < i + 1; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = tmp;
            }
        }

        // 2.水平互换（同行互换）
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n / 2; k++) {
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[i][n - k - 1];
                matrix[i][n - k - 1] = tmp;
            }
        }

        print(matrix);
    }

    private static void print(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int k=0;k<n;k++){
                System.out.print(matrix[i][k]);
                if(k<n-1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Rotate1 rt = new Rotate1();
        int[][] matrix = new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        rt.rotate(matrix);

        matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rt.rotate(matrix);

    }

}

