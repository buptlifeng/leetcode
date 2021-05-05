package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 中等
 *
 * @author lifeng
 */
public class FindLength {

    /**
     * dp写法
     * <p>
     * dp[i][j]代表 a[i]和b[j]的最长公共前缀
     * dp[i][j] = dp[i+1][j+1] + 1,a[i] = b[j]
     * 否则，dp[i][j] = 0
     * <p>
     * 时间:O(N*M)
     * 空间:O(N*M)
     *
     * @param A
     * @param B
     * @return
     */
    public int findLengthDp(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = A.length - 1; i > -1; i--) {
            for (int j = B.length - 1; j > -1; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 滑动窗口写法
     *
     * @param A
     * @param B
     * @return
     */
    public int findLengthWindow(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int ans = 0;
        // 固定A 相当于让A的每一个元素挨个去和B里的首元素对其，然后统计最大重复子序列
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxCommonLength(A, B, i, 0, len);
            // 每次更新记录最大重复子序列长度
            ans = Math.max(ans, maxLen);
        }

        // 固定B 相当于让B的每一个元素挨个去和A里的首元素对其，然后统计最大重复子序列
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = maxCommonLength(A, B, 0, i, len);
            ans = Math.max(ans, maxLen);
        }

        return ans;
    }

    /**
     * 窗口滑动时，计算最大相同子数组
     * @param A
     * @param B
     * @param as
     * @param bs
     * @param len
     * @return
     */
    private int maxCommonLength(int[] A, int[] B, int as, int bs, int len) {
        int ans = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[as + i] == B[bs + i]) {
                k++;
            } else {
                k = 0;
            }
            ans = Math.max(ans, k);
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            FindLength solution = new FindLength();
            int[] A = new int[]{
                    1, 2, 3, 2, 1
            };
            int[] B = new int[]{
                    3, 2, 1, 4, 7
            };
            System.out.println(solution.findLengthWindow(A, B));
            System.out.println(solution.findLengthDp(A, B));
        }

        {
            FindLength solution = new FindLength();
            int[] A = new int[]{
                    1, 2, 3
            };
            int[] B = new int[]{
                    1, 2, 4
            };
            System.out.println(solution.findLengthWindow(A, B));
            System.out.println(solution.findLengthDp(A, B));
        }
    }

}
