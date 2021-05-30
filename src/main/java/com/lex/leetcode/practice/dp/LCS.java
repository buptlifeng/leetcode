package com.lex.leetcode.practice.dp;

/**
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac
 * 中等
 * <p>
 * 最长公共子字符串
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/30 下午12:07
 */
public class LCS {
    /**
     * longest common substring
     * 结果需要连续
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null) {
            return "-1";
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        int index = -1, max = 0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (str1.charAt(i) == str2.charAt(k)) {
                    if (i == 0 || k == 0) {
                        dp[i][k] = 1;
                    } else {
                        dp[i][k] = dp[i - 1][k - 1] + 1;
                    }

                    if (dp[i][k] > max) {
                        max = dp[i][k];
                        index = i;
                    }
                }
            }
        }

        return str1.substring(index - max + 1, index + 1);
    }

    public static void main(String[] args) {
        {
            LCS lcs = new LCS();
            // 2345
            System.out.println(lcs.LCS("1AB2345CD", "12345EF"));
        }
    }

}
