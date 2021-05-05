package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 中等
 *
 * @author lifeng
 */
public class SearchMatrixI {

    /**
     * 把整个二维数组当做一个一维数组考虑，只需要一次即可
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixOnceBinary(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int rno = mid / n, cno = mid % n;
            int mv = matrix[rno][cno];
            if (mv == target) {
                return true;
            } else if (mv > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 先在所有第一列的元素中二分找到元素可能所在行，然后对改行做二分查找
     * lg(m+n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearch1thCol(matrix, target);
        if (row < 0) {
            return false;
        }
        return binarySearchRow(matrix, target, row);
    }

    private int binarySearch1thCol(int[][] matrix, int target) {
        int cs = -1, ce = matrix.length - 1;
        while (cs < ce) {
            int mid = (ce + cs + 1) / 2;
            if (matrix[mid][0] <= target) {
                cs = mid;
            } else {
                ce = mid - 1;
            }
        }
        return cs;
    }

    private boolean binarySearchRow(int[][] matrix, int target, int row) {
        int cols = matrix[0].length;
        int l = 0, r = cols - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        {
            SearchMatrixI solution = new SearchMatrixI();
            int[][] matrix = new int[][]{
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}
            };
            System.out.println(solution.searchMatrix(matrix, 3));
            System.out.println(solution.searchMatrixOnceBinary(matrix, 3));
        }

        {
            SearchMatrixI solution = new SearchMatrixI();
            int[][] matrix = new int[][]{
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}
            };
            System.out.println(solution.searchMatrix(matrix, 13));
            System.out.println(solution.searchMatrixOnceBinary(matrix, 13));
        }
    }

}
