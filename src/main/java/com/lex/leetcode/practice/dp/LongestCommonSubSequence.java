package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 中等
 * 最长公共子序列（不要求一定连续）
 *
 * @author lifeng
 */
public class LongestCommonSubSequence {

    /**
     * dp[i,j] i是text1的截止下标，j是text2的截止下标
     * dp[i,j] = dp[i-1,j-1] + 1,t1[i] == t2[j];
     * dp[i,j] = max{dp[i,j-1],dp[i-1,j]},t1[i] != t2[j];
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        {
            LongestCommonSubSequence solution = new LongestCommonSubSequence();
            String t1 = "abcde", t2 = "ace";
            // 3
            System.out.println(solution.longestCommonSubsequence(t1, t2));
        }

        {
            LongestCommonSubSequence solution = new LongestCommonSubSequence();
            String t1 = "abc", t2 = "abc";
            // 3
            System.out.println(solution.longestCommonSubsequence(t1, t2));
        }

        {
            LongestCommonSubSequence solution = new LongestCommonSubSequence();
            String t1 = "abc", t2 = "def";
            // 0
            System.out.println(solution.longestCommonSubsequence(t1, t2));
        }
    }

}
