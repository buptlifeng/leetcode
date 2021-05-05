package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * dp问题
 */
public class UniquePathWithObstacles {

    /**
     * 思路：
     * 如果某点是障碍，f(i,j)=0
     * <p>
     * f(i,j) = f(i-1,j) + f(i,j-1)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];

        boolean colMark = false;
        for (int i = 0; i < m; i++) {
            if(colMark){
                break;
            }
            if (obstacleGrid[i][0] == 0) {
                ans[i][0] = 1;
            } else {
                colMark = true;
            }
        }

        colMark = false;
        for (int k = 0; k < n; k++) {
            if(colMark){
                break;
            }
            if (obstacleGrid[0][k] == 0) {
                ans[0][k] = 1;
            } else {
                colMark = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                if (obstacleGrid[i][k] == 1) {
                    ans[i][k] = 0;
                } else {
                    ans[i][k] = ans[i][k - 1] + ans[i - 1][k];
                }
            }
        }

        return ans[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathWithObstacles upo = new UniquePathWithObstacles();
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        // 2
        System.out.println(upo.uniquePathsWithObstacles(obstacleGrid));

        obstacleGrid = new int[][]{
                {0, 1},
                {0, 0}
        };
        // 1
        System.out.println(upo.uniquePathsWithObstacles(obstacleGrid));
    }

}
